package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Baseclass;

public class ContactPage extends Baseclass {

	@FindBy(xpath = " //div[@class='ui header item mb5 light-black']")
	WebElement ContactsLabel;

	@FindBy(xpath = "//div[@class='item']/a/button[@class='ui linkedin button']")
	WebElement newContactLink;

	public ContactPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactLabel() {
		return ContactsLabel.isDisplayed();
	}

	public void selectContactByName(String name) {
		Actions actions = new Actions(driver);
		actions.moveToElement(
driver.findElement(By.xpath("//a[contains(text(),'" + name + "')]/parent::td/parent::tr"))).click().build().perform();
	}

	public NewContactPage clickOnCreateBtn() throws InterruptedException {
		newContactLink.click();
		return new NewContactPage();

	}

}
