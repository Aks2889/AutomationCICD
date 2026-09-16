 package rahulshettyacademy.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.SeleniumFrameworkDesign.CartPage;
import rahulshettyacademy.SeleniumFrameworkDesign.CheckOutPage;
import rahulshettyacademy.SeleniumFrameworkDesign.ConfirmationPage;
import rahulshettyacademy.SeleniumFrameworkDesign.OrderPage;
import rahulshettyacademy.SeleniumFrameworkDesign.ProductCatalogue;
import rahulshettyacademy.TestComponents.BaseTest;
public class SubmitOrderTest extends BaseTest {
	

	String productName = "ZARA COAT 3";

        @Test(dataProvider="getData", groups="Purchase")
        public void submitOrder(HashMap<String,String> input) throws IOException , InterruptedException {
	
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"),input.get("password"));
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.AddProductToCart(input.get("product"));
		
		CartPage cartPage = productCatalogue.goToCartPage();
		
		
		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
		
		Assert.assertTrue(match);
	    CheckOutPage checkOutPage = cartPage.goToCheckOut();
	    checkOutPage.selectCountry("india");
	    ConfirmationPage confirmationPage = checkOutPage.submitOrder();
	    String confirmMessage = confirmationPage.getMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	    
		
		
		

	
	
		
		
		

		
		
	    
        
		
	
		
	}	
        
        
     @Test(dependsOnMethods = {"submitOrder"})
     public void orderHistory() {
    	 
    	 ProductCatalogue productCatalogue = landingPage.loginApplication("testakshata@test.com", "Test.123456");
    	 OrderPage ordersPage = productCatalogue.goToOrderPage();
    	 Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
    	
    	 
    	 
     }
     
 
     
     @DataProvider
     public Object[][] getData() throws IOException {
//    	 
//    	 HashMap<String, String> map = new  HashMap<String, String>();
//    	 map.put("email", "testakshata@test.com" );
//    	 map.put("password","Test.123456");
//    	 map.put("product", "ZARA COAT 3");
//    	 
//    	 HashMap<String, String> map1 = new  HashMap<String, String>();
//    	 map1.put("email", "testakshata02@test.com" );
//    	 map1.put("password","Test@654321");
//    	 map1.put("product", "ADIDAS ORIGINAL");
//    	 
//    	 
    	 List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");
     	 return new Object[][] {{data.get(0)} , {data.get(1)}};
//    	 
//    	 
//    	 
    }
}	