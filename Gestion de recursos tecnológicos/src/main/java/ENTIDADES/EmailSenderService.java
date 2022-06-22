package ENTIDADES;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSenderService {
	private final static Properties properties = new Properties();

	private String password;

	private static Session session;

	private static void init() {

		properties.put("mail.smtp.host", "mail.gmail.com");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.port", 465);
		properties.put("mail.smtp.mail.sender", "grupo3dsiutnfrc@gmail.com");
		properties.put("mail.smtp.user", "usuario");
		properties.put("mail.smtp.auth", "true");

		session = Session.getDefaultInstance(properties);
	}

	public static void enviarMail(String receptor, String asunto, String mensaje) {

		init();
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
			message.setSubject(asunto);
			message.setText(mensaje);
			Transport t = session.getTransport("smtp");
			t.connect((String) properties.get("mail.smtp.user"), "grupo3dsi");
			t.sendMessage(message, message.getAllRecipients());
			t.close();
		} catch (MessagingException me) {
			System.out.println(me);
			return;
		}

	}
}
