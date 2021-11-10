package com.automationpractice.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)//Usando Junit 4- Run -> Run Configuration > Test Runner Junit 4
@CucumberOptions(features = "classpath:features", //onde esta a pasta com os cen�rios
					glue = "com.automationpractice.steps",//onde esta a pasta com os steps
					tags = "@carrinho", // tag que ser� executada e testada
					plugin = "pretty",//melhora resultado visual no console
					monochrome = true,//console sem caracteres especiais
					snippets = SnippetType.CAMELCASE)//steps escritos em m�todo padr�o do Java
public class AutomationPracticeCucumberRunner {

}
