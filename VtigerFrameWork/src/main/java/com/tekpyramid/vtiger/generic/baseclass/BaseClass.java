package com.tekpyramid.vtiger.generic.baseclass;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.tekpyramid.vtiger.generic.databaseutility.DataBaseUtility_2;
import com.tekpyramid.vtiger.generic.fileutility.PropertiesUtility_2;
import com.tekpyramid.vtiger.generic.objectrepository.HomePage_2;
import com.tekpyramid.vtiger.generic.objectrepository.LoginPage_2;

public class BaseClass {
	DataBaseUtility_2 db = new DataBaseUtility_2();
	PropertiesUtility_2 pu = new PropertiesUtility_2();
	public WebDriver driver;
	public static WebDriver sdriver;
	HomePage_2 hp ;

	@BeforeSuite(alwaysRun = true)
	public void ConnectToDB_2() throws SQLException {
		db.closeConnectionWithDB_2();
	}
	
	@Parameters("Browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(String Browser) throws IOException {
//		String BROWSER = pu.getDataFromProperties_2("browser");
		String URL = pu.getDataFromProperties_2("url");
		
		String BROWSER = Browser;
		
		if(BROWSER.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		
		if(BROWSER.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		hp = new HomePage_2(driver);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void login() {
		LoginPage_2 lp = new LoginPage_2(driver);
		lp.LoginToApp_2();
	}
	
	@AfterMethod(alwaysRun = true)
	public void logout() {
		hp.getSignOutImg().click();
		hp.getSignOutBtn().click();
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.close();
	}
	
	@AfterSuite(alwaysRun = true)
	public void closeDBConnection() throws SQLException {
		db.closeConnectionWithDB_2();
	}
	
	
	
	
	
	
}
