package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

	//product page Elements//
	@FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
	private WebElement addToCartBtn;
	@FindBy(css = "#back-to-products")
	private WebElement backToProdBtn;
	
	public ProductPage(WebDriver driver) {
		super(driver);
	}
	//add to cart operation//
	public void addToCart() {
		click(addToCartBtn);
		sleep(500);
	}
	public void back() {
		click(backToProdBtn);	
		sleep(500);

	}
}
