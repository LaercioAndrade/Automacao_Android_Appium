package br.andrade.appium.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.andrade.appium.core.BaseTest;
import br.andrade.appium.page.MenuPage;
import br.andrade.appium.page.WebViewPage;

public class WebViewTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private WebViewPage page = new  WebViewPage();
	
	@Test
	public void deveFazerLogin() {
		//Passo01: Acessar Menu
		menu.acessarSBHibrido();
		esperar(3000);
		page.entrarContextoWeb();
		
		//Passo02: Preencher email
		page.setEmail("landrade100@hotmail.com");
		
		//Passo03: Preencher senha
		page.setSenha("123");
		
		//Passo04: Entrar
		page.entrar();
		
		//Passo05: Verificar Mensagem Sucesso
		Assert.assertEquals("Bem vindo, Laercio!", page.getMensagem());
		
	}
	
	
	@After
	public void tearDown() {
		page.sairContextoWeb();
	}
}
