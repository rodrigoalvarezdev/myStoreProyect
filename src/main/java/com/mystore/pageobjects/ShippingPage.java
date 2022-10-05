package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass {
	@FindBy(id = "cgv")
	WebElement checkBox;
	
	@FindBy(css = "button[name='processCarrier']")
	WebElement proceedCarrierBtn;
	
	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickOnCheckBox() {
		Action.click(getDriver(), checkBox);
	}
	
	public PaymentPage clickOnProceedCarrier() {
		Action.explicitWait(proceedCarrierBtn);
		Action.click(getDriver(), proceedCarrierBtn);
		return new PaymentPage();
	}
}
