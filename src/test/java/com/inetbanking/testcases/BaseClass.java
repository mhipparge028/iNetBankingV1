package com.inetbanking.testcases;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	public String baseurl=readconfig.getApplicationUrl();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void Setup(String br) {
		
		logger= Logger.getLogger("ebanking");
		//PropertyConfigurator.configure("log4j.properties");
		DOMConfigurator.configure("log4j.xml");
		
		if(br.equals("chrome"))
		{
		System.setProperty("Webdriver.chrome.driver", readconfig.getChromepath());
		ChromeOptions co=new ChromeOptions();
		co.setBinary("D:\\New Software\\chrome-win64\\chrome-win64\\chrome.exe");
		driver= new ChromeDriver(co);
		}
		else if(br.equals("firefox")) {
			System.setProperty("Webdriver.gecko.driver", readconfig.getFirefoxpath());
			FirefoxOptions fo=new FirefoxOptions();
			fo.setBinary("D:\\New Software\\chrome-win64\\chrome-win64\\chrome.exe");
			driver= new FirefoxDriver(fo);
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseurl);
	}
	
	@AfterClass
//	public void teardown() {
//		driver.quit();
//	}
	
	public void CaptureScreenshot(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
		
	}
	
	public String randomstring()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
	    return(generatedString);
	}
	
	public static String randomNum()
	{
		String generatedString2=RandomStringUtils.randomNumeric(5);
	    return(generatedString2);
	}
	
}
