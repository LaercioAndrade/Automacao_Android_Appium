package br.andrade.appium.page;


import br.andrade.appium.core.DSL;
public class MenuPage {
	
	private DSL dsl = new DSL();
	
	public void acessarFormul�rio() {
		
		
		dsl.clicarPorTexto("Formul�rio");
	}

}
