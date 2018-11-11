package br.com.sicredi.testeQA.automatizado.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Classe para criação dos WebDrivers
 * 
 * @author Ruan Osorio 
 * @since 10/11/2018
 *
 */

public class WebDrivers {

	public static WebDriver createChromeSimulInvestPoupanca() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver\\chromedriver.exe");
		WebDriver navegador = new ChromeDriver();
		navegador.manage().window().maximize();
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		navegador.navigate().to("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");

		return navegador;

	}

}