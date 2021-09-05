package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.Baseclass;

public class NewContactPage extends Baseclass {
	@FindBy(xpath = "//div[@class='ui right corner labeled input']/input[@name='first_name']")
	WebElement FirstName;
	@FindBy(xpath = "//div[@class='ui right corner labeled input']/input[@name='last_name']")
	WebElement LastName;

	@FindBy(xpath = "//input[@placeholder='Number']")
	WebElement PhoneNO;

	@FindBy(xpath = "//input[@placeholder='Email address']")
	WebElement EmailAddress;

	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement SaveBtn;

	public NewContactPage() {
		PageFactory.initElements(driver, this);
	}

	public void createNewContact(String fname, String lname, String phoneno, String email)
			throws InterruptedException {
		FirstName.sendKeys(fname);
		LastName.sendKeys(lname);
		PhoneNO.sendKeys(phoneno);
		EmailAddress.sendKeys(email);
		SaveBtn.click();
	}
}
