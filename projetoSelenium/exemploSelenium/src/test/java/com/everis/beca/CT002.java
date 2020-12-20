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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CT002 {
	static WebDriver navegador;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\psantoma\\drivers\\chromedriver.exe");
		navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		navegador.get("https://www.webmotors.com.br/");
	}

	@Test
	public void validarCategorias() {
		String[] elementosCamposCategorias = { "Sedans", "SUVs", "Frontier 2020", "Carros para família",
				"Carros a diesel", "Carros de luxo", "Carros econômicos", "Carros antigos", "Conversíveis",
				"Carros híbridos" };

		for (String elemento : elementosCamposCategorias) {
			navegador.getPageSource().contains(elemento);
		}
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
