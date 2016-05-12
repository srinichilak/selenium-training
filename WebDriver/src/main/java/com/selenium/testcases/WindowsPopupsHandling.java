package com.selenium.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class WindowsPopupsHandling {
	WebDriver driver = new ChromeDriver();
	@Before
	public void setUp()
	{
		driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1");
	    driver.manage().window().maximize();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test()
	{
		String pageTitle =   driver.getTitle();
		String expectedPageTitle = "Gmail";
	//	Assert.assertEquals(expectedPageTitle, mpageTitle);
		WebElement email = driver.findElement(By.id("Email"));
		email.sendKeys("srinivas.qualitytesting");
	   // driver.findElement(By.xpath("//img[@id='account-image-0']")).click();
	    driver.findElement(By.id("next")).click();
		Wait<WebDriver> wait = new WebDriverWait(driver, 50).pollingEvery(1, TimeUnit.SECONDS);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
	    WebElement password = driver.findElement(By.id("Passwd"));
	    password.sendKeys("selenium");
	    driver.findElement(By.id("signIn")).click();
	  //  Wait<WebDriver> wait = new WebDriverWait(driver, 50).pollingEvery(1, TimeUnit.SECONDS);
	    wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//div[@class='z0']//div[contains(text(),'COMPOSE')]")));
	    driver.findElement(By.xpath("//div[@class='z0']//div[contains(text(),'COMPOSE')]")).click();
	    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']")).click();
	    
	    try {
			Robot robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	
}
