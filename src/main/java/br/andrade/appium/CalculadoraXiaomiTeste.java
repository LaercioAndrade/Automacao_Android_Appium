package br.andrade.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class CalculadoraXiaomiTeste {

	@Test
	public void deveSomarDoisValores() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "1f02089a");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability("appPackage", "com.miui.calculator");
	    desiredCapabilities.setCapability("appActivity", "com.miui.calculator.Calculator");
	    //desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);

	    
	    MobileElement el2 = (MobileElement) driver.findElementById("com.miui.calculator:id/btn_2_s");
	    el2.click();
	    MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("adição");
	    el3.click();
	    MobileElement el4 = (MobileElement) driver.findElementById("com.miui.calculator:id/btn_2_s");
	    el4.click();
	    MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("igual a");
	    el5.click();
	    MobileElement el6 = (MobileElement) driver.findElementById("com.miui.calculator:id/result");
	    el6.click();
	    Assert.assertEquals("4", el6.getText());
	
	    driver.quit();
	}

}
	

