package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Baseclass;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;

public class HomePageTest extends Baseclass {
	LoginPage login_page;
	HomePage home_page;
	ContactPage contact_page;
	TasksPage tasks_page;
	DealsPage deals_page;
	public HomePageTest() {
		super();
	} 
	
	@BeforeMethod
	public void setUp() {
		initialization();
		login_page=new LoginPage();
		contact_page=new ContactPage();
		home_page=login_page.verifyLoginFeature(prop.getProperty("Email"), prop.getProperty("password"));
	}
	@Test(priority=2)
	public void VerifyCorrectUserNameTest() {
			Assert.assertTrue(home_page.verifyCorrectUserName());
	}
	@Test(priority=1)
	public void VerifyContactLinkTest() {
		contact_page=home_page.clikOnContactLink();
	}
	
	@AfterMethod
	public void tearDown() {
	driver.quit();	
	}
	
}
