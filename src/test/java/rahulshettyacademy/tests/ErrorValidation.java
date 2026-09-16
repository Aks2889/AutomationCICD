package rahulshettyacademy.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import junit.framework.Assert;
import rahulshettyacademy.SeleniumFrameworkDesign.CartPage;
import rahulshettyacademy.SeleniumFrameworkDesign.ProductCatalogue;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.Retry;

public class ErrorValidation extends BaseTest {
	
	@Test(groups= {"ErrorHandling"}, retryAnalyzer=Retry.class)
    public void submitOrder() throws IOException , InterruptedException {
    	String productName = "ZARA COAT 3";
    	landingPage.loginApplication("testakshata@test.com", "A@123456");
        Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
        
    }
	
	@Test
    public void ProductErrorValidation() throws IOException , InterruptedException {
    	
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("testingerroraku@test.com", "Test@12345678");
		productCatalogue.getProductList();
		productCatalogue.AddProductToCart(productName);
		
		CartPage cartPage = productCatalogue.goToCartPage();
		
		
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		
		Assert.assertFalse(match);
	   
    }

}
