package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserRegistrationPage extends PageBase{


	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}


	//Page Factory

	@FindBy(id="gender-male")
	WebElement MaleGenderbtn;

	@FindBy(id="gender-female")
	WebElement FemaleGenderbtn;
	
	@FindBy(id="FirstName")
	WebElement FNametxtbox;

	@FindBy(id="LastName")
	WebElement LNametxtbox;

	@FindBy(id="Email")
	WebElement Emailtxtbox;

	@FindBy(id="Password")
	WebElement Passwordtxtbox;

	@FindBy(id="ConfirmPassword")
	WebElement ConfirmPasswordtxtbox;

	@FindBy(id="register-button")
	WebElement Registerbtn;
	
	@FindBy(css="div.result")
	public WebElement successmsg;

	@FindBy(linkText="Log out")
	public WebElement logoutLink; 
	
	@FindBy(linkText="My account")
	WebElement myAccountLink; 
	
	//Actions
	public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }
	
	
	public void FillRegistrationForm(String Fname,String LName,String Email,String Passwod ) {
		
		
		clickButton(MaleGenderbtn);
		setTextElementText(FNametxtbox, Fname);
		setTextElementText(LNametxtbox, LName);
		setTextElementText(Emailtxtbox, Email);
		setTextElementText(Passwordtxtbox, Passwod);
		setTextElementText(ConfirmPasswordtxtbox, Passwod);		
		clickButton(Registerbtn);
	}
	
	public void userLogout() 
	{
		clickButton(logoutLink);
	}
	
	public void openMyAccountPage() 
	{
		clickButton(myAccountLink);
	}
	
	 


}
