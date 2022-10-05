package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	
	@BeforeMethod
	public void setUp() {
		launchApp();
		indexPage = new IndexPage();
	}
	
	@Test
	public void addToCartTest() {
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage =  searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		Assert.assertTrue(addToCartPage.validateAddToCartMessage());
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
}
