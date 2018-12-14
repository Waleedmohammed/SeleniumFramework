package com.qa.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.UserRegistrationPage;
import com.qa.testdata.ExcelReader;

public class UserRegistrationDDT_ExcelFile extends TestBase{

	HomePage home;
	UserRegistrationPage Regist;

	@DataProvider(name="testData")
	public  Object [][] UserData() throws IOException{
		ExcelReader reader = new ExcelReader();
		return reader.getExcelData();

	}

	@Test(dataProvider="testData")
	public void UserCanRegisterSuccessfully(String FName,String LName,String Email , String  Passwd) {


		home = new HomePage(driver);
		home.waitForLoad(driver);
		home.openRegistrationPage();
		Regist = new UserRegistrationPage(driver);
		Regist.waitForLoad(driver);
		Regist.FillRegistrationForm(FName,LName,Email,Passwd	);
		Assert.assertTrue(Regist.successmsg.getText().contains("completed"));
		Regist.userLogout();

	}

}
