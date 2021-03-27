package br.andrade.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.Assert;

public class FormulárioTeste {

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "C://Users//Auditeste0345//eclipse-workspace//ProjetoAppium//src//main//resources/CTAppium_1_2.apk");    
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Passo01: Selecionar formulário
	    List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
//	    for(MobileElement elemento: elementosEncontrados) {
//	    	System.out.println(elemento.getText());
//	    }
	    elementosEncontrados.get(1).click();
	    
	    //Passo02: escrever nome
	    MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
	    campoNome.sendKeys("Laércio");
	    
	    //Passo03: checar nome escrito
	    String text = campoNome.getText();
	    Assert.assertEquals("Laércio", text);
	    
	    driver.quit();
	}
	
	
	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "C://Users//Auditeste0345//eclipse-workspace//ProjetoAppium//src//main//resources/CTAppium_1_2.apk");    
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Passo01: Selecionar formulário
	    driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
	   
	    
	    //Passo02: Clicar no combo
	    driver.findElement(MobileBy.AccessibilityId("console")).click();
	    
	    //Passo03: Selecionar opção desejada
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
	    
	    //Passo04: Verificar opção selecionada
	    String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
	    Assert.assertEquals("Nintendo Switch", text);
	    
	    driver.quit();
	}
	
	
	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "C://Users//Auditeste0345//eclipse-workspace//ProjetoAppium//src//main//resources/CTAppium_1_2.apk");    
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Passo01: Selecionar formulário
	    driver.findElement(By.xpath("//*[@text='Formulário']")).click();
	   
	    
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
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "C://Users//Auditeste0345//eclipse-workspace//ProjetoAppium//src//main//resources/CTAppium_1_2.apk");    
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Passo01: Selecionar formulário
	    driver.findElement(By.xpath("//*[@text='Formulário']")).click();
	   
	    
	    //Passo02: Preencher Campos
	    driver.findElement(By.className("android.widget.EditText")).sendKeys("Laércio");
	    driver.findElement(By.className("android.widget.Spinner")).click();
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
	    driver.findElement(By.className("android.widget.CheckBox")).click();
	    driver.findElement(By.className("android.widget.Switch")).click();
	    
	    //Passo03: Botão Salvar
	    driver.findElement(By.xpath("//*[@text='SALVAR']")).click();
	    
	    //Passo04: Verificações
	    MobileElement nome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Laércio']"));
	    Assert.assertEquals("Nome: Laércio", nome.getText());
	    
	    MobileElement combo = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
	    Assert.assertEquals("Console: switch",  combo.getText());
	    
	    MobileElement swit = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
	    Assert.assertTrue(swit.getText().endsWith("Off"));
	    
	    MobileElement check = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
	    Assert.assertTrue(check.getText().endsWith("Marcado"));
	    
	    
	    
	    
	    driver.quit();
	}
	
}
