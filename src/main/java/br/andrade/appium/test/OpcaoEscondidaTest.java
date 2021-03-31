package br.andrade.appium.test;

import org.junit.Assert;
import org.junit.Test;import org.openqa.selenium.By;

import br.andrade.appium.core.BaseTest;
import br.andrade.appium.page.MenuPage;

public class OpcaoEscondidaTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	
	@Test
	public void deveEncontrarOpcaoEscondida() {
		//scroll down
		menu.scrollDown();
		
		//clicar menu
		menu.clicarPorTexto("Opção bem escondida");
		
		//verificar mensagem
		Assert.assertEquals("Você achou essa opção", menu.obterMensagemAlerta());
		
		//sair
		menu.clicarPorTexto("OK");
	}
}
