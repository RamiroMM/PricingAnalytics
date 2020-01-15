package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.util.Locators;

public class QuotePreValidation {
	WebDriver driver;
	
	public QuotePreValidation(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(how = How.XPATH, using = Locators.LOAD_SPINNER_PATH)
	WebElement loadSpinner;
	@FindBy(how = How.XPATH, using = Locators.DATA_CHECK_BUTTON)
	WebElement dataCheckButton;
	@FindBy(how = How.XPATH, using = Locators.PRICE_CHECK_BUTTON)
	WebElement priceCheckButton;
	@FindBy(how = How.XPATH, using = Locators.BUNDLE_CHECK_BUTTON)
	WebElement bundleCheckButton;
	@FindBy(how = How.XPATH, using = Locators.COMPLETE_CHECK_BUTTON)
	WebElement completeQuoteButton;
	@FindBy(how = How.XPATH, using = Locators.QUOTE_COMPLETED_SUCCESS_MESSSAGE)
	WebElement completeSuccess;
	@FindBy(how = How.XPATH, using = Locators.CLOSE_PRE_VALIDATION_WINDOW_BUTTON)
	WebElement closeButton;
	
	public void dataCheck() {
		try {
			if(dataCheckButton.isEnabled()) {
				dataCheckButton.click();
				while(loadSpinner.isDisplayed()) {
					//Do nothing
				}
			}
		}
		catch(Exception ex){
			
		}
	}
	
	public void priceCheck() {
		try {
			if(priceCheckButton.isEnabled()) {
				priceCheckButton.click();
				while(loadSpinner.isDisplayed()) {
					//Do nothing
				}
			}		
		}
		catch(Exception ex){
					
		}
	}
	
	public void bundleCheck() {
		try {
			if(bundleCheckButton.isEnabled()) {
				bundleCheckButton.click();
				while(loadSpinner.isDisplayed()) {
					//Do nothing
				}
			}	
		}
		catch(Exception ex){
					
		}
	}
	
	public void completeQuote() {
		try {
			Thread.sleep(2000);
			if(completeQuoteButton.isEnabled()) {
				completeQuoteButton.click();
				while(!completeSuccess.isDisplayed()) {
					//Wait for the success message to appear
				}
				while(loadSpinner.isDisplayed()) {
					//Do nothing
				}
			}
			else {
				System.out.println("Complete quote button is not enabled");
			}
		}
		catch(Exception ex){
			System.out.println("Complete button is not enabled");		
		}
	}
	
	public void closePopup() {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(closeButton));
			closeButton.click();
			System.out.println("Close success");
		} catch (Exception ex) {
			System.out.println("Oops, something went wrong: " + ex);
		}
	}

}
