package br.andrade.appium;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.andrade.appium.core.DSL;
import br.andrade.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;


public class FormulárioTeste {

	
	private DSL dsl = new DSL();
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
	    //Passo01: Selecionar formulário
		dsl.clicarPorTexto("Formulário");
	}
	
	@After
	public void tearDown() {
		DriverFactory.KillDriver();
	}
	
	

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {	    
	    //Passo02: escrever nome
		dsl.escrever(MobileBy.AccessibilityId("nome"), "Laércio");
	    
	    //Passo03: checar nome escrito
	    Assert.assertEquals("Laércio", dsl.obterTexto(MobileBy.AccessibilityId("nome")));
	}

	
	@Test
	public void deveInteragirCombo() throws MalformedURLException {  
	     //Passo02: Clicar no combo
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");
	    
	    //Passo04: Verificar opção selecionada
	    String text = dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	    Assert.assertEquals("Nintendo Switch", text);
	}
	
	
	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {	     
	    //Passo02: Verificar status elementos
	    Assert.assertFalse(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
	    Assert.assertTrue(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));
	    
	    
	    //Passo03: Clicar nos elementos
	    dsl.clicar(By.className("android.widget.CheckBox"));
	    dsl.clicar(MobileBy.AccessibilityId("switch"));
	
	    //Passo04: Verificar estados alterados
	    Assert.assertTrue(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
	    Assert.assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));
	}
	
	@Test
	public void deveRealizarCadastro() throws MalformedURLException {  
	    //Passo02: Preencher Campos
	    dsl.escrever(By.className("android.widget.EditText"),"Laércio");
	    dsl.clicar(By.className("android.widget.CheckBox"));
	    dsl.clicar(By.className("android.widget.Switch"));
	    dsl.selecionarCombo(By.className("android.widget.Spinner"), "Nintendo Switch");
	    
	    //Passo03: Botão Salvar
	    dsl.clicarPorTexto("SALVAR");
	    
	    //Passo04: Verificações 
	    Assert.assertEquals("Nome: Laércio", dsl.obterTexto(By.xpath("//android.widget.TextView[@text='Nome: Laércio']")));
	    Assert.assertEquals("Console: switch", dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]")));
	    Assert.assertTrue(dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]")).endsWith("Off"));
	    Assert.assertTrue(dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]")).endsWith("Marcado"));
	    
	}
	
}
