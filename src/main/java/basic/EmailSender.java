package basic;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {//
    String receiveEmail;
    String from;
    public EmailSender(String receiveEmail){
        this.receiveEmail = receiveEmail;
        this.from="qsaydwekat994@gmail.com";}

    private void sending(String subject, String text){
        try {
            Properties properties = System.getProperties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator(){
                @Override
                protected  PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication("qsaydwekat994@gmail.com","pcyk etix wkxu tvxl");
                }
            });
            session.setDebug(false);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiveEmail,false));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
        }

        catch (MessagingException ex) {
            ex.fillInStackTrace();

        }
    }

    public boolean sendEmail(String subject, String text) {
        if(subject.isEmpty() && text.isEmpty())
           return false;
        else {
            sending(subject, text);
            return true;
        }
    }



}
