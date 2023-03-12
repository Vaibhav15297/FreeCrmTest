package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.Utils.TestUtils;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
	TestUtils testUtil;
	
	String sheetName="contacts";
	
	public ContactsPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initialization();
		testUtil=new TestUtils();
		loginpage=new LoginPage();
		contactpage=new ContactsPage();
		homepage=loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
		testUtil.switchToFrame();
		//contactpage=homepage.clickOnContactLink();
		
		
		
	}
	@Test(priority=1)
	public void verifyContactsPageLabel()
	{
		Assert.assertTrue(contactpage.verifyContactLabel());
	}
	@Test(priority=2)
	public void selectContactsTest()
	{
		contactpage.selectContacts("vaibhav kothewar");
	}
	@Test(priority=3,dataProvider="getCRMTestData")
	public void validateCreateNewContacts(String title,String firstName,String lastName,String company) throws InterruptedException
	{
		//testUtil.switchToFrame();
		homepage.clickOnNewContactLink();
		//contactpage.createNewContact("Mr.","Tom","Peter","Google");
		contactpage.createNewContact(title, firstName, lastName, company);
		
		
	}
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data [][]=TestUtils.getTestData(sheetName);
		return data;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
