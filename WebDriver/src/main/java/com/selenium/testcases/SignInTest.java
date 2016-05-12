package com.selenium.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInTest {

	WebDriver driver = new ChromeDriver();
	String appURL = "https://www.google.com";
	
	public void test() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String expectedPageTitle = "Google";
		String pageTitle = driver.getTitle();
		
		if (pageTitle.equals(expectedPageTitle)){
		driver.manage().window().maximize();
		WebElement signInLink = driver.findElement(By.linkText("Sign in"));
		signInLink.click();
		
		WebElement inputEmail = driver.findElement(By.id("Email"));
		inputEmail.clear();
		inputEmail.sendKeys("srinivas.chilaka29");
		
		WebElement inputNext = driver.findElement(By.id("next"));
		inputNext.click();
		//Thread.sleep(3000);
		
		//implicit wait:
	    //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//explicit wait:
		Wait<WebDriver> wait = new WebDriverWait(driver, 3).pollingEvery(1, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Passwd']")));
		
		WebElement inputPassword = driver.findElement(By.xpath("//input[@id='Passwd']"));
		//inputPassword.clear();
		inputPassword.sendKeys("gmail2911");
		
		WebElement signInButton = driver.findElement(By.id("signIn"));
		signInButton.click();
		}
		else
		{
			System.out.println("Page title verification failed");
		    driver.switchTo().alert();
			driver.close();
		    
		}
		System.exit(0);
	}
	
	public static void main(String[] args) throws InterruptedException {
		SignInTest obj = new SignInTest();
		obj.test();
	}
	
}
