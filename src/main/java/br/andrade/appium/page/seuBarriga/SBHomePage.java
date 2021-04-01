package br.andrade.appium.page.seuBarriga;

import org.openqa.selenium.By;

import br.andrade.appium.core.BasePage;

public class SBHomePage extends BasePage {

	public String obterSaldoConta(String conta) {
		return obterTexto(By.xpath("//*[@text='"+conta+"']/following-sibling::android.widget.TextView"));
	}
}
