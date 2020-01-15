package AnalyticsTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.framework.util.BaseDriver;
import com.framework.util.Locators;
import com.framework.util.Properties;

import pageObjects.AdditionalTab;
import pageObjects.HomeHeaderMenu;
import pageObjects.NGQHomePage;
import pageObjects.OpportunityAndQuote;
import pageObjects.OptimusHomePage;
import pageObjects.OptimusTroubleshoot;
import pageObjects.PricingAndTerms;
import pageObjects.ProductsConfigurations;
import pageObjects.QuoteOutput;
import pageObjects.QuotePreValidation;
import pageObjects.TopInformation;

public class testTest extends BaseDriver{
	
	@BeforeTest
	public void setUp() {
		getDriver();
	}
	
	@Test
	public void NF_22_S4_004_Validate_Product_Category_Is_Provided_In_Price_Line_Responses() {
		// Initializing the PageObjects
		NGQHomePage homepage = new NGQHomePage(driver);
		HomeHeaderMenu homeheader = new HomeHeaderMenu(driver);
		OpportunityAndQuote opeandquote = new OpportunityAndQuote(driver);
		ProductsConfigurations prodconfig = new ProductsConfigurations(driver);
		PricingAndTerms pricingtab = new PricingAndTerms(driver);
		TopInformation topinfo = new TopInformation(driver);
		QuoteOutput quoteoutput = new QuoteOutput(driver);
		AdditionalTab addtab = new AdditionalTab(driver);
		OptimusHomePage optimus = new OptimusHomePage(driver);
		
		/* TEST NAME:
		 * [New] - 2.2_S4_004_Validate Product Category is provided in price line responses
		 * 
		 * Preconditions:
		 * 1. NGQ and Optimus Access
		 * 2. Mixed Quote
		 * 
		 * */
		// Step 1: Create a quote for deployed country. Add products for different BU's in order to create a mixed quote (example EDGE product and Compute value product).
		driver.navigate().to(Locators.NGQ_ITG4_URL);
		homepage.validate_loginPage();
		homeheader.createNewQuote();
		opeandquote.importOPE(Properties.OPE_ID);
		prodconfig.addProduct(Properties.PRODUCT_SKU);
		prodconfig.addProduct(Properties.PRODUCT_SKU1);
		pricingtab.openPricingAndTermsTab();
		pricingtab.validatePA();
		topinfo.refreshPrice();
		quoteoutput.openQuoteOutputTab();
		quoteoutput.selectRFQNode();
		QuotePreValidation preval = topinfo.click_Validate();
		preval.dataCheck();
		preval.priceCheck();
		preval.bundleCheck();
		preval.completeQuote();
		preval.closePopup();
		addtab.openAdditionalTab();
		String refID = addtab.get_OptimusReferenceID();
		// Step 2: In Optimus Manager, go to troubleshooting and paste the quote ID in the search field and open the price line items file.
		//         Search for the lead product category tag and confirm is correct.
		driver.navigate().to(Locators.OPTIMUS_ITG_URL);
		optimus.LogOn();
		OptimusTroubleshoot troubleshoot = optimus.openTroubleshoot();
		troubleshoot.search_refID(refID);
		troubleshoot.openResponse();
		troubleshoot.validate_LeadProdCat("HPBA_WW198");
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
