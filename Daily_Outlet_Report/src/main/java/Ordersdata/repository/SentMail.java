package Ordersdata.repository;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.WebDriver;

import pages.ReadEmail;
import pages.ReadFile;


public class SentMail {
	
    WebDriver driver;
 	public  ReadFile rl;
    public  ReadEmail re;
    static String mailsubject;
    final StringBuffer previousDate = re.buffer;
    static String to;
    static String path;
    
    
	public void mail(String subject) throws IOException {
		mailsubject = subject;

	      // Recipient's email ID needs to be mentioned.khushboo.kashyap@singleinterface.com, dheeraj.bhatt@singleinterface.com, abhinav.singh@singleinterface.com
//		String to = "aijaz@singleinterface.com, khushboo.kashyap@singleinterface.com, dheeraj.bhatt@singleinterface.com, abhinav.singh@singleinterface.com, shailendra@singleinterface.com, manoj.yadav@singleinterface.com, renu.lohia@singleinterface.com, prashant.shandilya@singleinterface.com, parul.kapoor@singleinterface.com, brijesh.kumar@singleinterface.com, aman.sharma@singleinterface.com, pawan.yadav@singleinterface.com, deepika.gupta@singleinterface.com, aashita.bhayana@singleinterface.com, abhinav.singh@singleinterface.com, abhishek.jaiswal@singleinterface.com, deepak.ghorela@singleinterface.com, deepika.sheoran@singleinterface.com, ritu@singleinterface.com, ashish.tomar@singleinterface.com, naval.upadhyay@singleinterface.com, priyanka.rautela@singleinterface.com";
		if(rl.fail()==0  & rl.pass()!=0) {
			
			 to = "jagdish.shinde@singleinterface.com";
		}else {
			 to = "jagdish.shinde@singleinterface.com";
		}
		
	  
		// Sender's email ID needs to be mentioned
	      String from = "siclientsupport@singleinterface.com";

	      final String username = "siclientsupport@singleinterface.com";//change accordingly
	      final String password = "M*A$97#DvP17*";//change accordingly

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
	    	  MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO,
	            InternetAddress.parse(to));
	   
	         // Set Subject: header field
	            message.setSubject("🛑⚠️"+mailsubject+"🛑⚠️", "utf-8");

	         // Create the message part
            MimeBodyPart messageBodyPart = new MimeBodyPart();
	         
	         // Now set the actual message
	         try {
	        	 
	        	 try {
	        	   if(rl.fail()==0) {
	        		   
	        		   if(rl.todaySheet().toString().equals("Previous date data is not preasent in the sheet.Please check the today's downloaded sheet")) {
		        			 //messageBodyPart.setText("Hi Team, "+"\n"+"Please check Demo Mail of SI Location count for the Date of "+previousDate+" and report is::: "+"\n"+"Total Client Pass Count :"+rl.pass()+"\n"+"Total Client Fail Count :"+rl.fail()+"\n"+"Open location count issue in these clients :" +rl.sb());
		        			 String htmlText = "<H2><font color=red>!! Danger Alert !!</font</H2>\n"+
		        	        		 "<font size =\"3\" face=\"arial\" color=red >Hi Team, Previous date data in missing in the sheet. Please check the sent mail.</font>";
			                 messageBodyPart.setContent(htmlText,"text/html");
		        			 
		        		 }
		        		 else {
		        		    messageBodyPart.setText("Hi Team, "+"\n"+"Please check Demo Mail of SI Location count for the Date of "+previousDate+" and report is::: "+"\n"+"Total Client Pass Count :"+rl.pass()+"\n"+"Total Client Fail Count :"+rl.fail()+"\n"+"Open location count issue in these clients :" +rl.sb());
		        		 }
	        		   
	        		   
	        		// messageBodyPart.setText("Hi Team, "+"\n"+"Please check Demo Mail of SI Location count for the Date of "+previousDate+" and report is::: "+"\n"+"Total Client Pass Count :"+rl.pass()+"\n"+"Total Client Fail Count :"+rl.fail()+"\n"+"Open location count issue in these clients :" +rl.sb());
	        	   }
	        	 }catch(Exception e) {
	        		 System.out.println(e.getMessage());
	        	 }
	        
	        	 if(rl.fail()>0 ) {
	        		 //System.out.println(rl.todaySheet().toString());
	        		 if(rl.todaySheet().toString().equals("Previous date data is not preasent in the sheet.Please check the today's downloaded sheet")) {
	        			 //messageBodyPart.setText("Hi Team, "+"\n"+"Please check Demo Mail of SI Location count for the Date of "+previousDate+" and report is::: "+"\n"+"Total Client Pass Count :"+rl.pass()+"\n"+"Total Client Fail Count :"+rl.fail()+"\n"+"Open location count issue in these clients :" +rl.sb());
	        			 String htmlText = "<H2><font color=red>!! Danger Alert !!</font</H2>\n"+
	        	        		 "<font size =\"3\" face=\"arial\" color=red >Hi Team, Previous date data in missing in the sheet. Please check the sent mail.</font>";
		                 messageBodyPart.setContent(htmlText,"text/html");
	        			 
	        		 }
	        		 else {
	        		    messageBodyPart.setText("Hi Team, "+"\n"+"Please check Demo Mail of SI Location count for the Date of "+previousDate+" and report is::: "+"\n"+"Total Client Pass Count :"+rl.pass()+"\n"+"Total Client Fail Count :"+rl.fail()+"\n"+"Open location count issue in these clients :" +rl.sb());
	        		 }
	        	 } 
	        	 else {
	        		 if(re.mailSubject().toString().equals("Mail Subject Not Found")) {
	        		      
	        	         String htmlText = "<H2><font color=red>!! Danger Alert !!</font</H2>\n"+
	        	        		 "<font size =\"3\" face=\"arial\" color=red >Hi Team, Mail not sent today. Please check the sent mail.</font>";
		                 messageBodyPart.setContent(htmlText,"text/html");
	        		 }

	        		 
	        		  else if(re.mailLink().toString().equals("Url is not present in the mail")) {
	        			 String htmlText = "<H2><font color=red>!! Danger Alert !!</font</H2>\n"+
		        	        		 "<font size =\"3\" face=\"arial\" color=red >Hi Team, Sheet url is not present in the mail otherwise sheet not downloads due to network issue. Please check the sent mail.</font>";
	        			 messageBodyPart.setContent(htmlText, "text/html");
	        		 }
	        		else if(rl.sheetDownload().toString().equals("Sheet not download. The Excel file does not exist.")) {
	        			 String htmlText = "<H2><font color=red>!! Danger Alert !!</font</H2>\n"+
	        	        		 "<font size =\"3\" face=\"arial\" color=red >Hi Team, Sheet not downloads due to network essue. Please check the sent mail.</font>";
       			         messageBodyPart.setContent(htmlText, "text/html");
	        			 
	        		 }
//	        		else if(rl.todaySheet().toString().equals("Previous date data is not preasent in the sheet. Please check the today's downloaded sheet")) {
//    			         //String htmlContent = "<html><body><p style='color:red;'>Previous date is not preasent in the sheet. Please check the today's downloaded sheet.</p></body></html>";
//	        			 String htmlText = "<H2><font color=red>!! Danger Alert !!</font</H2>\n"+
//	        	        		 "<font size =\"3\" face=\"arial\" color=red >Hi Team, Previous date data is blank in the downloaded sheet. Please check the sent mail.</font>";
//	                     messageBodyPart.setContent(htmlText, "text/html");
//    		         }
//    		 
	        	  }

	          } catch(Exception e) {
	        	  
	        	  System.out.println(e.getMessage());
	        	  
	         }

	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();

//	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Part two is attachment
	         
	         messageBodyPart = new MimeBodyPart();
//	         if(rl.fail()==0 & rl.pass()!=0) {
//	        	 path = System.getProperty("user.dir")+"//writeexcel.xls";
//	         }
//	         else {
//	        	 path = System.getProperty("user.dir")+"//writeexcel.xls";
//	         }
	         
	         if(rl.fail()==0 && rl.pass()==0) {
	        	 path = System.getProperty("user.dir")+"//writeexcel.xls";
	         }
	         else {
	        	 path = System.getProperty("user.dir")+"//writeexcel.xls";
	         }
	         
	         String filename = path;
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
