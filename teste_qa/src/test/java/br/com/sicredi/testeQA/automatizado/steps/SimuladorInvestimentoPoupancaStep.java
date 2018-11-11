package br.com.sicredi.testeQA.automatizado.steps;

import org.openqa.selenium.WebDriver;
import br.com.sicredi.testeQA.automatizado.pages.SimuladorInvestimentoPoupancaPage;
import br.com.sicredi.testeQA.automatizado.utils.Constantes;


/**
 * Classe contem os passos dos testes para validação da página Simulador de INVESTIMENTO - Poupança
 * @author Ruan Osorio
 * @since 10/11/2018
 *
 */

public class SimuladorInvestimentoPoupancaStep extends SimuladorInvestimentoPoupancaPage{

	public SimuladorInvestimentoPoupancaStep(WebDriver navegador) {
		super(navegador);
	}
	
	public void simuladorInvestimentoPoupancaPFStep(String valorAplicar, String valorInvestir, String tempoPoupar, String valorInvestimento){
		esperaPageTitle();
		esperaFormularioBloco();
		System.out.println(Constantes.PAGINA_CARREGADA_COM_SUCESSO);
		inserirValorAplicar(valorAplicar);
		inserirValorInvestir(valorInvestir);
		inserirTempoPoupar(tempoPoupar);
		clicarBtnSimular();
		esperaPageTitle();
		esperaFormularioBloco();
		assertValidaTextoGuardado(Constantes.TEXTO_12_MESES);
		assertValidaValorInvestimento(valorInvestimento);
		assertValidaTabelaExiste();
		System.out.println(Constantes.ASSERTS_OK);
	}

	public void simuladorInvestimentoPoupancaPJStep(String valorAplicar, String valorInvestir, String tempoPoupar, String valorInvestimento) {
		esperaPageTitle();
		esperaFormularioBloco();
		System.out.println(Constantes.PAGINA_CARREGADA_COM_SUCESSO);
		clicarRadioPraEmpresa();
		inserirValorAplicar(valorAplicar);
		inserirValorInvestir(valorInvestir);
		inserirTempoPoupar(tempoPoupar);
		selecionarComboPeriodoAnos();
		clicarBtnSimular();
		esperaPageTitle();
		esperaFormularioBloco();
		assertValidaTextoGuardado(Constantes.TEXTO_60_MESES);
		assertValidaValorInvestimento(valorInvestimento);
		assertValidaTabelaExiste();
		System.out.println(Constantes.ASSERTS_OK);
	}

	public void simuladorInvestimentoPoupancaValidarCamposObrigatoriosStep(){
		esperaPageTitle();
		esperaFormularioBloco();
		System.out.println(Constantes.PAGINA_CARREGADA_COM_SUCESSO);
		clicarBtnSimular();
		assertMensagemErroCampoValorAplicar();
		assertMensagemErroCampoValorInvestir();
		assertMensagemErroCampoTempoObrigatorio();
		System.out.println(Constantes.ASSERTS_OK);
	}

	public void simuladorInvestimentoPoupancaValidarValorNaoConfereStep(String valorAplicar, String valorInvestir, String tempoPoupar) {
		esperaPageTitle();
		esperaFormularioBloco();
		System.out.println(Constantes.PAGINA_CARREGADA_COM_SUCESSO);
		inserirValorAplicar(valorAplicar);
		inserirValorInvestir(valorInvestir);
		inserirTempoPoupar(tempoPoupar);
		clicarBtnSimular();
		assertMensagemErroCampoValorAplicar();
		assertMensagemErroCampoValorInvestir();
		assertMensagemErroCampoTempoValorNaoConfere();
		System.out.println(Constantes.ASSERTS_OK);
	}

}
