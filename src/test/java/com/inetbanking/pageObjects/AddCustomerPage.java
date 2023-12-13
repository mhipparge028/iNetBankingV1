package com.inetbanking.pageObjects;

import java.awt.Frame;

import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	 WebDriver ldriver;
	 
	 public AddCustomerPage(WebDriver rdriver)
	 {
		 ldriver=rdriver;
		 PageFactory.initElements(rdriver, this);
	 }
	 
		@FindBy(how=How.XPATH, using = "//a[text()='New Customer']")
		@CacheLookup
		WebElement lnkAddNweCustomer;

		@FindBy(how=How.NAME, using = "name")
		@CacheLookup
		WebElement txtUserName;
		
		@FindBy(how=How.NAME, using = "rad1")
		@CacheLookup
		WebElement rdGender;
		
		@FindBy(how=How.ID_OR_NAME, using = "dob")
		@CacheLookup
		WebElement txtdob;
		
		@FindBy(how=How.NAME, using = "addr")
		@CacheLookup
		WebElement txtaddrs;
		
		@FindBy(how=How.NAME, using = "city")
		@CacheLookup
		WebElement txtcity;
		
		@FindBy(how=How.NAME, using = "state")
		@CacheLookup
		WebElement txtstate;
		
		@FindBy(how=How.NAME, using = "pinno")
		@CacheLookup
		WebElement txtpinno;
		
		@FindBy(how=How.NAME, using = "telephoneno")
		@CacheLookup
		WebElement txttelephoneno;
		
		@FindBy(how=How.NAME, using = "emailid")
		@CacheLookup
		WebElement txtemailid;
		
		@FindBy(how=How.NAME, using = "password")
		@CacheLookup
		WebElement txtpassword;
		
		@FindBy(how=How.NAME, using = "sub")
		@CacheLookup
		WebElement txtsubmit;
		
		@FindBy(how=How.XPATH, using = "//iframe[contains(@id,'google_ads_iframe')]")
		@CacheLookup
		WebElement parentframe;
		
		@FindBy(how=How.XPATH, using = "//iframe[@id='ad_iframe']")
		@CacheLookup
		WebElement childframe;
		
		@FindBy(how=How.NAME, using = "//div[@id='dismiss-button']")
		@CacheLookup
		WebElement closeadver;
		
		
		
		public void ClickAddNewCustomer()
		{
			lnkAddNweCustomer.click();
		}
		
		public void CloseAdvertisement(WebDriver driver) throws InterruptedException
		{
			Thread.sleep(3000);
			driver.switchTo().frame(parentframe); 
			Thread.sleep(3000);
			driver.switchTo().frame(childframe); //iframe[@id='ad_iframe']
			Thread.sleep(3000);
			
			closeadver.click();
	    }
		
		public void custName(String cname)
		{
			txtUserName.sendKeys(cname);
		}
		
		public void custGender(String cgender)
		{
			rdGender.click();	
		}
		
		public void custdob(String dd, String mm, String yy)
		{
			txtdob.sendKeys(dd);
			txtdob.sendKeys(mm);
			txtdob.sendKeys(yy);
		}
		
		public void custAddress(String caddress)
		{
			txtaddrs.sendKeys(caddress);
		}
		
		public void custcity(String ccity)
		{
			txtcity.sendKeys(ccity);
		}
		
		public void custState(String cstate)
		{
			txtstate.sendKeys(cstate);
		}
		
		public void custpinno(String cpinno)
		{
			txtpinno.sendKeys(String.valueOf(cpinno));
		}
		
		public void custtelephono(String ctelephono)
		{
			txttelephoneno.sendKeys(ctelephono);
		}
		
		public void custemailid(String cemailid)
		{
			txtemailid.sendKeys(cemailid);
		}
		
		public void custpassword(String cpassword)
		{
			txtpassword.sendKeys(cpassword);
		}
		
		public void custsubmit()
		{
			txtsubmit.click();
		}
		
}
