package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.UserRegistrationPage;

public class UserRegistrationDDT_JavaFaker extends TestBase{

	HomePage home;
	UserRegistrationPage Regist;
	Faker fakedata = new Faker();
	String FName = fakedata.name().firstName();
	String LName = fakedata.name().lastName();
	String Email = fakedata.internet().emailAddress();
	String Passwd = fakedata.internet().password();
	
	@Test
	public void UserCanRegisterSuccessfully() {


		home = new HomePage(driver);
		home.waitForLoad(driver);
		home.openRegistrationPage();
		Regist = new UserRegistrationPage(driver);
		Regist.waitForLoad(driver);
		Regist.FillRegistrationForm(FName, LName, Email, Passwd);
		Assert.assertTrue(Regist.successmsg.getText().contains("completed"));

	}

}
