package testObjectRepository;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Zigly_ElementsPage {
	public WebDriver driver;

	//Locating all the needed elements for the Scenario
	@FindBy(xpath = "//div[@id='desktopBannerWrapped']//button[@id='moe-dontallow_button']")
	public static WebElement adBanner;
	@FindBy(xpath = "//div[@class='page-wrapper']//div[@class='page-nav-section']/div[@class='navigation-links']/ul[1]/li/a[1]")
	private List<WebElement> menus;
	@FindBy(xpath = "//a[contains(@href,'https://www.zigly.com/shop/dogs/')]//span[2]")
	private List<WebElement> submenustxt;
	@FindBy(xpath = "//ul[@class='level1 submenu ui-menu ui-widget ui-widget-content ui-corner-all expanded activate']/li/a")
	private List<WebElement> submenushref;
	@FindBy(xpath = "//div[@class='top-toolbar']//div[@class='toolbar-sorter sorter']//select[@id=\"sorter\"]")
	private WebElement sortOptions;
	@FindBy(xpath = "//*[@id='amasty-shopby-product-list']/div[1]/div/div[3]/a")
	private WebElement setDescOrd;
	@FindBy(xpath = "//img[@class='logo-image']")
	private WebElement logo;
	@FindBy(name = "q")
	private WebElement searchBox;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public Zigly_ElementsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Mouse hover Dog menu and select "Accessories" submenu
	public void selectMenuandSubmenu() {
		// Instantiate Action Class
		Actions actions = new Actions(driver);
		categories: for (WebElement menu : menus) {
			if (menu.getText().equalsIgnoreCase("Dogs")) {
				//System.out.println("Checking Main Menu options with: Dogs");
				actions.moveToElement(menu).perform();
				for (WebElement submenu : submenustxt) {
					if (submenu.getText().equalsIgnoreCase("Accessories")) {
						for (WebElement submenuHref : submenushref) {
							//System.out.println("Checking Sub Menu options with: Accessories");
							if (submenuHref.getAttribute("href")
									.contains("https://www.zigly.com/shop/dogs/dog-accessories.html")) {
								actions.moveToElement(submenuHref);
								actions.click().build().perform();
								//System.out.println("Has quit the outermost for-loop");								
								break categories;
							}

						}
					}

				}
			}

		}
	}

	public void clickonprice() {
		//Click on Price from Sort By list
		Select select = new Select(sortOptions);
		select.selectByValue("price");		
	}

	public void clickondescarrow() {
		//Click on the Set Descending direction arrow
		setDescOrd.click();		
		//Webpage is refreshed
		driver.navigate().refresh();
	}

	public void clickonlogo() {
		//Click on the website logo
		logo.click();		
	}

	public void enterSearchtxt() {
		// Enter the search text in the home page search box
		searchBox.sendKeys("Dog bow ties");		
		// can add wait for search results
	}
}
