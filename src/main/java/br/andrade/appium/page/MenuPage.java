package br.andrade.appium.page;

import br.andrade.appium.core.BasePage;

public class MenuPage extends BasePage{

	
	public void acessarFormulário() {
		clicarPorTexto("Formulário");
	}
	
	public void acessarSplash() {
		clicarPorTexto("Splash");
	}
	
	public void acessarAlertas() {
		clicarPorTexto("Alertas");
	}
	
	public void acessarAbas() {
		clicarPorTexto("Abas");
	}
}
