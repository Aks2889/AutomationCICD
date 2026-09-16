package rahulshettyacademy.SeleniumFrameworkDesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbastractComponents.AbastractCompnents;

public class ConfirmationPage extends AbastractCompnents {
	
	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}

	@FindBy(css = ".hero-primary")
	WebElement confirmationMessage;
	
	public String getMessage() {
		
		return confirmationMessage.getText();
		
	}
	
}
