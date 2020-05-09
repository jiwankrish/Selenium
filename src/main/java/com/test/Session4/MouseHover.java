package com.test.Session4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {
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
	public void testMouseHover() {
		Actions action = new Actions(driver);
		WebElement hoverProduct = driver.findElement(By.xpath("//button[@id='l1']"));
		WebElement hoverNetwork = driver.findElement(By.xpath("//a[@id='l1_5']/span"));
		WebElement hoverHomeNet = driver.findElement(By.xpath("//header[@id='dell-masthead']/div[3]/nav/ul/li[1]/ul/li[8]/ul/li[1]/a/span[1]"));
		
		action.moveToElement(hoverProduct).build().perform();
		action.moveToElement(hoverNetwork).build().perform();
		action.moveToElement(hoverHomeNet).build().perform();
	}

}
