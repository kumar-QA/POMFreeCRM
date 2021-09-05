package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Baseclass;

public class HomePage extends Baseclass {

	@FindBy(xpath="//span[contains(text(),'Prasanna Kumar')]")
	WebElement userNameLabel;
	@FindBy(xpath="//*[contains(text(),'Contacts')]")
	WebElement contactlink;
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealslink;
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasklink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	public ContactPage clikOnContactLink() {
		contactlink.click();
		return new ContactPage();
	}
	public TasksPage clickOnTaskLink() {
		 tasklink.click();
		 return new TasksPage();
	}
	public DealsPage clickOnDealsLink() {
		dealslink.click();
		return new DealsPage();
	}
	
}
