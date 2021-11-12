package com.automationpractice.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;

public class Browser {

	private WebDriver driver;
	private Scenario cenario;


	public Browser(Scenario cenario) {
		this.cenario = cenario;
		this.driver = new BrowserFactory().createWebDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public HomePage getHomePage() {
		return new HomePage(driver,cenario);
	}
	
	public LoginPage getLoginPage() {
		return new LoginPage(driver,cenario);
	}
	
	public void fechar() {
		//driver.manage().deleteAllCookies();
		driver.close();
	}
}
