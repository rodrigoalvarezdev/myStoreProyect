package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass {
	IndexPage indexPage;
	@Parameters("browser")
	@BeforeMethod(alwaysRun = true,groups = {"smoke", "sanity", "regresion"})
	public void setUp(String browser) {
		launchApp(browser);
		indexPage = new IndexPage();
	}
	
	@Test(groups = "smoke")
	public void veryfyLogo() { 
		Assert.assertTrue(indexPage.validateLogo());
	}
	
	@Test(groups = "smoke")
	public void verifyTitle() {
		Assert.assertEquals(indexPage.getMyStoreTitle(), "My Store");
	}
	
	@AfterMethod(alwaysRun = true,groups = {"smoke", "sanity", "regresion"})
	public void tearDown() {
		getDriver().quit();
	}
}
