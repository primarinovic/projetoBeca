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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CT005 {
	
	static WebDriver driver;
	public WebElement pesquisar;
	@BeforeClass
	public static void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
	}

	@Test
	public void ct005() {
		driver.manage().window().maximize();
		driver.get("https://www.webmotors.com.br/");
	}
	
	@Test
	public void testaBusca() {
	By locatorPesquisa = By.xpath("/html/body/div/main/div[2]/div/div[1]/div[2]/div/div/div/div/input");
	WebElement pesquisa = driver.findElement(locatorPesquisa);
	pesquisa.sendKeys("Volkswagen UP");
	if(driver.getPageSource().contains("Volkswagen UP")) {
	By locatorResultado = By.xpath("/html/body/div/main/div[2]/div/div[1]/div[2]/div/div/div/div/div/div/a/div[2]");
	WebDriverWait wait = new WebDriverWait(driver,15);
	wait.until(ExpectedConditions.elementToBeClickable(locatorResultado));
	WebElement resultado = driver.findElement(locatorResultado);
	resultado.click();
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
