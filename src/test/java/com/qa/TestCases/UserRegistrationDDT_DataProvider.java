package com.qa.TestCases;



import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.UserRegistrationPage;

public class UserRegistrationDDT_DataProvider extends TestBase
{
	HomePage homeObject ; 
	UserRegistrationPage registerObject ;  
	LoginPage loginObject ; 

	
	@DataProvider(name="testData")
	public static Object [][] UserData(){
		return new Object [][] {
			{"Waleed","Mohammed","test97777cxcx@gmail.com","123456"},
			{"Waleed","Mohammed","test977773fff3@gmail.com","123456"} 
		};
	}
	
	
	@Test(priority=1,alwaysRun=true,dataProvider="testData")
	public void UserCanRegisterSuccssfully(String FName,String LName,String Email , String  Passwd) 
	{
		homeObject = new HomePage(driver); 	
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver); 
		registerObject.FillRegistrationForm(FName, LName, Email, Passwd);
		Assert.assertTrue(registerObject.successmsg.getText().contains("Your registration completed"));
		registerObject.userLogout();
		homeObject.openRegistrationPage();
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin(Email, Passwd);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();
	}
	
}
