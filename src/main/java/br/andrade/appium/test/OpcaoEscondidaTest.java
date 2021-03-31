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
		menu.clicarPorTexto("Op��o bem escondida");
		
		//verificar mensagem
		Assert.assertEquals("Voc� achou essa op��o", menu.obterMensagemAlerta());
		
		//sair
		menu.clicarPorTexto("OK");
	}
}
