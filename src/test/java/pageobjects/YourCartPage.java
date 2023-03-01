package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCartPage extends BasePage{
	//checkout elements//
	@FindBy(css = "#checkout")
	private WebElement checkoutBtn;
	public YourCartPage(WebDriver driver) {
		super(driver);
	}
	//checkout operation//
	public void checkout() {
		click(checkoutBtn);
		sleep(500);
	}
	
}
	
