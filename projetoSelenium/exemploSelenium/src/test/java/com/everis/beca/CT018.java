package com.everis.beca;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CT018 {
	static WebDriver navegador;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\psantoma\\drivers\\chromedriver.exe");
		navegador = new ChromeDriver();
		navegador.manage().window().maximize();
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		navegador.get("https://www.webmotors.com.br/");
	}

	@Test
	public void fazerLoginGoogle() {

		navegador.findElement(By.cssSelector(".Menu-User__login > p")).click();
		navegador.findElement(By.id("userLoginRegister")).click();
		navegador.findElement(By.xpath("/html/body/div[1]/div/main/section/div/div/form[1]/div[4]/div/button[2]"))
				.click();

	}
	
	@After

	public void takeScreenshot() throws IOException {
		SimpleDateFormat formatoDeData = new SimpleDateFormat("yyyyMMdd-HHmmss-SSSS");
		String fileName = formatoDeData.format(new Date());
		String shotName = String.format("%s.png", fileName);
		File finalShotFile = new File(
				"C:\\Users\\psantoma\\OneDrive - everis\\Escritorio\\Treinamento Beca\\projetoSelenium\\exemploSelenium\\Screenshots-WebMotors",
				shotName);
		File shotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(shotFile, finalShotFile);
	}


	@AfterClass
	public static void quitDriver() {
		navegador.quit();
	}

}