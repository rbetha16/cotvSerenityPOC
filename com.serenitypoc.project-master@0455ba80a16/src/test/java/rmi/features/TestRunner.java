package rmi.features;

import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="Features/RMISearch.feature", plugin = {"pretty", "html:target/cucumber-html-report"})

public class TestRunner {
	
	
}
