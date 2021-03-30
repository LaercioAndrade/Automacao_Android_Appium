package br.andrade.appium.page;

import static br.andrade.appium.core.DriverFactory.getDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.andrade.appium.core.BasePage;

public class SplashPage extends BasePage {
	
	public boolean isTelaSplashVisivel() {
		return existeElementoPorTexto("Splash!");
	}
	
	public void aguaradarSplashSumir() {
		getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='Splash!']")));
	}

}
