package userDefinedLibraries;

import java.io.File;

import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenShots {
	public static String filepath1 = "C:\\Users\\2327162\\eclipse-workspace\\SeleniumMavenPro\\ProjectScreenshots\\DragDrop.png";
	
	public static String filepath2 = "C:\\Users\\2327162\\eclipse-workspace\\SeleniumMavenPro\\ProjectScreenshots\\Datepicker.png";
	//To take ScreenShot
	public static void screenShotTC1(WebDriver driver){
		
		TakesScreenshot ts1=(TakesScreenshot)driver; //Creating object of Interface
		File source1=ts1.getScreenshotAs(OutputType.FILE);
		File target1= new File(filepath1);
		try {
			Files.copy(source1, target1);            //copy from source1 file to target1 where it can be visible
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	  }
	//To take ScreenShot
	public static void screenShotTC2(WebDriver driver){
		
		TakesScreenshot ts2=(TakesScreenshot)driver; //Creating object of Interface
		File source2=ts2.getScreenshotAs(OutputType.FILE);
		File target2= new File(filepath2);
		try {
			Files.copy(source2, target2);            //copy from source1 file to target1 where it can be visible
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	  }

}

