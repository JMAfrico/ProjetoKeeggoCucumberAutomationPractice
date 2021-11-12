package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class LoginPage {

	private WebDriver driver;
	private Scenario cenario;

	private static String URL_LOGIN = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

	public LoginPage() {
		
	}
	
	public LoginPage(WebDriver driver, Scenario cenario) {	
			this.cenario = cenario;
			cenario.log("Abrindo Pagina de Login");
			this.driver = driver;
			driver.navigate().to(URL_LOGIN);
			driver.manage().window().maximize();	
			
			TakesScreenshot screen = (TakesScreenshot)driver;
			byte[] data = screen.getScreenshotAs(OutputType.BYTES);
			cenario.attach(data, "image/png", null);
	}

	// espera a página de cadastro carregar
//	private void esperaCarregarPaginaDeCadastro() {
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		wait.until(ExpectedConditions.urlToBe(URL_CADASTRO));
//	}
//
//	// espera a página de cadastro com erro carregar
//	private void esperaCarregarPaginaDeCadastroInvalido() {
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		wait.until(ExpectedConditions.urlToBe(URL_CADASTRO_INVALIDO));
//	}
//
	// espera o texto de email invalido carregar
	private void esperaCarregarTextoEmailInvalido() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBe(By.id("create_account_error"), "Invalid email address."));
	}
//
	// espera o texto de email invalido carregar
	private void esperaCarregarBotaoNovoCadastro() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("authentication")));
	}
//
//	// Verifica se estou na página de Login
//	public boolean estouNaPaginaDeLogin() {
//		return this.driver.getCurrentUrl().equals(URL_LOGIN);
//	}
//
	// Verifica se estou na página de Login com erro
	public boolean estouNaPaginaDeLoginComEmailInvalido() {
		String msg = "Valido mensagem de email invalido";
		esperaCarregarTextoEmailInvalido();
		
		WebElement erro = driver.findElement(By.xpath("//*[@id=\"create_account_error\"]"));
		TakesScreenshot screen = (TakesScreenshot)erro;
		byte[] data = screen.getScreenshotAs(OutputType.BYTES);
		cenario.attach(data, "image/png", null);
		
		cenario.log(msg);
		return this.driver.getCurrentUrl().equals(URL_LOGIN) && verificaTextoDaPaginaEmailInvalido();
		
	}
//
//	// Verifica se estou na página de cadastro
//	public boolean estouNaPaginaDeCadastro() {
//		esperaCarregarPaginaDeCadastro();
//		return this.driver.getCurrentUrl().equals(URL_CADASTRO) && verificaTextoDaPaginaCadastroValido();
//	}
//
//	// Verifica se estou na página de cadastro com erro após tentativa de novo
//	// cadastro
//	public boolean estouNaPaginaDeCadastroComErro() {
//		esperaCarregarPaginaDeCadastroInvalido();
//		return this.driver.getCurrentUrl().equals(URL_CADASTRO_INVALIDO);
//	}
//
	// preenche o campo email para validação de inicio de cadastro
	
	public void validarEmailParaCadastro(String email) {
		String msg = "Digito email para cadastro "+email;
		
		WebElement txtValidarEmail = driver.findElement(By.id("email_create"));
		txtValidarEmail.sendKeys(email);
		
		TakesScreenshot screen = (TakesScreenshot)txtValidarEmail;
		byte[] data = screen.getScreenshotAs(OutputType.BYTES);
		cenario.attach(data, "image/png", null);
		
		cenario.log(msg);
	}

	// clica no botão validar email para cadastro
	public void btnValidarEmailParaCadastro() {
		String msg = "Clico no botão de cadastro ";
		esperaCarregarBotaoNovoCadastro();
		
		WebElement btnValidarEmail = driver.findElement(By.id("SubmitCreate"));
		
		TakesScreenshot screen = (TakesScreenshot)btnValidarEmail;
		byte[] data = screen.getScreenshotAs(OutputType.BYTES);
		cenario.attach(data, "image/png", null);
		
		btnValidarEmail.submit();
		cenario.log(msg);
	}
//
//	// Confirmação do texto que estou na página de cadastro
//	public boolean verificaTextoDaPaginaCadastroValido() {
//		return driver.getPageSource().contains("Create an account");
//	}
//
	// Confirmação do texto que deu erro no preenchimento de cadastro com email
	// inválido
	public boolean verificaTextoDaPaginaEmailInvalido() {
		return driver.getPageSource().contains("Invalid email address.");
	}
//
//	// Preenchimento dos campos de novo cadastro
//	public void selecionaSexo(String sexo) {
//
//		if (sexo.equals("Mr.")) {
//			WebElement rdGeneroMasc = driver.findElement(By.xpath("//input[@id='id_gender1']"));
//			rdGeneroMasc.click();
//		} else if (sexo.equals("Mrs.")) {
//			WebElement rdGeneroFem = driver.findElement(By.xpath("//input[@id='id_gender2']"));
//			rdGeneroFem.click();
//		}
//	}
//
//	public void preencherNome(String nome) {
//		WebElement txtNome = driver.findElement(By.id("customer_firstname"));
//		txtNome.sendKeys(nome);
//	}
//
//	public void preencherSobrenoNome(String sobrenome) {
//		WebElement txtSobrenome = driver.findElement(By.id("customer_lastname"));
//		txtSobrenome.sendKeys(sobrenome);
//	}
//
//	public void preencherSenha(String senha) {
//		WebElement txtSenha = driver.findElement(By.id("passwd"));
//		txtSenha.sendKeys(senha);
//	}
//
//	public void selecionaDiaDeNascimento(String dia) {
//		WebElement selectDia = driver.findElement(By.xpath("//*[@id='days']"));
//		selectDia.sendKeys(dia);
//	}
//
//	public void selecionaMesDeNascimento(String mes) {
//		WebElement selectMes = driver.findElement(By.xpath("//*[@id='months']"));
//		selectMes.sendKeys(mes);
//	}
//
//	public void selecionaAnoDeNascimento(String ano) {
//		WebElement selectAno = driver.findElement(By.xpath("//*[@id='years']"));
//		selectAno.sendKeys(ano);
//	}
//
//	public void preencherEndereco(String endereco) {
//		WebElement txtEndereco = driver.findElement(By.id("address1"));
//		txtEndereco.sendKeys(endereco);
//	}
//
//	public void preencherCidade(String cidade) {
//		WebElement txtCidade = driver.findElement(By.id("city"));
//		txtCidade.sendKeys(cidade);
//	}
//
//	public void preencherEstado(String estado) {
//		WebElement txtEstado = driver.findElement(By.id("id_state"));
//		txtEstado.sendKeys(estado);
//	}
//
//	public void preencherCep(String cep) {
//		WebElement txtCep = driver.findElement(By.id("postcode"));
//		txtCep.sendKeys(cep);
//	}
//
//	public void selecionaPais(String pais) {
//		WebElement txtPais = driver.findElement(By.id("id_country"));
//		txtPais.sendKeys(pais);
//	}
//
//	public void preencherCelular(String celular) {
//		WebElement txtCelular = driver.findElement(By.id("phone_mobile"));
//		txtCelular.sendKeys(celular);
//	}
//
//	public void preencherAlias(String alias) {
//		WebElement txtAlias = driver.findElement(By.id("alias"));
//		txtAlias.clear();
//		txtAlias.sendKeys(alias);
//	}
//
//	public void btnConfirmarInformacoesDeNovoCadastro() {
//		driver.findElement(By.id("submitAccount")).click();
//	}
//
	public MinhaContaPage navegarParaPaginaDeMinhaConta() {
		// esperaCarregarPaginaDeCadastro();
		return new MinhaContaPage(driver,cenario);
	}
//
	public void mensagemEmailJaCadastrado() {
		String msg = "Valido mensagem de email ja cadastrado";
		driver.getPageSource().contains("email address has already been registered.");
		
		WebElement erro = driver.findElement(By.xpath("//*[@id=\"create_account_error\"]"));
		
		TakesScreenshot screen = (TakesScreenshot)erro;
		byte[] data = screen.getScreenshotAs(OutputType.BYTES);
		cenario.attach(data, "image/png", null);
		cenario.log(msg);
	}
//
//	public boolean mensagemCadastroInválido() {
//		return driver.getPageSource().contains("errors");
//
//	}

	// login
	public void preencherEmailLogin(String email) {
		String msg = "Preenchendo email "+email;
		WebElement txtEmail = driver.findElement(By.id("email"));
		txtEmail.sendKeys(email);
			
		TakesScreenshot screen = (TakesScreenshot)txtEmail;
		byte[] data = screen.getScreenshotAs(OutputType.BYTES);
		cenario.attach(data, "image/png", null);
		
		cenario.log(msg);
	}

	public void preencherSenhaDoLogin(String senha) {
		String msg = "Preenchendo senha "+senha;
		WebElement txtSenha = driver.findElement(By.id("passwd"));
		txtSenha.sendKeys(senha);
		
		TakesScreenshot screen = (TakesScreenshot)txtSenha;
		byte[] data = screen.getScreenshotAs(OutputType.BYTES);
		cenario.attach(data, "image/png", null);
		
		cenario.log(msg);
	}

	public void ClicarEmFazerLogin() {
		String msg = "Clico no botao de fazer login";
		WebElement btnFazerLogin = driver.findElement(By.id("SubmitLogin"));
		
		TakesScreenshot screen = (TakesScreenshot)btnFazerLogin;
		byte[] data = screen.getScreenshotAs(OutputType.BYTES);
		cenario.attach(data, "image/png", btnFazerLogin.getText());
		
		btnFazerLogin.click();
		cenario.log(msg);
	}

	public boolean mensagemAcessoInvalido() {
		String msg = "Valido mensagem de acesso invalido";
			
		WebElement erro = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]"));
		TakesScreenshot screen = (TakesScreenshot)erro;
		byte[] data = screen.getScreenshotAs(OutputType.BYTES);
		cenario.attach(data, "image/png", null);
		
		String pageSource = driver.getPageSource();
		cenario.log(msg);
		return pageSource.contains("Authentication failed.") || pageSource.contains("Invalid password.");
		
	}
	
	public CadastroPage navegarParaPaginaDeCadastro() {
		return new CadastroPage(driver,cenario);
	}

}
