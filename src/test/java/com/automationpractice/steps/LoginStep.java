package com.automationpractice.steps;

import org.junit.Assert;

import com.automationpractice.pages.Browser;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.LoginPage;
import com.automationpractice.pages.MinhaContaPage;
import com.automationpractice.support.hooks.Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LoginStep {

	private Browser browser;
	private HomePage homePage;
	private LoginPage loginPage;
	private MinhaContaPage minhaContaPage;
	private Scenario cenario;

//	public LoginStep() {
//		browser = new Browser(cenario);
//		homePage = browser.getHomePage();
//	}
	
	@Before("@login")
	public void setup(Scenario cenario) {
		this.cenario = cenario;
		cenario.log("Iniciando automacao...");
		browser = new Browser(cenario);
		homePage = browser.getHomePage();
	}

	@After("@login")
	public void PrintCenario() {
		browser.fechar();
		cenario.log("Automacao Finalizada - Status: " + cenario.getStatus());
	}

	@Dado("que eu acessei a pagina de login")
	public void queEuEstouNaPaginaDeLogin() {
		loginPage = homePage.navegarParaPaginaDeLogin();
	}

	// fazer login
	@Quando("informo o email {string}")
	public void informoOEmail(String string) {
		loginPage.preencherEmailLogin(string);
	}

	@Quando("informo senha {string}")
	public void informoSenha(String string) {
		loginPage.preencherSenhaDoLogin(string);
	}

	@Quando("seleciono a acao de logar no site")
	public void selecionoAAcaoDeLogarNoSite() {
		loginPage.clicarEmFazerLogin();
	}

	@Entao("sou redirecionado para o menu da minha conta")
	public void sou_redirecionado_para_o_menu_da_minha_conta() {
		minhaContaPage = loginPage.navegarParaPaginaDeMinhaConta();// para cá
		Assert.assertTrue(minhaContaPage.estouNaPaginaMinhaConta());
	}

	@Entao("aparece uma mensagem de acesso invalido")
	public void apareceUmaMensagemDeAcessoInvalido() {
		Assert.assertTrue(loginPage.mensagemAcessoInvalido());
	}

}
