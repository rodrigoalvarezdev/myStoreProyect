package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass {
	@FindBy(id = "quantity_wanted")
	WebElement quantity;
	
	@FindBy(id = "group_1")
	WebElement size;
	
	@FindBy(name = "Submit")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[1]/h2")
	WebElement addToCartMessage;
	
	@FindBy(css = "a.btn.btn-default.button.button-medium")
	WebElement proceedToCheckOutBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterQuantity(String quantity1) {
		Action.type(quantity, quantity1);
	}
	
	public void selectSize(String size1) {
		Action.selectByVisibleText(size1, size);
	}
	
	public void clickOnAddToCart() {
		Action.click(getDriver(), addToCartBtn);
	}
	
	public boolean validateAddToCartMessage() {
		Action.explicitWait(addToCartMessage);
		return Action.isDisplayed(getDriver(), addToCartMessage);
	}
	
	public OrderPage clickOnProceedToChecOut() {
		Action.explicitWait(proceedToCheckOutBtn);
		Action.JSClick(getDriver(), proceedToCheckOutBtn);
		return new OrderPage();
	}
}
