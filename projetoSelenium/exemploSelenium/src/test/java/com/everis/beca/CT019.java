package com.everis.beca;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CT019 {
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
	public void fazerLogin() {

		navegador.findElement(By.cssSelector(".Menu-User__login > p")).click();
		navegador.findElement(By.id("userLoginRegister")).click();

		WebElement formularioEmail = navegador
				.findElement(By.xpath("/html/body/div[1]/div/main/section/div/div/form[1]/div[2]/div/input"));
		formularioEmail.click();
		formularioEmail.sendKeys("folotasm@gmail.com");

		WebElement formularioSenha = navegador
				.findElement(By.xpath("/html/body/div[1]/div/main/section/div/div/form[1]/div[3]/div/input"));
		formularioSenha.click();
		formularioSenha.sendKeys("123456");

		navegador.findElement(By.id("btnEntrar")).click();

	}

	@Test
	public void acessarAlterarDados() {

		navegador.findElement(By.xpath("/html/body/div[1]/header/nav/div/ul/li[5]")).click();
		navegador.findElement(By.xpath("/html/body/div[1]/header/nav/div/ul/li[5]/div[2]/ul/li[3]")).click();

	}

	@Test
	public void confirmarPaginaDeAlteracao() {

		String[] elementosAlterar = { "Editar meu perfil", "Dados pessoais", "Sexo*", "Endereço e contato",
				"Exibir meu telefone no anúncio" };

		for (String elemento : elementosAlterar) {
			navegador.getPageSource().contains(elemento);
		}
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}
	
	@Test
	public void alterarTel() {
		
		navegador.findElement(By.linkText("Sexo*")).click();
		
	}
}
