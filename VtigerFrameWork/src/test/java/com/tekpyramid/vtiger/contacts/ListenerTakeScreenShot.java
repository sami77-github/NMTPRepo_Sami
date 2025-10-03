package com.tekpyramid.vtiger.contacts;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tekpyramid.vtiger.generic.baseclass.BaseClass;

@Listeners(com.tekpyramid.vtiger.generic.listenerimpclass.ListImpClass_2.class)
public class ListenerTakeScreenShot extends BaseClass{

	@Test
	public void SreenShot() {
		System.out.println("Hello this is Sami Shaikh");
		Assert.fail("Forcing test failure");
		
	}
}
