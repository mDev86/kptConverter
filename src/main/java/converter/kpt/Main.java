package converter.kpt;

import converter.kpt.info.DownloadFile;
import converter.kpt.info.ResultInfo;
import converter.kpt.utils.Archiver;
import converter.kpt.utils.Utils;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static j2html.TagCreator.*;

@ManagedBean(name = "Main")
@ViewScoped
public class Main implements Serializable {

    //private final File FOLDER_ROOT = new File("C:\\kptinp");
    //private final File FOLDER_ROOT = new File("/home/KPTFiles");
    private final File FOLDER_ROOT = new File(Utils.GetPropFromSetting("files_root_folder"));
    private final File FOLDER_DESTINATION_ROOT = new File(FOLDER_ROOT,"output");
    private final File UPLOAD_FOLDER = new File(FOLDER_ROOT, "input");
    private final File OUTPUT_ZIP_FOLDER = new File(UPLOAD_FOLDER,"!output_zip");

    private final Boolean REMOVE_OUTPUT_ZIP = false;

    public Main() {
        /*String clientIP = null;
        HttpServletRequest context = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext();
        clientIP = context.getHeader("X-FORWARDED-FOR");
        if(clientIP == null){
            clientIP = context.getRemoteAddr();
        }
        System.out.println(clientIP);*/
        if(!UPLOAD_FOLDER.exists()){
            UPLOAD_FOLDER.mkdirs();
        }
        if(!OUTPUT_ZIP_FOLDER.exists()){
            OUTPUT_ZIP_FOLDER.mkdirs();
        }
        if(!FOLDER_DESTINATION_ROOT.exists()){
            FOLDER_DESTINATION_ROOT.mkdirs();
        }
    }

    private boolean showProtocol = false;
    public boolean isShowProtocol() {
        return showProtocol;
    }

    private String status = "";
    public String getStatus() {
        return status;
    }

    private boolean canDownload = false;

    public boolean isCanDownload() {
        return canDownload;
    }

    /***
     * Загрузка файлов
     */
    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesContext.getCurrentInstance().getExternalContext().setResponseCharacterEncoding("UTF-8");
        handleFile(event.getFile());
      /*  try {
    //        String filenameExt =  new String(event.getFile().getFileName().getBytes(Charset.defaultCharset()), "UTF-8");
            String filenameExt =  event.getFile().getFileName();
            String extension = FilenameUtils.getExtension(filenameExt).toLowerCase();
            String filename = FilenameUtils.removeExtension(filenameExt);

            File newFolder = new File("C:\\kptinp\\input\\tmp",  String.format("%d_%s", System.currentTimeMillis()/1000, filename));
            int i = 0;
            while(newFolder.exists()){
                i++;
                newFolder = new File(String.format("%s(%d)",newFolder.getPath(),i));
            }
            newFolder.mkdirs();
            File newFile = new File(newFolder.getPath(), filenameExt);
            Files.copy(event.getFile().getInputstream(), newFile.toPath());

            //boolean success = false;
            try {
                File sourceFolder = Unzip(newFile);
                // sendEMail("Успешное преобразование КПТ","Файл преобразован");
                System.out.println(sourceFolder.getPath());
                File[] outputFile = sourceFolder.listFiles((dir, name) -> FilenameUtils.isExtension(name, "xml"));

                String base64 =  Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(outputFile[0])),
                        name = outputFile[0].getName();

                //success = true;
                content += div(
                        text("Файл "+ filename + " успешно обработан! "),
                        a("Нажмите сюда чтобы скачать файлы").withHref("data:application/zip;base64," +  base64)
                                .attr("download", name)
                                .withClass("linkfile")
                ).render();
            }*//*catch (FileNotFoundException e){

            }*//*catch (IOException e){
                content += div(
                        text("Ошибка обработки! " + e.getMessage())
                ).render();
            }

            FacesContext.getCurrentInstance().getExternalContext().setResponseCharacterEncoding("UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }*/


       /* FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);*/

    }

    private void handleFile(UploadedFile file){
        try {
            String filenameExt = file.getFileName();
            if(!FilenameUtils.isExtension(filenameExt, "zip")){
                hideProtocol();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ошибка обработки! Вы не прикрепили zip архив", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return;
            }
            //String extension = FilenameUtils.getExtension(filenameExt).toLowerCase();
            String filename = FilenameUtils.removeExtension(filenameExt);

            File newFolder = new File(UPLOAD_FOLDER, String.format("%d_%s", System.currentTimeMillis() / 1000, filename));
            int i = 0;
            while (newFolder.exists()) {
                i++;
                newFolder = new File(String.format("%s(%d)", newFolder.getPath(), i));
            }
            newFolder.mkdirs();
            File newFile = new File(newFolder.getPath(), filenameExt);
            Files.copy(file.getInputstream(), newFile.toPath());

            try {
                File sourceFolder = Archiver.Unzip(newFile);

                //Ввызов непосредственно конвертера с передачей sourceFolder
                ResultInfo resultInfo = Converter.convert(sourceFolder.getPath(), FOLDER_DESTINATION_ROOT);

                List<String> FilesName = new ArrayList<>();
                List<String> KadastarsName = new ArrayList<>();
                resultInfo.getFilesInfo().forEach(it -> {
                    if(it.isConverted()){
                        FilesName.add(it.getFileName());
                        it.getCadastralBlocks().forEach(bl -> KadastarsName.add(bl.getCadastralNumber()));
                    }
                });

                String msgBody = String.format("Успешно преобразованы Файлы: %s <br/> Содержащие кадастровые кварталы: %s",
                        ul(
                                each(FilesName, it -> li(it))
                        ).renderFormatted(),
                        ul(
                                each(KadastarsName, it -> li(it))
                        ).renderFormatted()
                );

                Utils.SendEMail("КПТ конвертер", msgBody);

                //Архивация папок со сгенерированными файлами
                downloadInfoFile = Archiver.CompressFiles(filename, resultInfo.getFilesInfo(), OUTPUT_ZIP_FOLDER, REMOVE_OUTPUT_ZIP);

                //Формирование отображения информации протокола обработки в требуемом формате
                status = generateProtocol(resultInfo, filenameExt);

                canDownload = true;
                showProtocol = true;
            }catch (IOException e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ошибка обработки! " + e.getMessage(), "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                hideProtocol();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void submit(){
        if(file != null) {
            handleFile(file);
           // sendEMail("Test","Сообщение");
        }
        //compressFiles();
    }

    private DownloadFile downloadInfoFile = null;

    public StreamedContent getDownloadFile() {
        StreamedContent downloadFile = null;
        if(downloadInfoFile != null && downloadInfoFile.getDownloadFileBuffer() != null) {
            downloadFile = new DefaultStreamedContent(downloadInfoFile.getDownloadFileBuffer(), "application/zip", downloadInfoFile.getDownloadFileName());
            downloadInfoFile.getDownloadFileBuffer().reset();//Иначе при повторном скачивании ничего не возвращается
        }
        return downloadFile;
    }


    /**
     * Скрывает панель протокола обработки
     */
    private void hideProtocol(){
        showProtocol = false;
        canDownload = false;
    }

    /***
     * Генерация текста протокола работы конвертера
     * @param resultInfo
     * @param filenameExt
     * @return
     */
    private String generateProtocol(ResultInfo resultInfo, String filenameExt){
        return
            div(
                text("Архив " + filenameExt + " успешно обработан! "),
                br(),
                text("В результате работы было успешно обработано файлов: " + resultInfo.getConvertedFilesCnt()),
                ul(
                        li(String.format("Кадастровых кварталов: %d", resultInfo.getStatistics().getCadastralBlocksCnt())),
                        li(String.format("Участков: %d", resultInfo.getStatistics().getParcelsCnt())),
                        li(String.format("Участков с геометрией: %d", resultInfo.getStatistics().getParcelsWGeoCnt())),
                        li(String.format("Участков без геометрии: %d", resultInfo.getStatistics().getParcelsCnt() - resultInfo.getStatistics().getParcelsWGeoCnt())),
                        li(String.format("Объектов капитального строительства: %d", resultInfo.getStatistics().getObjectsRealitiesCnt())),
                        li(String.format("Объектов капитального строительства с геометрией: %d", resultInfo.getStatistics().getObjectsRealitiesWGeoCnt())),
                        li(String.format("Объектов капитального строительства без геометрии: %d", resultInfo.getStatistics().getObjectsRealitiesCnt() - resultInfo.getStatistics().getObjectsRealitiesWGeoCnt()))
                ),
                text("Кол-во файлов с ошибками: " + resultInfo.getErrorFilesCnt()),
                br(), br(),
                text("========================Подробный отчет================================"),
                br(),
                each(resultInfo.getFilesInfo(), files ->
                        div(
                                text("Файл " + files.getFileName() + iffElse(files.isConverted(), " успешно обработан"," не обработан")), br(),
                                iffElse(files.isConverted(),
                                        each(files.getCadastralBlocks(), block ->
                                                div(text("Найден кадастровый квартал: " + block.getCadastralNumber() + ", содержащий:"),
                                                        iff(!block.getErrorMsg().isEmpty(), text("Предупреждение: " + block.getErrorMsg())),
                                                        ul(
                                                                li(String.format("Участков: %d", block.getStatistics().getParcelsCnt())),
                                                                li(String.format("Участков с геометрией: %d", block.getStatistics().getParcelsWGeoCnt())),
                                                                li(String.format("Участков без геометрии: %d", block.getStatistics().getParcelsCnt()-block.getStatistics().getParcelsWGeoCnt())),
                                                                li(String.format("Объектов капитального строительства: %d", block.getStatistics().getObjectsRealitiesCnt())),
                                                                li(String.format("Объектов капитального строительства с геометрией: %d", block.getStatistics().getObjectsRealitiesWGeoCnt())),
                                                                li(String.format("Объектов капитального строительства без геометрии: %d", block.getStatistics().getObjectsRealitiesCnt()-block.getStatistics().getObjectsRealitiesWGeoCnt()))
                                                        )
                                                )
                                        ),
                                        div("Ошибка: " + files.getErrorMsg())
                                ),
                                text("-------------------------------------------------------------------------------------------------------------------")
                        )
                )
            ).render();
    }

}