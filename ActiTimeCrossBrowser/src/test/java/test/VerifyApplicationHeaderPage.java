package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pojoORbase.Browser;
import pom.ApplicationHeaderPage;
import pom.ApplicationLoginPage;
import utils.Utility;




public class VerifyApplicationHeaderPage extends Browser {

	private WebDriver driver;
	private ApplicationHeaderPage applicationHeaderPage;
	private ApplicationLoginPage applicationLoginPage;
	private SoftAssert soft;
	String testID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browserName) {
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtentReport"+File.separator+"extentReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		System.out.println("Launch Browser");
		if(browserName.equals("Chrome"))
		{
			driver = launchChromeBrowser();
		}
		
		if(browserName.equals("Edge"))
		{
			driver = launchEdgeBrowser();
		}
		
		if(browserName.equals("Opera"))
		{
			driver = launchOperaBrowser();
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	// Implicit Wait
	}
	
	@BeforeClass
	public void createObjectOfPOMClasses() {
		System.out.println("Creat an Object");
		applicationLoginPage = new ApplicationLoginPage(driver);
		applicationHeaderPage = new ApplicationHeaderPage (driver);
	}
	
	
	@BeforeMethod
	public void loginToApplication() {
		System.out.println("Login To Application");
		driver.get("http://localhost/login.do");
		
		applicationLoginPage.sendUserName();
		applicationLoginPage.sendPassword();
		applicationLoginPage.clickOnKeepMeLoginCheckBox();
		applicationLoginPage.clickOnLogIn();
	}
	
	@Test (priority = 2)
	public void verifyTasksTab() {
		testID = "1002";
		soft = new SoftAssert();
		System.out.println("Verify Tasks Tab");
		
		applicationHeaderPage.clickOnTasks();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		System.out.println("+" + title + "+" );
		
		Assert.assertEquals(url, "http://localhost/tasks/otasklist.do");
		
		soft.assertEquals(title, "actiTIME - Open Tasks");
		soft.assertAll();
	}
	
	@Test (priority = 4)
	public void verifyUserTab() {
		testID = "1004";
		soft = new SoftAssert();
		System.out.println("Verify User Tab");
		applicationHeaderPage.clickOnUsers();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		System.out.println("+" + title + "+" );
		
		
		Assert.assertEquals(url, "http://localhost/administration/userlist.do");
		
		soft.assertEquals(title, "actiTIME - User List");
		soft.assertAll();
	}
	
	@Test (priority = 1)
	public void verifyTimeTrack() {
		testID = "1001";
		soft = new SoftAssert();
		System.out.println("Verify Time Track");
		applicationHeaderPage.clickOnTimeTrack();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		System.out.println("+" + title + "+" );
		
		
		Assert.assertEquals(url, "http://localhost/user/submit_tt.do");
		
		soft.assertEquals(title, "actiTIME - Enter Time-Track");
		soft.assertAll();
	}
	
	@Test (priority = 3)
	public void verifyReports() {
		testID = "1003";
		soft = new SoftAssert();
		System.out.println("Verify Reports");
		applicationHeaderPage.clickOnReports();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		System.out.println("+" + title + "+" );
		
		
		Assert.assertEquals(url, "http://localhost/reports/reports.do");
		
		soft.assertEquals(title, "actiTIME - Saved Reports");
		soft.assertAll();
	}
	
	@Test (priority = 5)
	public void verifyWorkShedule() {
		testID = "1005";
		soft = new SoftAssert();
		System.out.println("Verify Work Shedule");
		applicationHeaderPage.clickOnWorkShedule();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		System.out.println("+" + title + "+" );
		
		
		Assert.assertEquals(url, "http://localhost/administration/workingdays.do");
		
		soft.assertEquals(title, "actiTIME - Corporate Schedule");
		soft.assertAll();
	}
	
	@AfterMethod
	public void logout(ITestResult result) throws InterruptedException, IOException {
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.screenshot(driver, testID);//Fail test case Screenshot
		}
		System.out.println("LogOut");
		applicationHeaderPage.clickOnLogout();
		System.out.println("-------------------------------");
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void clearPOMObject() {
		System.out.println("Clear POM Object");
		applicationLoginPage = null;
		applicationHeaderPage = null;
	}
	
	@AfterTest
	public void closeBrowser() throws InterruptedException {
		System.out.println("Close Browser");
		driver.quit();
		driver = null; 
		System.gc(); 	// Delete the all object without referances
		Thread.sleep(2000);
	}
}
