package com.nmtp02framework.listenerutility;

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
import com.nmtp02framework.baseclassutility.BaseClass;

public class ListenerImplementation implements ISuiteListener, ITestListener {
	ExtentReports report;
	ExtentTest test;
	String testName;
	String time = new Date().toString().replace(" ", "_").replace(":", "_");

	@Override
	public void onStart(ISuite suite) {
		System.out.println("===Suite On Start Method===");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/+report"+time+".html");
		spark.config().setDocumentTitle("Vtiger");
		spark.config().setReportName("VtigerReport");
		spark.config().setTheme(Theme.DARK);
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows11");
		report.setSystemInfo("browser", "chrome");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("===on finish method of suite===");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("===on Test Start method===");
		testName = result.getMethod().getMethodName();
		test = report.createTest(testName);
		test.log(Status.INFO, testName + " method started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("on test success method");
		test.log(Status.PASS, testName + " method is passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("===method is Failed===");
		TakesScreenshot tks =(TakesScreenshot) BaseClass.sdriver;
		String filepath = tks.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filepath, testName);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("===method is skipped===");
		test.log(Status.SKIP, testName + " method is skipped");
	}

}
