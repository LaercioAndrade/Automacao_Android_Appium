package br.andrade.appium.core;

import static br.andrade.appium.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {

	
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
	
	public boolean existeElementoPorTexto(String texto) {
	    List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text = '"+texto+"']"));
		return elementos.size() > 0;
	}
	
	public void tap(int x, int y) {
		new TouchAction(getDriver()).press(PointOption.point(x, y)).perform();
	}
	
	public void scrollDown() {
		scroll(0.9, 0.1);
	}
	
	public void scrollUp() {
		scroll(0.1, 0.9);
	}
	
	
	public void swipeLeft() {
		swipe(0.1, 0.9);
	}
	
	public void swipeRight() {
		swipe(0.9, 0.1);
	}
	
	public void scroll(double Inicial, double Final) {
		Dimension size = getDriver().manage().window().getSize();
		
		int x = size.width / 2;
		
		int start_y = (int) (size.height * Inicial);
		int end_y = (int) (size.height * Final);
		
		new TouchAction(getDriver())
        .longPress(PointOption.point(x, start_y))
        .moveTo(PointOption.point(x, end_y))
        .release()
        .perform();
	}
	
	
	public String obterTituloAlerta() {
		return obterTexto(By.id("android:id/alertTitle"));
	}
	
	public String obterMensagemAlerta() {
		return obterTexto(By.id("android:id/message"));
	}
	
	public void swipe(double Inicial, double Final) {
		Dimension size = getDriver().manage().window().getSize();
		
		int y = size.height / 2;
		
		int start_x = (int) (size.width * Inicial);
		int end_x = (int) (size.width * Final);
		
		new TouchAction(getDriver())
        .longPress(PointOption.point(start_x, y))
        .moveTo(PointOption.point(end_x, y))
        .release()
        .perform();
	}
	
	public void swipeElement(MobileElement element, double Inicial, double Final) {
		int y = element.getLocation().y + (element.getSize().height / 2);
		
		int start_x = (int) (element.getSize().width * Inicial);
		int end_x = (int) (element.getSize().width * Final);
		
		new TouchAction(getDriver())
        .longPress(PointOption.point(start_x, y))
        .moveTo(PointOption.point(end_x, y))
        .release()
        .perform();
	}
	
	public void cliqueLongo(By by) {
		AndroidTouchAction touch = new AndroidTouchAction(DriverFactory.getDriver());
        touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(DriverFactory.getDriver().findElement((by)))))
        .perform();
	}
	
	
}
