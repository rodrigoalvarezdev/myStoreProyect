package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class SearcResultPageTest extends BaseClass {
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	@Parameters("browser")
	@BeforeMethod(alwaysRun = true,groups = {"smoke", "sanity", "regresion"})
	public void setUp(String browser) {
		launchApp(browser);
		indexPage = new IndexPage();
	}
	
	@Test(groups = "smoke")
	public void productAbailibilityTest() {
		searchResultPage = indexPage.searchProduct("t-shirt");
		Assert.assertTrue(searchResultPage.isProductAvailable());
	}
	
	@AfterMethod(alwaysRun = true,groups = {"smoke", "sanity", "regresion"})
	public void tearDown() {
		getDriver().quit();
	}
}
