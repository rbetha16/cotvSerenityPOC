package rmi.features.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;
import rmi.feature.steps.definitions.RMISearchAPIStepsdef;

public class RMISearchAPISteps {
	
	@Steps
	RMISearchAPIStepsdef oRMISearchApiStepDef;
	
	/**
	 * MidRule Dot Version API
	 */

	
	@Given("^Send the MidRule Dot Version ([^\"]*)$")
	public void set_The_MidRule_Dot_Version(String midruledotversion) throws Throwable {
		
		oRMISearchApiStepDef.Set_Value_Of_MidRule_Dot_Version(midruledotversion);
		
	}

	
	@Then("^Validate the MidRule Dot Version API Status Code$")
	public void validate_The_Midrule_Dot_Version_API() throws Throwable {
		oRMISearchApiStepDef.Validate_MidRule_Response();
		
	   
	}


	@And("^Verify subRuleKey and reasonCode and bwReasonCode and ruleHeaderDesc and ruleHeaderKey and dpKeyForSubRuleKey$")
	public void verify_subRuleKey_reasonCode_bwReasonCode_ruleHeaderDesc_ruleHeaderKey_dpKeyForSubRuleKey() throws Throwable {
		oRMISearchApiStepDef.Verify_MidRule_Dot_Version_API();
	
	    
	}
	
	
	/**
	 * SubRule Key API
	 */


	@Given("^Send the SubRule Key ([^\"]*)$")
	public void set_The_SubRule_Key(String subrule) throws Throwable {
		
		oRMISearchApiStepDef.Set_Value_Of_SubRule(subrule);
	}

	
	@Then("^Validate the SubRule API Status Code$")
	public void validate_The_SubRule_API() throws Throwable {
		oRMISearchApiStepDef.Validate_SubRule_Response();
		
	   
	}


	@And("^Verify deactivated and disabled and subRuleRetired and subRuleDescription and libraryStatusKey and dosFrom and dosTo$")
	public void verify_deactivated_disabled_subRuleRetired_subRuleDescription_libraryStatusKey_dosFrom_dosTo() throws Throwable {
		oRMISearchApiStepDef.Verify_SubRule_API();
	
	    
	}
	
	/**
	 * DP Key API
	 */


	@Given("^Send the DP Key ([^\"]*) and ([^\"]*) and ([^\"]*)$")
	public void set_The_DP_Key(String dp,String pagenum, String pagesize) throws Throwable {
		
		oRMISearchApiStepDef.Set_Value_Of_DPKey(dp,pagenum, pagesize);
	}

	
	@Then("^Validate the DPKey API Status Code$")
	public void validate_The_DP_Key_API() throws Throwable {
		oRMISearchApiStepDef.Validate_DPKey_Response();
		
	   
	}


	@And("^Verify subRulesTotalCount$")
	public void verify_subRulesTotalCount() throws Throwable {
		oRMISearchApiStepDef.Verify_DPKey_API();
	
	    
	}

	
	
	
}
