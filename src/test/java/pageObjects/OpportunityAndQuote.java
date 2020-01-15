package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.util.Locators;

public class OpportunityAndQuote {
	WebDriver driver;
	
	public OpportunityAndQuote(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(how = How.XPATH, using = Locators.OPE_BOX_PATH)
	WebElement opeBox;
	@FindBy(how = How.XPATH, using = Locators.IMPORT_BUTTON_PATH)
	WebElement importButton;
	@FindBy(how = How.XPATH, using = Locators.LOAD_SPINNER_PATH)
	WebElement loadSpinner;
	@FindBy(how = How.XPATH, using = Locators.SUCCESS_SAVED_MSG_PATH)
	WebElement successMsg;
	
	public void importOPE(String opportunityID) {
		while(loadSpinner.isDisplayed()) {
			//Do nothing
		}
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(opeBox));
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(importButton));
		if (opeBox.isEnabled() && importButton.isEnabled()) {
			System.out.println("Opportunity and Quote Tab elements loaded");
			
			try {
				opeBox.click();
				opeBox.sendKeys(opportunityID);
				importButton.click();
				while(loadSpinner.isDisplayed()) {
					//Do nothing
				}
			}
			catch(Exception ex) {
				System.out.println(ex);
			}	
		}
		else {
			System.out.println("Opportunity and Quote Tab elements NOT loaded");
		}
	}

}
