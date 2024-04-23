package testScenario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import testObjectRepository.Zigly_ElementsPage;
import userDefinedLibraries.DriverSetup;
import userDefinedLibraries.ExtentReportsforProj;
import userDefinedLibraries.ScreenShot;

public class PetProducts extends DriverSetup {
	public String pageTitle;
	public static WebDriver driver;
	WebElement appbanner;	
	private ExtentReports extent;
	// helps to generate the logs in the test report.
	private ExtentTest test;
	ExtentReportsforProj extreportobj = new ExtentReportsforProj();
	String screenshotPath;

	@Parameters({ "browser" })
	@BeforeClass
	public void driverconfig(String browser) {
		// Instantiate driver
		driver = DriverSetup.driverInstantiate(browser);
		System.out.println("Browser opened with the provided url");
		extent = extreportobj.setExtentReport();
		System.out.println("Report object Initialised");
	}

	public void handle_ads() {
		try {
			// Take screen shot
			ScreenShot.screenShotTC(driver, "Ads and notifications");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Notification popup handled
		appbanner = Zigly_ElementsPage.adBanner;
		appbanner.click();
		/*
		 * // Handling ads and offer popups
		 * driver.switchTo().frame("moe-onsite-campaign-65eedc17d1c47ae2335a3bf4");
		 * driver.findElement(By.xpath("//*[@id=\"close-icon\"]")).click();
		 * 
		 * // Switching back to the main window driver.switchTo().defaultContent();
		 */

	}

	@Test(priority = 0)
	public void verifyTitle() {
		test = extent.createTest("To verify Zigly Title");
		test.log(Status.INFO, "Starting the test case");
		pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Best Online Pet  | Buy Pet Supplies at Best Prices - Zigly");
		test.pass("Title is correct");
	}

	@Test(priority = 1)
	public void verifyLogo() {
		test = extent.createTest("To verify Zigly Logo");
		boolean imgDispy = driver.findElement(By.xpath("//img[@class='logo-image']")).isDisplayed();
		test.createNode("Image is Present");
		Assert.assertTrue(imgDispy);
		test.pass("Test Passed");
	}

	@Test(priority = 2)
	public void searchScenario() {
		Zigly_ElementsPage pagecls = new Zigly_ElementsPage(driver);
		PetProducts petscenario = new PetProducts();
		test = extent.createTest("To enter text in Searchbox");
		petscenario.handle_ads();
		test.log(Status.INFO, "Closed the popups");
		pagecls.selectMenuandSubmenu();
		try {
			// Take screen shot
			ScreenShot.screenShotTC(driver, "accessories_page");
		} catch (Exception e) {
			e.printStackTrace();
		}
		test.log(Status.INFO, "Landed into Accessories page!!");
		pagecls.clickonprice();
		test.log(Status.INFO, "Selected price in sorting");
		pagecls.clickondescarrow();
		try {

			// Take screen shot
			ScreenShot.screenShotTC(driver, "sorted_on_Price");
		} catch (Exception e) {
			e.printStackTrace();
		}
		test.log(Status.INFO, "Clicked descending order arrow");
		pagecls.clickonlogo();
		test.log(Status.INFO, "Clicked on Zigly logo");
		pagecls.enterSearchtxt();
		try {
			// Take screen shot
			ScreenShot.screenShotTC(driver, "Dog_bow_ties");
		} catch (Exception e) {
			e.printStackTrace();
		}
		test.log(Status.INFO, "Entered text into searchbox");
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			// MarkupHelper is used to display the output in different colors
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			// To capture screenshot path and store the path of the screenshot in the string
			// "screenshotPath"
			// We do pass the path captured by this method in to the extent reports using
			// "logger.addScreenCapture" method.
			screenshotPath = ScreenShot.screenShotTC(driver, "TestCase Failed");
			// To add it in the extent report
			test.fail("Test Case Failed Snapshot is below " + test.addScreenCaptureFromPath(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}
	}

	@AfterMethod(dependsOnMethods = "getResult")
	public void endReport() {
		// write results into the file
		extreportobj.endExtentReport();
		System.out.println("Written the Report");

	}

	@AfterClass
	public void closeBrow() {
		// Close the browser after all the steps of scenario
		driverTearDown();
		System.out.println("Closed the browser");
	}
}
