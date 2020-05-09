package com.test.Session4;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseScroll {
	WebDriver driver;
	@BeforeTest
    public void launchBrowser() {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();    	
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	
    	driver.get("https://www.dell.com/en-us");
    }
	
	@Test
	public void testMouseScroll() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,200)");
		Thread.sleep(5000);
		js.executeScript("scroll(0,300)");
	}

}
