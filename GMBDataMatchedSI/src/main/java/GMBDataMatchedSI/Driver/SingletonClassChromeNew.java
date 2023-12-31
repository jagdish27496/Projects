package GMBDataMatchedSI.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;


public class SingletonClassChromeNew {
	
	private static SingletonClassChromeNew instanceOfSingletonBrowserClass=null;

	private WebDriver driver;

	private SingletonClassChromeNew() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\JagdishShinde\\Desktop\\GMBDataMatchedSI\\src\\main\\java\\GMBDataMatchedSI\\Driver\\chromedriver11.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
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
		
//		System.setProperty("webdriver.gecko.driver",
//				"D:\\GeekoDriver\\geckodriver.exe");
//		FirefoxProfile geoDisabled = new FirefoxProfile();
//		geoDisabled.setPreference("geo.enabled", false);
//		geoDisabled.setPreference("geo.provider.use_corelocation", false);
//		geoDisabled.setPreference("geo.prompt.testing", false);
//		geoDisabled.setPreference("geo.prompt.testing.allow", false);
//		geoDisabled.setPreference("dom.webnotifications.enabled", false);
//		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//		capabilities.setCapability(FirefoxDriver.PROFILE, geoDisabled);
//		driver = new FirefoxDriver();
		
//		ProfilesIni profile = new ProfilesIni();
//		FirefoxProfile testprofile = profile.getProfile("debanjan");
//		testprofile.setPreference("dom.webnotifications.enabled", false);
//		testprofile.setPreference("dom.push.enabled", false);
//		DesiredCapabilities dc = DesiredCapabilities.firefox();
//		dc.setCapability(FirefoxDriver.PROFILE, testprofile);
//		FirefoxOptions opt = new FirefoxOptions();
//		opt.merge(dc);
//		driver =  new FirefoxDriver(opt);
//		
		
		
//		FirefoxOptions options = new FirefoxOptions();
//		options.setProfile(new FirefoxProfile());
//		options.addPreference("geo.enabled", false);
//		options.addPreference("geo.provider.use_corelocation", false);
//		options.addPreference("geo.prompt.testing", false);
//		options.addPreference("geo.prompt.testing.allow", false);
//		options.addPreference("dom.webnotifications.enabled", false);
//
//		driver = new FirefoxDriver(options);
	}

	public static SingletonClassChromeNew getInstanceOfSingletonBrowserClass(){

		if(instanceOfSingletonBrowserClass==null) {

			instanceOfSingletonBrowserClass=new SingletonClassChromeNew();

		}

		return instanceOfSingletonBrowserClass;

	}

	public WebDriver getDriver() {

		return driver;

	}

}