package pages;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Properties;
//
//import javax.mail.BodyPart;
//import javax.mail.Flags;
//import javax.mail.Folder;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Multipart;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Store;
//import javax.mail.search.AndTerm;
//import javax.mail.search.BodyTerm;
//import javax.mail.search.SearchTerm;
//import javax.mail.search.SubjectTerm;
//
//import org.openqa.selenium.WebDriver;
//
//public class ReadMail {
//	
//	public WebDriver driver;
//	public ReadMail(WebDriver driver) {
//		this.driver = driver;
//		
//	}
//    public void read() {
//        final String username = "your_username@gmail.com";
//        final String password = "your_password";
//
//        // IMAP properties
//        Properties props = new Properties();
//        props.put("mail.store.protocol", "imaps");
//        props.put("mail.imap.ssl.trust", "*");
//        props.put("mail.imaps.host", "imap.gmail.com");
//        props.put("mail.imaps.port", "993");
//
//        // Create a session and authenticate
//        Session session = Session.getInstance(props,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(username, password);
//                    }
//                });
//
//        try {
//            // Connect to the inbox folder
//            Store store = session.getStore("imaps");
//            store.connect();
//
//            Folder inbox = store.getFolder("inbox");
//            inbox.open(Folder.READ_ONLY);
//            
//            SearchTerm searchTerm = new AndTerm(
//            	    new SubjectTerm("Regarding QR scanner code report for stores.exidecare.com. Total Pass= 0 Total Fail= 663"), // Replace with your subject
//            	    new BodyTerm("multipart")
//            	);
//             Message[] messages = inbox.search(searchTerm);
//
////            // Search for emails with attachments
////              Message[] messages = inbox.search((msg) -> {
////            
////                try {
////                    return msg.getContentType().toLowerCase().contains("multipart") &&
////                           msg.getSubject().contains("Your Subject Here"); // You can specify a subject filter
////                } catch (MessagingException e) {
////                    e.printStackTrace();
////                    return false;
////                }
////            });
//
//            for (Message message : messages) {
//                // Check if the email is not flagged as SEEN
//                if (!message.isSet(Flags.Flag.SEEN)) {
//                    // Get the attachment if it exists
//                    Multipart multipart = (Multipart) message.getContent();
//                    for (int i = 0; i < multipart.getCount(); i++) {
//                        BodyPart bodyPart = multipart.getBodyPart(i);
//                        if (bodyPart.getDisposition() != null &&
//                            bodyPart.getDisposition().equalsIgnoreCase("ATTACHMENT")) {
//                            String fileName = bodyPart.getFileName();
//                            
//                            // Save the attachment to a specified folder
//                            String savePath = "C:\\Attachments\\" + fileName;
//                            try (FileOutputStream fos = new FileOutputStream(savePath)) {
//                                fos.write((int) bodyPart.getContent());
//                                System.out.println("Attachment saved to: " + savePath);
//                            }
//                        }
//                    }
//                }
//            }
//
//            // Close the folder and store
//            inbox.close(false);
//            store.close();
//
//        } catch (MessagingException | IOException e) {
//            e.printStackTrace();
//        }
//    }
//}

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;
import javax.mail.search.SearchTerm;
import javax.mail.search.SubjectTerm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ReadEmail {
	
	public WebDriver driver;
    String wordText;
    public String previousdate;
    public static StringBuffer buffer  = new StringBuffer();
    public static String formattedDate ;
    public String date =formattedDate;
    static  String mailSubject ;
    static String link;
    static String mailDate;
    //public StringBuffer linkbuffer ;
    
    
    
	public ReadEmail(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
    public void read() throws SocketException, InterruptedException {
        final String username = "siclientsupport@singleinterface.com";
        final String password = "M*A$97#DvP17*";

        System.out.println("1");
        // IMAP properties
        try {
           Properties props = new Properties();
           props.put("mail.store.protocol", "imaps");
           props.put("mail.imap.ssl.trust", "*");
           props.put("mail.imaps.host", "imap.gmail.com");
           props.put("mail.imaps.port", "993");
       
        // Create a session and authenticate
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

                 System.out.println("2");
        
        try {
            // Connect to the inbox folder
            Store store = session.getStore("imaps");
            store.connect();
            
            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_ONLY);
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            Date currentDate = new Date();
            String date = dateFormat.format(currentDate);
            //String date = "2023-10-13";
            System.out.println("Daily Outlets Count Report - "+date);
            
            try {
            	String subject  = "Daily Outlets Count Report - "+date;
                SearchTerm searchTerm = new SubjectTerm(subject);
    
                if(inbox != null) {
                   Message[] messages = inbox.search(searchTerm);
            	   // Message[] messages = inbox.getMessages();
                 
                 if(messages.length!=0) {
                  System.out.println("3");
                
                  mailSubject  = "Mail";
                  for(Message message : messages) {

                   if(message!=null) {

                	 System.out.println(message.getContentType().toString());
       	   
                	   if (message.getContentType().toString().contains("multipart/ALTERNATIVE") ) {
                		   System.out.println("50");
                	       Multipart multipart = (Multipart) message.getContent();

                	       // Specify the boundary value
                	       String boundary = "MIMEboundary10067B";

                	       // Iterate through the parts and find the one with the specified boundary
                	       for (int i = 0; i < multipart.getCount(); i++) {
                	           MimeBodyPart bodyPart = (MimeBodyPart) multipart.getBodyPart(i);
                	           String content = (String) bodyPart.getContent();
                	           
                	           StringBuffer sb= new StringBuffer();
                	           sb.append(content).append(",");
                	            String[] splitString = sb.toString().split("<br>");
                	            for(String split : splitString) {
                	            	if(split.contains("https://www.singleinterface.com/files/daily_outlets_count_report")) {
                	            		
                	            		if( split.trim().toString().contains("<a")) {
                	            			  String[] splitted = split.toString().split("target=\"_blank");
                	            			  String[] splittedString = splitted[0].toString().split("=");
                	            			  String actLink = splittedString[1].toString();
                	            			  String linkk = actLink.replace("\"", "");
                	            			  
                	            			  wordText  = actLink.replace("\"", "");
                	            			  System.out.println(wordText);
                	            		}
                	            		else {
                	            			
                	            			 wordText = split.trim();
                	            			 System.out.println(wordText);
                	            		}
                	            	}
                	            }
                	     
                	       }
                	   
                	   }
                	   else {
                		  System.out.println("51");
                  	       Multipart multipart = (Multipart) message.getContent();
                  	       BodyPart bodypart = multipart.getBodyPart(0);
                  	       String content  =bodypart.getContent().toString();
                           //System.out.println(content);
              	    	     try {  
              	              // Check if the email content contains links
                              if (content.contains("http://") || content.contains("https://")) {
                         	 
                                // Split the content into words and search for links
                                   String[] words = content.split("\\s+");
                                   for (String word : words) {
                                    if (word.startsWith("http://") || word.startsWith("https://")) {
                                      System.out.println("Link found: " + word);
                                      wordText = word;
                                      link = "Link Found :"+word;
                                  
                                 }
 
                              }
                           
                           }
                          else {
                         	 System.out.println("Link not found");
                         	 link = "Url is not present in the mail";
                          }
              	    	}
              	    	catch(Exception e) {
              	    		
              	    		
              	    	}
              	    	     
              	    	     
                	   }
                	   
                	    
            	       if(wordText!=null) {
            	    	   
            	    	   link = "Link Found :"+wordText;
            	    	   System.out.println(link);
            	       }
            	       else {
            	    	   System.out.println("Link not found");
                      	   link = "Url is not present in the mail";
            	       }
            	       

              
            	     System.out.println("4");
            	     Date sentdate = message.getSentDate();
            	     formattedDate = dateFormat.format(sentdate);
            	     String formattedCurrentDate = dateFormat.format(currentDate);
            	     String formattedTime = timeFormat.format(sentdate);
            	     String formattedCurrentTime = timeFormat.format(currentDate);
      	 
             	   // Get the current date
                     LocalDate currentd = LocalDate.now();

                   // Subtract one day to get the previous date
                     LocalDate previousDate = currentd.minusDays(1);
                     previousdate = previousDate.toString();
                     buffer.append(previousdate);

                   } else {
                   //	System.out.println("Mail subject not found");
                   }
                 }
                  mailSubject  = "Mail Subject Found";
              	
               } else {
            	   System.out.println("Mail Subject Not Found....");
            	   mailSubject  = "Mail Subject Not Found";
            	
               }
                
           }else {
        	  System.out.println("inbox is null");
            }
             
           }catch(Exception e) {
            	 System.out.println(e.getMessage());
            	 mailSubject  = "Mail Subject Not Found";
            }

            // Close the folder and store
            inbox.close(false);
            store.close();
            
            
            Thread.sleep(1000);
            //driver.get(wordText);
            //Thread.sleep(4000);

        } catch (Exception e) {
        	System.out.println("Catch--------"+e.getMessage());
        	
            //e.printStackTrace();
        }
        }
        catch(Exception e) {
        	System.out.println("Catch : "+e.getMessage());
        }
      
    }
    
    
    public void FileDownloader() {
     
            // Specify the URL of the file you want to download
            String fileURL = wordText; // Replace with the actual file URL

            // Get the current project directory
            String projectDirectory = System.getProperty("user.dir");

            // Create a File object for the destination location
            String destinationPath = projectDirectory + File.separator + "downloaded_file.xlsx"; // Specify the desired file name and extension
            File destinationFile = new File(destinationPath);

            try {
                // Create a URL object
                URL url = new URL(fileURL);

                // Open a connection to the URL
                try (InputStream in = url.openStream();
                     OutputStream out = new FileOutputStream(destinationFile)) {

                    // Transfer data from the URL to the local file
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }

                    System.out.println("File downloaded successfully to: " + destinationFile.getAbsolutePath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                link = "Url is present in the mail";
            } catch (IOException e) {
            	link = "Url is not present in the mail";
//                linkbuffer = new StringBuffer();
//            	linkbuffer.append(link);
//            	
            	System.out.println("Catchhhhh :"+e.getMessage());
                e.printStackTrace();
            }
        

    }
	
    
    public static String todysDate() {
    	
    	return formattedDate;
    }
    
    public static String mailSubject() {
    	return mailSubject;
    	
    }
    public static String mailLink() {
    	return link;
    	
    }

    
  
}

