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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CT007 {
	
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
		driver.get("https://www.webmotors.com.br/carros/estoque/volkswagen/up?estadocidade=estoque&marca1=VOLKSWAGEN&modelo1=UP&idcmpint=t1:c17:m07:webmotors:modelo::volkswagen%20up&autocomplete=Volkswagen%20Up");
	}
	
		@Test
		  public void untitled() {
		    driver.get("https://www.webmotors.com.br/carros/estoque/volkswagen/up?estadocidade=estoque&marca1=VOLKSWAGEN&modelo1=UP&idcmpint=t1:c17:m07:webmotors:modelo::volkswagen%20up&autocomplete=Volkswagen%20Up");
			driver.manage().window().maximize();

		    {
		      WebElement element = driver.findElement(By.id("FilterAdvanced"));
		      Actions builder = new Actions(driver);
		      builder.moveToElement(element).perform();
		    }
		    driver.findElement(By.id("FilterAdvanced")).click();
		    {
		      WebElement element = driver.findElement(By.tagName("body"));
		      Actions builder = new Actions(driver);
		      builder.moveToElement(element, 0, 0).perform();
		    }
		    driver.findElement(By.cssSelector(".btn-option")).click();
		    {
		      WebElement element = driver.findElement(By.cssSelector(".btn-option"));
		      Actions builder = new Actions(driver);
		      builder.moveToElement(element).perform();
		    }
		    {
		      WebElement element = driver.findElement(By.tagName("body"));
		      Actions builder = new Actions(driver);
		      builder.moveToElement(element, 0, 0).perform();
		    }
		    driver.findElement(By.id("FilterOrderList")).click();
		    {
		      WebElement dropdown = driver.findElement(By.id("FilterOrderList"));
		      dropdown.findElement(By.xpath("//option[. = 'Maior preço']")).click();
		    }
		    driver.findElement(By.id("FilterOrderList")).click();
		    {
		      WebElement element = driver.findElement(By.id("FilterAdvanced"));
		      Actions builder = new Actions(driver);
		      builder.moveToElement(element).perform();
		    }
		    driver.findElement(By.id("FilterAdvanced")).click();
		    {
		      WebElement element = driver.findElement(By.tagName("body"));
		      Actions builder = new Actions(driver);
		      builder.moveToElement(element, 0, 0).perform();
		    }
		  }
	
		public void takeScreenshot() throws IOException {
			SimpleDateFormat formatoDeData = new SimpleDateFormat("yyyyMMdd-HHmmss-SSSS");
			String fileName = formatoDeData.format(new Date());
			String shotName = String.format("%s.png", fileName);
			File finalShotFile = new File("C:\\Selenium\\exemploSelenium\\screenshots",shotName);
			File shotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(shotFile, finalShotFile);
		}
		
	@AfterClass
	public static void quitDriver() {
		driver.quit();
	}
	
}
