package com.selenium.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SeleniumTest {
WebDriver driver = new FirefoxDriver();

public void geturl()
{
	driver.get("https://www.google.com");
	By bySearchBox = By.id("lst-ib");
	By bySearchButton = By.xpath("//button[@class='lsb' and @name='btnG']");
	By byTag = By.tagName("input");
	WebElement searchBox = driver.findElement(bySearchBox);
	List<WebElement> tags = driver.findElements(byTag);
	WebElement searchButton = driver.findElement(bySearchButton);
	searchBox.sendKeys("youtube");
	searchButton.click();
	
//	driver.close();
//	driver = new ChromeDriver();
//	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//	driver.get("https://www.google.com");
//	By bySearchBox = By.id("lst-ib");
//	WebElement searchBox = driver.findElement(bySearchBox);
//	searchBox.sendKeys("youtube");
//	driver.close();
//	driver = new InternetExplorerDriver();
//	System.setProperty("webdriver.ie.driver","IEDriverServer.exe");
//	driver.get("https://www.google.com");
//	driver.quit();
}
public static void main(String[] args) {
	SeleniumTest obj = new SeleniumTest();
	obj.geturl();
}
}
