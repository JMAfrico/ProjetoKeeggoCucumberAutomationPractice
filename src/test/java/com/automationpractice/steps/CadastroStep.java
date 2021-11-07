package com.automationpractice.steps;

import org.junit.Assert;

import com.automationpractice.pages.Browser;
import com.automationpractice.pages.CadastroPage;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.MinhaContaPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class CadastroStep {

	private Browser browser;
	private HomePage homePage;
	private CadastroPage cadastroPage;
	private MinhaContaPage minhaContaPage;


	@Before
	public void setup() {
		browser = new Browser();
		homePage = browser.getHomePage();	
	}

	@After
	public void tearDown() {
		//browser.fechar();
	}

	// @email
	@Dado("que eu estou na pagina de login")
	public void queEuEstouNaPaginaDeLogin() {
		cadastroPage = homePage.navegarParaPaginaDeLogin();
	}

	@Quando("informo o {string}")
	public void informoO(String email) {
		cadastroPage.validarEmailParaCadastro("maria3@hotmail.com");
	}

	@Quando("informo o {string} invalido")
	public void informoOEmailInvalido(String email) {
		cadastroPage.validarEmailParaCadastro("fulano");
	}
	
	@Quando("informo o {string} que ja foi cadastrado")
	public void informoOQueJaFoiCadastrado(String string) {
		cadastroPage.validarEmailParaCadastro("fulano@hotmail.com");
	}

	@Quando("seleciono a acao de criar uma conta")
	public void selecionoAAcaoDeCriarUmaConta() {
		cadastroPage.btnValidarEmailParaCadastro();
	}

	@Entao("sou redirecionado para a tela de novo usuario")
	public void souRedirecionadoParaATelaDeNovoUsuario() {
		Assert.assertTrue(this.cadastroPage.estouNaPaginaDeCadastro());
	}

	@Entao("uma mensagem de erro e mostrada")
	public void umaMensagemDeErroEMostrada() {
		Assert.assertTrue(this.cadastroPage.estouNaPaginaDeLoginComEmailInvalido());
	}
	
	@Entao("uma mensagem de email ja cadastrado e mostrada")
	public void umaMensagemDeEmailJaCadastrado() {
		cadastroPage.mensagemEmailJaCadastrado();
	}

	// @autenticacao
	@Dado("que tenho um email valido de novo usuario")
	public void queTenhoUmEmailValidoDeNovoUsuario() {
		cadastroPage = homePage.navegarParaPaginaDeLogin();
		cadastroPage.validarEmailParaCadastro("maria5@hotmail.com");
		cadastroPage.btnValidarEmailParaCadastro();
	}

	@Dado("que eu estou na pagina de cadastro de usuario")
	public void queEuEstouNaPaginaDeCadastroDeUsuario() {
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

	@Entao("sou redirecionado para o menu minha conta")
	public void souRedirecionadoParaOMenuMinhaConta() {		
		minhaContaPage = cadastroPage.navegarParaPaginaDeMinhaConta();
		Assert.assertFalse(cadastroPage.estouNaPaginaDeLogin());
		Assert.assertTrue(minhaContaPage.estouNaPaginaMinhaConta());

	}
	
	@Entao("uma mensagem de cadastro com erro e mostrada")
	public void umaMensagemDeCadastroInvalidoEMostrada() {
		Assert.assertTrue(cadastroPage.estouNaPaginaDeCadastroComErro());
		Assert.assertTrue(cadastroPage.mensagemCadastroInválido());
	}

}
