package com.nmtp02framework.baseclassutility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
@Listeners(com.nmtp02framework.listenerutility.ListenerImplementation.class)
public class BaseClass {
	public WebDriver driver = null;
	public static WebDriver  sdriver = null;
	@BeforeSuite
	public void configBS() {
		System.out.println("connect to db");
	}
@BeforeClass
public void configBC() {
	System.out.println("launch a browser");
      sdriver = driver;
	
}
@BeforeMethod
public void configBM() {
	System.out.println("Login to app");

}
@AfterMethod
public void configAM() {
	System.out.println("Logout of app");

}
@AfterClass
public void configAC() {
	System.out.println("close the browser");

}
@AfterSuite
public void configAS() {
	System.out.println("disconnect to db");

}
}
