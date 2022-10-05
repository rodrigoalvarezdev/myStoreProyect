package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass {
	@FindBy(css = "input#email")
	WebElement userName;
	
	@FindBy(css = "input#passwd")
	WebElement password;
	
	@FindBy(css = "button#SubmitLogin")
	WebElement singInButtton;
	
	@FindBy(id = "email_create")
	WebElement emailForNewAccount;
	
	@FindBy(id = "SubmitCreate")
	WebElement createNewAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login(String uname, String pswd) {
		Action.type(userName, uname);
		Action.type(password, pswd);
		Action.click(getDriver(), singInButtton);
		return new HomePage();
	}
	
	public AddressPage login1(String uname, String pswd) {
		Action.type(userName, uname);
		Action.type(password, pswd);
		Action.click(getDriver(), singInButtton);
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount(String email) {
		Action.type(emailForNewAccount, email);
		Action.click(getDriver(), createNewAccountBtn);
		return new AccountCreationPage();
	}
	
}
