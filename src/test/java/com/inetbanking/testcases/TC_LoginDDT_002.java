package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void LoginDDT(String usr, String pwd) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(usr);
		logger.info("Username is entered");
		lp.setPassword(pwd);
		logger.info("Username is entered");
		lp.ClickSubmit();
		
		Thread.sleep(3000);
		
		if(IsAlertPresent()==true)
		{
			driver.switchTo().alert().accept(); // Close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			logger.warn("Login failed");
		}
		else
		{
		      Assert.assertTrue(true);
		      logger.info("Login passed");
		      lp.ClickLogout();
		      Thread.sleep(3000);
		      driver.switchTo().alert().accept(); // close logout alert
		      driver.switchTo().defaultContent();
		}
	}
	
	public boolean IsAlertPresent() //user defined method created to check alert is present or not
	{
		try 
		{
			driver.switchTo().alert();
			return true;
		} 
		catch (NoAlertPresentException e) 
		{
			return false;
		}
	}

	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		//int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][] = new String[rownum][colcount];
		
		for(int i=1; i<=rownum; i++){
			{
				for(int j=0; j<colcount; j++)
				{
					loginData[i-1][j]= XLUtils.getCellData(path, "Sheet1", i, j); //1 0
				}
			}
		}
		return loginData;
	}
	
}
