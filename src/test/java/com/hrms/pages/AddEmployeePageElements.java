package com.hrms.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.testbase.BaseClass;

public class AddEmployeePageElements extends BaseClass {
	
	/**
	 * Method that sends text to any given element
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
	public static JavascriptExecutor getJSExecutor() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		return js;
	}
	/**
	 * Method performs clicking using JavaScript executor
	 * @param element
	 */
	
	public static void jsClick(WebElement element) {
		getJSExecutor().executeScript("argument[0].click;", element);
	}
	/**
	 * Methods scrolls up using JavaScript Executor
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		getJSExecutor().executeScript("windo.crollBy(0,-" + pixel + ")");
	}
	/**
	 * Methods scrolls down using JavaScript excutor
	 * @param pixel
	 */
	
	public static void scrollDown(int pixel) {
		getJSExecutor().executeScript("windo.crollBy(0," + pixel + ")");
	}
	
	public static WebDriverWait getWaitObject() {
		return new WebDriverWait(driver, 20);
		
	}
	
	@FindBy(xpath = "//input[@id = 'firstName']")
	public WebElement firstNameField;
	
	@FindBy(xpath = "//input[@id = 'middleName']")
	public WebElement middleName;
	
	@FindBy(xpath = "//input[@id = 'lastName']")
	public WebElement lastName;
	
	@FindBy(xpath = "//input[@id = 'photofile']")
	public WebElement chooseFile;
	
	@FindBy(id = "btnSave")
	public WebElement saveButton;
	
	@FindBy(xpath = "//span[@for = 'lastName']")
	public WebElement errorMessageForBlankLastName;
	
	@FindBy(xpath = "//span[@for = 'firstName']")
	public WebElement errorMessageForBlankFirstName;
	
	@FindBy(id = "chkLogin")
	public WebElement createLoginDetailsCheckbox;
	
	@FindBy(id = "user_name")
	public WebElement userName;
	
	@FindBy(id = "user_password")
	public WebElement userPassword;
	
	@FindBy(id = "re_password")
	public WebElement confirmPassword;
	
	public AddEmployeePageElements() {
		PageFactory.initElements(driver, this);
	}
}
