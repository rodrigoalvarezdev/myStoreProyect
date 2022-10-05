package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass {
	@FindBy(css = "span.price span")
	WebElement unitPrice;
	
	@FindBy(id = "total_price")
	WebElement totalPrice;
	
	@FindBy(css = "p.cart_navigation.clearfix a[title='Proceed to checkout']")
	WebElement proceedToCheckout;
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public double getUnitPrice() {
		String unitPrice1 = unitPrice.getText();
		String unit = unitPrice1.replaceAll("[^a-zA-Z0-9]+","");
		double finalUnitPrice = Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	
	public double getTotalPrice() {
		String totalPrice1 = totalPrice.getText();
		String unit = totalPrice1.replaceAll("[^a-zA-Z0-9]+","");
		double finalTotalPrice = Double.parseDouble(unit);
		return finalTotalPrice/100;
	}
	
	public LoginPage clickOnCheckOut() {
		Action.click(getDriver(), proceedToCheckout);
		return new LoginPage();
	}
}
