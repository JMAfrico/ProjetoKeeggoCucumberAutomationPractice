package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver;
	
	private static String URL_HOME_PAGE = "http://automationpractice.com/index.php";
	
	public HomePage() {
		// TODO Auto-generated constructor stub
	}
	//Abre o home Page assim que é chamado
	public HomePage(WebDriver driver) {
		this.driver = driver;
		driver.navigate().to(URL_HOME_PAGE);
		driver.manage().window().maximize();
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
	
	

	
	
	
	

}
