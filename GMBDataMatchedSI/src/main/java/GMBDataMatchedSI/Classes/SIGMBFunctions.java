package GMBDataMatchedSI.Classes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import javax.swing.JFrame;
import java.awt.Robot;
import java.awt.Dimension;
import java.awt.Toolkit;


public class SIGMBFunctions {

	public static String convertTo24HourFormat(String inputTime) {
		// Replace non-breaking spaces with regular spaces
		inputTime = inputTime.replace('\u202F', ' ');

		// Define multiple formats to try parsing
		SimpleDateFormat[] inputFormats = { new SimpleDateFormat("h:mm a"), new SimpleDateFormat("h a") };

		SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm");

		// Try each input format
		for (SimpleDateFormat inputFormat : inputFormats) {
			try {
				Date date = inputFormat.parse(inputTime);
				return outputFormat.format(date);
			} catch (ParseException e) {
				// Continue to the next format if parsing fails
			}
		}

		return null; // Handle parsing error as needed
	}

	// Business Hours days
	public static String convertToPattern(String day, String startTime, String endTime) {
	    // Map day names to numerical values
	    Map<String, Integer> dayToNumber = new HashMap<String, Integer>();
	    dayToNumber.put("Monday", 1);
	    dayToNumber.put("Tuesday", 2);
	    dayToNumber.put("Wednesday", 3);
	    dayToNumber.put("Thursday", 4);
	    dayToNumber.put("Friday", 5);
	    dayToNumber.put("Saturday", 6);
	    dayToNumber.put("Sunday", 7);

	    // Get the numerical value for the day
	    Integer dayNumber = dayToNumber.get(day);

	    if (dayNumber != null) {
	        // Format the day
	        String formattedDay = String.valueOf(dayNumber);

	        if ("Open 24 hours".equalsIgnoreCase(startTime)) {
	            // Handle open 24 hours case
	            String formattedStartTime = "00:00";
	            String formattedEndTime = "23:59";
	            return formattedDay + ":" + formattedStartTime + ":" + formattedEndTime;
	        } else {
	            // Handle specific time range
	            String formattedStartTime = convertTo24HourFormat(startTime);
	            String formattedEndTime = convertTo24HourFormat(endTime);
	            return formattedDay + ":" + formattedStartTime + ":" + formattedEndTime;
	        }
	    }
	    return null;
	}




	// Business Hours Time
	public static String extractDayTime(String input) {
	    // Trim the trailing ";" and spaces if they exist
	    input = input.trim().replaceAll(";\\s*", ";");

	    // Split the string by the delimiter "; " to get individual day-time pairs
	    String[] dayTimePairs = input.split(";");
	    StringBuilder patternBuilder = new StringBuilder();

	    for (String pair : dayTimePairs) {
	        // Split each pair by ", " to separate day and time
	        String[] parts = pair.split(", ");

	        if (parts.length == 2) {
	            String day = parts[0];
	            String time = parts[1];

	            if (time.contains("Open 24 hours")) {
	                // Handle open 24 hours case
	                String pattern = convertToPattern(day, "Open 24 hours", "Open 24 hours");
	                if (pattern != null) {
	                    patternBuilder.append(pattern);
	                    patternBuilder.append(", ");
	                }
	            } else {
	                // Split the time string by " to " to get starting and ending times
	                String[] timeParts = time.split(" to ");
	                if (timeParts.length == 2) {
	                    String startTime = timeParts[0];
	                    String endTime = timeParts[1];

	                    String pattern = convertToPattern(day, startTime, endTime);
	                    if (pattern != null) {
	                        patternBuilder.append(pattern);
	                        patternBuilder.append(", ");
	                    }
	                }
	            }
	        }
	    }
	        
	        String pattern = patternBuilder.toString().trim();
			if (pattern.endsWith(",")) {
				pattern = pattern.substring(0, pattern.length() - 1);
			}

			return pattern;
	}

	
	
	// Trim Function

	public static String trimTrailingCommaAndCheckFormat(String input) {
		// Define a regular expression pattern to match trailing comma and spaces
		String pattern = ",\\s*$";

		// Remove trailing comma and spaces
		String trimmed = input.replaceAll(pattern, "");

		// Check if the trimmed string ends with only alphabets and digits
		if (trimmed.matches(".*[a-zA-Z0-9]$")) {
			return trimmed;
		} else {
			return input; // Return the original string if the format doesn't match
		}
	}

	// Reagarange pattern

	public static String rearrangeString(String input) {
	    String[] parts = input.split(", "); // Split the string by comma and space
	    Arrays.sort(parts); // Sort the parts
	    return String.join(", ", parts); // Join the sorted parts back into a single string
	}
	
	public static String rearrangeStringSI(String input) {
		String[] parts = input.split(", "); // Split the string by comma and space
		Arrays.sort(parts); // Sort the parts
		return String.join(", ", parts); // Join the sorted parts back into a single string
	}

	public static double calculateDistance(double lat1, double lat2, double lon1, double lon2) {
		// Convert latitude and longitude coordinates from degrees to radians
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);
		lon1 = Math.toRadians(lon1);
		lon2 = Math.toRadians(lon2);

		double dlon = lon2 - lon1;
		double dlat = lat2 - lat1;
		double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);

		double c = 2 * Math.asin(Math.sqrt(a));

		// Radius of Earth in kilometers. Use 6371 for the mean radius of the Earth.
		double r = 6371;

		// Calculate the distance in kilometers
		return c * r;
	}
	
	
	
	
}
