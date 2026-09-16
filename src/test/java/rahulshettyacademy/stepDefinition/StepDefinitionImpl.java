package rahulshettyacademy.stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.SeleniumFrameworkDesign.CartPage;
import rahulshettyacademy.SeleniumFrameworkDesign.CheckOutPage;
import rahulshettyacademy.SeleniumFrameworkDesign.ConfirmationPage;
import rahulshettyacademy.SeleniumFrameworkDesign.LandingPage;
import rahulshettyacademy.SeleniumFrameworkDesign.ProductCatalogue;
import rahulshettyacademy.TestComponents.BaseTest;

public class StepDefinitionImpl extends BaseTest {
	
	public LandingPage landingPage ;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		
		landingPage = launchApplication();
		
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username,String password) {
		productCatalogue = landingPage.loginApplication(username,password);
 		
	}
	
	@When("^I add product (.+) to Cart$")
	public void i_add_product_to_cart(String productName) {
		
		
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.AddProductToCart(productName);
		
	
		
	}
	
	@And("^Checkout (.+) and submit the order$")
	public void checkout_submit_order(String productName) {

	    CartPage cartPage = productCatalogue.goToCartPage();

	    Boolean match = cartPage.VerifyProductDisplay(productName);
	    Assert.assertTrue(match);

	    CheckOutPage checkOutPage = cartPage.goToCheckOut();
	    checkOutPage.selectCountry("india");

	    confirmationPage = checkOutPage.submitOrder();
	}
	
	@Then("{string} message is displayed on ConfirmationPage")
	public void message_displayed_confirmationPage(String string) {
		
		
		String confirmMessage = confirmationPage.getMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.quit();
		
	}
	
	@Then("{string} message is displayed")
	public void something_message_is_displayed(String expectedMessage) {
	    Assert.assertEquals(expectedMessage, landingPage.getErrorMessage());
	    driver.quit();
	}
	

}
