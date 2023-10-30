package Ordersdata.repository;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

public class excelSheetUtility {

	static int rowcount = 1;
	static String sheetName = "Common Data";
	static HSSFWorkbook wb = new HSSFWorkbook();
	static HSSFSheet sheet = wb.createSheet(sheetName);
	static String writecode = "C:\\Eclips\\Getting_Font_Family\\src\\main\\java\\excelsheet\\writeurl.xls";
	
	

	// code is to write url value in excel sheet..
	public static void failcode(String Brand, String SiUrls , String BrandUrls, String SIFonts,String BrandFonts, String Status, String missingFont) throws IOException {
		HSSFRow row = sheet.createRow(rowcount);
		// iterating c number of columns
		int cellUrl = 0;
		HSSFCell cellurl = row.createCell(cellUrl);
		cellurl.setCellValue(Brand);
		int cellUrlone = 1;
		HSSFCell cellurlone = row.createCell(cellUrlone);
		cellurlone.setCellValue(SiUrls);
		int cellUrltwo = 2;
		HSSFCell cellurltwo = row.createCell(cellUrltwo);
		cellurltwo.setCellValue(BrandUrls);
		int cellUrlthree = 3;
		HSSFCell cellurlthree = row.createCell(cellUrlthree);
		cellurlthree.setCellValue(SIFonts);
		int cellUrlfour = 4;
		HSSFCell cellurlfour = row.createCell(cellUrlfour);
		cellurlfour.setCellValue(BrandFonts);
		int cellUrlfive = 5;
		HSSFCell cellurlfive = row.createCell(cellUrlfive);
		cellurlfive.setCellValue(Status);
		int cellUrlsix = 6;
		HSSFCell cellurlsix = row.createCell(cellUrlsix);
		cellurlsix.setCellValue(missingFont);

		
		
		FileOutputStream fileOut1 = new FileOutputStream(writecode);
		wb.write(fileOut1);
		rowcount++;
	}

	// code to write book a test drive..
	public static void Passcode(String Brand, String SiUrls , String BrandUrls, String SIFont,String BrandFonts ,String Status,String missingFont) throws IOException {
		HSSFRow row = sheet.createRow(rowcount);
		// iterating c number of columns
		int cellUrl = 0;
		HSSFCell cellurl = row.createCell(cellUrl);
		cellurl.setCellValue(Brand);
		int cellUrlone = 1;
		HSSFCell cellurlone = row.createCell(cellUrlone);
		cellurlone.setCellValue(SiUrls);
		int cellUrltwo = 2;
		HSSFCell cellurltwo = row.createCell(cellUrltwo);
		cellurltwo.setCellValue(BrandUrls);
		int cellUrlthree = 3;
		HSSFCell cellurlthree = row.createCell(cellUrlthree);
		cellurlthree.setCellValue(SIFont);
		int cellUrlfour = 4;
		HSSFCell cellurlfour = row.createCell(cellUrlfour);
		cellurlfour.setCellValue(BrandFonts);
		int cellUrlfive = 5;
		HSSFCell cellurlfive = row.createCell(cellUrlfive);
		cellurlfive.setCellValue(Status);
		int cellUrlsix = 6;
		HSSFCell cellurlsix = row.createCell(cellUrlsix);
		cellurlsix.setCellValue(missingFont);	

		
		FileOutputStream fileOut1 = new FileOutputStream(writecode);
		wb.write(fileOut1);

		rowcount++;
	}

	// This code is to write a row header values...
	public static void headerValues() throws IOException {
		int newrow = 0;
		HSSFRow row1 = sheet.createRow(newrow);
		
		ArrayList<String> names = new ArrayList<String>(Arrays.asList("Brand Name","SI Urls", "Clients Urls", "Singleinterface Font"," Client's Font", "Status", "SI Fonts Which are not present in clients websites"));
        int c=0;
		for (String cellName : names) {
			 
				HSSFCell cell = row1.createCell(c++);
				cell.setCellValue(cellName);
				
		}
		FileOutputStream fileOut3 = new FileOutputStream(writecode);
		wb.write(fileOut3);
		
		
	}

	
}


