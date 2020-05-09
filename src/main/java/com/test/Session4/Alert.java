package com.test.Session4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert 
{
	WebDriver driver;
	@BeforeTest
    public void launchBrowser() {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
    	
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	
    	driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
    }
    
   @Test
    public void testAlart() throws InterruptedException {
    	By signin= By.xpath("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/input[2]");    	
    	driver.findElement(signin).click();
    	
    	Thread.sleep(3000);    	
    	System.out.println(driver.switchTo().alert().getText()); //This is just to print the text in the alert window.
    	driver.switchTo().alert().accept();
    }
}
