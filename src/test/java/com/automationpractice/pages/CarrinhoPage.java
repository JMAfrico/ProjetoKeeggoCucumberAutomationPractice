package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.Scenario;

public class CarrinhoPage {

	private WebDriver driver;
	Scenario cenario;

	private static String URL_CARRINHO = "http://automationpractice.com/index.php?controller=order";

	public CarrinhoPage(WebDriver driver, Scenario cenario) {
		this.cenario = cenario;
		this.driver = driver;
		TakesScreenshot screen = (TakesScreenshot) driver;
		byte[] data = screen.getScreenshotAs(OutputType.BYTES);
		cenario.attach(data, "image/png", null);
	}

	public boolean estouNaPaginaDeCarrinho() {
		return this.driver.getCurrentUrl().equals(URL_CARRINHO);
	}

	public void removerProduto() {
		String msg = "Clico em remover produto ";
		WebElement linhaDaTabela = driver.findElement(By.cssSelector("#cart_summary tbody tr"));
		WebElement colunaDaTabela = linhaDaTabela.findElement(By.cssSelector("td:nth-child(6)"));
		WebElement btnRemover = colunaDaTabela
				.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[7]/div/a/i"));

		TakesScreenshot screen = (TakesScreenshot) linhaDaTabela;
		byte[] data = screen.getScreenshotAs(OutputType.BYTES);
		cenario.attach(data, "image/png", null);

		btnRemover.click();
		cenario.log(msg);
	}

	public boolean carrinhoEstaVazio() {
		String msg = "Valido mensagem que o carrinho esta vazio ";
		cenario.log(msg);
		return driver.getPageSource().contains("Your shopping cart is empty.");
	}
}
