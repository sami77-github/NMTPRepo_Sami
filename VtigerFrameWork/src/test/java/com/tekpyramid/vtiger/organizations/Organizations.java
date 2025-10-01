package com.tekpyramid.vtiger.organizations;

import org.testng.annotations.Test;

import com.tekpyramid.vtiger.generic.baseclass.BaseClass;

public class Organizations extends BaseClass {

	@Test(groups = "Smoke")
	public void createOrg() {
		System.out.println("Organization created");
	}
	
	@Test(groups = "Regression")
	public void createOrgWithPhno() {
		System.out.println("createOrgWithPhno created");
	}
	
	@Test(groups = "Regression")
	public void createOrgwithIndustry() {
		System.out.println("createOrgwithIndustry created");
	}
	
}
