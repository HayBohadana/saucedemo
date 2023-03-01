package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCart extends BasePage{

	public ShoppingCart(WebDriver driver) {
		super(driver);	
	}
	//shopping cart elements//
	@FindBy(css = "#shopping_cart_container")
	private WebElement openCartBtn;
	//open cart operation//
	public void openCart() {
		click(openCartBtn);
		sleep(500);
	}
	

}
