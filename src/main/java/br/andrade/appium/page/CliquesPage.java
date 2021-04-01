package br.andrade.appium.page;

import static br.andrade.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.andrade.appium.core.BasePage;

public class CliquesPage extends BasePage{

	
		public void cliqueLongo() {
			//new TouchAction(getDriver()).longPress(getDriver().findElement(By.xpath("//*[@text='Clique Longo']"))).perform();
			cliqueLongo(By.xpath("//*[@text='Clique Longo']"));
			//AndroidTouchAction touch = new AndroidTouchAction(DriverFactory.getDriver());
	        //touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(DriverFactory.getDriver().findElement(By.xpath("//*[@text='Clique Longo']")))))
	        //.perform();
		}
		
		public String obterTextoCampo() {
			return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
		}
}
