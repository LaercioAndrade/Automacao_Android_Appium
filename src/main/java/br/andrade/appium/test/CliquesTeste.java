package br.andrade.appium.test;

import org.junit.Test;

import br.andrade.appium.core.BaseTest;
import br.andrade.appium.page.CliquesPage;
import br.andrade.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;

public class CliquesTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private CliquesPage page = new CliquesPage();
	
	@Before
	public void setup() {
		menu.acessarCliques();
	}

	@Test
	public void deveRealizarCliqueLongo() {
		//clique longo
		page.cliqueLongo();
		
		
		//verifar texto
		Assert.assertEquals("Clique Longo", page.obterTextoCampo());
	}
	
	@Test
	public void deveRealizarCliqueDuplo() {
		page.clicarPorTexto("Clique duplo");
		page.clicarPorTexto("Clique duplo");
		
		Assert.assertEquals("Duplo Clique", page.obterTextoCampo());
		
	}

}


