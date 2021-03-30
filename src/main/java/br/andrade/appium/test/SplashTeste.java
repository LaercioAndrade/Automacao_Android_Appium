package br.andrade.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.andrade.appium.core.BaseTest;
import br.andrade.appium.page.MenuPage;
import br.andrade.appium.page.SplashPage;

public class SplashTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SplashPage page = new SplashPage();

	@Test
	public void deveAguardarSplashSumir() {
		//acessar menu splahs
		menu.acessarSplash();
		
		//verificar que o splash está sendo exibido
		page.isTelaSplashVisivel();
		
		
		// aguardar saida do splash
		page.aguaradarSplashSumir();
		
		//verificar que o formulário está aparacendo
		Assert.assertTrue(page.existeElementoPorTexto("Formulário"));
	}
}
