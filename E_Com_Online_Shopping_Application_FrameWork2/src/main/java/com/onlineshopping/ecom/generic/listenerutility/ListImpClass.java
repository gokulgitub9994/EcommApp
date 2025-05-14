package com.onlineshopping.ecom.generic.listenerutility;

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
import com.online_shopping.ecom.generic.baseclass.BaseClass;

public class ListImpClass implements ISuiteListener, ITestListener {

	public ExtentReports report;
	public static ExtentTest test;
	public String testName = null;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");
		String time = new Date().toString().replace(" ", " _").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_" + time + ".html");
		spark.config().setDocumentTitle("CRM_Results");
		spark.config().setReportName("CRM_Report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Os", "Windows-11");
		report.setSystemInfo("Browser", "Chrome");

	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report BackUp");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("===>>" + result.getMethod().getMethodName() + "<===Start===>");
		testName = result.getMethod().getMethodName();
		test = report.createTest(testName);
		test.log(Status.INFO, testName + "==>Test Started==>");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("===>>" + result.getMethod().getMethodName() + "<==End==>");
		test.log(Status.PASS, "==>Completed==>");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		testName = result.getMethod().getMethodName();
		TakesScreenshot eDriver = (TakesScreenshot) BaseClass.sDriver;
		String filepath = eDriver.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", " _").replace(":", "_");
		test.addScreenCaptureFromBase64String(filepath, testName + "_" + time);
	}

}
