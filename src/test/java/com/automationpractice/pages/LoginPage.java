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

	public LoginPage(WebDriver driver, Scenario cenario) {
		this.cenario = cenario;
		cenario.log("Abrindo Pagina de Login");
		this.driver = driver;
		driver.navigate().to(URL_LOGIN);
		driver.manage().window().maximize();

		TakesScreenshot screen = (TakesScreenshot) driver;
		byte[] data = screen.getScreenshotAs(OutputType.BYTES);
		cenario.attach(data, "image/png", null);
	}

	private void esperaCarregarTextoEmailInvalido() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBe(By.id("create_account_error"), "Invalid email address."));
	}

	private void esperaCarregarBotaoNovoCadastro() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("authentication")));
	}

	public boolean estouNaPaginaDeLoginComEmailInvalido() {
		String msg = "Valido mensagem de email invalido";
		esperaCarregarTextoEmailInvalido();

		WebElement erro = driver.findElement(By.xpath("//*[@id=\"create_account_error\"]"));
		TakesScreenshot screen = (TakesScreenshot) erro;
		byte[] data = screen.getScreenshotAs(OutputType.BYTES);
		cenario.attach(data, "image/png", null);

		cenario.log(msg);
		return this.driver.getCurrentUrl().equals(URL_LOGIN) && verificaTextoDaPaginaEmailInvalido();

	}

	public void validarEmailParaCadastro(String email) {
		String msg = "Digito email para cadastro " + email;

		WebElement txtValidarEmail = driver.findElement(By.id("email_create"));
		txtValidarEmail.sendKeys(email);

		TakesScreenshot screen = (TakesScreenshot) txtValidarEmail;
		byte[] data = screen.getScreenshotAs(OutputType.BYTES);
		cenario.attach(data, "image/png", null);

		cenario.log(msg);
	}

	public void btnValidarEmailParaCadastro() {
		String msg = "Clico no botão de cadastro ";
		esperaCarregarBotaoNovoCadastro();

		WebElement btnValidarEmail = driver.findElement(By.id("SubmitCreate"));

		TakesScreenshot screen = (TakesScreenshot) btnValidarEmail;
		byte[] data = screen.getScreenshotAs(OutputType.BYTES);
		cenario.attach(data, "image/png", null);

		btnValidarEmail.submit();
		cenario.log(msg);
	}

	public boolean verificaTextoDaPaginaEmailInvalido() {
		return driver.getPageSource().contains("Invalid email address.");
	}

	public MinhaContaPage navegarParaPaginaDeMinhaConta() {
		return new MinhaContaPage(driver, cenario);
	}

	public void mensagemEmailJaCadastrado() {
		String msg = "Valido mensagem de email ja cadastrado";
		driver.getPageSource().contains("email address has already been registered.");

		WebElement erro = driver.findElement(By.xpath("//*[@id=\"create_account_error\"]"));

		TakesScreenshot screen = (TakesScreenshot) erro;
		byte[] data = screen.getScreenshotAs(OutputType.BYTES);
		cenario.attach(data, "image/png", null);
		cenario.log(msg);
	}

	public void preencherEmailLogin(String email) {
		String msg = "Preenchendo email " + email;
		WebElement txtEmail = driver.findElement(By.id("email"));
		txtEmail.sendKeys(email);

		TakesScreenshot screen = (TakesScreenshot) txtEmail;
		byte[] data = screen.getScreenshotAs(OutputType.BYTES);
		cenario.attach(data, "image/png", null);

		cenario.log(msg);
	}

	public void preencherSenhaDoLogin(String senha) {
		String msg = "Preenchendo senha " + senha;
		WebElement txtSenha = driver.findElement(By.id("passwd"));
		txtSenha.sendKeys(senha);

		TakesScreenshot screen = (TakesScreenshot) txtSenha;
		byte[] data = screen.getScreenshotAs(OutputType.BYTES);
		cenario.attach(data, "image/png", null);

		cenario.log(msg);
	}

	public void clicarEmFazerLogin() {
		String msg = "Clico no botao de fazer login";
		WebElement btnFazerLogin = driver.findElement(By.id("SubmitLogin"));

		TakesScreenshot screen = (TakesScreenshot) btnFazerLogin;
		byte[] data = screen.getScreenshotAs(OutputType.BYTES);
		cenario.attach(data, "image/png", btnFazerLogin.getText());

		btnFazerLogin.click();
		cenario.log(msg);
	}

	public boolean mensagemAcessoInvalido() {
		String msg = "Valido mensagem de acesso invalido";

		WebElement erro = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]"));
		TakesScreenshot screen = (TakesScreenshot) erro;
		byte[] data = screen.getScreenshotAs(OutputType.BYTES);
		cenario.attach(data, "image/png", null);

		String pageSource = driver.getPageSource();
		cenario.log(msg);
		return pageSource.contains("Authentication failed.") || pageSource.contains("Invalid password.");

	}

	public CadastroPage navegarParaPaginaDeCadastro() {
		return new CadastroPage(driver, cenario);
	}

}
