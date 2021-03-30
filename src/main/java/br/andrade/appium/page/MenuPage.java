package br.andrade.appium.page;

import br.andrade.appium.core.BasePage;

public class MenuPage extends BasePage{

	
	public void acessarFormulário() {
		clicarPorTexto("Formulário");
	}
	
	public void acessarSplash() {
		clicarPorTexto("Splash");
	}
}
