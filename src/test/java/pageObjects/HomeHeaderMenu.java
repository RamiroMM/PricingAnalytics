package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.util.Locators;

public class HomeHeaderMenu {
	WebDriver driver;
	
	public HomeHeaderMenu(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(how = How.XPATH, using = Locators.NEW_QUOTE_PATH)
	WebElement newQuote;
	@FindBy(how = How.XPATH, using = Locators.CREATE_NEW_QUOTE_PATH)
	WebElement createNewQuote;
	@FindBy(how = How.XPATH, using = Locators.LOAD_SPINNER_PATH)
	WebElement loadSpinner;
	
	public void createNewQuote() {
		if (newQuote.isEnabled() && createNewQuote.isEnabled()) {
			System.out.println("Header elements loaded");
			
			try {
				new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(newQuote));
				new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(newQuote));
				while(loadSpinner.isDisplayed()) {
					//Do nothing, wait for the spinner to disappear
				}
				newQuote.click();
				Thread.sleep(5000);
				
			}
			catch(Exception ex) {
				System.out.println(ex);
			}
		}
		else {
			System.out.println("Header elements not loaded");
		}
	}

}
