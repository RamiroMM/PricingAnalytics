package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.util.Locators;

public class QuoteOutput {
	WebDriver driver;
	
	public QuoteOutput(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(how = How.XPATH, using = Locators.QUOTE_OUTPUT_TAB)
	WebElement quoteOutputTab;
	@FindBy(how = How.XPATH, using = Locators.RFQ_NODE_DROPDOWN_OPTION)
	WebElement rfqNodeOption;
	
	public void openQuoteOutputTab() {
		if(quoteOutputTab.isEnabled()) {
			quoteOutputTab.click();
		}
	}
	
	public void selectRFQNode() {
		try {
			if(rfqNodeOption.isEnabled()) {
				rfqNodeOption.click();
			}
			Thread.sleep(1000);
		}
		catch(Exception ex){
			
		}
	}
	
	public void selectPOAccount() {
			
		}

}
