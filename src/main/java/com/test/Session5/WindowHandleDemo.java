package com.test.Session5;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandleDemo {
	WebDriver driver;
	@BeforeTest
    public void launchBrowser() {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();    	
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	
    	driver.get("https://www.yahoo.com/");
    }
	
	@Test
	public void testWhandle() throws InterruptedException {
		//Collecting Elements
		WebDriverWait wait = new WebDriverWait(driver,300);
		By searchSpace = By.xpath("//input[@id='header-search-input']");		
		driver.findElement(searchSpace).sendKeys("XPath");
		
		//Creating new object for keyboard actions
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).build().perform();
		
		//Collecting element
		By w3School =By.linkText("XPath Tutorial - W3Schools");
		
		//Adding explicit wait until it find the element and the element is clickable, It will wait upto 30 seconds before it moves forward
		wait.until(ExpectedConditions.elementToBeClickable(w3School));
		
		//Now click the link now
		driver.findElement(w3School).click();
		
		//Saving window handles in a Array set
		Set<String> wh = driver.getWindowHandles();
		for(String i : wh) {
			driver.switchTo().window(i);
		}
		
		//Now on the new window
		By cssLink = By.linkText("CSS");
		wait.until(ExpectedConditions.elementToBeClickable(cssLink));
		driver.findElement(cssLink).click();
	}

}
