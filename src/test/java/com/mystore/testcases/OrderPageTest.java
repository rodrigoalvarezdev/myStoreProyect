package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass {
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	@BeforeMethod
	public void setUp() {
		launchApp();
		indexPage = new IndexPage();
	}
	
	@Test
	public void totalPriceTest() {
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage =  searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		orderPage = addToCartPage.clickOnProceedToChecOut();
		Double expectedPrice = (orderPage.getUnitPrice()*2)+2;
		Double totalPrice = orderPage.getTotalPrice();
		Assert.assertEquals(expectedPrice, totalPrice);
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
}
