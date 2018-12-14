package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.qa.util.Helper;

public class TestBase {

	public static WebDriver driver;
	//public static Properties prop;

	/*public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/

	
	@BeforeSuite
	@Parameters({"browser","URL"})
	public static void initializDriver(@Optional ("chrome")String Browsername ,@Optional ("https://demo.nopcommerce.com/")String URL){
		//String browserName = prop.getProperty("browser");

		if(Browsername.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(Browsername.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Resources\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}

		else if(Browsername.equalsIgnoreCase("internet explorer")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\Resources\\IEDriverServer.exe");	
			driver = new InternetExplorerDriver(); 
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.get(URL); 
	}


	@AfterSuite
	public static void quiteDriver() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	
	
	@AfterMethod
	public void screenshotonfailure(ITestResult result) {
		
		if (result.getStatus()==ITestResult.FAILURE) {
			System.out.println("Failed !");
			System.out.println("Taking screenshot...");
			Helper.capturescreenshot(driver, result.getName());
		}
		
	}
	

}
