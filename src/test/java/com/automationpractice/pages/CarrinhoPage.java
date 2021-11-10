package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CarrinhoPage {

	private WebDriver driver;
	
	private static String URL_CARRINHO = "http://automationpractice.com/index.php?controller=order";
	
	public CarrinhoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//verifica se estou na página de carrinho
	public boolean estouNaPaginaDeCarrinho() {
		return this.driver.getCurrentUrl().equals(URL_CARRINHO);
	}

	public void removerProduto() {													//id da table/ body da table / linha / coluna
		//WebElement removerItem = driver.findElement(By.cssSelector("#cart_summary tbody tr"));
		WebElement linhaDaTabela = driver.findElement(By.cssSelector("#cart_summary tbody tr"));
		WebElement colunaDaTabela = linhaDaTabela.findElement(By.cssSelector("td:nth-child(6)"));
		WebElement btnRemover = colunaDaTabela.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[7]/div/a/i"));
		btnRemover.click();
	}
	
	public boolean carrinhoEstaVazio() {
		return driver.getPageSource().contains("Your shopping cart is empty.");
	}
}
