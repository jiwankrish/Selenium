package com.test.Session4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
WebDriver driver;
	
	@BeforeTest
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void createAccount() {
		// Login
		WebElement EMAIL = driver.findElement(By.xpath("//input[@id='email']"));
		WebElement PASSWORD = driver.findElement(By.xpath("//input[@id='u_0_w']"));
		
		// Create Account
		WebElement FIRST_NAME = driver.findElement(By.xpath("//input[@id='u_0_m']"));
		WebElement LAST_NAME = driver.findElement(By.xpath("//input[@id='u_0_o']"));
		WebElement PHONE_NUMBER = driver.findElement(By.xpath("//input[@id='u_0_r']"));
		WebElement NEW_PASSWORD = driver.findElement(By.xpath("//input[@id='u_0_w']"));
		WebElement DOB_MONTH = driver.findElement(By.xpath("//select[@id='month']"));
		WebElement DOB_DAY = driver.findElement(By.xpath("//select[@id='day']"));
		WebElement DOB_YEAR = driver.findElement(By.xpath("//select[@id='year']"));
		WebElement GENDER = driver.findElement(By.xpath("//span[@id='u_0_z']/span[1]/label"));
		WebElement SIGNUP = driver.findElement(By.xpath("//button[@id='u_0_13']"));
		
		Select selMonth = new Select(DOB_MONTH);
		Select selDay = new Select(DOB_DAY);
		Select selYear = new Select(DOB_YEAR);
		
		//sel.selectByVisibleText("Jan");  // This will help to select by the exact text
		
		 FIRST_NAME.sendKeys("Krishna"); 
		 LAST_NAME.sendKeys("Ghimire");
		 PHONE_NUMBER.sendKeys("773-847-3388");
		 NEW_PASSWORD.sendKeys("Test@123");
		 
		 selMonth.selectByIndex(7); // This is to use select based on index in the list. For months it will be 1=Jan, 2=Feb so on..
		 selDay.selectByIndex(15);
		 selYear.selectByVisibleText("1935");
		 		 
		 GENDER.click();
		 SIGNUP.click();	
	}

}
