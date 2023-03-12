package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Utils.TestUtils;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TestUtils testUtil;
	ContactsPage contactpage;
	
	public HomePageTest()
	{
		super();
	}
	//TestCases  should be separated--->independent with each other
	//before each testcases---> lauch browser and login
	//@test--excuted test cases
	//Aafer each test cases-->close the browser
	@BeforeMethod
	public void setUp()
	{
		initialization();
		testUtil=new TestUtils();
		loginpage=new LoginPage();
		contactpage=new ContactsPage();
		homepage=loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
	}
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle=homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"CRMPRO","home page title Not match" );
	}
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		 testUtil.switchToFrame();
		 Assert.assertTrue(homepage.verifyCorrectUserName());
	}
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
		testUtil.switchToFrame();
		contactpage=homepage.clickOnContactLink();
		
	}
	
	
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	
	

}
