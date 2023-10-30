package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.spi.FileSystemProvider;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class ReadFile {
	
	public WebDriver driver;
	static String filepath;
	static String string;
	static double value;
	static StringBuffer stringbuffer =new StringBuffer();
	static List list  = new ArrayList<Integer>();
	static  HashSet<Integer> hashSet = new HashSet<Integer>();
	static Cell cell;
	static int index1 ;
	static  int index2;
    static List<String> column1Data = new ArrayList<>();
    static List<String> column2Data = new ArrayList<>();
    static List<String> column3Data = new ArrayList<>();
    static String valueindex2;
    static ArrayList<Integer> intList1 = new ArrayList<>();
    static ArrayList<Integer> intList2 = new ArrayList<>();
    static String brandname;
    static  int element1;
    static  int element2;
    static int Passcount=0;
	static int Failcount=0;
	public ReadEmail re;
	final StringBuffer previousDate = re.buffer;
	static String currentdate;
	static  LocalDate currentd;
	static StringBuffer sb ;
	static StringBuilder sbb;
	static HashSet<String> hashset ;
	static ArrayList<String> arraylist = new ArrayList<String>();
	static Set<String> uniqueData = new LinkedHashSet<>();
	static  ArrayList<String> listt  = new ArrayList<String>();
	static  ArrayList<Integer> arraylistt  = new ArrayList<Integer>();
	static int col2;
	static List<Integer> columnData = new ArrayList<>();
	static List<Integer> rownumdata = new ArrayList<>();
	static List<Integer> rownumpassdata = new ArrayList<>();
	static  HashSet<Integer> inthash = new HashSet<Integer>();
	static  HashSet<Integer> inthashpass = new HashSet<Integer>();
	static ArrayList<String>  arrayL  = new ArrayList<String>();
	static HashSet<String> set  = new HashSet<String>();
	static StringBuffer buffer  = new StringBuffer();
	static String downloadsheet;
	static String todaydate;
	static ArrayList<Date> parseDate  = new ArrayList<Date>();
	static Date sheetPreviousDate;
	static StringBuffer parseDatebuffer  = new StringBuffer();
	static  HashSet<String> parseDateSet = new HashSet<String>();
	
	
	
	
	public ReadFile(WebDriver driver) throws IOException {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	
	public void excelFileName() {
	        // Specify the path to your Excel file in the project directory
		    String path = System.getProperty("user.dir")+"//downloaded_file.xlsx";
	        String filePath = path;
	        filepath = path;
	        
	        // Create a File object for the Excel file
	        File excelFile = new File(filePath);

	        // Check if the file exists
	        if (excelFile.exists()) {
	            // Get the last modified timestamp in milliseconds
	            long lastModifiedTimestamp = excelFile.lastModified();

	            // Convert the timestamp to a Date object
	            Date lastModifiedDate = new Date(lastModifiedTimestamp);

	            // Format the Date object as a human-readable string
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            currentdate = dateFormat.format(lastModifiedDate);
	            
                // Get the current date
                currentd = LocalDate.now();
                System.out.println(currentd);

	            System.out.println("Last modified time of the Excel file: " + currentdate);
	            downloadsheet  = "Sheet downloaded.";
	        } else {
	            System.out.println("The Excel file does not exist.");
	            downloadsheet  = "Sheet not download. The Excel file does not exist.";
	        }
		
	}
	
	
	public void readFile() throws InterruptedException, ParseException {
		
		Thread.sleep(2000);
		String filePath = filepath ;

        try (FileInputStream fis = new FileInputStream(new File(filePath));
        	 XSSFWorkbook workbook = new XSSFWorkbook(fis)) { // Use XSSFWorkbook for .xlsx files

        	 XSSFSheet sheet = workbook.getSheetAt(0); 
        	 stringbuffer.setLength(0);
    		 list.clear();
    		 hashSet.clear();
    		 column1Data.clear();
    		 column2Data.clear();
    		 column3Data.clear();
    		 intList1.clear();
    		 intList2.clear();    		
             int rows = sheet.getLastRowNum();
             int cols = sheet.getRow(0).getLastCellNum();        

            	XSSFRow row = sheet.getRow(0);
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            string = cell.getStringCellValue();
                            //System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            value = cell.getNumericCellValue();
                            //System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case BOOLEAN:
                        	boolean val = cell.getBooleanCellValue();
                            //System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        case BLANK:
                            //System.out.print("BLANK\t");
                            break;
                        default:
                           // System.out.print("UNKNOWN\t");
                    
                     }
                    
                    
                  try { 
                	  arraylist.add(string);
                	  //System.out.println(arraylist);
                	  sb  = new StringBuffer();
                	  for(String array : arraylist) {
                          sb.append(array).append(","); 
                	  }
                     
                       String[] splittedstring = sb.toString().split(",");
                       uniqueData = new LinkedHashSet<>();
                       for(String split :splittedstring) {
                    	   uniqueData.add(split);
                       }
                     
                       listt  = new ArrayList<String>();
                       for(String date : uniqueData) {
                     	listt.add(date);
                     	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                     	Date datee = dateFormat.parse(date.toString());
                     	parseDatebuffer.append(datee).append(",");
                     	//sheetPreviousDate = parseDate.get(parseDate.size()-1);

                     }

                	   int col1 = cell.getColumnIndex();

                		   for(int j=0; j<=listt.size(); j++) {
                			   if(string.equals(listt.get(j).toString())) {
                				   for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                					  Row roww = sheet.getRow(rowIndex);
                     			      Cell cellindex = roww.getCell(col1);
                     			      String cellcontent = cellindex.getStringCellValue();
                     			      if(cellcontent.contains("SI OPEN Location Count")) {
                         		         col2 = cell.getColumnIndex();
                         			     arraylistt.add(col2);
                         		    
                         		       }
                         		 
                     	  	       }
                     		
                       	       }
                     	
                            }
                		 
                     } catch(Exception e) {
                	  
                	   //System.out.println(e.getMessage());
                   }
                  
                  }
                
                 arraylistt.add(0, 0);

                  //System.out.println("sheetPreviousDate is: "+sheetPreviousDate);
         	      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         	      String day = "2023-11-04";
         	      Date date1 = dateFormat.parse(day);
         	     // Get the current date
                  LocalDate currentdd = LocalDate.now();

                // Subtract one day to get the previous date
                  LocalDate previousDatee = currentdd.minusDays(1);
                  String predate = previousDatee.toString();
                  Date previousDateinsheet = dateFormat.parse(predate);
                   
                   String[] dateSplit = parseDatebuffer.toString().split(",");
                   for(String split : dateSplit){
                	   parseDateSet.add(split);
                   }
                   ArrayList<String> parseDatearrayList = new ArrayList<>(parseDateSet);
                   
                System.out.println(parseDatearrayList.toString());
                System.out.println(date1.toString());
                
                   // if(parseDate.toString().contains(date1.toString())) {
        		    if(parseDatearrayList.toString().contains(previousDateinsheet.toString())) {   
                    	 todaydate = "Previous date";
        			     System.out.println("Today's data is present in the sheet");
        			    
        	            } else {
        	    	      System.out.println("Today's data is missing in the sheet");
        	    	      todaydate = "Previous date data is not preasent in the sheet.Please check the today's downloaded sheet";
        	            }
             
                
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	 }
	

	 public void readWrite(){
	     try {
	        // Read data from the source Excel file
            FileInputStream sourceFile = new FileInputStream(filepath);
            Workbook sourceWorkbook = new XSSFWorkbook(sourceFile);
            Sheet sourceSheet = sourceWorkbook.getSheetAt(0);

	        // Create a new Excel file and sheet to write data
	        Workbook targetWorkbook = new XSSFWorkbook();
	        Sheet targetSheet = targetWorkbook.createSheet("targetSheet");

	        Integer[] intArray = arraylistt.toArray(new Integer[0]);
	           // Iterate through rows in the source sheet
	           for (Row sourceRow : sourceSheet) {
	               Row targetRow = targetSheet.createRow(sourceRow.getRowNum());

	               // Copy data from selected columns in the source row to the target row
	                int j=0; 
	                for (int columnIndex : intArray) {
	              	  Cell sourceCell = sourceRow.getCell(columnIndex);
                      Cell targetCell = targetRow.createCell(j);
                      j++;
	                      
	                    if (sourceCell != null) {
	                       switch (sourceCell.getCellType()) {
	                           case STRING:
	                               targetCell.setCellValue(sourceCell.getStringCellValue());
	                               break;
	                           case NUMERIC:
	                               targetCell.setCellValue(sourceCell.getNumericCellValue());
	                               break;
	                              // Handle other cell types as needed
	                          }
	                      }
	                    
	                 }
	                
	            }

	            // Save the target Excel file
	            String path = System.getProperty("user.dir")+"//writedata.xlsx";
	            FileOutputStream targetFile = new FileOutputStream(path);
	            targetWorkbook.write(targetFile);
	            targetFile.close();

	            System.out.println("Data copied successfully.");

	            // Close the source workbook
	            sourceWorkbook.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	 
	  public void excelDataComparison() {
	      try {
	    	    String path = System.getProperty("user.dir")+"//writedata.xlsx";
	            FileInputStream excelFile = new FileInputStream(path);
	            Workbook workbook = new XSSFWorkbook(excelFile);
	            Sheet sheet = workbook.getSheetAt(0); // Replace with your sheet name
	            int index = 0;
           	    int index2=(index+1);
           	    
	              for(int i=1; i<arraylistt.size(); i++) {
	            	 index++;
	                 for (int rowIndex = 2; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                       Row roww = sheet.getRow(rowIndex);
                       if (roww != null) {
                         // Get the data date wise
                         Cell cellindex1 = roww.getCell(index);
                         if (cellindex1 != null) {
                        	  String indexvalue = cellindex1.getStringCellValue();
                        	  int intvalue = Integer.parseInt(indexvalue);
                              intList1.add(intvalue);
                           
                             } else {
                        	    System.out.println("Data is blank");
                             }

                        try {
                             Cell cellindex2 = roww.getCell(index2);
                             if (cellindex2 != null) {
                       	     String indexvalue = cellindex2.getStringCellValue();
                       	     int intvalue = Integer.parseInt(indexvalue);
                       	     intList2.add(intvalue);
                          } else {
                       	
                             	//System.out.println("Data is blank");
                          }
                        } catch(Exception e) {
                        	System.out.println(e.getMessage());
                        }
                        
	                  }
                   
	    	         }
	                 
	                 try {
                       if(intList1!=null && intList2!=null) {
                       int sum=0;
                       int sum2=0;
                       for (int m = 0; m < intList1.size(); m++) {

                	     Row row = sheet.getRow(m);
                         element1 = intList1.get(m);
                         element2 = intList2.get(m);
                         sum +=element1;
                         sum2 +=element2;

                          if(sum==0) {
                	        System.out.println("Test is fail");
                	        int rownum = row.getRowNum();
                	        rownumdata.add(rownum);
                	       
                          }
                          else if(sum2==0) {
                    	    System.out.println("Test is fail");
                    	    int rownum = row.getRowNum();
                  	        rownumdata.add(rownum);
                          }
                          else if(element1==0 && element2!=0 ) {
                	        System.out.println("Test is faillllllllllllll");
                	        int rownum = row.getRowNum();
                	        rownumdata.add(rownum);
                          }
//                          else if(element1==0 && element2==0 ) {
//                        	  
//                        	  System.out.println("Test is Pass");
//                              int rownumm = row.getRowNum();
//                  	        rownumpassdata.add(rownumm);
//                          }
                          else {
                            System.out.println("Test is Pass");
                            int rownumm = row.getRowNum();
                	        rownumpassdata.add(rownumm);
                      
                          }
                    
                        }
                    
                      }
                       intList1.clear();
                       intList2.clear();
	                }
	                 
	                 catch(Exception e) {
	            	
	            	System.out.println(e.getMessage());
	                }
        
	             }
	              
	              for(int value : rownumdata) {
	            	   inthash.add(value);
	               }
	               System.out.println(inthash);
	              

	               for(int value : rownumpassdata) {
	            	   inthashpass.add(value); 
	            	   inthashpass.remove(inthash);
	               }
	               
	               System.out.println(inthashpass);
	              workbook.close();
	              excelFile.close();
	          } catch (IOException e) {
	              e.printStackTrace();
	          }
	    	
	    }

	    public void writeDataInExcel(){
	    	try {
	            // Read data from the source Excel file
	            FileInputStream sourceFile = new FileInputStream(filepath);
	            Workbook sourceWorkbook = new XSSFWorkbook(sourceFile);
	            Sheet sourceSheet = sourceWorkbook.getSheetAt(0);

	            // Create a new Excel file and sheet to write data
	            Workbook targetWorkbook = new XSSFWorkbook();
	            Sheet targetSheet = targetWorkbook.createSheet("targetSheet");
	            Sheet sheet = targetWorkbook.getSheetAt(0);
	           
	            Integer[] intArray = arraylistt.toArray(new Integer[0]);

	              // Iterate through rows in the source sheet
	              for (Row sourceRow : sourceSheet) {
	                 Row targetRow = targetSheet.createRow(sourceRow.getRowNum());
	                
	                 // Copy data from selected columns in the source row to the target row
	                  int j=0; 
	                  for (int columnIndex : intArray) {
	                	  Cell sourceCell = sourceRow.getCell(columnIndex);
	                      Cell targetCell = targetRow.createCell(j);
	                      j++;
	                      
	                      List<Integer> arrayList2 = new ArrayList<>(inthashpass); 
		                    
	                      for(int m=0; m<arrayList2.size(); m++) {
	                    	  int rownum = targetCell.getRowIndex();
	                          if(rownum-2==arrayList2.get(m)) {
	                          Row row = targetSheet.getRow(0);
	                          int k= row.getLastCellNum();
	                  
	       	                  for(int rowIndex : arrayList2) {
	       	                	  Cell targetCel = targetRow.createCell(k);
	       	                	  targetCel.setCellValue("Pass");
	       	                	  //System.out.println(rowIndex);
	                           }
	       	                  
	                         }
	                          
	                         if (sourceCell != null) {
	                           switch (sourceCell.getCellType()) {
	                              case STRING:
	                                  targetCell.setCellValue(sourceCell.getStringCellValue());
	                                  break;
	                              case NUMERIC:
	                                  targetCell.setCellValue(sourceCell.getNumericCellValue());
	                                  break;
	                            // Handle other cell types as needed
	                          }
	                        
	                       }
	                      
	                    }
	                      
	                      List<Integer> arrayList = new ArrayList<>(inthash); 
	                      for(int m=0; m<arrayList.size(); m++) {
	                    	  int rownum = targetCell.getRowIndex();
	                          if(rownum-2==arrayList.get(m)) {
	                          Row row = targetSheet.getRow(0);
	                          int k= row.getLastCellNum();
	                   
	   	                   	  DataFormatter df = new DataFormatter();
	   	                   	  brandname = df.formatCellValue(sheet.getRow(rownum).getCell(0));

	       	                  for(int rowIndex : arrayList) {
	       	                   Cell targetCel = targetRow.createCell(k);
	       	          	       targetCel.setCellValue("Fail");
	       	                   // Create a cell style with a red background color
	       	                   CellStyle redCellStyle = targetWorkbook.createCellStyle();
	       	                   redCellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
	       	                   redCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

	       	                   // Apply the red cell style to the cell
	       	                   targetCel.setCellStyle(redCellStyle);
	       	                
	       	                	  //System.out.println(rowIndex);
	                           }
	       	                  
	       	                    set  = new HashSet<String>();
	   	                  	    arrayL.add(brandname);
	   	                  	    for(String brand : arrayL) {
	   	                  	    	set.add(brand);
	   	                  	    }
	   	                  	    
	   	                  	    stringbuffer = new StringBuffer();
	   	                  	    for(String brand : set) {
	   	                  	    stringbuffer.append(brand).append(",");  
	   	                  	    }
	   	                  	    
	                         }
	                          
	                         if (sourceCell != null) {
	                           switch (sourceCell.getCellType()) {
	                              case STRING:
	                                  targetCell.setCellValue(sourceCell.getStringCellValue());
	                                  break;
	                              case NUMERIC:
	                                  targetCell.setCellValue(sourceCell.getNumericCellValue());
	                                  break;
	                            // Handle other cell types as needed
	                          }
	                        
	                       }
	                      
	                    }
	                   
	          
	                      arrayList.clear();
	                      arrayList2.clear();
	                 }
	                
	              }
	                Row roww = sheet.getRow(0);
	 	            Cell status = sheet.getRow(0).createCell(roww.getLastCellNum());
	 	            status.setCellValue("Status");
	                System.out.println(stringbuffer);
	  	            int total = sheet.getLastRowNum()-1;
		            Failcount = inthash.size();
		            System.out.println(inthash.size());
		            Passcount  = total - Failcount;
	              
	                // Save the target Excel file
		            String path = System.getProperty("user.dir")+"//writeexcel.xls";
	                FileOutputStream targetFile = new FileOutputStream(path);
	                targetWorkbook.write(targetFile);
	                targetFile.close();

	               System.out.println("Data copied successfully.");
	   

	              // Close the source workbook
	               sourceWorkbook.close();
	          } catch (IOException e) {
	              e.printStackTrace();
	            }
	       }
	    
	    
	    public static void deleteExcel() {
	        // Specify the file name and path to the Excel file in your project directory
	    	  String path = System.getProperty("user.dir")+"//downloaded_file.xlsx";
	        String filePath = path; 

	        // Create a File object for the Excel file
	        File excelFile = new File(filePath);

	        // Check if the file exists before attempting to delete it
	        if (excelFile.exists()) {
	            // Attempt to delete the file
	            if (excelFile.delete()) {
	                System.out.println("Excel file deleted successfully.");
	            } else {
	                System.out.println("Failed to delete the Excel file.");
	            }
	        } else {
	            System.out.println("The Excel file does not exist.");
	        }
	    }
	    
	    public static void clearExcelData() {
	        // Specify the path to your Excel file
	    	 String path = System.getProperty("user.dir")+"//writeexcel.xls";
	        String filePath = path;
	        
	        
	        try {
	            // Create a FileInputStream to read the Excel file
	            FileInputStream fis = new FileInputStream(filePath);

	            // Initialize the appropriate workbook based on the file type (XSSFWorkbook for .xlsx)
	            Workbook workbook = new XSSFWorkbook(fis);

	            // Get the sheet you want to clear (e.g., the first sheet at index 0)
	            Sheet sheet = workbook.getSheetAt(0);

	            // Iterate over the rows and clear the content (data) in each row
	            for (Row row : sheet) {
	                for (Cell cell : row) {
	                    // Clear the cell content
	                    cell.setCellValue("");
	                }
	            }

	            // Save the changes to the same file
	            FileOutputStream fos = new FileOutputStream(filePath);
	            workbook.write(fos);
	            fos.close();

	            // Close the FileInputStream and the workbook
	            fis.close();
	            workbook.close();

	            System.out.println("Data in the Excel sheet cleared successfully.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    }

	     public static int pass() {
		   return Passcount;
	    }
	
        public static int fail() {
		   return Failcount;
	    }
        
        public static StringBuffer sb() {
		   return stringbuffer;
	    }
        
        public static String filePath() {
        	return filepath;
        }
        
        public static String sheetDownload() {
        	return downloadsheet;
        }
        
        public static String todaySheet() {
        	return todaydate;
        }
        	

}
