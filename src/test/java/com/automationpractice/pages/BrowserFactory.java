package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

//  Documentação
//	http://chromedriver.storage.googleapis.com/index.html
//	https://github.com/mozilla/geckodriver/releases	

	public WebDriver createWebDriver() {
		String webdriver = System.getProperty("browser", "chrome");
		switch (webdriver) {
		case "firefox":
			return initFirefoxDriver();
		case "chrome":
			return initChromeDriver();
		default:
			return initChromeDriver();
		}
	}

	private WebDriver initChromeDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		return new ChromeDriver();
	}

	private WebDriver initFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		return new FirefoxDriver();
	}
}
