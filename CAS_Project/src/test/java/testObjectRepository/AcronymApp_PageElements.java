package testObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AcronymApp_PageElements {
	
	public WebDriver driver;
	
	//Constructor
	public AcronymApp_PageElements(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//*[@id=\"spTopPlaceholder\"]/div/div[2]/div/div/div/div/div/div/div[2]/button/span/i") 
	//@FindBy(how=How.XPATH, using="//img[@alt='company-branding']")
	WebElement comp_button;
	
	public void clikOnCompany(){
		
	}
	
	

}
