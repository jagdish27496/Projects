package testclasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.network.Network;
import org.openqa.selenium.devtools.v114.network.model.Request;
import org.openqa.selenium.devtools.v114.network.model.Response;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
//import org.openqa.selenium.devtools.v99.network.model.Response;
//import org.openqa.selenium.devtools.v99.network.model.Request;
//import org.openqa.selenium.devtools.v99.log.*;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeClass;
//import org.openqa.selenium.devtools.idealized.*;
import org.testng.annotations.BeforeSuite;

import Ordersdata.repository.SentMail;
//import Utility.ReadMail;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ReadEmail;
import pages.ReadFile;


public class BaseTest {
	
	 public static WebDriver driver;
	 public String parentWindow;
	 public static String childWindow ;
	 public  Set<String> windows;

	 public ReadEmail re;
	 public  ReadFile rl;

	// static int Passcount=0;

	 
	@BeforeSuite
	public void initBrowser() throws InterruptedException
	{
		     System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win32\\chromedriver.exe");
		
           // WebDriverManager.chromedriver().setup();
		     // Set the download directory
		   // String downloadPath = "C:\\Users\\JagdishShinde\\Downloads\\"; // Specify your desired download directory

	     	ChromeOptions options = new ChromeOptions();
		    options.addArguments("--disable-notifications");
		    //options.addArguments("--incognito");
		    options.addArguments("--start-maximized");
		    options.addArguments("--remote-allow-origins=*");
		    //options.addArguments("download.default_directory=" + downloadPath);
		    options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
	        //options.addArguments("--headless"); // only if you are ACTUALLY running headless
	        options.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
	        options.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
	        options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
	        options.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
	        options.addArguments("--disable-gpu"); //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
	        options.addArguments("enable-features=NetworkServiceInProcess");
	        options.addArguments("disable-features=NetworkService");
	        options.addArguments("--force-device-scale-factor=1");
		   
		     driver = new ChromeDriver(options);
		    // driver.get("https://testing.singleinterface.com/storepages/vehiclecare-delhi-ashok-nagar-tilak-nagar-gl-afghan-restaurants-tilak-nagar-new-delhi-138206");
		 
		 
	}
	@AfterSuite
	public void quitBrowser() throws Exception  {
		
		  try {
	
			  Thread.sleep(2000);
			  SentMail mailobj = new SentMail();
			  
			  try {
				  try {
				     if(rl.fail()==0  & rl.pass()!=0) {
				    	 mailobj.mail("Automation: Demo Mail of SI OPEN Location Count report ::: Total Pass client's = "+rl.pass()+", Total Fail client's = "+rl.fail());
				     }
				  }catch(Exception e){
					  System.out.println(e.getMessage());
				  }
				  
				  
			    if(rl.fail()>0) {
				    System.out.println("98");
	  	            mailobj.mail("Automation: Demo Mail of SI OPEN Location Count report ::: Total Pass client's = "+rl.pass()+", Total Fail client's = "+rl.fail());
			    }
		
			    else if(re.mailSubject().toString().equals("Mail Subject Not Found")) {
				    System.out.println("99");
			        mailobj.mail("Automation : Demo Mail of SI OPEN Location Count report ::: Mail subject not found");
			    } 
			    else if(re.mailLink().toString().equals("Url is not present in the mail")) {
				    System.out.println("100");
       		        mailobj.mail("Automation : Demo Mail of SI OPEN Location Count report ::: Url is not present in the mail."); 
       		    }
			    else if(rl.sheetDownload().toString().equals("Sheet not download. The Excel file does not exist.")) {
				    System.out.println("101");
				    mailobj.mail("Automation : Demo Mail of SI OPEN Location Count report ::: Sheet not download. Excel file does not exist in the directory");
			    }
			  
			   } catch(Exception e) {
				  
			     }
 
			 } catch(Exception e) { 
				 
			}
		  try {
			     rl.clearExcelData();  
		         rl.deleteExcel();
	             driver.quit();
		    } catch(Exception e) {
			    driver.quit();
			  System.out.println(e.getMessage());
		  }
		  
		
	}
	
	
	@BeforeClass
	public void ObjectCreation() throws IOException {
		
		  re = new ReadEmail(driver);
		  rl = new ReadFile(driver);
		
	  	}
	
	
}
