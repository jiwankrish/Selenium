package com.test.Session4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IframeDemo {
	WebDriver driver;
	@BeforeTest
    public void launchBrowser() {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
    	
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	
    	driver.get("https://docs.oracle.com/javase/8/docs/api/index.html");
    }
	
	@Test
	public void testIframe() throws InterruptedException {
		Thread.sleep(3000);
		driver.switchTo().frame("packageListFrame")	;
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("java.applet")).click();		
		
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.switchTo().frame("classFrame");
		System.out.println(driver.getTitle());		
		driver.findElement(By.linkText("compact1")).click();
		
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.switchTo().frame("packageFrame");
		System.out.println(driver.getTitle());		
		driver.findElement(By.linkText("AppletContext")).click();
		
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.switchTo().frame("packageListFrame")	;
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("java.awt")).click();		
	}
	
}
