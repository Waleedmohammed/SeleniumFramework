package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.UserRegistrationPage;
import com.qa.testdata.LoadPrepertyfile;

public class UserRegistrationDDT_PropertyFile extends TestBase{

	HomePage home;
	UserRegistrationPage Regist;
	String fn=LoadPrepertyfile.UserData.getProperty("FirstName");
	String ln=LoadPrepertyfile.UserData.getProperty("LAstName");
	String Email=LoadPrepertyfile.UserData.getProperty("Email");
	String Passwd=LoadPrepertyfile.UserData.getProperty("Password");

	@Test
	public void UserCanRegisterSuccessfully() {


		home = new HomePage(driver);
		home.waitForLoad(driver);
		home.openRegistrationPage();
		Regist = new UserRegistrationPage(driver);
		Regist.waitForLoad(driver);
		Regist.FillRegistrationForm(fn, ln, Email, Passwd);
		Assert.assertTrue(Regist.successmsg.getText().contains("completed"));

	}

}
