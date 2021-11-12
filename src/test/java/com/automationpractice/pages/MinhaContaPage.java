package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class MinhaContaPage {

	private WebDriver driver;
	private Scenario cenario;

	private static String URL_MINHA_CONTA = "http://automationpractice.com/index.php?controller=my-account";

	public MinhaContaPage() {
		//driver.navigate().to(URL_MINHA_CONTA);
	}
	
	public MinhaContaPage(WebDriver driver, Scenario cenario) {
		this.cenario = cenario;
		cenario.log("Acessando minha conta");
		this.driver = driver;

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
	
	public MinhaContaPage navegarParaPaginaDeMinhaConta() {
		WebElement btnFazerLogin = driver.findElement(By.id("SubmitLogin"));
		btnFazerLogin.submit();
		return new MinhaContaPage(driver,cenario);
	}
	
	//dentro do menu de login, ao apertar para homepage,levo o drive comigo
	public HomePage navegarParaHomePage() {
		WebElement btnHomePage = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/a"));
		btnHomePage.click();
		return new HomePage(driver,cenario);
	}
	//fazer login
	
//	public void preencherEmailLogin(String email) {
//		WebElement txtEmail = driver.findElement(By.id("email"));
//		txtEmail.sendKeys(email);
//	}
//	
//	public void preencherSenhaDoLogin(String senha) {
//		WebElement txtEmail = driver.findElement(By.id("passwd"));
//		txtEmail.sendKeys(senha);
//	}
//	
//	public void ClicarEmFazerLogin() {
//		WebElement btnFazerLogin = driver.findElement(By.id("SubmitLogin"));
//		btnFazerLogin.submit();
//	}
	
	

}
