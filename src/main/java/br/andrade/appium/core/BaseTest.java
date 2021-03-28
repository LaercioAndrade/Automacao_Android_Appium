package br.andrade.appium.core;

import org.junit.After;

public class BaseTest {

	
	@After
	public void tearDown() {
		DriverFactory.KillDriver();
	}
}
