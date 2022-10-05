package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass {
	@FindBy(css = "a.bankwire")
	WebElement payByBank;
	
	@FindBy(css = "a.cheque")
	WebElement payByCheck;
	
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderSumaryPage clickOnPayByBank() {
		Action.explicitWait(payByBank);
		Action.click(getDriver(), payByBank);
		return new OrderSumaryPage();
	}
}
