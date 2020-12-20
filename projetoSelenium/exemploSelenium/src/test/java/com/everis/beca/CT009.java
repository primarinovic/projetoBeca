package com.everis.beca;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CT009 {
	static WebDriver driver;
	public WebElement pesquisar;

	@BeforeClass
	public static void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void ct007() {
		driver.manage().window().maximize();
		driver.get("https://www.webmotors.com.br");
		driver.manage().window().maximize();
	    driver.findElement(By.cssSelector(".Menu-User__login > p")).click();
	    driver.findElement(By.id("userLoginRegister")).click();
	    driver.findElement(By.xpath("\"button\" id = \"btnNovaConta\" class = \"button button - new-account\"")).click();
	    driver.findElement(By.xpath("//*[@id=\"boxName\"]/div")).click();
	    driver.findElement(By.id("nome")).click();
	    driver.findElement(By.id("nome")).sendKeys("Jaqueline");
	    
	    }
	
	@AfterClass
	public static void quitDriver() {
		driver.quit();
	}
}
