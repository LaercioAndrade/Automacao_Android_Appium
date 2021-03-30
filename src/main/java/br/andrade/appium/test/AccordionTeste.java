package br.andrade.appium.test;

import org.junit.Test;

import br.andrade.appium.core.BaseTest;
import br.andrade.appium.page.AccordionPage;
import br.andrade.appium.page.MenuPage;
import org.junit.Assert;

public class AccordionTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AccordionPage page = new AccordionPage();
	
	@Test
	public void deveInteragirComAccordion() {
	//acessar menu
		menu.acessarAccordion();
			
	//clicar op1
		page.selecionarOp1();
		
	//verificar texto op1
		esperar(1000);
		Assert.assertEquals("Esta é a descrição da opção 1", page.obterValorOp1());
	}

}
