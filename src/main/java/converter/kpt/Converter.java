package converter.kpt;

import converter.kpt.exceptions.CustomException;
import converter.kpt.info.CadastralBlockInfo;
import converter.kpt.info.FileInfo;
import converter.kpt.info.ResultInfo;
import converter.kpt.kpt.KPT;
import converter.kpt.kpt.TCadastralBlock;
import converter.kpt.kpt.TCoordSystem;
import converter.kpt.utils.FSHelper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Path;

public class Converter {

    //private static String destRoot = "C:\\kptinp\\output";
    private static String destRoot;

    public static ResultInfo convert(String inFolderStr, File folderRoot) {
        ResultInfo result = new ResultInfo();
        File inFolder = new File(inFolderStr);

        if (!inFolder.isDirectory()) {
            result.setErrorMsg("Указанный путь " + inFolderStr + " не является папкой");
            return result;
        }

        if(!folderRoot.isDirectory()){
            result.setErrorMsg("Указанный путь " + folderRoot.getPath() + " не является папкой");
            return result;
        }else{
            destRoot = folderRoot.getPath();
        }


        File[] files = inFolder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".xml");
            }
        });

        for (File f: files) {
            FileInfo fi = new FileInfo(f.getName());
            try {
                convertFile(f.getAbsolutePath(), fi);
                result.incConvertedFilesCnt(1);
            } catch (CustomException e) {
                fi.setErrorMsg(e.getMessage());
                fi.setConverted(false);
                result.incErrorFilesCnt(1);
            }
            result.getFilesInfo().add(fi);
        }

        return result;
    }

    private static void convertFile(String kptPath, FileInfo fi) throws CustomException {
        Unmarshaller unmarshaller = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(KPT.class);
            unmarshaller = jaxbContext.createUnmarshaller();
        } catch (JAXBException ex) {
            throw new CustomException("Ошибка иницилизации серилизатора", ex);
        }

        KPT kpt = null;
        try {
            kpt = (KPT) unmarshaller.unmarshal(new File(kptPath));
        } catch (JAXBException ex) {
            throw new CustomException("Ошибка серилизации xml файла " + kptPath, ex);
        }

        //Цикл по кадастравым кварталам, проверяем кол-во координатных систем и наличие коэфициентов персчета
        for(TCadastralBlock cb: kpt.getCadastralBlocks().getCadastralBlock()) {
            if (cb.getCoordSystems().getCoordSystem().size() > 1) {
                throw new CustomException("В квартале " + cb.getCadastralNumber() + " указанно больше 1 системы координат");
            }
            if (cb.getCoordSystems().getCoordSystem().size() == 0) {
                throw new CustomException("В квартале " + cb.getCadastralNumber() + " не указанна система координат");
            }
            TCoordSystem cs = cb.getCoordSystems().getCoordSystem().get(0);

            if (CRSEnum.get(cs.getName()) == null) {
                //todo: Warning or nah
                throw new CustomException("Для координатной системы " + cs.getName() + " отсутсвуют коэфициенты пересчета");
            }
        }

        //Цикл по кадастравым кварталам, сохраняем кадастровый план
        for(TCadastralBlock cb: kpt.getCadastralBlocks().getCadastralBlock()) {
            CadastralBlockInfo cbInfo = new CadastralBlockInfo();
            cbInfo.getStatistics().incCadastralBlocksCnt(1);
            fi.getCadastralBlocks().add(cbInfo);

            Path destFld = FSHelper.createPathByCadastral(destRoot, cb.getCadastralNumber());

            FSHelper.saveTextFile(new File(destFld.toString(), "sourceKPT.txt"), kptPath);

            cb.saveGeoJSON(destFld, cbInfo);
        }
    }
}
