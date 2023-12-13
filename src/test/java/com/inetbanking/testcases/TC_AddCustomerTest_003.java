package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void AddNewCustomer() throws InterruptedException, IOException
	{
		logger.info("URL is opened");
		driver.manage().window().maximize();
		
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username is provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.ClickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.ClickAddNewCustomer();
		
		addcust.CloseAdvertisement(driver);
		
		
		
		logger.info("provided customer details...");
		addcust.custName("Mahesh");
		addcust.custGender("male");
		addcust.custdob("11", "08", "1996");
		Thread.sleep(3000);
		addcust.custAddress("INDIA");
		addcust.custcity("HYD");
		addcust.custState("MH");
		addcust.custpinno("402585");
		addcust.custtelephono("8523365245");
		
		String email = randomstring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		logger.info("Validation started..");
		boolean res= driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			logger.info("Test case is passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Test case is failed");
			CaptureScreenshot(driver, "AddNewCustomer");
			Assert.assertTrue(false);
		}
	}
	
}
