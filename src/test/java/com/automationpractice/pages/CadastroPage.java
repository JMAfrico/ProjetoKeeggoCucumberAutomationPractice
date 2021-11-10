package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPage {

	private WebDriver driver;

	private static String URL_LOGIN = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	private static String URL_CADASTRO = "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
	private static String URL_CADASTRO_INVALIDO = "http://automationpractice.com/index.php?controller=authentication";
	private static String URL_MINHA_CONTA = "http://automationpractice.com/index.php?controller=my-account";

	public CadastroPage(WebDriver driver) {
		this.driver = driver;

	}
	
	private void esperaCarregarPaginaDeCadastro() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.urlToBe(URL_CADASTRO));
	}
	
	private void esperaCarregarPaginaMinhaConta() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.urlToBe(URL_MINHA_CONTA));
	}

	// espera a página de cadastro com erro carregar
	private void esperaCarregarPaginaDeCadastroInvalido() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.urlToBe(URL_CADASTRO_INVALIDO));
	}

	// espera o texto de email invalido carregar
	private void esperaCarregarTextoEmailInvalido() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBe(By.id("create_account_error"), "Invalid email address."));
	}

	// espera o texto de email invalido carregar
	private void esperaCarregarBotaoNovoCadastro() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("authentication")));
	}

	// Verifica se estou na página de Login
	public boolean estouNaPaginaDeLogin() {
		return this.driver.getCurrentUrl().equals(URL_LOGIN);
	}

	// Verifica se estou na página de Login com erro
	public boolean estouNaPaginaDeLoginComEmailInvalido() {
		esperaCarregarTextoEmailInvalido();
		return this.driver.getCurrentUrl().equals(URL_LOGIN) && verificaTextoDaPaginaEmailInvalido();
	}

	// Verifica se estou na página de cadastro
	public boolean estouNaPaginaDeCadastro() {
		esperaCarregarPaginaDeCadastro();
		return this.driver.getCurrentUrl().equals(URL_CADASTRO) && verificaTextoDaPaginaCadastroValido();
	}

	// Verifica se estou na página de cadastro com erro após tentativa de novo
	// cadastro
	public boolean estouNaPaginaDeCadastroComErro() {
		esperaCarregarPaginaDeCadastroInvalido();
		return this.driver.getCurrentUrl().equals(URL_CADASTRO_INVALIDO);
	}

	// preenche o campo email para validação de inicio de cadastro
	public void validarEmailParaCadastro(String email) {
		driver.findElement(By.id("email_create")).sendKeys(email);
	}

	// clica no botão validar email para cadastro
	public void btnValidarEmailParaCadastro() {
		esperaCarregarBotaoNovoCadastro();
		driver.findElement(By.id("SubmitCreate")).submit();

	}

	// Confirmação do texto que estou na página de cadastro
	public boolean verificaTextoDaPaginaCadastroValido() {
		return driver.getPageSource().contains("Create an account");
	}

	// Confirmação do texto que deu erro no preenchimento de cadastro com email
	// inválido
	public boolean verificaTextoDaPaginaEmailInvalido() {
		return driver.getPageSource().contains("Invalid email address.");
	}

	// Preenchimento dos campos de novo cadastro
	public void selecionaSexo(String sexo) {

		if (sexo.equals("Mr.")) {
			WebElement rdGeneroMasc = driver.findElement(By.xpath("//input[@id='id_gender1']"));
			rdGeneroMasc.click();
		} else if (sexo.equals("Mrs.")) {
			WebElement rdGeneroFem = driver.findElement(By.xpath("//input[@id='id_gender2']"));
			rdGeneroFem.click();
		}
	}

	public void preencherNome(String nome) {
		WebElement txtNome = driver.findElement(By.id("customer_firstname"));
		txtNome.sendKeys(nome);
	}

	public void preencherSobrenoNome(String sobrenome) {
		WebElement txtSobrenome = driver.findElement(By.id("customer_lastname"));
		txtSobrenome.sendKeys(sobrenome);
	}

	public void preencherSenha(String senha) {
		WebElement txtSenha = driver.findElement(By.id("passwd"));
		txtSenha.sendKeys(senha);
	}

	public void selecionaDiaDeNascimento(String dia) {
		WebElement selectDia = driver.findElement(By.xpath("//*[@id='days']"));
		selectDia.sendKeys(dia);
	}

	public void selecionaMesDeNascimento(String mes) {
		WebElement selectMes = driver.findElement(By.xpath("//*[@id='months']"));
		selectMes.sendKeys(mes);
	}

	public void selecionaAnoDeNascimento(String ano) {
		WebElement selectAno = driver.findElement(By.xpath("//*[@id='years']"));
		selectAno.sendKeys(ano);
	}

	public void preencherEndereco(String endereco) {
		WebElement txtEndereco = driver.findElement(By.id("address1"));
		txtEndereco.sendKeys(endereco);
	}

	public void preencherCidade(String cidade) {
		WebElement txtCidade = driver.findElement(By.id("city"));
		txtCidade.sendKeys(cidade);
	}

	public void preencherEstado(String estado) {
		WebElement txtEstado = driver.findElement(By.id("id_state"));
		txtEstado.sendKeys(estado);
	}

	public void preencherCep(String cep) {
		WebElement txtCep = driver.findElement(By.id("postcode"));
		txtCep.sendKeys(cep);
	}

	public void selecionaPais(String pais) {
		WebElement txtPais = driver.findElement(By.id("id_country"));
		txtPais.sendKeys(pais);
	}

	public void preencherCelular(String celular) {
		WebElement txtCelular = driver.findElement(By.id("phone_mobile"));
		txtCelular.sendKeys(celular);
	}

	public void preencherAlias(String alias) {
		WebElement txtAlias = driver.findElement(By.id("alias"));
		txtAlias.clear();
		txtAlias.sendKeys(alias);
	}

	public void btnConfirmarInformacoesDeNovoCadastro() {
		driver.findElement(By.id("submitAccount")).click();
	}

	public MinhaContaPage navegarParaPaginaDeMinhaConta() {
		//esperaCarregarPaginaMinhaConta();
		return new MinhaContaPage(driver);
	}

	public void mensagemEmailJaCadastrado() {
		driver.getPageSource().contains("email address has already been registered.");
	}

	public boolean mensagemCadastroInválido() {
		return driver.getPageSource().contains("errors");

	}
	
	
}
