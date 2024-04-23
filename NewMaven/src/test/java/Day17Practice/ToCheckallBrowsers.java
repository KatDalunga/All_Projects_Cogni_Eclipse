package Day17Practice;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ToCheckallBrowsers {
	static String browser;
	static WebDriver driver;
	public static void setBrowser()
	{
		browser = "Chrome";
	}

	public static void setBrowserConfig()
	{
		if(browser.equals("Edge"))
		{
			//Instantiating driver object and launching browser
			// Start Edge Session
			driver = new EdgeDriver();
			System.out.println("Edge browser opened");
		}
		
		if(browser.equals("Chrome"))
		{
			//Instantiating driver object and launching browser
			driver = new ChromeDriver();
			System.out.println("Chrome browser opened");
		}
		
		if(browser.equals("Firefox"))
		{
			//Instantiating driver object and launching browser
			driver = new FirefoxDriver();
			System.out.println("Firefox browser opened");
		}		
		
	}

	public static void main(String[] args) {
		// Instantiation of driver with Webdriver Interface
		setBrowser();
		setBrowserConfig();
		driver.get("https://www.google.com");
		driver.close();	
		System.out.println("Browser Closed");
	}

}