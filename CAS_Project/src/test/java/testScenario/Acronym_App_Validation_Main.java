package testScenario;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.util.Assert;

import testObjectRepository.AcronymApp_PageElements;
import userDefinedLibraries.DriverSetup;
import userDefinedLibraries.ExtentReportsforProj;

//import CAS_Project.AcronymApp_PageElements;

public class Acronym_App_Validation_Main extends DriverSetup{
	private ExtentReports extent;
	// helps to generate the logs in the test report.
	private ExtentTest test;
	public static WebDriver driver;
	public static String pageUrl="https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx";
	
	String screenshotPath;
	
	//LoginPage lp;
	AcronymApp_PageElements ap;
	
	@Parameters({ "browser" })
	@BeforeClass
	public void driverconfig(String browser) throws InterruptedException {
		// Instantiate driver
		driver = DriverSetup.driverInstantiate(browser);
		System.out.println("Browser opened with the provided url");
		Thread.sleep(10000);
		
		ExtentReportsforProj extreportobj = new ExtentReportsforProj();
		extent = extreportobj.setExtentReport();
		System.out.println("Report object Initialised");
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test(priority = 0)
	public void verifyTitle() {
		test = extent.createTest("To verify be.Cognizant url");
		test.log(Status.INFO, "Starting the test case");
		pageUrl = driver.getCurrentUrl();
		Assert assert1 = new Assert();
		assert1.equals(pageUrl);
		test.pass("Url is correct");
	}
	
	
	@AfterClass
	public void closeBrow() {
		// Close the browser after all the steps of scenario
		driverTearDown();
		System.out.println("Closed the browser");
	}

}
