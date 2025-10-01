package com.tekpyramid.vtiger.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_2 {

	WebDriver driver;
	public LoginPage_2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "user_name")
	private WebElement usernameTextField;
	
	@FindBy(name = "user_password")
	private WebElement passwordTextField;
	
	@FindBy(id = "submitButton")
	private WebElement LoginBtn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	
	// Business Logic
	public void LoginToApp_2() {
		getUsernameTextField().sendKeys("admin");
		getPasswordTextField().sendKeys("admin");
		getLoginBtn().click();
	}
	
	
}
