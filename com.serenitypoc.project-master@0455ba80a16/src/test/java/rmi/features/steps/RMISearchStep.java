package rmi.features.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

import rmi.feature.steps.definitions.RMISearchStepDef;

public class RMISearchStep {
	
	@Steps
	RMISearchStepDef oRMISearchStepDef;
	
	/**
	 * MidRule Dot Version Search 
	 */

	
	@Given("^Launch Browser and Login to RMI Application$")
	public void open_Browser_And_Login() throws Throwable {
		
		oRMISearchStepDef.open_Browser_to_Login();
		
	}

	
	@When("^Search with the Midule dot Version ([^\"]*)$")
	public void validate_The_Midrule_Dot_Version_API(String midruledotversion) throws Throwable {
		
		oRMISearchStepDef.search_midrule_dot_version(midruledotversion);
	   
	}


	@Then("^Validate the Values with the API$")
	public void verify_subRuleKey_reasonCode_bwReasonCode_ruleHeaderDesc_ruleHeaderKey_dpKeyForSubRuleKey() throws Throwable {
		
		oRMISearchStepDef.Verify_MidRule_Dot_Version_API();
	    
	}
	
	
}
