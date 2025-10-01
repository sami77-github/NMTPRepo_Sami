package com.tekpyramid.vtiger.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility_2 {

	public String getDataFromProperties_2(String Key) throws IOException {
		FileInputStream fis = new FileInputStream("./TestData/Commendata.properties");
		Properties prop = new Properties();
		prop.load(fis);
	 	String Value = prop.getProperty(Key);
	 	return Value;
	}
}
