package converter.kpt.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import converter.kpt.exceptions.CustomException;
import converter.kpt.info.InfoIP;
import converter.kpt.kpt.KPT;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class Utils {

    public static String XmlGCToStr(XMLGregorianCalendar calendar) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");
        return sdf.format(calendar.toGregorianCalendar().getTime());
    }

    /***
     * Отправка уведомления на почту
     * @param subject
     * @param body
     */
    public static void SendEMail(String subject, String body, ExternalContext context){
        try {

            Properties props = new Properties();
            props.put("mail.smtp.host", "mail.uriit.ru");
            props.put("mail.smtp.port", 25);

            Session session = Session.getInstance(props);

            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("KPTconvert@uriit.ru"));

            msg.setSubject(subject, "UTF-8");

            msg.setContent(body, "text/html; charset=UTF-8");

            String[] mails = GetPropFromSetting("email", context).split(",");

            for(String mail: mails){
                mail = mail.trim();
                if(msg.getAllRecipients() != null && msg.getAllRecipients().length > 0){
                    msg.addRecipients(Message.RecipientType.CC, InternetAddress.parse(mail, false));
                }else{
                    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail, false));
                }
            }

            Transport.send(msg);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /***
     * Считывание настроек с файла конфигураций
     * @param propertie Требуемое значение конфигурации
     * @return
     */
    public static String GetPropFromSetting(String propertie, ExternalContext externalContext)  {
//        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Properties props = new Properties();
        String val = null;
        try {
            props.load(externalContext.getResourceAsStream("/WEB-INF/setting.properties"));
            val =  props.getProperty(propertie);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(val == null){
            switch (propertie.toLowerCase()){
                case "files_root_folder":
                    val = "/home/KPTFiles";
                    break;
                case "email":
                    val = "KocherginGA@uriit.ru,OgorodnikovIN@uriit.ru";
                    //val = "slobodenyukss@uriit.ru";
                    break;
            }
        }
        return val;
    }


    public static InfoIP GetIPandGeolocation(HttpServletRequest context){
        String clientIP = null;
        //HttpServletRequest context = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        clientIP = context.getHeader("X-FORWARDED-FOR");
        if(clientIP == null){
            clientIP = context.getRemoteAddr();
        }

        InfoIP info = null;
        if(clientIP != null) {
            try {
                URL url = new URL( String.format("http://ip-api.com/json/%s?fields=196413&lang=ru", clientIP));
                URLConnection con = url.openConnection();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                con.getInputStream(), "UTF-8"));
                //String inputLine = in.readLine();
                ObjectMapper obj = new ObjectMapper();
                info = obj.readValue(in, InfoIP.class);
                in.close();
            } catch (Exception e) {
                System.err.println("Ошибка запроса информации об IP адресе клиента\r\n");
                e.printStackTrace();
            }
        }

        if(info == null){
            info = new InfoIP();
            info.setQuery(clientIP);
        }

        return info;

    }

}
