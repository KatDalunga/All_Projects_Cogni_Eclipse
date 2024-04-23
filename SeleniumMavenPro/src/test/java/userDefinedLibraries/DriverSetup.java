package userDefinedLibraries;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetup {
	
	//Decleration of variables which we need
	
	public static WebDriver driver;	
	public static String url ;
	public static String browsertype;
	
	//Created method to initiatedriver with given parameters 
	
	public static WebDriver driverInstantiate1(String browser,String url_1) {
		browsertype = browser;
		url=url_1;
		if (browsertype.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();                              //to maximize the window after opening the url	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//it will wait until the all the elements gets loaded
		driver.get(url_1);		                                          //it will open the url
		return driver;                                                    //return the driver
	}
	public static WebDriver driverInstantiate2(String browser,String url_2) {
		browsertype = browser;
		url=url_2;
		if (browsertype.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url_2);		
		return driver;
	}
	
	public static void driverTearDown() {
		driver.quit();                                                    //this method will close the browser
	}


}
