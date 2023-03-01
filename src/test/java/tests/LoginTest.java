package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.LoginPage;
import pageobjects.ProductsPage;


public class LoginTest extends BaseTest{

	@Test (description = "test with wrong password")
	public void tc01_loginFailed() {
		//login//
		LoginPage lp = new LoginPage(driver);
		lp.login("standard_user1", "");
		String expected = "Epic sadface: Password is required";
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected);
	}
	@Test (description = "test with wrong user name")
	public void tc02_loginFailed() {
		//login//
		LoginPage lp = new LoginPage(driver);
		lp.sleep(1000);
		lp.login("","secret_sauce");
		String expected = "Epic sadface: Username is required";
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected);
	}
	@Test (dataProvider = "getData", description = "test with many user")
	public void tc03_loginFailed(String user,String password) {
		//login//
		LoginPage lp = new LoginPage(driver);
		lp.login(user, password);
		String expected = "Epic sadface: Username and password do not match any user in this service";
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected);
	}
	@Test (description = "work Test")
	public void tc04_loginSucceed() {
		//login//
		LoginPage lp = new LoginPage(driver);
		lp.login("standard_user", "secret_sauce");
		ProductsPage psp = new ProductsPage(driver);
		Assert.assertTrue(psp.isProductsPage());
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] myData = {
				{"user1","123"},
				{"hay","123"},
				{"einav","1#444"},
				{"hay","123456878"},
		};
		return myData;
	}
}
