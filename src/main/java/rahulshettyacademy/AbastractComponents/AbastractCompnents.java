package rahulshettyacademy.AbastractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.SeleniumFrameworkDesign.CartPage;
import rahulshettyacademy.SeleniumFrameworkDesign.OrderPage;

public class AbastractCompnents {
	
	WebDriver driver;
	
	public AbastractCompnents(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[routerlink*= 'cart']")
	WebElement cartHeader;
	
	@FindBy(css = "[routerlink*= 'myorders']")
	WebElement orderHeader;
	
	@FindBy(css=".ngx-spinner-overlay")
	WebElement spinner;


	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement webEle) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(webEle));
	}
	
	public void waitForElementToDisappear(WebElement webEle) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(webEle));
	}
	

	
	public CartPage goToCartPage() {
		
		    waitForElementToDisappear(spinner);
		    cartHeader.click();
		    return new CartPage(driver);
		
	}
	
public OrderPage goToOrderPage() {
		
		orderHeader.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
		
	}

}
