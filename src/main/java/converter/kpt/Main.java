package converter.kpt;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

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
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Enumeration;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static j2html.TagCreator.*;

@ManagedBean(name = "Main")
@ViewScoped
public class Main implements Serializable {
    /*public Main() {

    }*/

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
                hideProtokol();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ошибка обработки! Вы не прикрепили zip архив", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return;
            }
            //String extension = FilenameUtils.getExtension(filenameExt).toLowerCase();
            String filename = FilenameUtils.removeExtension(filenameExt);

            File newFolder = new File("C:\\kptinp\\input\\tmp", String.format("%d_%s", System.currentTimeMillis() / 1000, filename));
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

                //TODO: Ввызов бэка с передачей sourceFolder

                //TODO: Раскоментить
                // sendEMail("Успешное преобразование КПТ","Файл преобразован");

                // TODO: Раскоментить
                // outFile = CompressFiles();

                //TODO: Удалить после того как появится функция бэка
                System.out.println(sourceFolder.getPath());
                File[] outputFile = sourceFolder.listFiles((dir, name) -> FilenameUtils.isExtension(name, "xml"));
                outFile = outputFile[0];

                /*String base64 = "",//Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(outputFile[0])),
                        name = outputFile[0].getName();*/

                //TODO: Сформировать отображение информации в требуемом формате
                status += div(
                        text("Архив " + filename + " успешно обработан! ")
                ).render();

                canDownload = true;
                showProtocol = true;
            }/*catch (FileNotFoundException e){

            }*/ catch (IOException e) {
                /*status += div(
                        text("Ошибка обработки! " + e.getMessage())
                ).render();*/
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ошибка обработки! " + e.getMessage(), "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                hideProtokol();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void submit(){
        if(file != null) {
            handleFile(file);
        }
        System.out.println("ajax");
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
          //  hideProtokol();
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
           //hideProtokol();
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
    private File compressFiles(){
        return null;
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
            props.put("mail.smtp.host", "mail.uriit.ru");
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
    private File outFile = null;

    public StreamedContent getDownloadFile() {
        if(outFile != null) {
            InputStream stream = null;
            try {
                stream = new FileInputStream(outFile);
                downloadFile = new DefaultStreamedContent(stream, "application/zip", outFile.getName());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return downloadFile;
    }


    /**
     * Скрывает панель протокола обработки
     */
    private void hideProtokol(){
        showProtocol = false;
        canDownload = false;
    }

}