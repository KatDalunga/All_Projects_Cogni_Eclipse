package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginTestMain {
	WebDriver driver;
	//LoginPage lp;
	LoginPage_Pagefactory lp;
	
	@BeforeClass
	void setup() throws InterruptedException
	{
		
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		
	}
	
	@Test(priority=1)
	void testLogo()
	{
		//lp=new LoginPage(driver);
		lp=new LoginPage_Pagefactory(driver);
		
		Assert.assertEquals(lp.checkLogoPresence(), true);
	}
	
	
	@Test(priority=2)
	void testLogin()
	{
		lp.setUserName("Admin");
		lp.setPassword("admin123");
		lp.clickSubmit();
		
		Assert.assertEquals(driver.getTitle(),"OrangeHRM");
				
	}
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}
}