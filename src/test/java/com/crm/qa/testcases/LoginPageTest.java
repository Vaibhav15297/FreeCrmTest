package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		 loginpage=new LoginPage();
	}

	@Test(priority=1)
	public void LoginPageTitleTest()
	{
		String title=loginpage.validateLoginPageTitle();
		Assert.assertEquals(title,"Free CRM  - CRM software for customer relationship management, sales, and support.","test case is not match");
		
	}
	@Test(priority=2)
	public void crmLogoImageTest()
	{
		boolean flag=loginpage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void LoginTest()
	{
		homepage=loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	public void tearDown()
	{
		driver.quit();
	}
}
