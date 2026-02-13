import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
    
  static  User_Info user = new User_Info();
    
    public static void sendMail(String recipient) throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

     //   String myAccountEmail = "im.7249000@gmail.com";
      String myAccountEmail = user.userEmail();
        String password = "njua xkgf aqqp ngib"; 

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        Message message = prepareMessage(session, myAccountEmail, recipient);

        // Enable debug mode to see additional information
        session.setDebug(true);

        try {
            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recipient) {
        Message message = new MimeMessage(session);
        System.out.println("Preparing message...");
        try {
            System.out.println("in try of prepared message");
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject("Fee Reminder");
            message.setText(MailMessage.message);
            return message;
        } catch (MessagingException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error preparing message.", ex);
        }
    }
}
