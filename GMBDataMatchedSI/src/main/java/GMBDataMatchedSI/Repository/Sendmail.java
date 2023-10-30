package GMBDataMatchedSI.Repository;


	import java.util.Properties;

	import javax.activation.DataHandler;
	import javax.activation.DataSource;
	import javax.activation.FileDataSource;
	import javax.mail.BodyPart;
	import javax.mail.Message;
	import javax.mail.MessagingException;
	import javax.mail.Multipart;
	import javax.mail.PasswordAuthentication;
	import javax.mail.Session;
	import javax.mail.Transport;
	import javax.mail.internet.InternetAddress;
	import javax.mail.internet.MimeBodyPart;
	import javax.mail.internet.MimeMessage;
	import javax.mail.internet.MimeMultipart;


	public class Sendmail {
		
		public static void mail(String subject) {

		// Recipient's email ID needs to be mentioned.
			String to = "jagdish.shinde@singleinterface.com";
				//String to = "abhishek.jaiswal@singleinterface.com,priyanka.rautela@singleinterface.com,deepika.sheoran@singleinterface.com, ritu@singleinterface.com,aijaz@singleinterface.com";
				
				//String to = "priyanka.rautela@singleinterface.com, deepika.sheoran@singleinterface.com, ritu@singleinterface.com, aijaz@singleinterface.com";

				// Sender's email ID needs to be mentioned
				String from = "automationscripts@singleinterface.com";

				final String username = "automationscripts@singleinterface.com";//change accordingly
				final String password = "ZZH3=uAe1";//change accordingly

				// Assuming you are sending email through relay.jangosmtp.net
				String host = "smtp.gmail.com";

				Properties props = new Properties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.port", "587");

				// Get the Session object.
				Session session = Session.getInstance(props,
						new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

				try {
					// Create a default MimeMessage object.
					Message message = new MimeMessage(session);

					// Set From: header field of the header.
					message.setFrom(new InternetAddress(from));

					// Set To: header field of the header.
					message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(to));

					// Set Subject: header field
					message.setSubject(subject);

					// Create the message part
					BodyPart messageBodyPart = new MimeBodyPart();

					// Now set the actual message
					messageBodyPart.setText("Hi Team,"+"\n"+"\n"+"Please check GMB Listing All Attributes");


					// Create a multipar message
					Multipart multipart = new MimeMultipart();

					//	         // Set text message part
					multipart.addBodyPart(messageBodyPart);

					// Part two is attachment
			         messageBodyPart = new MimeBodyPart();
			         String filename = "C:\\Users\\AbhishekJaiswal\\Downloads\\IOCLGMBDataMatchedSICode\\GMBDataMatchedSI\\src\\main\\java\\GMBDataMatchedSI\\Excel\\writeurl.xls";
			         DataSource source = new FileDataSource(filename);
			         messageBodyPart.setDataHandler(new DataHandler(source));
			         messageBodyPart.setFileName(filename);
			         multipart.addBodyPart(messageBodyPart);

					// Send the complete message parts
					message.setContent(multipart);

					// Send message
					Transport.send(message);

					System.out.println("Sent message successfully....");

				} catch (MessagingException e) {
					throw new RuntimeException(e);
				}
			}






	}

