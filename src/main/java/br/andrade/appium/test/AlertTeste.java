package br.andrade.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.andrade.appium.core.BaseTest;
import br.andrade.appium.page.AlertaPage;
import br.andrade.appium.page.MenuPage;


public class AlertTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AlertaPage page = new AlertaPage();
	
	@Before
	public void setup() {
		//acessar menu alerta
		menu.acessarAlertas();
	}
	
	@Test
	public void deveConfirmarAlerta() {
		//acessar menu alerta
		menu.acessarAlertas();
		
		
		//clicar em alerta confirm
		page.clicarAlertaConfirm();
		
		
		//verificar os textos
		Assert.assertEquals("Info", page.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?", page.obterMensagemAlerta());
		
		//confirmar alerta
		page.confirmar();
		
		//verificar nova mensagem
		//Assert.assertEquals("Confirmado", page.obterMensagemAlerta());
		
		//sair
		page.sair();
	}
	
	@Test
	public void deveClicarForaAlerta() {
		//clicar alerta simples
		page.clicarAlertaSimples();
		
		//clicar fora da caixa
		esperar(1000);
		page.clicarForaCaixa();
		//verificar que a mensagem não está presente
		Assert.assertFalse(page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
	}
	

}
