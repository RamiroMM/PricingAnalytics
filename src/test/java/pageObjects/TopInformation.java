package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.util.Locators;

public class TopInformation {
	WebDriver driver;
	
	public TopInformation(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(how = How.XPATH, using = Locators.NGQ_REFRESH_PRICE_BUTTON)
	WebElement priceButton;
	@FindBy(how = How.XPATH, using = Locators.LOAD_SPINNER_PATH)
	WebElement loadSpinner;
	@FindBy(how = How.XPATH, using = Locators.PRICING_SUCCESS_MESSSAGE)
	WebElement successMsg;
	@FindBy(how = How.XPATH, using = Locators.VALIDATE_BUTTON)
	WebElement validateButton;
	@FindBy(how = How.XPATH, using = Locators.QUOTE_PRE_VALIDATION_WINDOW_TITLE)
	WebElement validationTitle;
	
	public void refreshPrice() {
		if(priceButton.isEnabled()) {
			priceButton.click();
			while(!successMsg.isDisplayed()) {
				//Do nothing while refresh price
			}
			while(loadSpinner.isDisplayed()) {
				//Do nothing while quote is being saved
			}
		}
	}
	
	public QuotePreValidation click_Validate() {
		try {
			if(validateButton.isEnabled()) {
				validateButton.click();
				while(!validationTitle.isDisplayed()) {
					// Wait for the window to load
				}
				Thread.sleep(3000);
				return new QuotePreValidation(driver);
			}
			else {
				return null;
			}
		}
		catch(Exception ex) {
			return null;
		}
	}

}
