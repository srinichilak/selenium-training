package com.selenium.testcases;

import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropDowns {
WebDriver driver = new ChromeDriver();
@Before
public void setup()
{
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
}
	
@Test
public void testDropDowns()
{
	//even though i specified wait time it is not waiting for every action
	//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	driver.findElement(By.linkText("Having trouble?")).click();
	driver.navigate().back();
	WebElement firstName = driver.findElement(By.xpath("//input[@id='u_0_1']"));
	firstName.clear();
	firstName.sendKeys("srinivas");
	//input[@id='u_0_3']
	WebElement lastName = driver.findElement(By.xpath("//input[@id='u_0_3']"));
	lastName.clear();
	lastName.sendKeys("chilakapati");
	//input[@id='u_0_6']
	WebElement email = driver.findElement(By.xpath("//input[@id='u_0_6']"));
	email.clear();
	email.sendKeys("srinivas.chilakapati11@gmail.com");
	
	WebElement emailVerification = driver.findElement(By.xpath("//input[@id='u_0_9']"));
	emailVerification.clear();
	emailVerification.sendKeys("srinivas.chilakapati11@gmail.com");
	
	WebElement newPassword = driver.findElement(By.xpath("//input[@id='u_0_b']"));
	newPassword.clear();
	newPassword.sendKeys("srinivasc");
	
	Select selectingByValue = new Select(driver.findElement(By.id("month")));
	selectingByValue.selectByValue("11");
	
	Select selectingByIndex = new Select(driver.findElement(By.id("day")));
	selectingByIndex.selectByIndex(28);
	
	Select selectingByText = new Select(driver.findElement(By.id("year")));
	selectingByText.selectByVisibleText("1991");
	
	driver.findElement(By.id("u_0_f")).click();
	//Robot rb = new Robot();
	if (driver.findElement((By.id("u_0_f"))).isSelected()== true)
	{
		driver.findElement(By.id("u_0_j")).click();
	    driver.switchTo().alert().accept();
	    
	}
	else
		System.out.println("gender is not selected");
	
	
}
	
@After
public void tearDown(){
	
}
}
