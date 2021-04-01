package br.andrade.appium.page.seuBarriga;

import org.openqa.selenium.By;

import br.andrade.appium.core.BasePage;

public class SBMovimentacaoPage extends BasePage {

	public void salvar() {
		clicarPorTexto("SALVAR");
	}
	
	public void setDescrição(String desc) {
		escrever(By.className("android.widget.EditText"), desc);
	}
	
	public void setInteressado(String interessado) {
		escrever(By.xpath("//android.widget.EditText[2]"), interessado);
	}
	
	public void setValor(String valor) {
		escrever(By.xpath("//android.widget.EditText[3]"), valor);
	}
	
	public void setConta(String conta) {
		selecionarCombo(By.xpath("//android.widget.Spinner[2]"), conta);
	}
}
