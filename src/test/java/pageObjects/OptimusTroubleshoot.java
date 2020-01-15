package pageObjects;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.util.Locators;

public class OptimusTroubleshoot {
	WebDriver driver;
	
	public OptimusTroubleshoot(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(how = How.XPATH, using = Locators.OPTIMUS_REF_ID_FIELD)
	WebElement refIDfield;
	@FindBy(how = How.XPATH, using = Locators.OPTIMUS_REF_ID_SEARCH_BUTTON)
	WebElement searchButton;
	@FindBy(how = How.XPATH, using = Locators.OPTIMUS_PRICELINEITEMS_SUBMODULE)
	WebElement subModuleTitle;
	@FindBy(how = How.XPATH, using = Locators.OPTIMUS_RESPONSE_XML_LINK)
	WebElement responseXML;
	@FindBy(how = How.XPATH, using = Locators.OPTIMUS_XML_TEXT_AREA)
	WebElement xmlText;
	
	public void search_refID(String refID) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(refIDfield));
		try {
			if(refIDfield.isDisplayed() && refIDfield.isEnabled()) {
				refIDfield.sendKeys(refID);
				try {
					searchButton.click();
					new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(subModuleTitle));
				}
				catch(Exception ex) {
					System.out.println("Price Line Items sub module not found" + ex);
				}
			}
		}
		catch(Exception ex) {
			System.out.println("Something went wrong..." + ex);
		}
	}
	
	public void openResponse() {
		try {
			responseXML.click();
			while(!xmlText.isDisplayed()) {
				//Wait for the element to load
			}
			Thread.sleep(2500);
		}
		catch(Exception ex) {
			System.out.println("Something went wrong..." + ex);
		}
	}
	
	public void validate_LeadProdCat(String LeadProdCat) {
		try {
			Thread.sleep(1000);
			String xmltext = xmlText.getText();
			String leadProdTag = StringUtils.substringBetween(xmltext, "<LeadProdCat>", "</LeadProdCat>");
			System.out.println("LeadProdCat: " + leadProdTag);
			boolean isTextPresent = leadProdTag.contains(LeadProdCat);
			Assert.assertTrue(isTextPresent);
			if(isTextPresent) {
				System.out.println("TEST PASSED: ProdCat matches");
			}
		}
		catch(Exception ex) {
			System.out.println("TEST FAILED: LeadProdCat was not found..." + ex);
			Assert.assertTrue(false);
		}
	}

}
