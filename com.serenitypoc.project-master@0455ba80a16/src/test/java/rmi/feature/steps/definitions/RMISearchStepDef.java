package rmi.feature.steps.definitions;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;

import rmi.pageobjects.HomePage;
import rmi.pageobjects.LoginPage;
import io.restassured.response.Response;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import rmi.utilities.SeleniumUtils;
import rmi.utilities.ProjectVariables;
import rmi.utilities.RestUtils;

public class RMISearchStepDef extends ScenarioSteps {

	// private static final long serialVersionUID = 1L;
	HomePage oHomePage;
	LoginPage oLPage;
	SeleniumUtils oSeleniumUtils;
	RestUtils restutils;
	Response midrule_version_response;
	int response_status_code = 200;
	String midrule_api;
	String version_api;
	String midrule_dot_version_api;
	String subRulekey_api;
	String ruleHeaderKey_api;
	String ruleHeaderDesc_api;
	String lobsForRule_api;
	String dpBilatType_api;
	String dos_added_api;
	String dos_from_api;
	String dos_to_api;

	/**
	 * @author naga.sistla ThrowsException Open the Browser and Login to RMI
	 *         Application to Land in the Home Page Wait Until the Search Box
	 *         Appears in Home Page
	 */

	@Step
	public void open_Browser_to_Login() throws Exception {

		oLPage.open();

		oLPage.Login_to_the_RMI_application();

		oHomePage.waitUntilSearchBoxAppears();

	}

	@Step
	public void search_midrule_dot_version(String midruledotversion) throws Exception {

		oHomePage.search_Key(midruledotversion);
		restutils = new RestUtils();
		midrule_version_response = restutils.getRequest("midrulekeydotversion/" + midruledotversion);


	}

	@Step
	public void Verify_MidRule_Dot_Version_API() throws Exception {
		oHomePage.click_AutoComplete();
		
		String midrule_dotversion = oHomePage.get_Midrule_Version_Subrule("Mid Rule.Vsn");
		System.out.println(midrule_dotversion);
		
		String subrule = oHomePage.get_Midrule_Version_Subrule("Sub Rule");
		System.out.println(subrule);
		
		Assert.assertTrue("Validating the Deactivated Flag Value", oHomePage.get_Deactivated_Disabled_Retired_CPTARD_ICDARD_QuirkyDiag_MidRuleRelationships("Deactivated"));
		Assert.assertTrue("Validating the Disabled Flag Value", oHomePage.get_Deactivated_Disabled_Retired_CPTARD_ICDARD_QuirkyDiag_MidRuleRelationships("Disabled"));
		Assert.assertTrue("Validating the Retired Flag Value", oHomePage.get_Deactivated_Disabled_Retired_CPTARD_ICDARD_QuirkyDiag_MidRuleRelationships("Retired"));
		Assert.assertTrue("Validating the CPTARD Flag Value", oHomePage.get_Deactivated_Disabled_Retired_CPTARD_ICDARD_QuirkyDiag_MidRuleRelationships("CPT ARD"));
		Assert.assertTrue("Validating the CPTARD Flag Value", oHomePage.get_Deactivated_Disabled_Retired_CPTARD_ICDARD_QuirkyDiag_MidRuleRelationships("ICD ARD"));
		Assert.assertTrue("Validating the QuirkyDiag Flag value", oHomePage.get_Deactivated_Disabled_Retired_CPTARD_ICDARD_QuirkyDiag_MidRuleRelationships("Quirky Diag"));
		Assert.assertTrue("Validating the midRuleRelationship Flag Value", oHomePage.get_Deactivated_Disabled_Retired_CPTARD_ICDARD_QuirkyDiag_MidRuleRelationships("Mid Rule Relationships"));
		
		String dos_added = oHomePage.get_DateAdded_DOSFrom_DOSTo("Date Added");
		System.out.println(dos_added);
		String dos_from = oHomePage.get_DateAdded_DOSFrom_DOSTo("DOS From");
		System.out.println(dos_from);
		String dos_to = oHomePage.get_DateAdded_DOSFrom_DOSTo("DOS To");
		System.out.println(dos_to);

		oHomePage.get_Description_SubRuleNotes_ConfigNotes_Payers("DESCRIPTION");
		oHomePage.get_Description_SubRuleNotes_ConfigNotes_Payers("SUB RULE NOTES");
		oHomePage.get_Description_SubRuleNotes_ConfigNotes_Payers("CONFIG NOTES");
		oHomePage.get_Description_SubRuleNotes_ConfigNotes_Payers("PAYERS");
		
		String policy_type = oHomePage.get_MidRuleDP_Jurisdictions_PolicyType_Topic_ClaimTypes_MRLOBs_DPBilateralType_DPKey_MRIndustryUpdInd_EditFlag_CVSource_ECLRule("Policy Type");
		System.out.println(policy_type);
		
		String med_policy = oHomePage.get_MidRuleDP_Jurisdictions_PolicyType_Topic_ClaimTypes_MRLOBs_DPBilateralType_DPKey_MRIndustryUpdInd_EditFlag_CVSource_ECLRule("Med Policy");
		System.out.println(med_policy);
		
		String topic = oHomePage.get_MidRuleDP_Jurisdictions_PolicyType_Topic_ClaimTypes_MRLOBs_DPBilateralType_DPKey_MRIndustryUpdInd_EditFlag_CVSource_ECLRule("Topic");
		System.out.println(topic);
		
		String claim_types = oHomePage.get_MidRuleDP_Jurisdictions_PolicyType_Topic_ClaimTypes_MRLOBs_DPBilateralType_DPKey_MRIndustryUpdInd_EditFlag_CVSource_ECLRule("Claim Types");
		System.out.println(claim_types); 
		
		String mrlob = oHomePage.get_MidRuleDP_Jurisdictions_PolicyType_Topic_ClaimTypes_MRLOBs_DPBilateralType_DPKey_MRIndustryUpdInd_EditFlag_CVSource_ECLRule("MR LOBs");
		System.out.println(mrlob);
		
		Assert.assertTrue("Validating the Real Time MR Flag Value", oHomePage.get_RealTimeMR_PODMR_CVRule("Real Time MR"));
		Assert.assertTrue("Validating the POD MR Flag Value", oHomePage.get_RealTimeMR_PODMR_CVRule("POD MR"));
		
		String bilateral_type = oHomePage.get_MidRuleDP_Jurisdictions_PolicyType_Topic_ClaimTypes_MRLOBs_DPBilateralType_DPKey_MRIndustryUpdInd_EditFlag_CVSource_ECLRule("DP Bilateral Type");
		System.out.println(bilateral_type);
		
		String dpkey = oHomePage.get_MidRuleDP_Jurisdictions_PolicyType_Topic_ClaimTypes_MRLOBs_DPBilateralType_DPKey_MRIndustryUpdInd_EditFlag_CVSource_ECLRule("DP Key");
		System.out.println(dpkey);
		
		String mrindustry = oHomePage.get_MidRuleDP_Jurisdictions_PolicyType_Topic_ClaimTypes_MRLOBs_DPBilateralType_DPKey_MRIndustryUpdInd_EditFlag_CVSource_ECLRule("MR Industry Upd Ind");
		System.out.println(mrindustry);
		
		Assert.assertTrue("Validating the CV Rule Flag Value", oHomePage.get_RealTimeMR_PODMR_CVRule("CV Rule"));
		
		String editflag = oHomePage.get_MidRuleDP_Jurisdictions_PolicyType_Topic_ClaimTypes_MRLOBs_DPBilateralType_DPKey_MRIndustryUpdInd_EditFlag_CVSource_ECLRule("Edit Flag");
		System.out.println(editflag);
		
		String cvsource = oHomePage.get_MidRuleDP_Jurisdictions_PolicyType_Topic_ClaimTypes_MRLOBs_DPBilateralType_DPKey_MRIndustryUpdInd_EditFlag_CVSource_ECLRule("CV Source");
		System.out.println(cvsource);
		
		String eclrule = oHomePage.get_MidRuleDP_Jurisdictions_PolicyType_Topic_ClaimTypes_MRLOBs_DPBilateralType_DPKey_MRIndustryUpdInd_EditFlag_CVSource_ECLRule("ECL Rule");
		System.out.println(eclrule);

		JSONArray midrule_dot_version = restutils.parseJSONArray(midrule_version_response);

		for (int i = 0; i < midrule_dot_version.size(); i++) {
			JSONObject midrule_version_jobj = (JSONObject) midrule_dot_version.get(i);
			System.out.println(midrule_version_jobj);
			midrule_api = Long.toString((Long) midrule_version_jobj.get("midRuleKey"));
			version_api = Long.toString((Long) midrule_version_jobj.get("ruleVersion"));
			midrule_dot_version_api = midrule_api+"."+version_api;
			
			subRulekey_api = Long.toString((Long) midrule_version_jobj.get("subRuleKey"));
			
			ruleHeaderKey_api = Long.toString((Long) midrule_version_jobj.get("ruleHeaderKey"));

			ruleHeaderDesc_api = (String) midrule_version_jobj.get("ruleHeaderDesc");
			
			String reasoncode_api = (String) midrule_version_jobj.get("reasonCode");
			
			String betweenreasoncode_api = (String) midrule_version_jobj.get("bwReasonCode");
			
			String deactivated_api = Long.toString((Long) midrule_version_jobj.get("deactivated"));
			String disabled_api = Long.toString((Long) midrule_version_jobj.get("disabled"));
			
			String subRuleDescription_api = (String) midrule_version_jobj.get("subRuleDescription");
			
			String librarystatuskey_api = Long.toString((Long) midrule_version_jobj.get("libraryStatusKey"));
			
			String dpkey_api = Long.toString((Long) midrule_version_jobj.get("dpKeyForSubRuleKey"));
			
			String payersforrule_api = (String) midrule_version_jobj.get("payersForRule");
			String subrulenotes_api = (String) midrule_version_jobj.get("subRuleNotes");
			
			String confignotes_api = (String) midrule_version_jobj.get("configNotes");
			String retired_api = (String) midrule_version_jobj.get("subRuleRetired");
			
			String cptard_api = (String) midrule_version_jobj.get("isCptArd");
			
			String podmr_api = (String) midrule_version_jobj.get("isPodMR");
			String realtimemr_api = (String) midrule_version_jobj.get("isRealTimeMR");
			
			String quirkydiag_api = (String) midrule_version_jobj.get("isQuirkyDiag");
			
			dpBilatType_api = (String) midrule_version_jobj.get("dpBilatType");
			String dpBilatTypeDesc_api = (String) midrule_version_jobj.get("dpBilatTypeDesc");
			String _api = (String) midrule_version_jobj.get("isRealTimeMR");
			String jurisdictions_api = (String) midrule_version_jobj.get("mcareJurisListForSubRule");
			
			lobsForRule_api = (String) midrule_version_jobj.get("lobsForRule");

			String relationexists_api = (String) midrule_version_jobj.get("mrRelationExist");
			String policytitle_api = (String) midrule_version_jobj.get("medPolTitleForSubRuleKey");
			String topictitle_api = (String) midrule_version_jobj.get("topicTitleForSubRuleKey");
			String claimtype_api = (String) midrule_version_jobj.get("claimTypesForRule");
			String industryUpdate_api = (String) midrule_version_jobj.get("industryUpdIndForRule");

			String cvrule_api = Long.toString((Long) midrule_version_jobj.get("cvRule"));
			
			
			dos_added_api = (String) midrule_version_jobj.get("dateAdded");
			dos_from_api = (String) midrule_version_jobj.get("dosFrom");
			dos_to_api = (String) midrule_version_jobj.get("dosTo");
		}
		
		Assert.assertEquals("Validating the midrule dot version ", midrule_dotversion, midrule_dot_version_api);

		Assert.assertEquals("Validating the SubRule", subrule, subRulekey_api);
		Assert.assertEquals("Validating the MR LOB", mrlob, lobsForRule_api);
		Assert.assertEquals("Validating the DP BiLateral Type", bilateral_type, dpBilatType_api);
		Assert.assertEquals("Validating the DP DOS Added", dos_added, dos_added_api);
		Assert.assertEquals("Validating the DP DOS From", dos_from, dos_from_api);
		Assert.assertEquals("Validating the DP DOS To", dos_to, dos_to_api);

	}

}
