package com.test.Session6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;
	@BeforeTest
    public void launchBrowser() {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();    	
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	
    	driver.get("https://www.dell.com/en-us");
    }
	
	public void testCommit() {
		driver.findElement(By.xpath(""));
		driver.findElement(By.className(""));
		driver.findElement(By.id(""));
	}
	
	public void testMerge() {
		//Thank You
		//Thank You
	}

}
