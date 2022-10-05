package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass{
	
	@FindBy(css = "button[name='processAddress']")
	WebElement proceedAddressBtn;
	
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public ShippingPage clickOnproceedAddressBtn() {
		Action.explicitWait(proceedAddressBtn);
		Action.click(getDriver(), proceedAddressBtn);
		return new ShippingPage();
	}
}
