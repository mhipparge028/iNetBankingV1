package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void LoginTest() throws IOException, InterruptedException 
	{
		
		logger.info("URL is opened");
		driver.manage().window().maximize();
		
		LoginPage lp= new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.ClickSubmit();
		
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage123"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test passe");
		}
		else
		{
			CaptureScreenshot(driver, "LoginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
	}

}
