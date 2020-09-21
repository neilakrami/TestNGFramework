package com.hrms.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class LoginTest extends CommonMethods{
	

	@Test(groups="smoke")
	public void validLogin() {
		sendText(login.userNametextBox, ConfigsReader.getPropValue("username"));
		sendText(login.passwordTextBox, ConfigsReader.getPropValue("password"));
		click(login.btnLogin);

		
		Assert.assertTrue(dash.welcome.isDisplayed());
		
	
	}
	
	@Test(groups="regression", dataProvider="inValidCredentials")

	public void inValidLogin(String username, String password, String errorMessage) {
	
	sendText(login.userNametextBox, username);
	sendText(login.passwordTextBox, password);
	click(login.btnLogin);
	AssertJUnit.assertEquals(login.spanMessage.getText(), errorMessage);
	
	}

	
	@DataProvider
	public String[][] inValidCredentials() {
		String[][] data = { 
				{ ""		, 	"Hum@nhrm123"	, 	"Username cannot be empty" },
				{ "Admin"	,	""				, 	"Password cannot be empty" }, 
				{ "Admin"	, 	"Hum@nhrm12"	, 	"Invalid credentials" }, 
				};
		return data;
	}
	
	
}
