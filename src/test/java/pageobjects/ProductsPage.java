package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends ShoppingCart {

	//choose Products elements//
	@FindBy(css = ".inventory_item_name")
	private List<WebElement> productList;
	//choose products In Line elements//
	@FindBy(css = ".inventory_item")
	private List<WebElement> productListInLine ;
	//validation//
	@FindBy(css = "[class='title']")
	private WebElement title;
	
	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	//choose Products operation//
	public void chooseProducts(String name) {
		for (WebElement el : productList) {
			if (getText(el).equalsIgnoreCase(name)) {
				click(el);
				break;
			}
		}
		sleep(1000);
	}
	//choose products In Line operation//
	public void chooseProductsInLine(String name) {
		for (WebElement el : productListInLine) {
			WebElement productTitle = el.findElement(By.cssSelector(".inventory_item_name"));
				if (getText(productTitle).equalsIgnoreCase(name)) {
					WebElement addBtn = el.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
					click(addBtn);
					break;
				}	
			}
		sleep(1000);
		}
	//validation operation//
	public Boolean isProductsPage() {
		if (getText(title).equalsIgnoreCase("products")) {
			return true;
		}
		return false;
	}

}


