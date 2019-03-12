package converter.kpt;

import converter.kpt.info.CadastralBlockInfo;
import converter.kpt.info.FileInfo;
import converter.kpt.info.ResultInfo;
import j2html.tags.ContainerTag;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import static j2html.TagCreator.*;

@ManagedBean(name = "Main")
@ViewScoped
public class Main implements Serializable {

    private final File FOLDER_ROOT = new File("C:\\kptinp");
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
                File sourceFolder = Unzip(newFile);

                //Ввызов непосредственно конвертера с передачей sourceFolder
                ResultInfo resultInfo = Converter.convert(sourceFolder.getPath(), FOLDER_DESTINATION_ROOT);

                //TODO: Раскоментить
                // sendEMail("Успешное преобразование КПТ","Файл преобразован");

                //Архивация папок со сгенерированными файлами
                compressFiles(filename, resultInfo.getFilesInfo());

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
        }
        //compressFiles();
    }

    private File Unzip(File pathZip) throws IOException {
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
                                //    throw new IOException(String.format("Внутренний %s архив поврежден, невозможно извлечь файлы", zip.getName()), e);
            }
        }catch (IOException e){
          //  hideProtocol();
            throw new IOException(String.format("%s %s поврежден, невозможно извлечь файлы", archive, archiveName), e);
        }

       /* try(ZipInputStream zin = new ZipInputStream(new FileInputStream(pathZip))){
            //ZipFile zi = new ZipFile(pathZip, Charset.forName("CP866"));
           *//* Enumeration<? extends ZipEntry> entries = zi.entries();
            ZipEntry ze;*//*
           *//* while (entries.hasMoreElements()){
                ze = entries.nextElement();
                String filename =  new String(ze.getName().getBytes(Charset.defaultCharset()), "UTF-8");
//            FileOutputStream outFile = new FileOutputStream(new File(outputFolder.getPath(), entry.getName()));
                FileOutputStream outFile = new FileOutputStream(new File(outputFolder.getPath(), filename));
                int readBytes;
                while((readBytes = zin.read()) != -1) {
                    outFile.write(readBytes);
                }
                outFile.close();
            }*//*

            //ExtractFile(outputFolder, zin);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException(String.format("Архив %s поврежден, невозможно извлечь файлы", pathZip.toPath().getFileName()), e);
        }
*/
        /*File[] innerZip = outputFolder.listFiles((dir, name) -> FilenameUtils.isExtension(name, "zip"));
        for(File zip : innerZip){
            try(ZipInputStream zin = new ZipInputStream(new FileInputStream(zip.getPath()))){
                ExtractFile(outputFolder, zin);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
                throw new IOException(String.format("Внутренний %s архив поврежден, невозможно извлечь файлы", zip.getName()), e);
            }
        }*/

        if(outputFolder.listFiles((dir, name) -> FilenameUtils.isExtension(name, "xml")).length == 0){
           //hideProtocol();
            throw new FileNotFoundException(String.format("В архиве %s отсутствует файл КПТ", pathZip.toPath().getFileName()));
        }
        return outputFolder;
    }

    /***
     * Извлечение файлов из архива
     * @param outputFolder
     * @param pathZip
     * @throws IOException
     */
    private void ExtractFile(File pathZip, File outputFolder) throws IOException {
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

    /**
     * Архивирование файлов полученыых от бэка
     * @return
     */
    private void compressFiles(String outFileName, List<FileInfo> convertInfo){
        downloadFileName = String.format("%s_geojson(%d).zip", outFileName, System.currentTimeMillis());
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
    }

    //TODO: Проверить оотправку на серваке
    /***
     * Отправка уведомления на почту
     * @param subject
     * @param body
     */
    private void sendEMail(String subject, String body){
        try {

            Properties props = new Properties();
            props.put("mail.smtp.host", "mail2.uriit.ru");
            props.put("mail.smtp.port", 25);

            Session session = Session.getInstance(props);

            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("KPTconvert@uriit.ru"));

            msg.setSubject(subject, "UTF-8");

            msg.setContent(body, "text/html; charset=UTF-8");

            //msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("slobodenyukss@uriit.ru", false));
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


    private StreamedContent downloadFile;
    private ByteArrayInputStream downloadFileBuffer;
    private String downloadFileName;

    public StreamedContent getDownloadFile() {
        if(downloadFileBuffer != null) {
            downloadFile = new DefaultStreamedContent(downloadFileBuffer, "application/zip", downloadFileName);
            downloadFileBuffer.reset();//Иначе при повторном скачивании ничего не возвращается
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


    private void addDirectory(ZipOutputStream zout, File fileSource)
    {
        try {
            File[] files = fileSource.listFiles();
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
                                                        ul(
                                                                li(String.format("Участков: %d", block.getStatistics().getParcelsCnt())),
                                                                li(String.format("Участков с геометрией: %d", block.getStatistics().getParcelsWGeoCnt())),
                                                                li(String.format("Участков без геометрии: %d", block.getStatistics().getParcelsCnt()-block.getStatistics().getParcelsWGeoCnt())),
                                                                li(String.format("Объектов капитального строительства: %d", block.getStatistics().getObjectsRealitiesCnt())),
                                                                li(String.format("Объектов капитального строительства с геометрией: %d", block.getStatistics().getObjectsRealitiesWGeoCnt())),
                                                                li(String.format("Объектов капитального строительства без геометрии: %d", block.getStatistics().getObjectsRealitiesCnt()-block.getStatistics().getObjectsRealitiesWGeoCnt()))
                                                        ),
                                                        iff(!block.getErrorMsg().isEmpty(), text("Предупреждение: " + block.getErrorMsg()))
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