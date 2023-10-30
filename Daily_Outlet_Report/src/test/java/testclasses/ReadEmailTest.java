package testclasses;

import java.net.SocketException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.Assert;
import org.testng.annotations.Test;

import extentlisteners.ListenerClass;
import pages.ReadEmail;
//import pages.ReadMail;


public class ReadEmailTest extends ListenerClass {
	
	@Test
	public void readEmail() throws Exception, SocketException{
	
	    re.read();
	    String mailSubject = "Mail Subject Found";
	    Assert.assertEquals(mailSubject, re.mailSubject().toString());
	    
	    re.FileDownloader();
	    String link =  "Url is present in the mail";
	    Assert.assertEquals(link, re.mailLink().toString()); 
	    rl.excelFileName();
	    String sheetdownload =   "Sheet downloaded.";
	    Assert.assertEquals(sheetdownload, rl.sheetDownload().toString()); 
	    
	    rl.readFile();
	    rl.readWrite();
	    rl.excelDataComparison();
	    rl.writeDataInExcel();
	    
	    
	}
	
}
