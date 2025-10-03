package com.tekpyramid.vtiger.contacts;

import org.testng.annotations.Test;

import com.tekpyramid.vtiger.generic.baseclass.BaseClass;

public class Contacts extends BaseClass {

	@Test(groups = "Smoke")
	public void createContact() {
		System.out.println("Contact Created");
	}
	
	@Test(groups = "Regression")
	public void createContactWithSupportDate() {
		System.out.println("Contact Created");
	}
	
	@Test(groups = "Regression")
	public void createContactWithOrg() {
		System.out.println("Contact Created");
	}
}
