package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Utils.TestUtils;
import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase  {
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signup;
	////a[contains(text(),'Sign Up')]
	
	@FindBy(xpath="(//img[contains(@class,'img-responsive')])[1]")
	WebElement crmlogo;
	
	//initializaing the page object
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
		
	//Actions	
	}
	public String validateLoginPageTitle()
	{
		//driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT,TimeUnit.SECONDS);
		return driver.getTitle();
	}
	
	public boolean validateCRMImage()
	{
		return crmlogo.isDisplayed();
	}
	public HomePage Login(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		 return new HomePage();
		 
	}
	
	

}
