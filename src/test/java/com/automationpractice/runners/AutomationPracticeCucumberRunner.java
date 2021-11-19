package com.automationpractice.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", 
					glue = "com.automationpractice.steps",
					tags = "@acesso_valido", 
					plugin = {"pretty","html:target/report/report.html","json:target/report/report.json"},
					snippets = SnippetType.CAMELCASE)
public class AutomationPracticeCucumberRunner {

}
