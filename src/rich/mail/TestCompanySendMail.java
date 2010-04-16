
package rich.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import junit.framework.TestCase;

/**
 * @author Rich.Li
 * 
 */
public class TestCompanySendMail extends TestCase {
  String from = "";
  String to = "";
  String userName = "";
  String passwd = "";
  
  String companyHost = "";
  String companyPort = "25";
  
  
  public void testcompanySend() {

    // Get system properties
    Properties props = System.getProperties();

    // Setup mail server
    props.put("mail.smtp.host", companyHost);
    props.put("mail.smtp.port", companyPort);

    // Get session
    Session session = Session.getInstance(props, null);

    // Define message
    MimeMessage message = new MimeMessage(session);
    try {
      message.setFrom(new InternetAddress(from));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
      message.setSubject("Hello JavaMail");
      message.setText("Welcome to JavaMail");

      Transport trans = session.getTransport("smtp");
      System.out.println("start to connect successfully");
      trans.connect();
      System.out.println("connect successfully");
      // Send message
      Transport.send(message);
    } catch (AddressException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (MessagingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  private String mailhost = "smtp.gmail.com";

  public void testSendGamil() {

    try {
      sendMail("Hello JavaMail", "elcome to JavaMail", from, to);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public synchronized void sendMail(String subject, String body, String sender,
      String recipients) throws Exception {

//    Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

    Properties props = new Properties();
    props.setProperty("mail.transport.protocol", "smtp");
    props.setProperty("mail.host", mailhost);
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.socketFactory.fallback", "false");
    props.setProperty("mail.smtp.quitwait", "false");

    Session session = Session.getDefaultInstance(props,
        new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(userName, passwd);
          }
        });
    MimeMessage message = new MimeMessage(session);
    message.setSender(new InternetAddress(sender));
    message.setSubject(subject);
    message.setContent(body, "text/plain");
    if (recipients.indexOf(',') > 0)
      message.setRecipients(Message.RecipientType.TO, InternetAddress
          .parse(recipients));
    else
      message.setRecipient(Message.RecipientType.TO, new InternetAddress(
          recipients));

    Transport trans = session.getTransport("smtp");
    trans.connect(companyHost,Integer.parseInt(companyPort), userName, passwd);
    trans.send(message);

  }

}
