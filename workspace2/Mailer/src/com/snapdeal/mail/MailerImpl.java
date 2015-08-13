package com.snapdeal.mail;

import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.snapdeal.dao.Users;

import org.hibernate.SessionFactory;

public class MailerImpl implements Mailer {

	private String from;

	@Override
	public void sendMail(Set<String> participantsSet, SessionFactory factory) {

		org.hibernate.Session hibernateSession = factory.openSession();
		String hql = "FROM Users";
		hibernateSession.beginTransaction();

		List<Users> list = hibernateSession.createQuery(hql).list();

		hibernateSession.getTransaction().commit();

		// mail to each id individually as msg is diff for each id
		Session session = getMailingSession();
		for (Users user : list) {

			if (participantsSet.contains(user.getUserid())) {
				String msg = createMessage(user.getUserid(), user.getPassword());
				try {
					sendSingleMail(session, from, user.getUserid(), msg);
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private String createMessage(String participant, String password) {
		return "Hey,\n\n" + "USERID: " + participant + "\n" + "PASSWORD: "
				+ password;
	}

	private Session getMailingSession() {
		ResourceBundle rb = ResourceBundle.getBundle("login");

		from = rb.getString("id");
		final String pass = rb.getString("password");

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(from, pass);
					}
				});
		return session;
	}

	private void sendSingleMail(Session session, String from, String to,
			String msg) throws AddressException, MessagingException {

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));
		message.setSubject("Follow Up link for test");
		message.setText(msg);

		System.out.println("MAILER: Sending mail..");
		Transport.send(message);
		System.out.println("MAILER: Mail sent successfully");
	}
}