package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderSumaryPage extends BaseClass {
	@FindBy(css = "button.button.btn.btn-default.button-medium")
	WebElement confirmOrderBtn;
	
	public OrderSumaryPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderConfirmationPage clickOnConfirmOrder() {
		Action.explicitWait(confirmOrderBtn);
		Action.click(getDriver(), confirmOrderBtn);
		return new OrderConfirmationPage();
	}
}
