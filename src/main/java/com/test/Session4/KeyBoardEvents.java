package com.test.Session4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardEvents {
	WebDriver driver;
	@BeforeTest
    public void launchBrowser() {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();    	
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	
    	driver.get("http://techfios.com/test/billing/?ng=login/");
    }
	
	@Test(priority=1)
	public void testKBEvents() {
		By userName = By.xpath("//input[@id='username']");
		By passWord = By.xpath("//input[@id='password']");
		
		driver.findElement(userName).sendKeys("");	
		driver.findElement(passWord).sendKeys("");		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
	}
	
	@Test(priority=2)
	public void login() {
		//Collecting elements
		By userName = By.xpath("//input[@id='username']");
		By passWord = By.xpath("//input[@id='password']");
		By SignIn = By.name("login");
		
		//Executing actions
		driver.findElement(userName).sendKeys("techfiosdemo@gmail.com");	
		driver.findElement(passWord).sendKeys("abc123");		
		driver.findElement(SignIn).click();
	}
}
