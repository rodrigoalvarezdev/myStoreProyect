package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass {
	IndexPage indexPage;
	
	@BeforeMethod
	public void setUp() {
		launchApp();
		indexPage = new IndexPage();
	}
	
	@Test
	public void veryfyLogo() { 
		Assert.assertTrue(indexPage.validateLogo());
	}
	
	@Test
	public void verifyTitle() {
		Assert.assertEquals(indexPage.getMyStoreTitle(), "My Store");
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
}
