package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class AccountCreationPageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;
	
	@BeforeMethod
	public void setUp() {
		launchApp();
		indexPage = new IndexPage();
	}
	
	@Test
	public void createNewAccountTest() {
		loginPage = indexPage.clickOnSignIn();
		accountCreationPage = loginPage.createNewAccount("cliente2@xyz.com");
		Assert.assertTrue(accountCreationPage.validateAccountCreatePage());
		
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
}
