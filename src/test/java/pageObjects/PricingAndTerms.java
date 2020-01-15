package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.util.Locators;

public class PricingAndTerms {
	WebDriver driver;
	
	public PricingAndTerms(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(how = How.XPATH, using = Locators.PRICING_AND_TERMS_TAB)
	WebElement pricingTab;
	@FindBy(how = How.XPATH, using = Locators.PA_NOT_VALIDATED_MSG)
	WebElement paMessage;
	@FindBy(how = How.XPATH, using = Locators.PA_VALIDATE_BUTTON)
	WebElement paValidateButton;
	@FindBy(how = How.XPATH, using = Locators.LOAD_SPINNER_PATH)
	WebElement loadSpinner;
	
	public void openPricingAndTermsTab() {
		if(pricingTab.isEnabled()) {
			pricingTab.click();
		}
	}
	
	public void validatePA() {
		while(loadSpinner.isDisplayed()) {
			//Do nothing
		}
		try {
			if(paMessage.isDisplayed()) {
				paValidateButton.click();
			}
			else {
				while(loadSpinner.isDisplayed()) {
					//Do nothing
				}
			}
		}
		catch(Exception ex){
			
		}
	}

}
