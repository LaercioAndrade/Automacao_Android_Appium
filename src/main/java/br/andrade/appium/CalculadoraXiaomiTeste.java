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
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability("appPackage", "com.miui.calculator");
	    desiredCapabilities.setCapability("appActivity", "com.miui.calculator.Calculator");
	    //desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);

	    MobileElement el7 = (MobileElement) driver.findElementById("com.miui.calculator:id/btn_2_s");
	    el7.click();
	    MobileElement el8 = (MobileElement) driver.findElementByAccessibilityId("adição");
	    el8.click();
	    MobileElement el9 = (MobileElement) driver.findElementById("com.miui.calculator:id/btn_2_s");
	    el9.click();
	    MobileElement el10 = (MobileElement) driver.findElementByAccessibilityId("igual a");
	    el10.click();
	    MobileElement el11 = (MobileElement) driver.findElementById("com.miui.calculator:id/result");
	    Assert.assertEquals("4", el11.getText());
	
	    driver.quit();
	}

	  
	  }
	

