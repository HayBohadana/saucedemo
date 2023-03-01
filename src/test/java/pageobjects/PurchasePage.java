package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchasePage extends BasePage {

	//purchase page Elements//
	@FindBy(css = "#first-name")
	private WebElement firstName;
	@FindBy(css = "#last-name")
	private WebElement lastName;
	@FindBy(css = "#postal-code")
	private WebElement PostalCode;
	@FindBy(css = "#continue")
	private WebElement continueBtn;
	@FindBy(css = "#finish")
	private WebElement finishBtn;
	
	public PurchasePage(WebDriver driver) {
		super(driver);
	}
	//purchase page Elements//
	public void purchase(String fname,String lname,String postCode) {
		fillText(firstName, fname);
		fillText(lastName, lname);
		fillText(PostalCode, postCode);
		click(continueBtn);
		click(finishBtn);
		sleep(500);
	}
}
