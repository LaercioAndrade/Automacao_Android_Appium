package br.andrade.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.andrade.appium.core.BaseTest;
import br.andrade.appium.page.AbasPage;
import br.andrade.appium.page.MenuPage;

public class AbasTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AbasPage page = new AbasPage();
	
	
	@Test
	public void deveInteragirComAbas() {
		//acessar menu abas
		menu.acessarAbas();
		//verificar que está na aba1
		Assert.assertTrue(page.isAba1());
		
		//acessar aba2
		page.selecionarAba2();
		
		//verificar que esta na aba2
		Assert.assertTrue(page.isAba2());
	}

}
