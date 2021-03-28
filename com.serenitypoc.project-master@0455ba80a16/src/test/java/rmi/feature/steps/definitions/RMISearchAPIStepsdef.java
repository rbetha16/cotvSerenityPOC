package rmi.feature.steps.definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.junit.Assert;


import io.restassured.response.Response;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import rmi.utilities.RestUtils;

public class RMISearchAPIStepsdef extends ScenarioSteps {

	private static final long serialVersionUID = 1L;
	RestUtils ru = new RestUtils();
	Response midrule_version_response;
	int response_status_code = 200;

	/**
	 * MidRule Dot Version API
	 */

	@Step
	public void Set_Value_Of_MidRule_Dot_Version(String midruledotversionkey) throws Exception {
		midrule_version_response = ru.getRequest("midrulekeydotversion/"+midruledotversionkey);

	}

	@Step
	public void Validate_MidRule_Response() throws Exception {
		assertEquals(response_status_code, ru.responseStatusCode(midrule_version_response));
		

	}

	@Step
	public void Verify_MidRule_Dot_Version_API() throws Exception {
	
		JSONArray midrule_dot_version = ru.parseJSONArray(midrule_version_response);
		
		
		for (int i = 0; i < midrule_dot_version.size(); i++) {
			JSONObject midrule_version_jobj = (JSONObject) midrule_dot_version.get(i);
			System.out.println(midrule_version_jobj);
			String subRulekey = Long.toString((Long) midrule_version_jobj.get("subRuleKey"));
			String reasonCode = (String) midrule_version_jobj.get("reasonCode");
			String bwReasonCode = (String) midrule_version_jobj.get("bwReasonCode");
			
			String ruleHeaderDesc = (String) midrule_version_jobj.get("ruleHeaderDesc");
			
			String ruleHeaderKey = Long.toString((Long) midrule_version_jobj.get("ruleHeaderKey"));
			String dpKeyForSubRuleKey = Long.toString((Long) midrule_version_jobj.get("dpKeyForSubRuleKey"));
			
			assertNotNull(subRulekey + reasonCode + bwReasonCode + ruleHeaderDesc + ruleHeaderKey + dpKeyForSubRuleKey);

		}

	}

	/**
	 * SubRule API
	 */

	@Step
	public void Set_Value_Of_SubRule(String subrulekey) throws Exception {

		midrule_version_response=ru.getRequest("subrulekey/"+subrulekey);
	}
	
	
	@Step
	public void Validate_SubRule_Response() throws Exception {
		assertEquals(response_status_code, ru.responseStatusCode(midrule_version_response));
		

	}

	@Step
	public void Verify_SubRule_API() throws Exception {
	
		JSONArray subrule = ru.parseJSONArray(midrule_version_response);
		
		
		for (int i = 0; i < subrule.size(); i++) {
			JSONObject subrule_jobj = (JSONObject) subrule.get(i);
			System.out.println(subrule_jobj);
			String deactivated = Long.toString((Long) subrule_jobj.get("deactivated"));
			String disabled = Long.toString((Long) subrule_jobj.get("disabled"));
			String subRuleRetired = (String) subrule_jobj.get("subRuleRetired");
			
			String subRuleDescription = (String) subrule_jobj.get("subRuleDescription");
			
			String libraryStatusKey = Long.toString((Long) subrule_jobj.get("libraryStatusKey"));
			
			String dosFrom = (String) subrule_jobj.get("dosFrom");
			String dosTo = (String) subrule_jobj.get("dosTo");
						
			assertNotNull(deactivated + disabled + subRuleRetired + subRuleDescription + libraryStatusKey + dosFrom + dosTo);

		}

	}
	
	
	/**
	 * DPKey API
	 */

	@Step
	public void Set_Value_Of_DPKey(String dpkey, String pagenum, String pagesize) throws Exception {

		midrule_version_response=ru.getRequest("dpkey/"+dpkey+"?"+pagenum+"&"+pagesize);
	}
	
	
	@Step
	public void Validate_DPKey_Response() throws Exception {
		assertEquals("Response Status Code ", ru.responseStatusCode(midrule_version_response));
		

	}

	@Step
	public void Verify_DPKey_API() throws Exception {
	
		JSONObject dpkey = ru.parseJSONObject(midrule_version_response);
		System.out.println(dpkey);
		String subRulesTotalCount = Long.toString((Long) dpkey.get("subRulesTotalCount"));
		
		assertNotNull(subRulesTotalCount);
		
	}



}
