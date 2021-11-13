package com.automationpractice.steps;

import org.junit.Assert;

import com.automationpractice.pages.Browser;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.LoginPage;
import com.automationpractice.pages.MinhaContaPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LoginStep {

	private Browser browser;
	private HomePage homePage;// inicio o homePage
	private LoginPage loginPage;
	private MinhaContaPage minhaContaPage;
	private Scenario cenario;

//	public String dataAtual() {
//		Date data = new Date();
//		SimpleDateFormat formatar = new SimpleDateFormat("dd-MM-yyyy");
//		String dataFormatada = formatar.format(data);
//		return dataFormatada;
//	}

	@Before("@login")
	public void setup(Scenario cenario) {
		this.cenario = cenario;
		this.cenario.log("Iniciando automacao...");
		browser = new Browser(this.cenario);// inicio o browser
		homePage = browser.getHomePage();// inicio a homepage(construtor abre a página)(
	}

	@After("@login")
	public void PrintCenario() {
			
		browser.fechar();
		cenario.log("Automacao Finalizada - Status: " + cenario.getStatus());
	}

//	@After(order = 0)
//	public void tearDown() {
//
//	}

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
		loginPage.ClicarEmFazerLogin();
	}

	@Entao("sou redirecionado para o menu da minha conta")
	public void sou_redirecionado_para_o_menu_da_minha_conta() {
		minhaContaPage = loginPage.navegarParaPaginaDeMinhaConta();// para cá
		Assert.assertTrue(minhaContaPage.estouNaPaginaMinhaConta());
		// minhaContaPage.navegarParaHomePage();
	}

	@Entao("aparece uma mensagem de acesso invalido")
	public void apareceUmaMensagemDeAcessoInvalido() {
		Assert.assertTrue(loginPage.mensagemAcessoInvalido());
	}

}
