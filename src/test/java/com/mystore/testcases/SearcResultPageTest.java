package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class SearcResultPageTest extends BaseClass {
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	
	@BeforeMethod
	public void setUp() {
		launchApp();
		indexPage = new IndexPage();
	}
	
	@Test
	public void productAbailibilityTest() {
		searchResultPage = indexPage.searchProduct("t-shirt");
		Assert.assertTrue(searchResultPage.isProductAvailable());
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
}
