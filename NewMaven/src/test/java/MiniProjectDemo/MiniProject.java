package MiniProjectDemo;

import java.io.File;
import java.io.IOException;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;



public class MiniProject {

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new EdgeDriver();
		driver.get("https://demoqa.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement source1 = driver.findElement(By.xpath("//div[@id='draggable']"));
		
        WebElement target1 = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions builder = new Actions(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",source1);
        builder.moveToElement(source1);
        builder.clickAndHold(source1).moveToElement(target1).release(source1).build().perform();
        
        String s=target1.getText();
        System.out.println("The Element"+ s +"at Given Drop Box");
        
        System.out.println("ScreenShot capturing1111...........................");
		TakesScreenshot ts1=(TakesScreenshot)driver; 
		File source2=ts1.getScreenshotAs(OutputType.FILE);
		File target2= new File("C:\\Users\\2327162\\eclipse-workspace\\SeleniumMavenPro\\ProjectScreenshots\\Drag.png");
		
		Files.copy(source2,target2);
		System.out.println("ScreenShot captured Successfully1111");
        
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		driver.get("https://demoqa.com/date-picker");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement datepick = driver.findElement(By.xpath("//*[@id=\'datePickerMonthYearInput\']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",datepick);
		datepick.click();
		datepick.clear();
		LocalDate nextDate= LocalDate.now().plusDays(1);
		String formatedDate=nextDate.format(DateTimeFormatter.ofPattern("dd-MM-YYYY"));
		String date=formatedDate.substring(0, 2);
		
		List <WebElement> alldates1 = driver.findElements(By.xpath("//div[@class='react-datepicker__month']/div/div"));
		for(WebElement dt1:alldates1) {
			if(dt1.getText().equals(date)) {
				dt1.click();
				break;
			}
		
		}
		
		WebElement dtTime= driver.findElement(By.xpath("//*[@id='dateAndTimePickerInput']"));
		dtTime.click();
		dtTime.clear();
	
		
		List <WebElement> alldates2 = driver.findElements(By.xpath("//div[@class='react-datepicker__month']//div"));
		for(WebElement dt2:alldates2) {
			if(dt2.getText().equals(date)) {
				dt2.click();
				break;
			}
		}
		String time="06:00";
		List <WebElement> alltimes = driver.findElements(By.xpath("//div[@class='react-datepicker__time-box']//li"));
		for(WebElement t:alltimes) {
			if(t.getText().equals(time)) {
				t.click();
				break;
			}
		}
		
		// take SS1
		System.out.println("ScreenShot capturing...........................");
		TakesScreenshot ts=(TakesScreenshot)driver; 
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target= new File("C:\\Users\\2327162\\eclipse-workspace\\SeleniumMavenPro\\ProjectScreenshots\\fullpage.png");
		
		Files.copy(source,target);
		System.out.println("ScreenShot captured Successfully");
		
		driver.close();
		
	

	}

	

}
