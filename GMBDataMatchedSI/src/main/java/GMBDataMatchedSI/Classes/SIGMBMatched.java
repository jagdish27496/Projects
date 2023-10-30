package GMBDataMatchedSI.Classes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import GMBDataMatchedSI.Classes.SIGMBFunctions;
import com.google.common.collect.ImmutableMap;
import com.sun.accessibility.internal.resources.accessibility;
import GMBDataMatchedSI.Repository.Sendmail;
import GMBDataMatchedSI.Repository.excelSheetUtility;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;

import java.awt.Robot;
import java.awt.Dimension;
import java.awt.Toolkit;

public class SIGMBMatched {

	static GMBDataMatchedSI.Driver.SingletonClassChromeNew singleton = GMBDataMatchedSI.Driver.SingletonClassChromeNew
			.getInstanceOfSingletonBrowserClass();
	static WebDriver driver = singleton.getDriver();
	static int rowcount = 0;
	static boolean error = false;
	static boolean chatlive = false;
	static int datacount = 0;
	static int passcount = 0;
	static int urlnumbercount = 0;
	static int failcount = 0;
	static WebElement element = null;
	static WebElement elementseo = null;
	static String biffurcateattribute = null;
	static String biffurcateabout = null;
	static String attributeyimestatus = null;
	static String ownernow = null;
	static String attributecover = null;
	static String coverphoto = null;
	static String GMBWebLink = null;
	static String tabname = null;
	static List<String> alladdress = new ArrayList();
	static String FromTheBusiness = null;
	static String Serviceoptions = null;
	static String Accessibilities = null;
	static List<String> allabout = new ArrayList();
	static List<String> Business = new ArrayList();
	static List<String> Service = new ArrayList();
	static List<String> Accessibility = new ArrayList();
	static List<String> Amenities = new ArrayList();
	static List<String> Crowd = new ArrayList();
	static List<String> Recycling = new ArrayList();
	static List<String> Payments = new ArrayList();
	static String biffurcateAccessibility = null;
	static String biffurcateBusiness = null;
	static String biffurcateService = null;
	static String biffurcateAmenities = null;
	static String biffurcateCrowd = null;
	static String biffurcateRecycling = null;
	static String biffurcatePayments = null;
	static String address = null;
	static String website = null;
	static String phonenumber = null;
	static String plusocode = null;
	static String screenmode = null;
	static String AmenitiesText = null;
	static String PaymentsText = null;
	static String CrowdText = null;
	static String RecyclingText = null;
	static String Ratings = null;
	static String Reviews = null;
	static String CategoryGMB = null;
	static boolean googlelinkmatched = false;
	static String GooglelinkText = null;
	static int size = 0;
	static String Businessname = null;
	static String rearrangedPattern = null;
	static String Matched_Business = null;
	static String Matched_Address = null;
	static String Matched_Loclity = null;
	static String Matched_City = null;
	static String Matched_Hours = null;
	static String Matched_State = null;
	static String Matched_Phone = null;
	static String GMB_Address = null;
	static String GMB_State = null;
	static String GMB_City = null;
	static String SIPattern = null;
	static String GMB_Locality = null;
	static String GMB_Phone = null;
	static String Matched_Website = null;
	static String Matched_Category = null;
	static String Matched_Service = null;
	static String Matched_Accessbility = null;
	static String Matched_Amenities = null;
	static String Matched_LatLong = null;
	static String Matched_Payments = null;
	static public int si_lat_length = 0;
	static public int si_long_length = 0;
	static public String map_lat = null;
	static public String map_long = null;
	static public int map_lat_length = 0;
	static public int map_long_length = 0;
	static public Double dist = 0.0d;
	static String SIaddress = null;
	static String SIBusinessHours = null;
	static String Google_Post = null;
	static int postsize = 0;
	static String Google_Products = null;
	static String SIService = null;
	static String SIAccessibility = null;
	static String SIPayments = null;
	static String SIAmenities = null;
	static String sortedaddress=null;
	static String sortedSICombineaddress=null;
	static String  BusinessMon=null;
	static String BusinessTues=null;
	static String BusinessWed=null;
	static String BusinessThrus=null;
	static String BusinessFri=null;
	static String BusinessSat=null;
	static String BusinessSun=null;
	static String Matched_Chat = null;
	static String Matched_Products = null;
	static String Serachaddress=null;
	static public String FullBusinesshours=null;
	static WebDriverWait wait = new WebDriverWait(driver, 120);
	static JavascriptExecutor js = (JavascriptExecutor) driver;
	static String chattext = "";
	static int i = 0;
	static WebDriver driver1;
	static public String Bingaddress=null;
	static public double bing_latitude = 0.0;
    static public double bing_longitude = 0.0;
    static public String Bing_address=null;
    static public String bing_lat=null;
    static public String bing_long=null;
    static public String addresselse = null;

	public SIGMBMatched() throws IOException {
		excelSheetUtility.headerValues();
	}
	
//	@BeforeTest
//	public void setUp() throws InterruptedException {
//		driver.get("https://accounts.google.com/");
//		Thread.sleep(2000);
//		driver.findElement(By.id("identifierId")).sendKeys("siclientsupport@singleinterface.com");
//		driver.findElement(By.id("identifierNext")).click();
//		Thread.sleep(3000);
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("Passwd"))));
//		driver.findElement(By.name("Passwd")).sendKeys("M*A$97#DvP17*");
//		driver.findElement(By.id("passwordNext")).click();
//		Thread.sleep(15000);
//		System.out.println("Login done");
//		
//	}

	@Test(dataProvider = "dataprov")
	public static void getdata(String StoreCode, String Maplinks, String Business_Name, String Address1,String Address2,
			String Locality, String Landmark,String City, String State, String SILat, String SILong, String SI_Business_Hours,
			String Phonenumber, String Website) throws InterruptedException, IOException, ClassNotFoundException, URISyntaxException {
		
		
		Actions actions = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		JavascriptExecutor jschat = (JavascriptExecutor) driver1;
		

		try {
			address = null;
			rearrangedPattern = null;
			GooglelinkText = null;
			SIaddress = null;
			googlelinkmatched = false;
			PaymentsText = null;
			allabout.clear();
			Business.clear();
			Service.clear();
			Accessibility.clear();
			Google_Post = "No";
			Amenities.clear();
			Payments.clear();
			CategoryGMB = null;
			address = null;
			GMB_Address = null;
			website = null;
			coverphoto = null;
			phonenumber = null;
			plusocode = null;
			screenmode = null;
			biffurcateAccessibility = null;
			biffurcateBusiness = null;
			biffurcateService = null;
			biffurcateAmenities = null;
			biffurcateCrowd = null;
			biffurcateRecycling = null;
			attributeyimestatus = null;
			biffurcatePayments = null;
			GMB_Locality = null;
			GMB_State = null;
			GMB_City = null;
			Reviews = null;
			Ratings = null;
			si_lat_length = 0;
			si_long_length = 0;
			map_lat = null;
			map_long = null;
			map_lat_length = 0;
			map_long_length = 0;
			Google_Products = null;
			Matched_Phone = null;
			Matched_Website = null;
			Matched_Category = null;
			Matched_Service = null;
			Matched_Accessbility = null;
			Matched_LatLong = null;
			Matched_Payments = null;
			Matched_Business = null;
			Matched_Address = null;
			Matched_Loclity = null;
			Matched_City = null;
			Matched_Hours = null;
			Matched_State = null;
			dist = 0.0d;
			postsize = 0;
			SIService = null;
			SIAccessibility = null;
			SIPayments = null;
			SIAmenities = null;
			sortedaddress=null;
			sortedSICombineaddress=null;
			BusinessMon=null;
			BusinessTues=null;
			BusinessWed=null;
			BusinessThrus=null;
			BusinessFri=null;
			BusinessSat=null;
			BusinessSun=null;
			SIBusinessHours=null;
			Matched_Chat = null;
			Matched_Products = null;
			Serachaddress=null;
			chatlive = false;
			Bingaddress=null;
			FullBusinesshours=null;
			bing_latitude = 0.0;
		    bing_longitude = 0.0;
		    Bing_address=null;
		    bing_lat=null;
		    bing_long=null;
		    GMB_Phone = null;
			

			if (Maplinks != null && !Maplinks.isEmpty()) {
				
				driver.get(Maplinks);
				Thread.sleep(5000);
				System.out.println(Maplinks);
				if(!SILat.isEmpty()&&!SILong.isEmpty()) {
				// Let's compare Lat Long
				String curr_map_url = driver.getCurrentUrl();
				Thread.sleep(3000);

				//Lat Long
				
				// Split the URL by the "&" character to separate parameters
		        String[] params = curr_map_url.split("&");
		        
		        
		     // Iterate through the parameters to find the "cp" parameter
		        for (String param : params) {
		            if (param.startsWith("cp=")) {
		                // Extract the value of the "cp" parameter
		                String cpValue = param.substring(3); // Remove "cp="

		                // Split the "cp" value by "%7E" to separate latitude and longitude
		                String[] latLong = cpValue.split("%7E");
		                
		                if (latLong.length == 2) {
		                    try {
		                        // Convert latitude and longitude strings to doubles
		                        bing_latitude = Double.parseDouble(latLong[0]);
		                        bing_longitude = Double.parseDouble(latLong[1]);
		                    } catch (NumberFormatException e) {
		                        System.out.println("Failed to extract latitude and longitude.");
		                    }
		                }
		                break; // No need to continue after finding the "cp" parameter
		            }
		        }
		        
		        bing_lat = Double.toString(bing_latitude);
		        bing_long = Double.toString(bing_longitude);
		        
		        Double newsi_lat = Double.valueOf(SILat);
				Double newsi_long = Double.valueOf(SILong);

		        System.out.println("Bing_Latitude: " + bing_latitude + " SI Lat: " + newsi_lat);
		        System.out.println("Bing_Longitude: " + bing_longitude + " SI Long: " + newsi_long);
		        
		        dist = SIGMBFunctions.calculateDistance(newsi_lat, bing_latitude, newsi_long, bing_longitude);

				if (dist < 0.009) {
					Matched_LatLong = "Yes";
					System.out.println("Pass");

				} else {
					Matched_LatLong = "No";
					System.out.println("Fail");

				}
				}
				else
				{
					Matched_LatLong = "Not Found";
				}

				Thread.sleep(3000);
				// Let's compare Business Name
				Businessname = driver.findElement(By.cssSelector(".eh_text_outer .nameContainer")).getText();
				System.out.println(Businessname);
				if(Businessname.isEmpty())
				{
					Businessname="Not Found";
					Matched_Business="No";
				}
				else {
				Matched_Business = (Businessname.contains(Business_Name)) ? "Yes" : "No";
				}
				
				//address
				Thread.sleep(2000);
				wait.until(ExpectedConditions
						.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='iconDataList']")));
				WebElement attributesGMB = driver.findElement(By.xpath("//*[@class='iconDataList']"));
				
				Bingaddress= attributesGMB.getText();
				System.out.println("Bing Address " +Bingaddress);
				
				SIaddress = Address1 + " " + Address2 + " " + Landmark;
				
			   if(Bingaddress.replaceAll("[,\\s]", "").toLowerCase().contains(SIaddress.replaceAll("[,\\s]", "").toLowerCase()))
			   {
				   System.out.println("Pass");
				   Bing_address = SIaddress;
				   Matched_Address="Yes";
			   }
			   else
			   { 
				   Matched_Address="No";  
				   addresselse=driver.findElement(By.cssSelector("div.iconDataList")).getText();
				   Bing_address=addresselse;
			   }
			   			   
			   if(Bingaddress.replaceAll("[,\\s]", "").toLowerCase().contains(Locality.replaceAll("[,\\s]", "").toLowerCase()))
			   {
				   System.out.println("Pass1"); 
				   GMB_Locality=Locality;
				   Matched_Loclity = "Yes";
			   }
			   else
			   {
				   GMB_Locality="Not Found";
				   Matched_Loclity = "No";  
			   }
			   if(Bingaddress.replaceAll("[,\\s]", "").toLowerCase().contains(City.replaceAll("[,\\s]", "").toLowerCase()))
			   {
				   System.out.println("Pass2");
				   GMB_City= City;
				   Matched_City = "Yes";
			   }
			   else
			   {
				   GMB_City= "Not Found";
				   Matched_City = "No";
			   }
			   if(Bingaddress.replaceAll("[,\\s]", "").toLowerCase().contains(State.replaceAll("[,\\s]", "").toLowerCase()))
			   {
				   System.out.println("Pass3");
				   GMB_State=State;
				   Matched_State = "Yes";
			   }
			   else
			   {
				   GMB_State="Not Found";
				   Matched_State = "No";
			   }	
					
			   //Phone Number
			   Thread.sleep(2000);
			   
			   if (driver.findElements(By.xpath("(//*[@id='sacallsvg']//following::a)[1]")).size()>0) {
					System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
					phonenumber = driver.findElement(By.xpath("(//*[@id='sacallsvg']//following::a)[1]")).getText();
					System.out.println("Number Value " + phonenumber);
					GMB_Phone = phonenumber.replaceFirst("^0+", "").replace("+91", "").replaceAll("\\s+", "");
					System.out.println("Map Contact " +GMB_Phone);
					Phonenumber = Phonenumber.replaceFirst("91", "");
					System.out.println("SI Contacts " + Phonenumber);
					if (GMB_Phone.isEmpty()) {
						Matched_Phone = "No";
						GMB_Phone="Not Found";
					} else {
						if (GMB_Phone.contains(Phonenumber)) {
							Matched_Phone = "Yes";
						} else {
							Matched_Phone = "No";
						}
					}
				}
			   else
			   {
				   Matched_Phone = "No";
				   GMB_Phone="Not Found";
				   
			   }
			   
			   if (driver.findElements(By.xpath("(//*[@id='sawebsitesvg']//following::a)[1]")).size() > 0) {
					GMBWebLink = driver.findElement(By.xpath("(//*[@id='sawebsitesvg']//following::a)[1]"))
							.getAttribute("href");
					System.out.println(GMBWebLink);	
					
					if(GMBWebLink.toLowerCase().contains(Website.toLowerCase()))
					{
					Matched_Website = "Yes";
					}
					else
					{
						Matched_Website = "No";
					}
			   }
			   else
			   {
				   GMBWebLink="Not Found";
				   Matched_Website="No";
				   
			   }
			  
			   

		

				excelSheetUtility.Passcode(StoreCode, Maplinks, Business_Name, SIaddress, Locality, City, State, SILat,
						SILong, SI_Business_Hours, Phonenumber, Website, Businessname, Matched_Business, Bing_address, Matched_Address, 
						GMB_Locality,Matched_Loclity, GMB_City, Matched_City, GMB_State, Matched_State, bing_lat, bing_long,
						Matched_LatLong, GMB_Phone, Matched_Phone, GMBWebLink,Matched_Website);
	//			driver.quit();
			
		}  
		}
			catch (Exception e) {
//		    if (e instanceof SocketException) {
//		        // Handle SomeSpecificException
//		    } else if (e instanceof ArithmeticException) {
//		        // Handle AnotherSpecificException
//		    } else {
//		        // Handle other exceptions
//		        System.out.println("An exception occurred: " + e.getMessage());
//		    }
				
				  if (e instanceof SocketException) {
				        // Handle SomeSpecificException
				    } else if (e instanceof ArithmeticException) {
				        // Handle AnotherSpecificException
				    } else {
				        // Handle other exceptions
				        System.out.println("An exception occurred: " + e.getMessage());
				        
				        excelSheetUtility.Passcode(StoreCode, Maplinks, Business_Name, SIaddress, Locality, City, State, SILat,
								SILong, SI_Business_Hours, Phonenumber, Website, "Not Found", "Not Found", "Not Found", "Not Found", 
								"Not Found","Not Found", "Not Found", "Not Found", "Not Found", "Not Found", "Not Found", "Not Found",
								"Not Found", "Not Found", "Not Found", "Not Found","Not Found");
				        
				    }
		}

	}
	 public static String cleanAndStandardizeAddress(String address) {
	        // Remove spaces and commas from the address and standardize it
	        return address.replaceAll("[,\\s]", "").toLowerCase();
	    }
	
	@DataProvider
	public Object[][] dataprov() throws IOException {
		System.out.println("@DataProvider");
		String[][] data = readXLSXFileurl();
		return data;
	}

	public static String[][] readXLSXFileurl() throws IOException {
		DataFormatter formatter = new DataFormatter();
		InputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\GMBDataMatchedSI\\Excel\\read.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file); // get my workbook
		XSSFSheet worksheet = wb.getSheetAt(0);// get my sheet from workbook
		XSSFRow Row = worksheet.getRow(0); // get my Row which start from 0

		int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
		int ColNum = Row.getLastCellNum(); // get last ColNum
		int rowIndex = 0;

		String Data[][] = new String[RowNum - 1][ColNum]; // pass my count data in array

		for (int i = 0; i < RowNum - 1; i++) // Loop work for Rows
		{
			System.out.println("1");
			XSSFRow row = worksheet.getRow(i + 1);

			for (int j = 0; j < ColNum; j++) // Loop work for colNum
			{
				// System.out.println("2");
				if (row == null) {
					// System.out.println("3");
					Data[i][j] = "";
				} else {
					XSSFCell cell = row.getCell(j);
					if (cell == null) {
						// System.out.println("4");
						Data[i][j] = ""; // if it get Null value it pass no data
					} else if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
						// System.out.println("String value");
						String value = formatter.formatCellValue(cell);
						Data[i][j] = value;
					} else {
						// System.out.println("5");
						String value = new java.text.DecimalFormat("0").format(cell.getNumericCellValue());
						System.out.println(value);
						Data[i][j] = value;
					}
				}
			}
			rowIndex++;
		}
		return Data;
	}

	@AfterTest
	public void aftertest() {


			//Sendmail.mail("Automation ::: Demo : IOCL : Bing Listings All Attributes");
			 driver.quit();
		
	}

}