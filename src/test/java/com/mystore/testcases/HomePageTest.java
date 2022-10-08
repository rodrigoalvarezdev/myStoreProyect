package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class HomePageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	@Parameters("browser")
	@BeforeMethod(alwaysRun = true,groups = {"smoke", "sanity", "regresion"})
	public void setUp(String browser) {
		launchApp(browser);
		indexPage = new IndexPage();
	}
	
	@Test(groups = "smoke")
	public void wishListTest() {
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(homePage.validateListWish());
	}
	
	@Test(groups = "smoke")
	public void orderHistoryTest() {
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(homePage.validateOrderHistory());
	}
	
	@AfterMethod(alwaysRun = true,groups = {"smoke", "sanity", "regresion"})
	public void tearDown() {
		getDriver().quit();
	}
}
