package br.andrade.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.andrade.appium.core.BaseTest;
import br.andrade.appium.page.MenuPage;

public class SwipeTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	
	@Test
	public void deveRealizarSwipe() {
		//acessar menu
		menu.acessarSwipe();
		
		//verficicar texto 'a esquerda'
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
		
		//swipe para direita
		menu.swipeRight();;
		
		//verificar texto 'E veja se'
		Assert.assertTrue(menu.existeElementoPorTexto("E veja se"));
		
		//clicar bot�o direita
		menu.clicarPorTexto("�");
		
		//verifcar texto 'Chegar at� o fim!"
		Assert.assertTrue(menu.existeElementoPorTexto("Chegar at� o fim!"));
		
		//swipe esquerda
		menu.swipeLeft();;
		
		//clicar bot�o esquerda
		menu.clicarPorTexto("�");
		
		//verficicar texto 'a esquerda'
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
	}
}
