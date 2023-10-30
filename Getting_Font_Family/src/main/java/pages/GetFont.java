package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.network.Network;
import org.openqa.selenium.devtools.v114.network.model.Headers;
import org.openqa.selenium.devtools.v114.network.model.Request;
import org.openqa.selenium.devtools.v114.network.model.RequestId;
import org.openqa.selenium.devtools.v114.network.model.Response;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Ordersdata.repository.excelSheetUtility;


public class GetFont {
	
	public WebDriver driver;
	public DevTools devtools;
	static  Response res;
	static String brandnames= null;
	static String siUrlsText= null;
	static String brandurlText = null;
	static String brandUrlsText= null;
	static String font1Text = null;
	static String font2Text = null;
	static String font3Text = null;
	static String SIAllFontText = null;
	static String brandFontFamilyText= null;
	static String statusText = null;
	static String failStatusText = null;
	static String ClientAllFontText = null;
	static List<String> arrayList=new ArrayList();
	static List<String> arrayList2=new ArrayList();
	static List<String> arrayListNew=new ArrayList();
	static StringBuffer stringBuffer = new StringBuffer();
	static StringBuffer stringBuffer2 = new StringBuffer();
	static StringBuffer stringBuffer3 = new StringBuffer();
	static StringBuffer stringBufferNew = new StringBuffer();
	static StringBuffer stringBufferNewNew = new StringBuffer();
	static  HashSet<String> hashSet = new HashSet<String>();
	static  HashSet<String> hashSet2 = new HashSet<String>();
	static  HashSet<String> hashSetNew = new HashSet<String>();
	static  HashSet<String> hashSetNewNew = new HashSet<String>();
	static  Set<String> ClientSet =  new HashSet<>();
	static  Set<String> SiSet =  new HashSet<>();
	static String uniqueSiSetText = null;
	static int Passcount=0;
	static int Failcount=0;
    JavascriptExecutor js = (JavascriptExecutor) driver;
    
	
    
    
	public GetFont(WebDriver driver) throws IOException {
		try {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	    devtools  = ((ChromeDriver )driver).getDevTools();
	    excelSheetUtility.headerValues();
	    
		}
		catch(Exception e) {
		   //System.out.println("Constructor Exception : " +e.getMessage());
		}
	}
	
	
	   @FindBy(xpath="//*[@class='card-header heading']") WebElement brandname;
	   @FindBy(xpath="//*[@rel='canonical']") WebElement brandcanonical;

	
	 protected void finalize() throws Throwable
	    {
	        try {
	 
	            //System.out.println("inside demo's finalize()");
	        }
	        catch (Throwable e) {
	 
	            throw e;
	        }
	        finally {
	 
	            // Calling finalize() of Object class
	            super.finalize();
	        }
	    }
	 
	 
	public void gettingFontFamily(String siUrl) throws Throwable {
		     
	     try {

			    font1Text = null;
		    	brandnames = null;
			    siUrlsText = null;
			    brandurlText= null;
				SIAllFontText = null;
				statusText = null;
				failStatusText = null;
				ClientAllFontText =null;
				arrayList.clear();
				arrayList2.clear();
				hashSet.clear();
				hashSet2.clear();
				stringBuffer.setLength(0);
				stringBuffer2.setLength(0);
				stringBuffer3.setLength(0);
				arrayListNew.clear();
				stringBufferNew.setLength(0);
				hashSetNew.clear();
				hashSetNewNew.clear();
				ClientSet.clear();
				SiSet.clear();
				uniqueSiSetText = null;
				
				
				  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
				  siUrlsText = siUrl;
				  
				  final RequestId[] requestIds = new RequestId[1];
			      devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty())) ;

			    
				    if(siUrl!=null) {
				    	
					   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					 
				       try {
				    	
				           devtools.addListener(Network.responseReceived(), response -> {
				         
				    	    Response res = response.getResponse();
//				    	    System.out.println("URL - " + res.getUrl());
//			                System.out.println(res.getStatus().toString());
//			                System.out.println("Headers - " + res.getHeaders());
//			                System.out.println("Header text - " + res.getHeadersText());
				    
			                 if(res.getStatus()==200){
			            	   
			            	   if( res.getUrl().contains("VendorpageTheme") && res.getUrl().contains("/fonts/")) {

			            		   String fontUrls = res.getUrl();
				                	  
				                	try {  
				                	    arrayList.add(fontUrls);
		                                 for(String fonts :arrayList ) {
		                           	         stringBuffer.append(fonts).append(",");
		                                   }  
		                           	          String resultString = stringBuffer.toString();
		                           	          String[] splittedString = resultString.split(",");
		                           	          hashSet = new HashSet<String>();
		                                 	    for(String word :splittedString ) {
		                                		   hashSet.add(word);
		                                 	     }
		                                 	        stringBuffer.setLength(0);
		                                 	        arrayList.clear();
		                                              for(String word : hashSet) {
		                                		         arrayList.add(word);
		                                              }  
		                                                  hashSet.clear();
				                	         }
				                	
				                	      catch(Exception e) {
				                		    // System.out.println(e.getMessage());
				                	       }

	                                   
			                                     try {
			                                    	 if(arrayList !=null) {
			                	                       for(int j=0; j<arrayList.size(); j++) {
			                	            
			                	                           String url1 = arrayList.get(j);
				                		                   String[] url1Array = url1.split("/");
				                		                   List<String> endpoints1 = Arrays.asList(url1Array);
						            	                   int size1 = endpoints1.size();
						            	                   String font1 = endpoints1.get(size1-1);
						            	                   String[] fonts1 = font1.split("\\.");
						            	                   List<String> fontf1 = Arrays.asList(fonts1);
						            	                   String fontFamily1 = fontf1.get(0);
						            	                   String actualFontFamily1 = fontFamily1.replace("-", " ");
						            	                   font1Text = actualFontFamily1.replaceAll("[^a-zA-Z0-9]", " "); 
						            	              
			                	                         }
						            	                    arrayListNew.add(font1Text);
						            	                    stringBufferNew = new StringBuffer();
						            	                      for(String fontList : arrayListNew) {
						            	                	      stringBufferNew.append(fontList).append(",");
						            	                       }
						            	                     
						            	                           String fontsfamily = stringBufferNew.toString();
						            	                           String[] fontss = fontsfamily.split(",");
						            	                   
						            	                             hashSetNew = new HashSet<String>();
						            	                               for(String font : fontss) {
						            	                	               hashSetNew.add(font.replaceAll("[^a-zA-Z0-9]", " "));
						            	                                 }
						            	                
						            	                                   stringBufferNew.setLength(0);
				                                 	                         for(String fontFam: hashSetNew) {
				                                 	        	                stringBufferNew.append(fontFam.trim()).append(",");
				                                 	        	                
				                                 	        	                SIAllFontText = stringBufferNew.toString().trim();
				                                 	        	                SiSet = new HashSet<>(Arrays.asList(SIAllFontText.toLowerCase().split(",")));
				                                 	        	                
				                                 	                          }
				                                 	                         
			                	                                   arrayList.clear();
			                	                                   stringBuffer.setLength(0);
			                                             }
			                                    	 
			                                    	else {
			                                    		 SIAllFontText  ="Font not found";
			                                     }
			                                    	 
			                              }
			                 
			               
			                       catch(Exception e) {
							     	//System.out.println("Exception for ArrayList Index : " +e.getMessage());
								 
			                    }

			                 
			            	 }
			              	
			              }
			           
				      });
				          //System.out.println("1");
				          //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				          Thread.sleep(2000);
				          driver.get(siUrl);
				           
				          try {
				            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				            wait.until(ExpectedConditions.visibilityOf(brandname));
					    	  if(driver.findElements(By.cssSelector(".card-header.heading")).size()>0){
								//brandnames= driver.findElement(By.cssSelector(".card-header.heading")).getText();
					    		 brandnames = brandname.getText();
								 System.out.println(brandnames);
								
							   }
					    	 
							  else {
								 
								brandnames="Null";
							   }
				            }
				           
				           catch(Exception e) {
				        	  System.out.println(e.getMessage());
				           }
					    	
				           
					 }
					 catch(Exception e) {
						// System.out.println(e.getMessage());
					 }
				      
				  }
				    
				    else {
				    	//excelSheetUtility.failcode("Null", "Null", "---", "---","---", "---", "---" );
				    	System.out.println("No any Url in a row");
				    }
				 
				    
				    try {
				    
				    	  if(siUrl.contains("kfc")) {
					    		 //WebElement banner = driver.findElement(By.xpath("//*[@class='offer-area mt-3 mt-md-0']"));
					    		 //brandurlText= banner.getAttribute("href");
				    		     brandurlText= "https://online.kfc.co.in/";
					    	  }
				    	  else if(siUrl.contains("skoda")) {
					    		 //WebElement fpviewdetails = driver.findElement(By.xpath("(//*[@class='card-footer'])[1]"));
					    		 //brandurlText= fpviewdetails.getAttribute("href");
				    		     brandurlText= "https://www.skoda-auto.co.in/";
					    	  }
				    	  else if(siUrl.contains("iqube")) {
					    		 //WebElement banner = driver.findElement(By.xpath("//*[@class='offer-area']"));
					    		 //brandurlText= banner.getAttribute("href");
				    		     brandurlText=  "https://www.tvsmotor.com/";
					    	  }
				    	  else if(siUrl.contains("metropolisindia")) {
					    		 brandurlText= "https://www.metropolisindia.com/";
					    	  }
				    	  else if(siUrl.contains("vredestein")) {
					    		 //WebElement banner = driver.findElement(By.xpath("//*[@class='offer-area']"));
					    		// brandurlText= banner.getAttribute("href");
					    		 brandurlText= "https://www.vredestein.co.in/";
					    	  }
				    	  else if(siUrl.contains("aeo.in")) {
					    		 //WebElement fpbuynow = driver.findElement(By.xpath("(//*[@class='card-footer cta-btn'])[1]"));
					    		 //brandurlText= fpbuynow.getAttribute("href");
					    		 brandurlText= "https://www.aeo.in/";
					    	  }
				    	  else if(siUrl.contains("digi1electronics")) {
					    		 brandurlText= "https://www.pinelabs.com/";
					    	  }
				    	  else if(siUrl.contains("utpro")) {
					    		 brandurlText= "https://stores.utpro.in/ut-mart-grocery-stores-baf-lane-ajmer-180275/Home";
					    	  }
				    	  else if(siUrl.contains("hero")) {
					    		// System.out.println("brandurlText of hero client");
					    		 WebElement logo = driver.findElement(By.xpath("//*[@class='navbar-brand']"));
					    		 brandurlText= logo.getAttribute("href");
					    	  }
				    	  else if(siUrl.contains("muthootfincorp")) {
					    		 brandurlText= "https://www.muthootfincorp.com/";
					    	  }
				    	  else if(siUrl.contains("axisbank")) {
				    		     brandnames="Axis Bank";
					    		 brandurlText= "https://www.axisbank.com/";
					    	  }
				    	  else if(siUrl.contains("duroflexworld")) {
				    		     brandnames="duroflex world";
					    		 brandurlText= "https://www.duroflexworld.com/";
					    	  }
				    	  else {
				    		   //Brand Website click
				    		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
						       WebElement Brandweb = driver.findElement(By.xpath("(//*[@title='Brand Website'])[1]"));
						       wait.until(ExpectedConditions.visibilityOf(Brandweb));
						       String Brandwebsite = Brandweb.getAttribute("href");
				
						       brandurlText = Brandwebsite;
						       //System.out.println("brandurlText of All clients");
						      
				    	  }
				    	
				    }
				    
				    catch(Exception e) {
				    	
				    	//System.out.println("Brand Website is not present for "+brandnames+" :" +e.getMessage());
				    	
		            }
				     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				     if(brandurlText!=null) {
				   
			             try {
			            	 
				            devtools.addListener(Network.responseReceived(), response ->
				             {
				    	      Response res = response.getResponse();
				    	      requestIds[0] = response.getRequestId();

			                    if(res.getStatus()==200 && res.getUrl().contains(".css")) {
			            	  
			                       if(response.getResponse().getHeaders().toString().contains("text/css")) {
			      
			                	       String cssContent = devtools.send(Network.getResponseBody( requestIds[0])).getBody();
			                	       String[] cssRules = cssContent.split("\\}"+"\\{");
			                	        for(String rule : cssRules) {
			                	       	   if(rule.contains("font-family")) {
			                			      String[] declarations = rule.split(";");
			                			
			                			        for(String declaration :declarations ) {
			                				       String[] propertyValue = declaration.trim().split(":");
			                				   
			                				         if (propertyValue.length == 2 && propertyValue[0].trim().equals("font-family")) {
			                                            String fontFamily = propertyValue[1].trim();  
			                                            String actualFontFamily = fontFamily.replace("-", " ");
			                                            
			                                            try {  
			                                            	stringBuffer2 = new StringBuffer();
			                                                arrayList2.add(actualFontFamily);
			                                                 for(String fonts :arrayList2 ) {
			                                            	   
			                                                	  stringBuffer2.append(fonts).append(",");
			                                                    }  
			                                            	        String resultString = stringBuffer2.toString();
			                                            	        String[] splittedString = resultString.split(",");
			                                            	       // brandFontFamilyText = resultString;
			                                            	       // System.out.println("Brand Font Families Are : "+resultString);
			                                            	 
			                                            	           hashSet2 = new HashSet<String>();
			                                            	            for(String word :splittedString ) {
			                                            		           hashSet2.add(word.replaceAll("[^a-zA-Z0-9]", " "));
			                                            	             }
			                                            	            
			                                            	            try {
			                                            	            	 stringBuffer2.setLength(0);
			                                            	                 for (String word : hashSet2) {
			                                                                   stringBuffer2.append(word.trim()).append(",");
			                                                               
			                                                                  }
			                                            	                 
			                                                                   ClientAllFontText = stringBuffer2.toString().trim();
			                                                                  // System.out.println(allBrandFontTextInLowerCase);
			                                                                   ClientSet = new HashSet<>(Arrays.asList(ClientAllFontText.toLowerCase().split(",")));
			                                                                   
			                                                                   
			                                            	              }
			                                            	            
			                                            	           catch(Exception e) {
			                                            	           //	System.out.print(e.getMessage());
			                                            	          }
			                                        
			                                                  }
			                                         catch(Exception e) {
			                                        	 //System.out.print(e.getMessage());
			                                        }

			                                            	 
			                			       }
			                				         
			                			  
			                		      }
			                			        
			                		 
			                	     }
			                	       	   
			                		 
			            	     }
			                	        
			              	
			                  }
			                       
			        
			              }
			                    
			                   
				       });
				            //System.out.println("2");
				            Thread.sleep(2000);
				            driver.get(brandurlText);
				            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				            driver.switchTo().alert().accept();
				           

				           
			         }
			             
			        catch(Exception e) {
			        	  
			        	 //System.out.println("Catch---------------"+e.getMessage());

			           }
			             
			              driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						  if(ClientSet!=null && SiSet!=null ) {
						 
						    if((ClientSet.containsAll(SiSet)) ) {
							  
							   statusText = "Pass";
							   excelSheetUtility.Passcode(brandnames, siUrlsText, brandurlText, SIAllFontText ,ClientAllFontText, statusText, "---");
							   Passcount++;
							 }
						  
						    else {
							  
							   if(SiSet.containsAll(ClientSet)) {
								  
								   statusText = "Pass";
								   excelSheetUtility.Passcode(brandnames, siUrlsText, brandurlText, SIAllFontText ,ClientAllFontText, statusText, "---");
								   Passcount++;
							    }
							  
							    else {
							  
							     // Find common elements
						         Set<String> commonElements = new HashSet<>(SiSet);
						         commonElements.retainAll(ClientSet);

						         // Find unique elements in each set
						         Set<String> uniqueSiSet = new HashSet<>(SiSet);
						         uniqueSiSet.removeAll(commonElements);
						         uniqueSiSetText = uniqueSiSet.toString();
						        
						         if(uniqueSiSetText.equals(" ") || uniqueSiSetText.equals(",") || uniqueSiSetText.equals("") || uniqueSiSetText.equalsIgnoreCase("null") || uniqueSiSetText.equals(",,") || uniqueSiSet.equals(",")) {
						        	  statusText = "Pass";
									  excelSheetUtility.Passcode(brandnames, siUrlsText, brandurlText, SIAllFontText ,ClientAllFontText, statusText, "---");
									  Passcount++;
						         }
						         else {
						        	  failStatusText = "Fail";
									  excelSheetUtility.failcode(brandnames, siUrlsText, brandurlText, SIAllFontText,ClientAllFontText, failStatusText, uniqueSiSetText );
									  Failcount++;
						         }
							   
							     commonElements.clear();
							     uniqueSiSet.clear();
							     
							  }	  
						    }
						  
						  }
						  
						  else {
							  
							    failStatusText = "Fail";
							    excelSheetUtility.failcode(brandnames,siUrlsText,"Null", "Null", "---", failStatusText, "---" );
							    Failcount++;
						    }
				   
				       }
				  
				 
				   else {

					    failStatusText = "Fail";
				    	excelSheetUtility.failcode(brandnames, siUrlsText, "Null", "---","---", failStatusText, "SI Url Not Load" );
				    	Failcount++;
				    }
				   
			
				     
			   }
				 catch(Exception e) {
					 
					System.out.println("Catch---------------"+e.getMessage());
					  //excelSheetUtility.failcode(brandnames, siUrlsText, brandurlText, allSIFontText,allBrandFontText, failStatusText);
					 
				 }
				 
	     
	     // Creating GetFont's object
	    	GetFont d = new GetFont(driver);
	 
	        // Calling finalize
	        d.finalize();
	       
		}
	
	public static int pass() {

		return Passcount;
		
	}
	
    public static int fail() {

		return Failcount;
		
	}
    

}
