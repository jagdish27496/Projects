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

import Ordersdata.repository.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GetFont;

public class BaseTest {
	
	 public WebDriver driver;
	 public DevTools devtools;
	 public static GetFont gfl;
	 public String parentWindow;
	 public static String childWindow ;
	 public  Set<String> windows;

	// static int Passcount=0;

	 
	@BeforeSuite
	public void initBrowser() throws InterruptedException
	{
		     System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win32\\chromedriver.exe");
		
           // WebDriverManager.chromedriver().setup();
		
	     	ChromeOptions options = new ChromeOptions();
		    options.addArguments("--disable-notifications");
		    //options.addArguments("--incognito");
		    options.addArguments("--start-maximized");
		    options.addArguments("--remote-allow-origins=*");
			
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
		     //driver.get("https://restaurants.pizzahut.co.in/pizza-hut-ph-wea-tank-road-karol-bagh-pizza-restaurant-karol-bagh-new-delhi-130397/Home");
//		     parentWindow = driver.getWindowHandle();
//		     Thread.sleep(2000);
//		     driver.switchTo().newWindow(WindowType.TAB);
//		     String child = driver.getWindowHandle();
//		     childWindow = child.toString();
//		     System.out.println("Child window Id :"+childWindow);
//		     driver.get("https://www.pizzahut.co.in");
//		     Thread.sleep(1000);
//		     driver.switchTo().window(parentWindow);
//		    
		     
//		     windows = driver.getWindowHandles() ; 
		     
		     
		      
		      devtools = ((ChromeDriver )driver).getDevTools();
		      devtools.createSession();
		    //  devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

      
	}
	@AfterSuite
	public void quitBrowser() throws IOException  {
		
		
//		
//		  FontMail mailobj = new FontMail();
//		  gfl= new GetFont(driver);
//		  System.out.println(gfl.pass());
//		  System.out.println(gfl.fail());
//	   	  mailobj.mail("Automation : Demo Mail for Fonts comparison with SI website and client's site report::: Total Pass = "+gfl.pass()+", Total Fail = "+gfl.fail());
//	   	  
	     driver.quit();
		
	}
	
	
	@BeforeClass
	public void ObjectCreation() throws IOException {
	
	     gfl= new GetFont(driver);
	     
	     
	  	}
	
	
	
	
}
