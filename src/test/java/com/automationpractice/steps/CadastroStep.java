package com.automationpractice.steps;

import org.junit.Assert;

import com.automationpractice.pages.Browser;
import com.automationpractice.pages.CadastroPage;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.LoginPage;
import com.automationpractice.pages.MinhaContaPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class CadastroStep {

	//se nao funcionar é só apagar essa classe
	private Browser browser;
	private HomePage homePage;//inicio o homePage
	private LoginPage loginPage;
	private MinhaContaPage minhaContaPage;
	private CadastroPage cadastroPage;


	@Before("@cadastro")
	public void setup() {
		browser = new Browser();//inicio o browser
		homePage = browser.getHomePage();//inicio a homepage(construtor abre a página)(
	}
	
	@After("@cadastro")
	public void tearDown() {
		browser.fechar();
	}
	
	// @novo email
	@Dado("que eu estou na pagina de login")
	public void queEuEstouNaPaginaDeLogin() {
		loginPage = homePage.navegarParaPaginaDeLogin();
	}

	@Quando("informo o email para cadastro {string}")
	public void informoOEmailParaCadastro(String email) {
		loginPage.validarEmailParaCadastro(email);
	}

	@Quando("informo o email {string} invalido")
	public void informoOEmailInvalido(String email) {
		loginPage.validarEmailParaCadastro(email);
	}

	@Quando("informo o email {string} que ja foi cadastrado")
	public void informoOEmailQueJaFoiCadastrado(String email) {
		loginPage.validarEmailParaCadastro(email);
	}

	@Quando("seleciono a acao de criar uma conta")
	public void selecionoAAcaoDeCriarUmaConta() {
		loginPage.btnValidarEmailParaCadastro();
	}

	@Entao("sou redirecionado para a tela de novo usuario")
	public void souRedirecionadoParaATelaDeNovoUsuario() {
		cadastroPage = loginPage.navegarParaPaginaDeCadastro();
		Assert.assertTrue(cadastroPage.estouNaPaginaDeCadastro());
	}

	@Entao("uma mensagem de erro e mostrada")
	public void umaMensagemDeErroEMostrada() {
		Assert.assertTrue(loginPage.estouNaPaginaDeLoginComEmailInvalido());
	}

	@Entao("uma mensagem de email ja cadastrado e mostrada")
	public void umaMensagemDeEmailJaCadastrado() {
		loginPage.mensagemEmailJaCadastrado();
	}

	// @autenticacao
	@Dado("que tenho um email {string} valido de novo usuario")
	public void queTenhoUmEmailValidoDeNovoUsuario(String email) {
		loginPage = homePage.navegarParaPaginaDeLogin();
		loginPage.validarEmailParaCadastro(email);
		loginPage.btnValidarEmailParaCadastro();
		
	}

	@Dado("que eu estou na pagina de cadastro de usuario")
	public void queEuEstouNaPaginaDeCadastroDeUsuario() {
		cadastroPage = loginPage.navegarParaPaginaDeCadastro();
		cadastroPage.estouNaPaginaDeCadastro();
	}

	@Quando("informo o genero {string}")
	public void informoOGenero(String genero) {
		cadastroPage.selecionaSexo(genero);
	}

	@Quando("informo o nome {string}")
	public void informoONome(String nome) {
		cadastroPage.preencherNome(nome);

	}

	@Quando("informo o sobrenome {string}")
	public void informoOSobrenome(String sobrenome) {
		cadastroPage.preencherSobrenoNome(sobrenome);
	}

	@Quando("informo a senha {string}")
	public void informoASenhaSenha(String senha) {
		cadastroPage.preencherSenha(senha);
	}

	@Quando("informo o dia {string} de dia de nascimento")
	public void informoODiaDeDiaDeNascimento(String dia) {
		cadastroPage.selecionaDiaDeNascimento(dia);
	}

	@Quando("informo o mes {string} de mes de nascimento")
	public void informoOMesDeMesDeNascimento(String mes) {
		cadastroPage.selecionaMesDeNascimento(mes);
	}

	@Quando("informo o ano {string} de ano de nascimento")
	public void informoOAnoDeAnoDeNascimento(String ano) {
		cadastroPage.selecionaAnoDeNascimento(ano);
	}

	@Quando("informo o endereco {string}")
	public void informoOEndereco(String endereco) {
		cadastroPage.preencherEndereco(endereco);
	}

	@Quando("informo a cidade {string}")
	public void informoACidade(String cidade) {
		cadastroPage.preencherCidade(cidade);
	}

	@Quando("informo o estado {string}")
	public void informoOEstado(String estado) {
		cadastroPage.preencherEstado(estado);
	}

	@Quando("informo o cep {string}")
	public void informoOCep(String cep) {
		cadastroPage.preencherCep(cep);
	}

	@Quando("informo o pais {string}")
	public void informoOPais(String pais) {
		cadastroPage.selecionaPais(pais);
	}

	@Quando("informo o numero de celular {string}")
	public void informoONumeroDeCelular(String celular) {
		cadastroPage.preencherCelular(celular);
	}

	@Quando("informo o endereco alternativo {string}")
	public void informoOEnderecoAlternativo(String alias) {
		cadastroPage.preencherAlias(alias);
	}

	@Quando("clico na acao registrar uma conta")
	public void clicoNaAcaoRegistrarUmaConta() {
		cadastroPage.btnConfirmarInformacoesDeNovoCadastro();

	}

	@Entao("eu sou redirecionado para o menu minha conta")
	public void souRedirecionadoParaOMenuMinhaConta() {
		minhaContaPage = cadastroPage.navegarParaPaginaDeMinhaConta();// para cá
		//Assert.assertFalse(cadastroPage.estouNaPaginaDeCadastro());
		Assert.assertTrue(minhaContaPage.estouNaPaginaMinhaConta());

	}

	@Entao("uma mensagem de cadastro com erro e mostrada")
	public void umaMensagemDeCadastroInvalidoEMostrada() {
		Assert.assertTrue(cadastroPage.estouNaPaginaDeCadastroComErro());
		Assert.assertTrue(cadastroPage.mensagemCadastroInválido());
	}
	
	

}
