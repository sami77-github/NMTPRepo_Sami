package com.tekpyramid.vtiger.generic.listenerimpclass;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tekpyramid.vtiger.generic.baseclass.BaseClass;
import com.tekpyramid.vtiger.generic.databaseutility.DataBaseUtility_2;

public class ListImpClass_2 implements ITestListener,ISuiteListener{
	ExtentSparkReporter spark;
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		spark = new ExtentSparkReporter("./AdvanceReport/report"+time+".html");
		spark.config().setDocumentTitle("CRM");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Windows");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, "Execution Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String TestName = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filepath,TestName + time);	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}
	
	
	
	
}
