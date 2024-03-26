package basic;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class EmailSender {
    private static final Logger LOGGER = Logger.getLogger(EmailSender.class.getName());
    Session newSession = null;
    MimeMessage mimeMessage = null;

    public void spaOrganizer(String names) throws MessagingException {
        EmailSender mail = new EmailSender();
        mail.setupServerProperties();
        mail.draftEmail(names);
        LOGGER.info("Before mail.send     ;;;;;;;;;;;;;;;");
        mail.sendEmail();
    }

    private void sendEmail() throws NoSuchProviderException {
        String fromUser = "qsaydwekat994@gmail.com";
        String fromUserP = "pcyk etix wkxu tvxl";
        String emailHost = "smtp.gmail.com";

        Transport transport = newSession.getTransport("smtp");

        try {
            transport.connect(emailHost, fromUser, fromUserP);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());

        } catch (MessagingException e) {
          LOGGER.log(Level.INFO,"Error sending email: {0}", e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                transport.close();
            } catch (MessagingException e) {
                LOGGER.log(Level.INFO,"Error closing transport: {0}", e.getMessage());
                e.printStackTrace();
            }
        }
    }
    private MimeMessage draftEmail(String names) throws MessagingException {
        String emailSubject = "Your product is completed";
        String emailBody = "Come to the store and take the product as soon as possible.";

        mimeMessage = new MimeMessage(newSession);

        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(names));
        mimeMessage.setSubject(emailSubject);

        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(emailBody, "text/html"); // Corrected content type
        MimeMultipart multiPart = new MimeMultipart();
        multiPart.addBodyPart(bodyPart);
        mimeMessage.setContent(multiPart);

        return mimeMessage;
    }

    private void setupServerProperties() {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        newSession = Session.getDefaultInstance(properties, null);
    }

}