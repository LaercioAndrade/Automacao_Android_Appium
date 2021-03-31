package br.andrade.appium.page;

import static br.andrade.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import br.andrade.appium.core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class SwipeListPage extends BasePage {

	public void swipeElementLeft(String opcao) {
		swipeElement(getDriver().findElement(MobileBy.xpath("//*[@text = '"+opcao+"']/..")), 0.2, 0.8);
	}
	
	public void swipeElementRight(String opcao) {
		swipeElement(getDriver().findElement(MobileBy.xpath("//*[@text = '"+opcao+"']/..")), 0.8, 0.2);
	}
	
	public void clicarBotaoMais() {
		MobileElement botao = getDriver().findElement(MobileBy.xpath("//*[@text = '(+)']/.."));
		Point center1 = botao.getCenter();
		
		new TouchAction(getDriver()).tap(PointOption.point(center1.x - 50, center1.y)).perform();
	}
}
