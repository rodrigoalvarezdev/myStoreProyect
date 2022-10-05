package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSumaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

public class EndToEndTest extends BaseClass{
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSumaryPage orderSumaryPage;
	OrderConfirmationPage orderConfirmationPage;
	@BeforeMethod
	public void setUp() {
		launchApp();
		indexPage = new IndexPage();
	}
	
	@Test
	public void endToEndTest() {
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage =  searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		orderPage = addToCartPage.clickOnProceedToChecOut();
		loginPage = orderPage.clickOnCheckOut();
		addressPage =  loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingPage = addressPage.clickOnproceedAddressBtn();
		shippingPage.clickOnCheckBox();
		paymentPage = shippingPage.clickOnProceedCarrier();
		orderSumaryPage = paymentPage.clickOnPayByBank();
		orderConfirmationPage = orderSumaryPage.clickOnConfirmOrder();
		Assert.assertEquals(orderConfirmationPage.validateOrderCompleteTitle(), "Your order on My Store is complete.");
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
}
