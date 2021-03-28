package br.andrade.appium.test;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.andrade.appium.core.BaseTest;
import br.andrade.appium.page.Formul�rioPage;
import br.andrade.appium.page.MenuPage;


public class Formul�rioTeste extends BaseTest{

	private MenuPage menu = new MenuPage();
	private Formul�rioPage page = new Formul�rioPage();
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarFormul�rio();
	}
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {	    
		page.escreverNome("La�rcio");
	    Assert.assertEquals("La�rcio", page.obterNome());
	}

	
	@Test
	public void deveInteragirCombo() throws MalformedURLException {  
		page.selecionarCombo("Nintendo Switch");  
	    Assert.assertEquals("Nintendo Switch", page.obterValorCombo());
	}
	
	
	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {	     
	    
	    Assert.assertFalse(page.isCheckMarcado());
	    Assert.assertTrue(page.isSwitchMacado());
	    
	    
	    page.clicarCheck();
	    page.clicarSwitch();
	
	    
	    Assert.assertTrue(page.isCheckMarcado());
	    Assert.assertFalse(page.isSwitchMacado());
	}
	
	@Test
	public void deveRealizarCadastro() throws MalformedURLException {  
		page.escreverNome("La�rcio");
		page.clicarCheck();
		page.clicarSwitch();
		page.selecionarCombo("Nintendo Switch");
	 
	    
	    
	    page.salvar();
	    
	     
	    Assert.assertEquals("Nome: La�rcio", page.obterNomeCadastrado() );
	    Assert.assertEquals("Console: switch", page.obterConsoleCadastro());
	    Assert.assertTrue(page.obterCheckCadastrado().endsWith("Off"));
	    Assert.assertTrue(page.obterSwitchCadastrado().endsWith("Marcado"));
	    
	}
	
}
