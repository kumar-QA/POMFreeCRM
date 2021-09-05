package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Baseclass;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactPage;

public class ContactPageTest extends Baseclass {
	LoginPage login_page;
	ContactPage contact_page;
	HomePage home_page;
	NewContactPage newcontact_page;

	public ContactPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		login_page = new LoginPage();
		contact_page = new ContactPage();
		home_page = login_page.verifyLoginFeature(prop.getProperty("Email"), prop.getProperty("password"));
		contact_page = home_page.clikOnContactLink();
		System.out.println("BeforeMethod");
	}

	@Test()
	public void verifyContactLabelTest() {
		Assert.assertTrue(contact_page.verifyContactLabel());
		System.out.println("second Test:verifyContactLabelTest");
	}

	@Test()
	public void verifySelectContactByNameTest() {
		contact_page.selectContactByName("benson neal");
		contact_page.selectContactByName("kumar m");
		System.out.println("First Test:verifySelectContactByNameTest");
	}

//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//		System.out.println("after Method ");
//	}

}
