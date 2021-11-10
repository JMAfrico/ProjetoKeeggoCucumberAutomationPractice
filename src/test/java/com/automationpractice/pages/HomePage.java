package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;
	
	private static String URL_HOME_PAGE = "http://automationpractice.com/index.php";
	
	//Abre o home Page assim que é chamado
	public HomePage(WebDriver driver) {
		this.driver = driver;
		driver.navigate().to(URL_HOME_PAGE);
		driver.manage().window().maximize();
	}
	
	public HomePage navegarParaPaginaHome(WebDriver driver) {
		driver.navigate().to(URL_HOME_PAGE);
		return new HomePage(driver);
	}
	
	//verifica se está na home page
	public boolean estouNaHomePage() {
		return this.driver.getCurrentUrl().contains(URL_HOME_PAGE);
	}

	//dentro da home page, clica no botão de login e navega para a página de cadastro
	//utilizando o mesmo driver
	public LoginPage navegarParaPaginaDeLogin() {
		driver.findElement(By.className("login")).click();
		return new LoginPage(driver);
	}

	public void pesquisaProduto(String pesquisa) {
		WebElement txtPesquisa = driver.findElement(By.id("search_query_top"));
		txtPesquisa.sendKeys(pesquisa);
		WebElement btnPesquisa = driver.findElement(By.name("submit_search"));
		btnPesquisa.submit();
		
	}

	public void MudaVisualizacaoDosItens() {
		WebElement btnClicaNaVisualizacao = driver.findElement(By.id("list"));
		btnClicaNaVisualizacao.click();
	
	}
	
	public void adicionaProdutoAoCarrinhoFinalizandoCompra() {
		WebElement btnClicaNoBotaoAdicionarAoCarrinho = driver.
				findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div/div[3]/div/div[2]/a[1]"));
		btnClicaNoBotaoAdicionarAoCarrinho.click();
		
		WebElement btnFinalizaCompraEIrParaCarrinho = driver.
				findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a"));	
		btnFinalizaCompraEIrParaCarrinho.click();	
		navegarParaCarrinho();
	}
	
	public CarrinhoPage navegarParaCarrinho() {
		return new CarrinhoPage(driver);
	}

	
	

	
	
	
	

}
