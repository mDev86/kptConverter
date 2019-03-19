package converter.kpt.utils;

import converter.kpt.info.CadastralBlockInfo;
import converter.kpt.info.DownloadFile;
import converter.kpt.info.FileInfo;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class Archiver {

    /***
     * Разархивирование архива и проверка на наличие файлов
     * @param pathZip
     * @return
     * @throws IOException
     */
    public static File Unzip(File pathZip) throws IOException {
        File outputFolder = new File(pathZip.toPath().getParent().toString(), FilenameUtils.removeExtension(pathZip.toPath().getFileName().toString()));
        outputFolder.mkdirs();

        String archive = "Архив",
                archiveName = pathZip.toPath().getFileName().toString();

        try{
            ExtractFile(pathZip, outputFolder);
            File[] innerZip = outputFolder.listFiles((dir, name) -> FilenameUtils.isExtension(name, "zip"));
            archive = "Внутренний архив";
            for(File zip : innerZip){
                archiveName = zip.getName();
                ExtractFile(zip, outputFolder);
            }
        }catch (IOException e){
            throw new IOException(String.format("%s %s поврежден, невозможно извлечь файлы", archive, archiveName), e);
        }

        if(outputFolder.listFiles((dir, name) -> FilenameUtils.isExtension(name, "xml")).length == 0){
            throw new FileNotFoundException(String.format("В архиве %s отсутствует файл КПТ", pathZip.toPath().getFileName()));
        }
        return outputFolder;
    }


    /**
     * Архивирование файлов полученыых от бэка
     * @return
     */
    public static DownloadFile CompressFiles(String outFileName, List<FileInfo> convertInfo, File OUTPUT_ZIP_FOLDER, Boolean REMOVE_OUTPUT_ZIP){
        ByteArrayInputStream downloadFileBuffer = null;
        String downloadFileName = String.format("%s_geojson(%d).zip", outFileName, System.currentTimeMillis());
        File zipOut = new File(OUTPUT_ZIP_FOLDER, downloadFileName);

        try {
            // Cоздание объекта ZipOutputStream из FileOutputStream
            FileOutputStream fout = new FileOutputStream(zipOut);
            ZipOutputStream zout = new ZipOutputStream(fout);
            // Определение кодировки
            //zout.setEncoding("CP866");

            // Создание объекта File object архивируемой директории (Добавление в цикле всех требуемых папок)
            for(FileInfo file: convertInfo){
                if(file.isConverted()) {
                    for(CadastralBlockInfo block: file.getCadastralBlocks()){
                        File f1 = new File(block.getExportFolder());
                        addDirectory(zout, f1);
                    }
                }
            }

            // Закрываем ZipOutputStream
            zout.close();

            //Храним в памяти выходной архив для выгрузки пользователю
            InputStream tmpIO = new FileInputStream(zipOut);
            downloadFileBuffer = new ByteArrayInputStream(IOUtils.toByteArray(tmpIO));
            tmpIO.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        if(REMOVE_OUTPUT_ZIP) {
            zipOut.delete();
        }

        return new DownloadFile(downloadFileName, downloadFileBuffer);
    }


    /***
     * Извлечение файлов из архива
     * @param outputFolder
     * @param pathZip
     * @throws IOException
     */
    private static void ExtractFile(File pathZip, File outputFolder) throws IOException {
        ZipFile zip = new ZipFile(pathZip, Charset.forName("CP866"));
        Enumeration<? extends ZipEntry> entries = zip.entries();
        ZipEntry entry;
        while (entries.hasMoreElements()) {
            entry = entries.nextElement();

            InputStream is = zip.getInputStream(entry);
            BufferedInputStream bis = new BufferedInputStream(is);
            FileOutputStream fileOutput = new FileOutputStream(new File(outputFolder.getPath(), entry.getName()));
            while (bis.available() > 0)
            {
                fileOutput.write(bis.read());
            }
            fileOutput.close();
        }
    }

    /***
     * Рекурсивное архивирование папок с файлами
     * @param zout Выходной архив
     * @param fileSource Архивируемая папка
     */
    private static void addDirectory(ZipOutputStream zout, File fileSource)
    {
        try {
            File[] files = fileSource.listFiles((dir, name) -> FilenameUtils.isExtension(name, "geojson"));
//        System.out.println("Добавление директории <" + fileSource.getName() + ">");
            for (int i = 0; i < files.length; i++) {
                // Если file является директорией, то рекурсивно вызываем
                // метод addDirectory
                if (files[i].isDirectory()) {
                    addDirectory(zout, files[i]);
                    continue;
                }
//            System.out.println("Добавление файла <" + files[i].getName() + ">");

                FileInputStream fis = new FileInputStream(files[i]);
                zout.putNextEntry(new ZipEntry(files[i].getParentFile().getName() + "\\" + files[i].getName()));

                byte[] buffer = new byte[4048];
                int length;
                while ((length = fis.read(buffer)) > 0)
                    zout.write(buffer, 0, length);
                // Закрываем ZipOutputStream и InputStream
                zout.closeEntry();
                fis.close();
            }
        }catch (Exception e){
            System.out.println("Ошибка архивирования");
            e.printStackTrace();
        }

    }

}
