package pageobjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{ 
	//login page Elements//	
	@FindBy(css = "#user-name")
	private WebElement userField;
	@FindBy(css = "#password")
	private WebElement passwordField;
	@FindBy(css = "#login-button")
	private WebElement loginBtn;
	@FindBy(css = "[data-test='error']")
	private WebElement errorMsg;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	//login operation//
	public void login(String user,String password) {
		fillText(userField,user);
		fillText(passwordField,password);
		click(loginBtn);
		sleep(1000);
	}
	//validation//
	public String getErrorMsg() {
		return getText(errorMsg);
	}
}

