package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MinhaContaPage {

	private WebDriver driver;

	private static String URL_MINHA_CONTA = "http://automationpractice.com/index.php?controller=my-account";

	public MinhaContaPage(WebDriver driver) {
		this.driver = driver;
	}

	public MinhaContaPage() {
	}

	private void esperaCarregarPaginaMinhaConta() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.urlToBe(URL_MINHA_CONTA));
	}

	public boolean estouNaPaginaMinhaConta() {
		esperaCarregarPaginaMinhaConta();
		return this.driver.getCurrentUrl().equals(URL_MINHA_CONTA)
				&& verificaTextoDaPaginaMinhaConta();

	}

	public boolean verificaTextoDaPaginaMinhaConta() {
		return driver.getPageSource().contains("Welcome to your account. Here you can manage all of your personal information and orders.");

	}

}
