package extentlisteners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGen {
	
	static ExtentReports extent;
	
	public static ExtentReports extentReportGenerator()
	{
		String path = System.getProperty("user.dir")+"//reports//NewOrder.html";
		
		ExtentHtmlReporter reporter  = new ExtentHtmlReporter(path);
	   
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Test Cache");
		
		extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		extent.setSystemInfo("Project Name", "Backend Project");
		extent.setSystemInfo("Enviroment", "Test");
		extent.setSystemInfo("Executed By", "Jagdish Shinde");
		
		
		return extent;
	}

}
