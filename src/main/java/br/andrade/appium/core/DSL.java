package br.andrade.appium.core;

import static br.andrade.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

public class DSL {
	
	public void escrever(By by, String texto) {
		 getDriver().findElement(by).sendKeys(texto);
		    
	}
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public void clicar(By by) {
		getDriver().findElement(by).click();
	}
	
	
	
	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//*[@text='"+texto+"']"));
	}
	
	public void selecionarCombo(By by, String valor) {
		getDriver().findElement(by).click();	
		clicarPorTexto(valor);
		//getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='"+valor+"']")).click();
	}
	
	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}
}
