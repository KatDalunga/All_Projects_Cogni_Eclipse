package testActionsRepo;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

//Calling the all classes from different packages which are required 

import testObjectRepo.ProjectElements;
import userDefinedLibraries.DriverSetup;
import userDefinedLibraries.ScreenShots;


public class ProjectActions extends DriverSetup {
	
	//Decleration of variables required
	
	public static String browser = "Chrome";
	public static String url_1 = "https://demoqa.com/droppable/";
	public static String url_2="https://demoqa.com/date-picker";
	public static WebDriver driver;
	
	public static void driverconfig1(String browser,String url)
    {
	 	//Instantiate driver for First page with url_1
		System.out.println("Instantiating browser with first url ..........");
    	driver=DriverSetup.driverInstantiate1(browser,url_1); 
    	System.out.println("URL opened Successfully in "+ browser + " Browser");
    }
	
	public static void performDragDrop()
    {   
		//calling the elements required for drag and drop 
    	WebElement drag = ProjectElements.source1Element(driver);
    	WebElement drop = ProjectElements.target1Element(driver);
    	
    	System.out.println("Performing Drag and Drop Action..........");
    	
    	//to perform the action of drag and drop need to use Actions interface 
    	
        Actions builder = new Actions(driver); //object of Actions class 
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",drag);//to perform scrolldown action upto that element 
        builder.moveToElement(drag);           // it will take the mouse curser to that element
        builder.clickAndHold(drag).moveToElement(drop).release(drag).build().perform();//build and perform action
        
        String s=drop.getText();//to get text which are present on drop box
        System.out.println("The Element "+ s +" at Given Drop Box");
        
        //to capture Scrennshot
        
        System.out.println("Capturing ScreenShot for Drag and Drop ...............");
        try {
    		// Take screen shot for Drag and Drop
    		ScreenShots.screenShotTC1(driver);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
        System.out.println("ScreenShot Captured Successfully!!!!!");
    }
	
	public static void driverconfig2(String browser,String url)
    {
	 	//Instantiate driver for Second page with url_2
		System.out.println("Instantiating browser with Second url ..........");
    	driver=DriverSetup.driverInstantiate1(browser,url_2); 
    	System.out.println("URL opened Successfully in "+ browser + " Browser");
    	
    }

	public static void clickOnDate() {
		System.out.println("Searching for DateBox........");
		WebElement ClickOnTBox = ProjectElements.datepickElement(driver); //finding the element of datebox 
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ClickOnTBox);
		ClickOnTBox.click();                                              //click on datebox
		ClickOnTBox.clear();                                              //clear text present in datebox
		System.out.println("Successfully clicked on DateBox!!!");
		
	}
	//Fetching the today date to get tomorrows date 
	static LocalDate nextDate= LocalDate.now().plusDays(1);//it will give tomorrows date
	static String formatedDate=nextDate.format(DateTimeFormatter.ofPattern("dd-MM-YYYY"));//format the date in given format
	static String date=formatedDate.substring(0, 2);       //fetch the day from the date
	static String time="06:00";                            //time which we need to select from timebox
	
	public static void selectDate() {
		
		//Search the tomorrows date and click on it
		System.out.println("Searching for Tomorrow's date.......");
		List <WebElement> all_dates = ProjectElements.datepickDates(driver);
		for(WebElement dt:all_dates) {
			if(dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}
		System.out.println("Successfully clicked on Tomorrow's date");
	}
	
	public static void clickOnDateTime() {
		
		//to click on datetimebox and clear the text present in it
		System.out.println("Searching for DateTimeBox........");
		WebElement ClickOnDTBox = ProjectElements.dtTimeElement(driver);
		ClickOnDTBox.click();
		ClickOnDTBox.clear();
		System.out.println("Clicked On DateTimeBox");
	}
	
	public static void selectDateTime() {
		
		//search for tomorrows date and click on it
		System.out.println("Searching for given date.......");
		List <WebElement> all_dates1 = ProjectElements.dtTimeDates(driver);
		for(WebElement dt1:all_dates1) {
			if(dt1.getText().equals(date)) {
				dt1.click();
				break;
			}
		}
		System.out.println("Clicked on given date");
	}
	
	public static void selectTime() {
		
		//serach for given time and click on it
		System.out.println("Searching for given time ");
		List <WebElement> all_times = ProjectElements.allTimesList(driver);
		for(WebElement t:all_times) {
			if(t.getText().equals(time)) {
				t.click();
				break;
			}
		}
		System.out.println("Clicked on given Time ");
		
		
		System.out.println("Capturing ScreenShot for DatePicker...............");
        try {
    		// Take screen shot for Datepicker 
    		ScreenShots.screenShotTC2(driver);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
        System.out.println("ScreenShot Captured Successfully!!!!!");
	}
	
	 public static void closeBrow()
	    {
	    	//Close the browser after all the steps of scenario
	    	driverTearDown();
	    	System.out.println("Closed the browser");
	    }
	
	
	
	public static void main(String[]args) {
		
		//calling  all the methods 
		ProjectActions.driverconfig1(browser, url_1);
		ProjectActions.performDragDrop();
		ProjectActions.closeBrow();
		
		ProjectActions.driverconfig2(browser, url_2);
		ProjectActions.clickOnDate();
		ProjectActions.selectDate();
		ProjectActions.clickOnDateTime();
		ProjectActions.selectDateTime();
		ProjectActions.selectTime();
		ProjectActions.closeBrow();
		
	}

}
