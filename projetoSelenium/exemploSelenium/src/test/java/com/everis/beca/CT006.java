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

public class CT006 {
	
	static WebDriver driver;
	public WebElement pesquisar;
	
	@BeforeClass
	public static void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void ct006() {
		driver.manage().window().maximize();
		driver.get("https://www.webmotors.com.br/carros/estoque/volkswagen/up?estadocidade=estoque&marca1=VOLKSWAGEN&modelo1=UP&idcmpint=t1:c17:m07:webmotors:modelo::volkswagen%20up&autocomplete=Volkswagen%20Up");
		
	}
	@Test
	public void validarCamposBusca() {
		String[] elementosCampos = {"Localização", "O que é interessante pra você? ", "Marca do carro", "Carros", "Preço", "Quilometragem","Vendedor","Opcionais","Câmbio","Combustí­vel","Final da Placa","Blindagem ","Cores","Carroceria","Categoria","Ofertas","Características","Apenas anúncios com foto ","Limpar filtros"};

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

