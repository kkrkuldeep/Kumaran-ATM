package KumaranATM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer {
	private static String[] args;

	public static void sendMail(int withdrawAmt, int DepositAmt) throws SQLException {
		int userId = 0;
		String receipentEmail = "";

		// Setting up configurations for the email connection to the Google SMTP server
		// using TLS

		Properties props = new Properties();
		props.put("mail.smtp.host", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		// Establishing a session with required user details
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("kumaranfamilybank@gmail.com", "Kumaran@1234");
			}
		});
		try {
			CardAcountNumberGenerator.main(args);
			Connection con = ATMDataBaseConnection.JAVAConnection();
			String getUseruserId = "select IdcustomerData from customerdata where cardNum=?";

			PreparedStatement pst = con.prepareStatement(getUseruserId);
			pst.setString(1, Index.getCardtf());
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				userId = rs.getInt(1);
			}

			String getEmailQuery = "select email from pdetails where id=?";
			pst = con.prepareStatement(getEmailQuery);
			pst.setInt(1, userId);
			rs = pst.executeQuery();

			if (rs.next()) {
				receipentEmail = rs.getString(1);
			}

			// Creating a Message object to set the email content
			MimeMessage msg = new MimeMessage(session);
			// Storing the comma seperated values to email addresses
			String to = receipentEmail;
			/*
			 * Parsing the String with defualt delimiter as a comma by marking the boolean
			 * as true and storing the email addresses in an array of InternetAddress
			 * objects
			 */
			InternetAddress[] address = InternetAddress.parse(to, true);
			// Setting the recepients from the address variable
			msg.setRecipients(Message.RecipientType.TO, address);
			String timeStamp = new SimpleDateFormat("dd-LL-yyyy hh-mm-ss").format(new Date());

			msg.setSubject("Kumaran Bank " + timeStamp); // Subject
			msg.setSentDate(new Date());

			if (withdrawAmt != 0) {
				msg.setText("Rs. " + withdrawAmt
						+ " successfully debited from your account \nThankyou For Joining Kumaran Bank");
			} else {
				msg.setText("Rs. " + DepositAmt
						+ " successfully credit from your account \nThankyou For Joining Kumaran Bank");
			}

			msg.setHeader("This is a Header", "1");
			Transport.send(msg);
			System.out.println("Mail has been sent successfully");
		} catch (MessagingException mex) {
			System.out.println("Unable to send an email" + mex);
		}
	}
}