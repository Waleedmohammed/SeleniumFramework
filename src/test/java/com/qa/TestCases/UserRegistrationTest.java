package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase{

	HomePage home;
	UserRegistrationPage Regist;

	@Test
	public void UserCanRegisterSuccessfully() {


		home = new HomePage(driver);
		home.waitForLoad(driver);
		home.openRegistrationPage();
		Regist = new UserRegistrationPage(driver);
		Regist.waitForLoad(driver);
		Regist.FillRegistrationForm("Waleed", "Mohamed", "waleed.m.science68@gmail.com", "123456");
		Assert.assertTrue(Regist.successmsg.getText().contains("completed"));

	}

}
