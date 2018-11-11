package br.com.sicredi.testeQA.automatizado.pages;

import br.com.sicredi.testeQA.automatizado.utils.Constantes;
import org.openqa.selenium.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Classe contem os elementos da página Simulador de INVESTIMENTO - Poupança
 * @author Ruan Osorio 
 * @since 10/11/2018
 *
 */

public class SimuladorInvestimentoPoupancaPage {
	protected WebDriver navegador;

	public SimuladorInvestimentoPoupancaPage(WebDriver navegador) {
		this.navegador = navegador;
	}
	
	protected SimuladorInvestimentoPoupancaPage clicarRadioPraVoce() {
        navegador.findElement(By.xpath("//*[@value=\"paraVoce\"]")).click();
        return this;
    }
	
	protected SimuladorInvestimentoPoupancaPage clicarRadioPraEmpresa() {
        navegador.findElement(By.xpath("//*[@value=\"paraEmpresa\"]")).click();
        return this;
    }
	
	protected SimuladorInvestimentoPoupancaPage inserirValorAplicar(String valorAplicar){
        navegador.findElement(By.id("valorAplicar")).sendKeys(valorAplicar);
        return this;
	}
	
	protected SimuladorInvestimentoPoupancaPage inserirValorInvestir(String valorInvestir){
        navegador.findElement(By.id("valorInvestir")).sendKeys(valorInvestir);
        return this;
	}
	
	protected SimuladorInvestimentoPoupancaPage inserirTempoPoupar(String tempoPoupar){
        navegador.findElement(By.id("tempo")).sendKeys(tempoPoupar);
        return this;
	}
	
	protected SimuladorInvestimentoPoupancaPage selecionarComboPeriodoAnos(){
        navegador.findElement(By.xpath("//a[@class=\"btSelect\"]")).click();
        WebElement element = navegador.findElement(By.xpath("//*[@id=\"formInvestimento\"]//li/a[contains(text(), 'Anos')]"));
        JavascriptExecutor executor = (JavascriptExecutor)navegador;
        executor.executeScript("arguments[0].click()", element);
        return this;
	}

	protected void clicarBtnSimular(){
		navegador.findElement(By.xpath("//button[@class=\"btn btnAmarelo btnSimular\"]")).click();
	}

    protected String esperaPageTitle() {
        new WebDriverWait(navegador, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h2[@class=\"sessaoTitulo\"]")));
        return navegador.findElement(By.xpath("//h2[@class=\"sessaoTitulo\"]")).getAttribute("innerHTML");
    }

    protected void esperaFormularioBloco() {
        new WebDriverWait(navegador, 30).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=\"conteudoGeral conteudoGeralCompleto clearfix\"]")));
    }

    protected void assertValidaTextoGuardado(String texto){
        String message = navegador.findElement(By.xpath("//span[@class=\"texto\"]")).getText();
        Assert.assertEquals(texto, message);
    }

    protected void assertValidaValorInvestimento(String valorInvestimento){
        String message = navegador.findElement(By.xpath("//span[@class=\"valor\"]")).getText();
        Assert.assertEquals(valorInvestimento, message);
    }

    protected void assertMensagemErroCampoValorAplicar(){
        String message = navegador.findElement(By.xpath("//label[@id=\"valorAplicar-error\"]")).getText();
        Assert.assertEquals(Constantes.MINIMO_VALOR, message);
    }

    protected void assertMensagemErroCampoValorInvestir(){
        String message = navegador.findElement(By.xpath("//label[@id=\"valorInvestir-error\"]")).getText();
        Assert.assertEquals(Constantes.MINIMO_VALOR, message);
    }

    protected void assertMensagemErroCampoTempoObrigatorio() {
        String message = navegador.findElement(By.xpath("//label[@id=\"tempo-error\"]")).getText();
        Assert.assertEquals(Constantes.CAMPO_OBRIGATORIO, message);
    }

    protected void assertMensagemErroCampoTempoValorNaoConfere() {
        String message = navegador.findElement(By.xpath("//label[@id=\"tempo-error\"]")).getText();
        Assert.assertEquals(Constantes.VALOR_ESPERADO_NAO_CONFERE, message);
    }

    protected void assertValidaTabelaExiste(){
        Assert.assertTrue(navegador.findElement(By.xpath("//table//th[contains(text(), 'Tempo (Meses)')]")).isEnabled());
        Assert.assertTrue(navegador.findElement(By.xpath("//table//th[contains(text(), 'Valor')]")).isEnabled());

    }

}
