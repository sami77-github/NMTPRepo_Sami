package com.tekpyramid.vtiger.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_2 {

	WebDriver driver;
	public HomePage_2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement SignOutImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutBtn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getSignOutImg() {
		return SignOutImg;
	}

	public WebElement getSignOutBtn() {
		return SignOutBtn;
	}
	
	
}
