package com.automationpractice.steps;

import static org.junit.Assert.assertTrue;

import com.automationpractice.pages.Browser;
import com.automationpractice.pages.CarrinhoPage;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.LoginPage;
import com.automationpractice.pages.MinhaContaPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class CarrinhoStep {

	private Browser browser;
	private HomePage homePage;
	private LoginPage loginPage;
	private MinhaContaPage minhaContaPage;
	private CarrinhoPage carrinhoPage;
	private Scenario cenario;

	@Before("@carrinho")
	public void setup(Scenario cenario) {
		this.cenario = cenario;
		this.cenario.log("Iniciando automacao...");
		browser = new Browser(this.cenario);
		homePage = browser.getHomePage();
		loginPage = browser.getLoginPage();
	}

	@After("@carrinho")
	public void tearDown() {
		browser.fechar();
		cenario.log("Automacao Finalizada - Status: " + cenario.getStatus());
	}

	@Dado("que eu tenho estou logado no site com email {string} e senha {string}")
	public void queEuTenhoEstouLogadoNoSiteComEmail(String email, String senha) {
		loginPage.preencherEmailLogin(email);
		loginPage.preencherSenhaDoLogin(senha);
		loginPage.clicarEmFazerLogin();
		minhaContaPage = loginPage.navegarParaPaginaDeMinhaConta();
		homePage = minhaContaPage.navegarParaHomePage();
	}

	@Quando("pesquiso e seleciono o produto {string}")
	public void pesquisoESelecionoOProduto(String pesquisa) {
		homePage.pesquisaProduto(pesquisa);
	}

	@Entao("o produto e adicionado ao carrinho de compras")
	public void o_produto_e_adicionado_ao_carrinho_de_compras() {
		homePage.mudaVisualizacaoDosItens();
		homePage.adicionaProdutoAoCarrinhoFinalizandoCompra();
		carrinhoPage = homePage.navegarParaCarrinho();
		assertTrue(carrinhoPage.estouNaPaginaDeCarrinho());
	}

	@Entao("o produto e removido do carrinho de compras")
	public void oProdutoERemovidoDoCarrinhoDeCompras() {
		carrinhoPage.removerProduto();
		assertTrue(carrinhoPage.carrinhoEstaVazio());
	}

}
