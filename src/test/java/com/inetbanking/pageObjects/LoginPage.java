package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
    @FindBy(name="uid")
    @CacheLookup
	WebElement txtUsername;
    
    @FindBy(name="password")
    @CacheLookup
	WebElement txtPassword;
    
    @FindBy(name="btnLogin")
    @CacheLookup
	WebElement btnLogin;
    
    @FindBy(xpath="//a[text()='Log out']")
    @CacheLookup
	WebElement lnklogout;
    
    public void setUserName(String Username) {
    	txtUsername.sendKeys(Username);
    }
    
    public void setPassword(String Password) {
    	txtPassword.sendKeys(Password);
    }
    
    public void ClickSubmit() {
    	btnLogin.click();
    }
    
    public void ClickLogout()
    {
    	lnklogout.click(); 
    }
}
