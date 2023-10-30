package testclasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import extentlisteners.ListenerClass;


public class GetFontTest extends ListenerClass {
	
	public WebDriver driver;
	public DevTools devtools;
	
	
	@Test(dataProvider = "pr")
	public void getFontFamily(String Url) throws Throwable {
		
		gfl.gettingFontFamily(Url);
		
	}
	
	public static String[] readXLSXFile() throws IOException, InterruptedException {
		
		InputStream excelFileName = new FileInputStream(System.getProperty("user.dir")+
				"/src/main/java/excelsheet/read1.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(excelFileName);
		int sheets = wb.getNumberOfSheets();
		System.out.println("Total Number of sheets :"+sheets);
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row;
		XSSFCell cell;

		Iterator<Row> rows = sheet.rowIterator();

		String[] arrUrls = new String[sheet.getLastRowNum() + 1];
		int rowNum = sheet.getLastRowNum() + 1;
		System.out.println("Total Number of Rows in the excel is : " + rowNum);
		int rowIndex = 0;
		while (rows.hasNext()) {
			row = sheet.getRow(rowIndex);
			row = (XSSFRow) rows.next();
			Iterator<Cell> cells = row.cellIterator();
			
			while (cells.hasNext()) {
				cell = (XSSFCell) cells.next();

				CellType cellType = cell.getCellType().equals(CellType.FORMULA)
						? cell.getCachedFormulaResultType() : cell.getCellType();

				if (cellType.equals(CellType.STRING)) {
					arrUrls[rowIndex] = cell.getStringCellValue();
				} else if(cellType.equals(CellType.NUMERIC)) {
					
				}
			
			}
		
			rowIndex++;
		}
		
		return arrUrls;
		
	}
	
	
	@DataProvider
	public Object[] pr() throws IOException, InterruptedException { 
		System.out.println("@DataProvider");
		String[] data = readXLSXFile();
		return data;
	}
	
	
	

}
