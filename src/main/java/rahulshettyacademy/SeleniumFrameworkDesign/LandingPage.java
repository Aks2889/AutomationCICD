package rahulshettyacademy.SeleniumFrameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbastractComponents.AbastractCompnents;

public class LandingPage extends AbastractCompnents{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement userName = driver.findElement(By.id("userEmail"));
	
	@FindBy(id = "userEmail")
	WebElement userEmail;
	
	@FindBy(id = "userPassword")
	WebElement passwordEle;
	
	@FindBy(id = "login")
	WebElement submit;
	
	@FindBy(css = "[class*= 'flyInOut']")
	WebElement errorMessage;
	
    public String getErrorMessage() {
    	waitForWebElementToAppear(errorMessage);
    	return errorMessage.getText();
    	
    }
	
	public ProductCatalogue loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
		
	}

	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
}
