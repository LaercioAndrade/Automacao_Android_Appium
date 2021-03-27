package br.andrade.appium;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.andrade.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class Formul�rioTeste {
	
	private AndroidDriver<MobileElement> driver;
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		driver = DriverFactory.getDriver();
	    //Passo01: Selecionar formul�rio
	    driver.findElement(By.xpath("//*[@text='Formul�rio']")).click();
	}
	
	@After
	public void tearDown() {
		DriverFactory.KillDriver();
	}
	
	

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {	    
	    //Passo02: escrever nome
	    MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
	    campoNome.sendKeys("La�rcio");
	    
	    //Passo03: checar nome escrito
	    String text = campoNome.getText();
	    Assert.assertEquals("La�rcio", text);
	}

	
	@Test
	public void deveInteragirCombo() throws MalformedURLException {  
	     //Passo02: Clicar no combo
	    driver.findElement(MobileBy.AccessibilityId("console")).click();
	    
	    //Passo03: Selecionar op��o desejada
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
	    
	    //Passo04: Verificar op��o selecionada
	    String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
	    Assert.assertEquals("Nintendo Switch", text);
	}
	
	
	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {	     
	    //Passo02: Verificar status elementos
	    MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
	    MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
	    Assert.assertTrue(check.getAttribute("checked").equals("false"));
	    Assert.assertTrue(switc.getAttribute("checked").equals("true"));
	    
	    //Passo03: Clicar nos elementos
	    check.click();
	    switc.click();	    
	    
	    //Passo04: Verificar estados alterados
	    Assert.assertFalse(check.getAttribute("checked").equals("false"));
	    Assert.assertFalse(switc.getAttribute("checked").equals("true"));
	}
	
	@Test
	public void deveResolverDesafio() throws MalformedURLException {  
	    //Passo02: Preencher Campos
	    driver.findElement(By.className("android.widget.EditText")).sendKeys("La�rcio");
	    driver.findElement(By.className("android.widget.Spinner")).click();
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
	    driver.findElement(By.className("android.widget.CheckBox")).click();
	    driver.findElement(By.className("android.widget.Switch")).click();
	    
	    //Passo03: Bot�o Salvar
	    driver.findElement(By.xpath("//*[@text='SALVAR']")).click();
	    
	    //Passo04: Verifica��es
	    MobileElement nome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: La�rcio']"));
	    Assert.assertEquals("Nome: La�rcio", nome.getText());
	    
	    MobileElement combo = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
	    Assert.assertEquals("Console: switch",  combo.getText());
	    
	    MobileElement swit = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
	    Assert.assertTrue(swit.getText().endsWith("Off"));
	    
	    MobileElement check = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
	    Assert.assertTrue(check.getText().endsWith("Marcado"));
	    
	}
	
}
