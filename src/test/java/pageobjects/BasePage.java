package pageobjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage  {
	WebDriver driver;
	JavascriptExecutor js;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js=(JavascriptExecutor)driver;
	}
	//////////methods/////////////
	public WebDriver getDriver() {
		return driver;
	}
	public void fillText(WebElement el,String text) {
		//highlight//
		highlightElement(el, "green");
		el.clear();
		sleep(500);
		el.sendKeys(text);
	}
	public void click(WebElement el) {
		//highlight//
		highlightElement(el, "green");
		el.click();
		sleep(500);
	}
	public String getText(WebElement el) {
		highlightElement(el, "orange");
		return el.getText();
	}
	public void sleep(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void alertOK(String text) {
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();	
	}
	 // Call this method with your element and a color like (red,green,orange etc...)
	private void highlightElement(WebElement element, String color) {
		//keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "border: 1px solid " + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Change the style 
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
				element);

		// Change the style back after few milliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);
	}
}
