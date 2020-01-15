package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.util.Locators;

public class OptimusHomePage {
	WebDriver driver;
	
	public OptimusHomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(how = How.XPATH, using = Locators.OPTIMUS_HPE_LINK)
	WebElement hpeLogon;
	@FindBy(how = How.XPATH, using = Locators.OPTIMUS_HPE_LINK)
	WebElement optimusLogo;
	@FindBy(how = How.XPATH, using = Locators.OPTIMUS_SUPPORT_BUTTON)
	WebElement supportOpt;
	@FindBy(how = How.XPATH, using = Locators.OPTIMUS_TROUBLESHOOTING_BUTTON)
	WebElement troubleshootOpt;
	
	public void LogOn() {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(hpeLogon));
			if (hpeLogon.isDisplayed()) {
				hpeLogon.click();
				while(!optimusLogo.isDisplayed()) {
					// wait for the page to load
				}
				System.out.println("Optimus Loaded");
				Thread.sleep(5000);
			}
		}
		catch(Exception ex) {
			
		}
	}
	
	public OptimusTroubleshoot openTroubleshoot() {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(supportOpt));
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(supportOpt));
			if(supportOpt.isDisplayed() && troubleshootOpt.isEnabled()) {
				supportOpt.click();
				if(troubleshootOpt.isEnabled() && troubleshootOpt.isDisplayed()) {
					troubleshootOpt.click();
					System.out.println("Troubleshoot opened");
					return new OptimusTroubleshoot(driver);
				}
				else {
					System.out.println("Troubleshoot option not found");
				}
			}
			else {
				System.out.println("Support option not found");
			}
		}
		catch(Exception ex) {
			System.out.println("Something went wrong: " + ex);
		}
		return null;
	}

}
