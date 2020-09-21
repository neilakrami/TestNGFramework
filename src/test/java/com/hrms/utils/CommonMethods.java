package com.hrms.utils;
	
	import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import com.hrms.testbase.PageInitializer;

	public class CommonMethods extends PageInitializer {
		
		/**
		 * Method that sends text to any given element
		 * @param element
		 * @param text
		 */
		public static void sendText(WebElement element, String text) {
			element.clear();
			element.sendKeys(text);
		}
		
		/**
		 * Method return object of JavaScript Executor type
		 * @return
		 */
		public static JavascriptExecutor getJSExecutor() {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			return js;
		}
		
		/**
		 * Method performs clicking using JavaScript executor
		 * @param element
		 */
		
		public static void jsClick(WebElement element) {
			getJSExecutor().executeScript("arguments[0].click();", element);
		}
		
		/**
		 * Methods scrolls up using JavaScript Executor
		 * @param pixel
		 */
		public static void scrollUp(int pixel) {
			getJSExecutor().executeScript("window.scrollBy(0,-" + pixel + ")");
		}
		/**
		 * Methods scrolls down using JavaScript excutor
		 * @param pixel
		 */
		
		public static void scrollDown(int pixel) {
			getJSExecutor().executeScript("window.scrollBy(0." + pixel + ")");
		}
		
		public static WebDriverWait getWaitObject() {
			return new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
			
		}
		
		public static void waitForClickability(WebElement element) {
			getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
		}
		public static void click(WebElement element) {
			waitForClickability(element);
			element.click();
		}
		
		/**
		 * Method that will take a screenshot and store with name in specified location with .png extension
		 * @param fileName
		 */
		public static void takeScreen(String fileName) {
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(src,new File(Constants.SCREENSHOT_FILEPATH+fileName+ getTimeStamp()+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		/**
		 * This method will generate timeStamp
		 * @return
		 */
		public static String getTimeStamp() {
			
			Date date=new Date();
	
			//	This is the structure of Java	---> ("yyyy-MM-dd-HH:mm:ss")
			//										 ("yyyy-MM-dd-HH_mm_ss")
			SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss-MM-dd-yyyy");
			return sdf.format(date);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
