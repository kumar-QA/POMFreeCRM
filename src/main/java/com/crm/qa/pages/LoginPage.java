package com.crm.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Baseclass;

public class LoginPage extends Baseclass {
//1.pageFactory == OR(ObjectRepository)//Create pageFactory
	@FindBy(name="email")WebElement Email;
	@FindBy(name="password")WebElement Password;
	@FindBy(xpath="//div[contains(@class,'ui fluid large blue submit button')]")WebElement Loginbtn;
	
//2.initialization webelements through initElement in a constructor
	public LoginPage() {
		PageFactory.initElements(driver, this);//this refers to class name loginpage
	}
	
//3. Actions
	public String verifyPageTitle() {
		return driver.getTitle();
	}
	public HomePage verifyLoginFeature(String email,String pwd) {
		Email.sendKeys(email);
		Password.sendKeys(pwd);
		Loginbtn.click();
		return new HomePage();
	}
	
}
