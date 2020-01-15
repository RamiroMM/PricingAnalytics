package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.util.Locators;

public class ProductsConfigurations {
	WebDriver driver;
	
	public ProductsConfigurations(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(how = How.XPATH, using = Locators.NGQ_ADD_BUTTON)
	WebElement addButton;
	@FindBy(how = How.XPATH, using = Locators.NGQ_ADD_PRODUCT_BUTTON)
	WebElement addProductButton;
	@FindBy(how = How.XPATH, using = Locators.NGQ_PRODUCT_FIELD)
	WebElement productField;
	
	public void addProduct(String product) {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(addButton));
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(addButton));
			if(addButton.isDisplayed()) {
				addButton.click();
				new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(addProductButton));
				new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(addProductButton));
				if(addProductButton.isDisplayed()) {
					addProductButton.click();
					new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(productField));
					productField.sendKeys(product);
					productField.sendKeys(Keys.ENTER);
				}
			}
			Thread.sleep(1500);
		}
		catch(Exception ex) {
			
		}
	}

}
