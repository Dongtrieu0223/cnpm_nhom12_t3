package lol.work.stop.Model;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class SendMail2 {

    public static void sendEmail(String host, String port,
                                 final String userName, final String password, String toAddress,String message) throws AddressException,
            MessagingException {

        // sets SMTP server properties
        
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.mime.charset","UTF-8");

        // creates a new session with an authenticator
        Authenticator auth=new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };



        Session session = Session.getInstance(properties, auth);

        // creates a new e-mail message
        Message msg = new MimeMessage(session);
        msg.setContent(msg, "UTF-8");

        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = {new InternetAddress(toAddress)};
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        String sub = "Vui long nhap vao duong link de xac nhan tai khoan: ";

        msg.setSubject(sub);
        msg.setSentDate(new Date());
        // duong dan trong mail láy link của waiting.jsp
        //3. link cho nguoi dung nhan vao de xac thuc
        msg.setText(message);

        // sends the e-mail
        Transport.send(msg);
    }
}
