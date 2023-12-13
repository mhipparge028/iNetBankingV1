package com.inetbanking.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandlingIframe {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\New Software\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
		co.setBinary("D:\\New Software\\chrome-win64\\chrome-win64\\chrome.exe");
		
		WebDriver driver =new ChromeDriver(co);
		driver.get("https://demo.guru99.com/v4/");
		driver.manage().window().maximize();
		driver.findElement(By.name("uid")).sendKeys("mngr540071");
		driver.findElement(By.name("password")).sendKeys("EnEgEzA");
		driver.findElement(By.name("btnLogin")).click();
		
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		Thread.sleep(3000);
		driver.switchTo().frame("//iframe[contains(@id,'google_ads_iframe')]");
		Thread.sleep(3000);
		driver.switchTo().frame("//iframe[@id='ad_iframe']"); //iframe[@id='ad_iframe']
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
	}

}
