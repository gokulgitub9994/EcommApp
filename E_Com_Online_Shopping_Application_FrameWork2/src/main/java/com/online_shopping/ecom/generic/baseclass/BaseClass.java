package com.online_shopping.ecom.generic.baseclass;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.online_shopping.ecom.generic.fileutility.ExcelUtility;
import com.online_shopping.ecom.generic.fileutility.FileUtility;
import com.online_shopping.ecomm.generic.databaseutility.DataBaseUtility;
import com.online_shopping.ecomm.generic.objectrepository.HomePage;
import com.online_shopping.ecomm.generic.objectrepository.LoginPage;
import com.online_shopping.ecomm.generic.objectrepository.MyCartPage;
import com.online_shopping.ecomm.generic.webdriverutility.JavaUtility;
import com.online_shopping.ecomm.generic.webdriverutility.WebDriverUtility;

public class BaseClass {

	public WebDriver driver = null;
	public static WebDriver sDriver =null;
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public JavaUtility jLib = new JavaUtility();
	public DataBaseUtility dLib = new DataBaseUtility();
	public ExtentReports report;
	

	@BeforeSuite
	public void configBeforeSuite() {
		System.out.println("Connect to dB and Report Configure");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM SUITE RESULTS");
		spark.config().setReportName("CRM-Report");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Windows-10");
		report.setSystemInfo("Browser","Chrome-10");
		// dLib.getDbConnection("null", null,null);

	}

	@BeforeClass
	public void configBeforeClass() throws Throwable {
		System.out.println("Launch Browser");
		String BROWSER = fLib.getDataFromPropertyFile("browser");
		if (BROWSER.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
			driver = new ChromeDriver(options);
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");

	        // Configure Edge to run in headless mode
	        EdgeOptions options = new EdgeOptions();
	        options.addArguments("--headless=new"); 
	        options.addArguments("--disable-gpu");
	        options.addArguments("--no-sandbox");
	        options.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(options);
		} else {
			driver = new ChromeDriver();
		}
		
		sDriver=driver;

		driver.manage().window().maximize();
		wLib.waitForPageToLoad(driver);

	}

	@BeforeMethod
	public void configBeforeMethod() throws Throwable {
		wLib.waitForPageToLoad(driver);
		String URL = fLib.getDataFromPropertyFile("url");
		String MAILID = fLib.getDataFromPropertyFile("mailId");
		String PASSWORD = fLib.getDataFromPropertyFile("password");
		driver.get(URL);
		HomePage hp = new HomePage(driver);
		hp.getLogInLink().click();
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(MAILID, PASSWORD);
//		Thread.sleep(3000);
//		wLib.switchToAlertAndAccept(driver);
		//driver.switchTo().alert().dismiss();
		System.out.println("Login to App");
	}

	@AfterMethod
	public void configAfterMethod() {
		MyCartPage mp = new MyCartPage(driver);
		mp.getLogoutLink().click();
		System.out.println("Logout from the application");
	}

	@AfterClass
	public void configAfterClass() {
		driver.quit();
		System.out.println(" Browser Closed");
	}

	@AfterSuite
	public void configAfterSuite() {
		System.out.println("Close connection");
		report.flush();
		// dLib.closeDbConnection();
	}

}
