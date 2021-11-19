package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.Scenario;

public class HomePage {

	private WebDriver driver;
	private Scenario cenario;

	private static String URL_HOME_PAGE = "http://automationpractice.com/index.php";

	public HomePage(WebDriver driver, Scenario cenario) {
		this.cenario = cenario;
		this.cenario.log("Abrindo Home Page");
		this.driver = driver;
		driver.navigate().to(URL_HOME_PAGE);
		driver.manage().window().maximize();

		TakesScreenshot screen = (TakesScreenshot) driver;
		byte[] data = screen.getScreenshotAs(OutputType.BYTES);
		cenario.attach(data, "image/png", null);
	}

	public HomePage navegarParaPaginaHome(WebDriver driver) {
		driver.navigate().to(URL_HOME_PAGE);
		return new HomePage(driver, cenario);
	}

	public boolean estouNaHomePage() {
		return this.driver.getCurrentUrl().contains(URL_HOME_PAGE);
	}

	public LoginPage navegarParaPaginaDeLogin() {
		WebElement btnFazerLogin = driver.findElement(By.className("login"));

		TakesScreenshot screen = (TakesScreenshot) btnFazerLogin;
		byte[] data = screen.getScreenshotAs(OutputType.BYTES);
		cenario.attach(data, "image/png", null);

		btnFazerLogin.click();
		return new LoginPage(driver, cenario);

	}

	public void pesquisaProduto(String pesquisa) {
		String msg = "Pesquiso o produto " + pesquisa;
		WebElement txtPesquisa = driver.findElement(By.id("search_query_top"));
		txtPesquisa.sendKeys(pesquisa);

		TakesScreenshot screen = (TakesScreenshot) txtPesquisa;
		byte[] data = screen.getScreenshotAs(OutputType.BYTES);
		cenario.attach(data, "image/png", null);

		WebElement btnPesquisa = driver.findElement(By.name("submit_search"));

		btnPesquisa.submit();
		cenario.log(msg);
	}

	public void mudaVisualizacaoDosItens() {
		String msg = "Mudo a visualizacao dos produtos para Modo Lista";
		WebElement btnClicaNaVisualizacao = driver.findElement(By.id("list"));
		btnClicaNaVisualizacao.click();
		cenario.log(msg);
	}

	public void adicionaProdutoAoCarrinhoFinalizandoCompra() {
		String msg = "Finalizo o carrinho ";
		WebElement btnClicaNoBotaoAdicionarAoCarrinho = driver
				.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div/div[3]/div/div[2]/a[1]"));

		TakesScreenshot screen = (TakesScreenshot) btnClicaNoBotaoAdicionarAoCarrinho;
		byte[] data = screen.getScreenshotAs(OutputType.BYTES);
		cenario.attach(data, "image/png", null);

		btnClicaNoBotaoAdicionarAoCarrinho.click();

		WebElement btnFinalizaCompraEIrParaCarrinho = driver
				.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a"));

		btnFinalizaCompraEIrParaCarrinho.click();
		navegarParaCarrinho();
		cenario.log(msg);
	}

	public CarrinhoPage navegarParaCarrinho() {
		return new CarrinhoPage(driver, cenario);
	}

}
