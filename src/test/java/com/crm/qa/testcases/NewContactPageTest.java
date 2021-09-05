package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.Baseclass;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactPage;
import com.crm.qa.util.TestUtil;

public class NewContactPageTest extends Baseclass {
	LoginPage login_page;
	ContactPage contact_page;
	HomePage home_page;
	NewContactPage newcontact_page;
	String SheetName="contacts";

	public NewContactPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		login_page = new LoginPage();
		contact_page = new ContactPage();
		newcontact_page = new NewContactPage();
		home_page = login_page.verifyLoginFeature(prop.getProperty("Email"), prop.getProperty("password"));
		contact_page = home_page.clikOnContactLink();
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object[][] data=TestUtil.getTestData(SheetName);
		return data;
	}
	
	@Test(dataProvider="getCRMTestData")
	public void newContactFormTest(String FirstName,String LastName,String PhoneNo,String Email) throws InterruptedException {
		Thread.sleep(4000);
		newcontact_page = contact_page.clickOnCreateBtn();
		newcontact_page.createNewContact(FirstName, LastName,PhoneNo,Email );
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
