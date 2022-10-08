package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class AccountCreationPageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;
	@Parameters("browser")
	@BeforeMethod(alwaysRun = true,groups = {"smoke", "sanity", "regresion"})
	public void setUp(String browser) {
		launchApp(browser);
		indexPage = new IndexPage();
	}
	
	@Test(groups = "sanity")
	public void createNewAccountTest() {
		loginPage = indexPage.clickOnSignIn();
		accountCreationPage = loginPage.createNewAccount("cliente2@xyz.com");
		//Assert.assertTrue(accountCreationPage.validateAccountCreatePage());
		Assert.assertTrue(false);
		
	}
	
	@AfterMethod(alwaysRun = true,groups = {"smoke", "sanity", "regresion"})
	public void tearDown() {
		getDriver().quit();
	}
}
