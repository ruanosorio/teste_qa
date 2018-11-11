package br.com.sicredi.testeQA.automatizado.tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import br.com.sicredi.testeQA.automatizado.steps.SimuladorInvestimentoPoupancaStep;
import br.com.sicredi.testeQA.automatizado.utils.WebDrivers;

/**
 * Classe de execução dos testes para validação da página Simulador de INVESTIMENTO - Poupança
 * @author Ruan Osorio
 * @since 10/11/2018
 *
 */

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "SimuladorInvestimentoPoupancaData.csv")
public class SimuladorInvestimentoPoupancaTest {

	private WebDriver navegador;

	@Before
	public void setUp() {
		navegador = WebDrivers.createChromeSimulInvestPoupanca();
	}

	@Test
	public void simuladorInvestimentoPoupancaPFTest(
			@Param(name = "valorAplicar") String valorAplicar, 
			@Param(name = "valorInvestir") String valorInvestir,
			@Param(name = "tempoPoupar") String tempoPoupar,
			@Param(name = "valorInvestimento") String valorInvestimento
	){
			new SimuladorInvestimentoPoupancaStep(navegador)
			.simuladorInvestimentoPoupancaPFStep(valorAplicar, valorInvestir, tempoPoupar, valorInvestimento);
	}

	@Test
	public void simuladorInvestimentoPoupancaPJTest(
			@Param(name = "valorAplicar") String valorAplicar,
			@Param(name = "valorInvestir") String valorInvestir,
			@Param(name = "tempoPoupar") String tempoPoupar,
			@Param(name = "valorInvestimento") String valorInvestimento
	){
		new SimuladorInvestimentoPoupancaStep(navegador)
				.simuladorInvestimentoPoupancaPJStep(valorAplicar, valorInvestir, tempoPoupar, valorInvestimento);
	}

	@Test
	public void simuladorInvestimentoPoupancaValidarCamposObrigatoriosTest(){
		new SimuladorInvestimentoPoupancaStep(navegador)
				.simuladorInvestimentoPoupancaValidarCamposObrigatoriosStep();
	}

	@Test
	public void simuladorInvestimentoPoupancaValidarValorNaoConfereTest(
			@Param(name = "valorAplicar") String valorAplicar,
			@Param(name = "valorInvestir") String valorInvestir,
			@Param(name = "tempoPoupar") String tempoPoupar
	){
		new SimuladorInvestimentoPoupancaStep(navegador)
				.simuladorInvestimentoPoupancaValidarValorNaoConfereStep(valorAplicar, valorInvestir, tempoPoupar);
	}


	@After
	public void tearDown() {
		navegador.quit();
	}

}
