package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.util.Locators;

public class AdditionalTab {
	WebDriver driver;
	
	public AdditionalTab(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(how = How.XPATH, using = Locators.ADDITIONAL_TAB)
	WebElement additionalTab;
	@FindBy(how = How.XPATH, using = Locators.ADDTNL_TAB_INFO_BUTTON)
	WebElement infoButton;
	@FindBy(how = How.XPATH, using = Locators.OPTIMUS_REFERENCE_ID)
	WebElement optimusRefID;
	
	public void openAdditionalTab() {
		try {
			Thread.sleep(1500);
			if(additionalTab.isEnabled()) {
				additionalTab.click();
			}
		}
		catch(Exception ex) {}
	}
	
	public String get_OptimusReferenceID() {
		try {
			infoButton.click();
			if(optimusRefID.isDisplayed()) {
				String refID = optimusRefID.getText();
				return refID;
			}
		}
		catch(Exception ex){
			System.out.println("Reference ID not found");
		}
		return null;
	}

}
