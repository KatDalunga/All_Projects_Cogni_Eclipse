package testObjectRepo;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectElements {
	
	//Decleration of variables required
	public static WebElement element = null;
	public static WebDriver driver;
    
	//to find the element of drag me box
	
	public static WebElement source1Element(WebDriver driver) {
		element =driver.findElement(By.xpath("//div[@id='draggable']")); 
    	return element;
    }
	
	//to find the element of drop here box
	
	public static WebElement target1Element(WebDriver driver) {
		element =driver.findElement(By.xpath("//*[@id='droppable']"));
    	return element;
    }
	
	//to find the element of datepicker box
	
	public static WebElement datepickElement(WebDriver driver) {
		element =driver.findElement(By.xpath("//*[@id=\'datePickerMonthYearInput\']"));
    	return element;
    }
	
	//to find the elements of alldates in date box
	
	public static List<WebElement> datepickDates(WebDriver driver){
		List<WebElement> alldates1 = driver.findElements(By.xpath("//div[@class='react-datepicker__month']/div/div"));
        return alldates1;
	}
	
	//to find the element of date and time box
	
	public static WebElement dtTimeElement(WebDriver driver) {
		element =driver.findElement(By.xpath("//*[@id='dateAndTimePickerInput']"));
    	return element;
    }
	
	//to find the elements all dates in date and time box
	
	public static List<WebElement> dtTimeDates(WebDriver driver){
		List<WebElement> alldates2 = driver.findElements(By.xpath("//div[@class='react-datepicker__month']//div"));
        return alldates2;
	}
	
	//to find the elements all times in time box
	
	public static List<WebElement> allTimesList(WebDriver driver){
		List<WebElement> allTimes = driver.findElements(By.xpath("//div[@class='react-datepicker__time-box']//li"));
        return allTimes;
	}
	
	 
}
