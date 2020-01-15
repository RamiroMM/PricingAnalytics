package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.framework.util.Locators;

public class NGQHomePage {
	WebDriver driver;
	
	public NGQHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(how = How.CSS, using = Locators.HPE_LOGO_PATH)
	WebElement hpeLogo;
	@FindBy(how = How.XPATH, using = Locators.NEW_QUOTE_PATH)
	WebElement newQuote;
	
	public void validate_loginPage() {
		if (hpeLogo.isDisplayed() && newQuote.isEnabled()) {
			System.out.println("NGQ Home Page Loaded");
		}
		else {
			System.out.println("Page Home Page not loaded");
		}
	}

}
