package br.andrade.appium.test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.andrade.appium.core.BaseTest;
import br.andrade.appium.core.DriverFactory;
import br.andrade.appium.page.FormulárioPage;
import br.andrade.appium.page.MenuPage;
import io.appium.java_client.MobileBy;


public class FormulárioTeste extends BaseTest{

	private MenuPage menu = new MenuPage();
	private FormulárioPage page = new FormulárioPage();
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarFormulário();
	}
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {	    
		page.escreverNome("Laércio");
	    Assert.assertEquals("Laércio", page.obterNome());
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
		page.escreverNome("Laércio");
		page.clicarCheck();
		page.clicarSwitch();
		page.selecionarCombo("Nintendo Switch");
	 
	    
	    
	    page.salvar();
	    
	     
	    Assert.assertEquals("Nome: Laércio", page.obterNomeCadastrado() );
	    Assert.assertEquals("Console: switch", page.obterConsoleCadastro());
	    Assert.assertTrue(page.obterCheckCadastrado().endsWith("Off"));
	    Assert.assertTrue(page.obterSwitchCadastrado().endsWith("Marcado"));
	    
	}
	
	@Test
	public void deveRealizarCadastroDemorado() throws MalformedURLException { 
		page.escreverNome("Laércio");
		
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	    page.salvarDemorado();
	    //esperar(3000);
	    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Laércio']")));
	    Assert.assertEquals("Nome: Laércio", page.obterNomeCadastrado() );
    
	}
	
	@Test
	public void deveAlterarData() {
		page.clicarPorTexto("01/01/2000");
		page.clicarPorTexto("20");
		page.clicarPorTexto("OK");
		Assert.assertTrue(page.existeElementoPorTexto("20/2/2000"));

		
	}
	
	@Test
	public void deveAlterarHora() {
		page.clicarPorTexto("06:00");
		page.clicar(MobileBy.AccessibilityId("10"));
		page.clicar(MobileBy.AccessibilityId("40"));
		page.clicarPorTexto("OK");
		Assert.assertTrue(page.existeElementoPorTexto("10:40"));
	}
	
	@Test
	public void deveInteragirComSeekbar() {
		//clicar no seekbar
		page.clicarSeekbar(0.67);
		
		//salvar
		page.salvar();
		
		//obter o valr
	}
}
