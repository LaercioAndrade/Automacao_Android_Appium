package br.andrade.appium.test;

import org.junit.Before;
import org.junit.Test;

import br.andrade.appium.core.BaseTest;
import br.andrade.appium.page.MenuPage;
import br.andrade.appium.page.SBLoginPage;

public class SBTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SBLoginPage login = new SBLoginPage();
	
	@Before
	public void setup() {
		menu.acessarSBNativo();
		login.setEmail("laercio@teste");
		login.setSenha("123");
		login.entrar();
	}
	
	@Test
	public void test() {
		
	}
}
