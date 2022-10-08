package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass {
	LoginPage loginPage;
	IndexPage indexPage;
	HomePage homePage;
	@Parameters("browser")
	@BeforeMethod(alwaysRun = true, groups = {"smoke", "sanity", "regresion"})
	public void setUp(String browser) {
		launchApp(browser);
		indexPage = new IndexPage();
	}
	
	@Test(dataProvider = "dataLogin", dataProviderClass = DataProviders.class, groups = {"smoke", "sanity"})
	public void loginTest(String user, String pass) {
		Log.startTestCase("loginTest");
		Log.info("user is going to click on signin");
		loginPage = indexPage.clickOnSignIn();
		Log.info("Enter username and pasword");
		homePage = loginPage.login(user, pass);
		Log.info("verifying if user is able to login");
		Assert.assertEquals(homePage.currUrl(), "http://automationpractice.com/index.php?controller=my-account");
		Log.info("login is success");
	}
	
	@AfterMethod(alwaysRun = true, groups = {"smoke", "sanity", "regresion"})
	public void tearDown() {
		getDriver().quit();
	}
}
