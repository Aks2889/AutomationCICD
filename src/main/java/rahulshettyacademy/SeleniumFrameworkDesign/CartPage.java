package rahulshettyacademy.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbastractComponents.AbastractCompnents;

public class CartPage extends AbastractCompnents{
	
	WebDriver driver;
	@FindBy(css = ".totalRow button")
	WebElement checkOutEle;
	
	@FindBy(css = ".cartSection h3")
	private List<WebElement> productTitles;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	public Boolean VerifyProductDisplay(String productName){
		Boolean match = productTitles.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckOutPage goToCheckOut() {
		checkOutEle.click();
		return new CheckOutPage(driver);
		
	}
	

}
