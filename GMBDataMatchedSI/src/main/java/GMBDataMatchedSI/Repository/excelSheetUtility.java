package GMBDataMatchedSI.Repository;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class excelSheetUtility {

	static int rowcount = 1;
	static String sheetName = "GMB Audit";
	static HSSFWorkbook wb = new HSSFWorkbook();
	static HSSFSheet sheet = wb.createSheet(sheetName);
	static String writecode = (System.getProperty("user.dir")
			+ "\\src\\main\\java\\GMBDataMatchedSI\\Excel\\writeurl.xls");

	// code is to write url value in excel sheet..
	public static void failcode(String ClientStoreid, String maplinks, String brandName, String Address,
			String Locality, String City, String State, String siLat, String silong, String hours, String phonenumber, 
			String website, String brand_Name, String matched_brandname, String bingaddress, String Matched_address,
			String GMBLocality, String Matched_locality, String GMBCity,String Matched_City, String GMBState, String Matched_State,
			String bing_latitude, String bing_longitude,  String Matched_latlong, String bing_phonenumber, String Matched_phonenumber,
			String Binglink, String Matched_binglink) throws IOException {

		HSSFRow row = sheet.createRow(rowcount);

		int cellUrl = 0;
		HSSFCell cellurl = row.createCell(cellUrl);
		cellurl.setCellValue(ClientStoreid);

		int cellUrlone = 1;
		HSSFCell cellurlone = row.createCell(cellUrlone);
		cellurlone.setCellValue(maplinks);

		int cellUrltwo = 2;
		HSSFCell cellurltwo = row.createCell(cellUrltwo);
		cellurltwo.setCellValue(brandName);

		int cellUrlthree = 3;
		HSSFCell cellurlthree = row.createCell(cellUrlthree);
		cellurlthree.setCellValue(Address);

		int cellUrlfour = 4;
		HSSFCell cellurlfour = row.createCell(cellUrlfour);
		cellurlfour.setCellValue(Locality);

		int cellUrlfive = 5;
		HSSFCell cellurlfive = row.createCell(cellUrlfive);
		cellurlfive.setCellValue(City);

		int cellUrlsix = 6;
		HSSFCell cellurlsix = row.createCell(cellUrlsix);
		cellurlsix.setCellValue(State);

		int cellUrlseven = 7;
		HSSFCell cellurlseven = row.createCell(cellUrlseven);
		cellurlseven.setCellValue(siLat);

		int cellUrleight = 8;
		HSSFCell cellurleight = row.createCell(cellUrleight);
		cellurleight.setCellValue(silong);

		int cellUrlnine = 9;
		HSSFCell cellurlnine = row.createCell(cellUrlnine);
		cellurlnine.setCellValue(hours);

		int cellUrlten = 10;
		HSSFCell cellurlten = row.createCell(cellUrlten);
		cellurlten.setCellValue(phonenumber);

		int cellUrleleven = 11;
		HSSFCell cellurleleven = row.createCell(cellUrleleven);
		cellurleleven.setCellValue(website);

		int cellUrltwelve = 12;
		HSSFCell cellurltwelve = row.createCell(cellUrltwelve);
		cellurltwelve.setCellValue(brand_Name);

		int cellUrlthirteen = 13;
		HSSFCell cellurlthirteen = row.createCell(cellUrlthirteen);
		cellurlthirteen.setCellValue(matched_brandname);

		int cellUrlfourteen = 14;
		HSSFCell cellurlfourteen = row.createCell(cellUrlfourteen);
		cellurlfourteen.setCellValue(bingaddress);

		int cellUrlfifteen = 15;
		HSSFCell cellurlfifteen = row.createCell(cellUrlfifteen);
		cellurlfifteen.setCellValue(Matched_address);

		int cellUrlsixteen = 16;
		HSSFCell cellurlsixteen = row.createCell(cellUrlsixteen);
		cellurlsixteen.setCellValue(GMBLocality);

		int cellUrlseventeen = 17;
		HSSFCell cellurlseventeen = row.createCell(cellUrlseventeen);
		cellurlseventeen.setCellValue(Matched_locality);

		int cellUrleighteen = 18;
		HSSFCell cellurleighteen = row.createCell(cellUrleighteen);
		cellurleighteen.setCellValue(GMBCity);

		int cellUrlnineteen = 19;
		HSSFCell cellurlnineteen = row.createCell(cellUrlnineteen);
		cellurlnineteen.setCellValue(Matched_City);

		int cellUrltwenty = 20;
		HSSFCell cellurltwenty = row.createCell(cellUrltwenty);
		cellurltwenty.setCellValue(GMBState);

		int cellUrltwentyone = 21;
		HSSFCell cellurltwentyone = row.createCell(cellUrltwentyone);
		cellurltwentyone.setCellValue(Matched_State);

		int cellUrltwentytwo = 22;
		HSSFCell cellurltwentytwo = row.createCell(cellUrltwentytwo);
		cellurltwentytwo.setCellValue(bing_latitude);
		
		int cellUrltwentythree = 23;
		HSSFCell cellurltwentythree = row.createCell(cellUrltwentythree);
		cellurltwentythree.setCellValue(bing_longitude);
		
		int cellUrltwentyfour = 24;
		HSSFCell cellurltwentyfour = row.createCell(cellUrltwentyfour);
		cellurltwentyfour.setCellValue(Matched_latlong);
		
		int cellUrltwentyfive = 25;
		HSSFCell cellurltwentyfive = row.createCell(cellUrltwentyfive);
		cellurltwentyfive.setCellValue(bing_phonenumber);
		
		int cellUrltwentysix = 26;
		HSSFCell cellurltwentysix = row.createCell(cellUrltwentysix);
		cellurltwentysix.setCellValue(Matched_phonenumber);
		
		int cellUrltwentyseven = 27;
		HSSFCell cellurltwentyseven = row.createCell(cellUrltwentyseven);
		cellurltwentyseven.setCellValue(Binglink);
		
		int cellUrltwentyeight = 28;
		HSSFCell cellurltwentyeight = row.createCell(cellUrltwentyeight);
		cellurltwentyeight.setCellValue(Matched_binglink);
		
		

		FileOutputStream fileOut1 = new FileOutputStream(writecode);
		wb.write(fileOut1);
		rowcount++;
	}

	// code to write book a test drive..
	public static void Passcode(String ClientStoreid, String maplinks, String brandName, String Address,
			String Locality, String City, String State, String siLat, String silong, String hours, String phonenumber, 
			String website, String brand_Name, String matched_brandname, String bingaddress, String Matched_address,
			String GMBLocality, String Matched_locality, String GMBCity,String Matched_City, String GMBState, String Matched_State,
			String bing_latitude, String bing_longitude, String Matched_latlong, String bing_phonenumber, String Matched_phonenumber,
			String Binglink, String Matched_binglink) throws IOException {

	    HSSFRow row = sheet.createRow(rowcount);

	    int cellUrl = 0;
		HSSFCell cellurl = row.createCell(cellUrl);
		cellurl.setCellValue(ClientStoreid);

		int cellUrlone = 1;
		HSSFCell cellurlone = row.createCell(cellUrlone);
		cellurlone.setCellValue(maplinks);

		int cellUrltwo = 2;
		HSSFCell cellurltwo = row.createCell(cellUrltwo);
		cellurltwo.setCellValue(brandName);

		int cellUrlthree = 3;
		HSSFCell cellurlthree = row.createCell(cellUrlthree);
		cellurlthree.setCellValue(Address);

		int cellUrlfour = 4;
		HSSFCell cellurlfour = row.createCell(cellUrlfour);
		cellurlfour.setCellValue(Locality);

		int cellUrlfive = 5;
		HSSFCell cellurlfive = row.createCell(cellUrlfive);
		cellurlfive.setCellValue(City);

		int cellUrlsix = 6;
		HSSFCell cellurlsix = row.createCell(cellUrlsix);
		cellurlsix.setCellValue(State);

		int cellUrlseven = 7;
		HSSFCell cellurlseven = row.createCell(cellUrlseven);
		cellurlseven.setCellValue(siLat);

		int cellUrleight = 8;
		HSSFCell cellurleight = row.createCell(cellUrleight);
		cellurleight.setCellValue(silong);

		int cellUrlnine = 9;
		HSSFCell cellurlnine = row.createCell(cellUrlnine);
		cellurlnine.setCellValue(hours);

		int cellUrlten = 10;
		HSSFCell cellurlten = row.createCell(cellUrlten);
		cellurlten.setCellValue(phonenumber);

		int cellUrleleven = 11;
		HSSFCell cellurleleven = row.createCell(cellUrleleven);
		cellurleleven.setCellValue(website);

		int cellUrltwelve = 12;
		HSSFCell cellurltwelve = row.createCell(cellUrltwelve);
		cellurltwelve.setCellValue(brand_Name);

		int cellUrlthirteen = 13;
		HSSFCell cellurlthirteen = row.createCell(cellUrlthirteen);
		cellurlthirteen.setCellValue(matched_brandname);

		int cellUrlfourteen = 14;
		HSSFCell cellurlfourteen = row.createCell(cellUrlfourteen);
		cellurlfourteen.setCellValue(bingaddress);

		int cellUrlfifteen = 15;
		HSSFCell cellurlfifteen = row.createCell(cellUrlfifteen);
		cellurlfifteen.setCellValue(Matched_address);

		int cellUrlsixteen = 16;
		HSSFCell cellurlsixteen = row.createCell(cellUrlsixteen);
		cellurlsixteen.setCellValue(GMBLocality);

		int cellUrlseventeen = 17;
		HSSFCell cellurlseventeen = row.createCell(cellUrlseventeen);
		cellurlseventeen.setCellValue(Matched_locality);

		int cellUrleighteen = 18;
		HSSFCell cellurleighteen = row.createCell(cellUrleighteen);
		cellurleighteen.setCellValue(GMBCity);

		int cellUrlnineteen = 19;
		HSSFCell cellurlnineteen = row.createCell(cellUrlnineteen);
		cellurlnineteen.setCellValue(Matched_City);

		int cellUrltwenty = 20;
		HSSFCell cellurltwenty = row.createCell(cellUrltwenty);
		cellurltwenty.setCellValue(GMBState);

		int cellUrltwentyone = 21;
		HSSFCell cellurltwentyone = row.createCell(cellUrltwentyone);
		cellurltwentyone.setCellValue(Matched_State);

		int cellUrltwentytwo = 22;
		HSSFCell cellurltwentytwo = row.createCell(cellUrltwentytwo);
		cellurltwentytwo.setCellValue(bing_latitude);
		
		int cellUrltwentythree = 23;
		HSSFCell cellurltwentythree = row.createCell(cellUrltwentythree);
		cellurltwentythree.setCellValue(bing_longitude);
		
		int cellUrltwentyfour = 24;
		HSSFCell cellurltwentyfour = row.createCell(cellUrltwentyfour);
		cellurltwentyfour.setCellValue(Matched_latlong);
		
		int cellUrltwentyfive = 25;
		HSSFCell cellurltwentyfive = row.createCell(cellUrltwentyfive);
		cellurltwentyfive.setCellValue(bing_phonenumber);
		
		int cellUrltwentysix = 26;
		HSSFCell cellurltwentysix = row.createCell(cellUrltwentysix);
		cellurltwentysix.setCellValue(Matched_phonenumber);
		
		int cellUrltwentyseven = 27;
		HSSFCell cellurltwentyseven = row.createCell(cellUrltwentyseven);
		cellurltwentyseven.setCellValue(Binglink);
		
		int cellUrltwentyeight = 28;
		HSSFCell cellurltwentyeight = row.createCell(cellUrltwentyeight);
		cellurltwentyeight.setCellValue(Matched_binglink);

	    FileOutputStream fileOut1 = new FileOutputStream(writecode);
	    wb.write(fileOut1);
	    rowcount++;
	}


	public static void headerValues() throws IOException {
	    int newrow = 0;
	    HSSFRow row1 = sheet.createRow(newrow);

	    ArrayList<String> names = new ArrayList<String>(Arrays.asList("StoreCode", "Maplinks", "Business Name", "Address",
	        "Locality", "City", "State","Latitude","Longitude", "Hours", "Phone Number", "Website", "Business Name", "Matched", "Address", "Matched",
	        "Locality", "Matched", "City", "Matched", "State", "Matched","Latitude","Longitude","Matched","Phone Number", "Matched", "Website", "Matched"));

	    // Create a CellStyle with background color (light blue) for "Matched" header cells
	    CellStyle matchedHeaderStyle = wb.createCellStyle();
	    matchedHeaderStyle.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE1.getIndex());
	    matchedHeaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

	    // Create a different font for "Matched" header cells
	    HSSFFont font = wb.createFont();
	    font.setItalic(false);

	    CellStyle Headingstyle = wb.createCellStyle();
	    Headingstyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
	    Headingstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

	    CellStyle duplicateHeaderStyle = wb.createCellStyle();
	    duplicateHeaderStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
	    duplicateHeaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

	    Set<String> encounteredHeaderNames = new HashSet<String>();
	    int c = 0;
	    for (String cellName : names) {
	        HSSFCell cell = row1.createCell(c++);
	        cell.setCellValue(cellName);

	        if (cellName.equals("Matched")) {
	            cell.setCellStyle(matchedHeaderStyle); // Apply background color for "Matched" header cells
	            // Apply the different font to the cell
	            cell.getCellStyle().setFont(font);
	        }
	        else {
	            // Check if this header text has been encountered before
	            if (encounteredHeaderNames.contains(cellName)) {
	                // If it's a duplicate, apply a different style
	                cell.setCellStyle(duplicateHeaderStyle);
	            }
	            else {
	            	
	            	if(cellName.equals("Google Business Messaging")||cellName.equals("Google Products")||cellName.equals("Google Post")) {
	            		
	               cell.setCellStyle(duplicateHeaderStyle); // Apply background color for "Matched" header cells
	            	}
	            	else {
	                cell.setCellStyle(Headingstyle);
	                encounteredHeaderNames.add(cellName); // Mark it as encountered
	            	}
	            }
	        }
	    }

	    FileOutputStream fileOut3 = new FileOutputStream(writecode);
	    wb.write(fileOut3);
	}


		
}
