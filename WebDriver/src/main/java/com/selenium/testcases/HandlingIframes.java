package com.selenium.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingIframes {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.ebay.com/");
		driver.manage().window().maximize();
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(driver.findElement(By.id("rtm_iframe_226")));
		
		driver.findElement(By.tagName("img")).click();
		
	}
}
