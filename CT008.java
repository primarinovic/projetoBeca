package com.everis.beca;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CT008 {
	static WebDriver driver;
	public WebElement pesquisar;
	
	@BeforeClass
	public static void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void ct008() {
		driver.manage().window().maximize();
		driver.get("https://login.webmotors.com.br/?&r=https://www.webmotors.com.br&inst=header:webmotors::logar-ou-cadastrar");
		
	}
	@Test
	public void validarCamposBusca() {
		String[] elementosCampos = {"Nome e Sobrenome", "Digite seu e-mail", "Digite sua senha", "Exibir", "Criar conta", "Criar com facebook", "Criar com Google", "Cancelar"};

		 for (String elemento : elementosCampos) {
		driver.getPageSource().contains(elemento);
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
