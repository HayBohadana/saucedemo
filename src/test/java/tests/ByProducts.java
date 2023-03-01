package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.LoginPage;
import pageobjects.ProductPage;
import pageobjects.ProductsPage;
import pageobjects.PurchasePage;
import pageobjects.YourCartPage;

public class ByProducts extends BaseTest{

	@Test (description = "login")
	public void tc01_login() {
		LoginPage lp = new LoginPage(driver);
		lp.login("standard_user", "secret_sauce");
		//validation//
		ProductsPage psp = new ProductsPage(driver);
		Assert.assertTrue(psp.isProductsPage());
	}
	@Test (description = "choose product") 
	public void tc02_chooseProduct1() {
		ProductsPage psp = new ProductsPage(driver);
		psp.chooseProducts("Sauce Labs Onesie");
		ProductPage pp = new ProductPage(driver);
		pp.addToCart();
		pp.back();
	}
	@Test (description = "choose product") 
	public void tc03_chooseProduct2() {
		//choose product//
		ProductsPage psp = new ProductsPage(driver);
		psp.chooseProducts("Sauce Labs Bolt T-Shirt");
		ProductPage pp = new ProductPage(driver);
		pp.addToCart();
		pp.back();
	}
	@Test (description = "choose product in line") 
	public void tc04_chooseProductInLine() {
		//choose product in line//
		ProductsPage psp = new ProductsPage(driver);
		psp.chooseProductsInLine("Sauce Labs Fleece Jacket");
		psp.openCart();
	}
	@Test (description = "checkout and success purchase") 
	public void tc05_checkout() {
		//go to shopping cart//
		ProductsPage psp = new ProductsPage(driver);
		psp.openCart();
		//checkout//
		YourCartPage ycp = new YourCartPage(driver);
		ycp.checkout();
		//purchase//
		PurchasePage prp = new PurchasePage(driver);
		prp.purchase("orel", "levi", "145615");
	}
}

