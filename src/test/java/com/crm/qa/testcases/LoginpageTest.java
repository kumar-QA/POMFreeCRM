package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Baseclass;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginpageTest extends Baseclass{
	LoginPage login_page;
	HomePage home_page;
//1.invoke config prop of parent class constructor to read config file properties
	public LoginpageTest() {
		super();//Baseclass constructor
	}

//2.
	@BeforeMethod
	public void setUp() {
		initialization();
		login_page=new LoginPage();//to acess webelements and action of loginpage 
		System.out.println("Before Method");
	}
//	
	@Test(priority=1)
	public void verifyPageTitleTest() {
	String title=login_page.verifyPageTitle();
	Assert.assertEquals(title, "Cogmento CRM");
	System.out.println("verifyPageTitleTest");
	}
	@Test(priority=2)
	public void verifyLoginFeatureTest() {
	home_page=login_page.verifyLoginFeature(prop.getProperty("Email"), prop.getProperty("password"));//return object of homepage
	//like HomePage homepage=new HomePage()
	System.out.println("verifyLoginFeatureTest");
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		System.out.println("After Method");
	}
}
