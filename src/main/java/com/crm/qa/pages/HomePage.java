package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'vaibhav kothewar')]")
	@CacheLookup
	WebElement usernameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLinks;
	
	@FindBy(xpath="//a[@title=\"New Contact\"]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslinks;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLinks;
	
	
	
	//initializing the page object
	public HomePage()
	{
		PageFactory.initElements(driver,this);
		
	}
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	public ContactsPage clickOnContactLink()
	{
		
		contactsLinks.click();
		return new ContactsPage();
	}
	public DealsPage clickOnDealsLinks()
	{
		dealslinks.click();
		return new DealsPage();
	}
	public DealsPage clickOnTasksLinks()
	{
		tasksLinks.click();
		return new DealsPage();
	}
	public boolean verifyCorrectUserName()
	{
		return usernameLabel.isDisplayed();
	}
	public void clickOnNewContactLink() throws InterruptedException
	{
		
		Actions action=new Actions(driver);
		action.moveToElement(contactsLinks).perform();
		newContactLink.click();
		
		
		//action.moveToElement(newContactLink).click().build().perform();
		//newContactLink.click();
		//action.moveToElement(newContactLink).click().perform();
		
		
	}

}
