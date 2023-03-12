package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	//vaibhav kothewar
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
	
	@FindBy(xpath="//input[@id=\"first_name\"]")
	WebElement fristname;
	
	@FindBy(xpath="//input[@id=\"surname\"]")
	WebElement lastname;
	
	@FindBy(xpath="//input[@name=\"client_lookup\"]")
	WebElement company;
	
	@FindBy(xpath="//input[@value='Load From Company']//following-sibling::input[1]")
	WebElement saveBtn;
	
	
	public ContactsPage()
	{
		PageFactory.initElements(driver,this);
	}
	public boolean verifyContactLabel()
	{
		return contactslabel.isDisplayed();
	}
	public void selectContacts(String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td")).click();
		
	}
	public void createNewContact(String title,String ftname,String ltname,String com)
	{
		Select select=new Select(driver.findElement(By.xpath("//select[@name=\"title\"]")));
		select.selectByVisibleText(title);
		
		fristname.sendKeys(ftname);
		lastname.sendKeys(ltname);
		company.sendKeys(com);
		saveBtn.click();
		
		
		
		
		
		
	}

}
