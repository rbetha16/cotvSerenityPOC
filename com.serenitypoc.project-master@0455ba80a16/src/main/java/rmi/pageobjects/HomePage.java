package rmi.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.WhenPageOpens;
import rmi.utilities.ProjectVariables;
import rmi.utilities.SeleniumUtils;

public class HomePage extends PageObject {

	SeleniumUtils oSeleniumUtils;

	@FindBy(xpath = "//input[@placeholder='Search']")
	public WebElementFacade Search_Box;

	@FindBy(xpath = "//pagination//following::input[@disabled='disabled']")
	public WebElementFacade pagination;

	@FindBy(xpath = "//div[@class='autocomplete-results']/div")
	public WebElementFacade autoselect;

	@FindBy(xpath = "//div[text() = ' Mid Rule - DP ']")
	public WebElementFacade midRule_DP_Section;

	public WebElement Midrule_Version_Subrule_Deactivated_Disabled_Retired_CPTARD_ICDARD_QuirkyDiag_MidRuleRelationships_DateAdded_DOSFrom_DOSTo(
			String headername) {
		return getDriver().findElement(By.xpath("//strong[text()='"+headername+"']//parent::div//span"));
	}

	public WebElement highlight_Midrule_Version_Subrule_Deactivated_Disabled_Retired_CPTARD_ICDARD_QuirkyDiag_MidRuleRelationships_DateAdded_DOSFrom_DOSTo(
			String headername) {
		return getDriver().findElement(By.xpath("//strong[text()='"+headername+"']"));
	}

	public WebElement highlight_Description_SubRuleNotes_ConfigNotes_Payers(String headername) {
		return getDriver().findElement(By.xpath("//div[text()='"+headername+"']"));
	}

	public WebElement Description_SubRuleNotes_ConfigNotes_Payers(String headername) {
		return getDriver().findElement(By.xpath("//div[text()='"+headername+"']//following-sibling::div"));
	}

	public WebElement fieldvalue_Of_MidRuleDP_Jurisdictions_PolicyType_Topic_ClaimTypes_MRLOBs_DPBilateralType_DPKey_MRIndustryUpdInd_EditFlag_CVSource_ECLRule_RealTimeMR_PODMR_CVRule(
			String headername) {
		return getDriver().findElement(
				By.xpath("//div[text()='"+headername+"']//following-sibling::div"));
	}

	public WebElement fieldlabel_Of_MidRuleDP_Jurisdictions_PolicyType_Topic_ClaimTypes_MRLOBs_DPBilateralType_DPKey_MRIndustryUpdInd_EditFlag_CVSource_ECLRule_RealTimeMR_PODMR_CVRule(
			String headername) {
		return getDriver().findElement(
				By.xpath("//div[text()='"+headername+"'and @class='fld-label']"));
	}

	
	@SuppressWarnings("deprecation")
	@WhenPageOpens
	public void waitUntilSearchBoxAppears() throws Exception {

		$(Search_Box).withTimeoutOf(ProjectVariables.MID_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible();

	}

	/**
	 * @author naga.sistla ThrowsException
	 * 
	 *         Open the Browser and Login to RMI Application to Land in the Home
	 *         Page Wait Until the Search Box Appears in Home Page
	 */

	public void search_Key(String midruledotversion) throws Exception {
		oSeleniumUtils.highlightElement(Search_Box);
		$(Search_Box).clear();
		oSeleniumUtils.is_WebElement_Displayed(Search_Box);
		$(Search_Box).sendKeys(midruledotversion);

	}

	/**
	 * @author naga.sistla ThrowsException
	 * 
	 *         Searches For the Element In Auto Complete and Clicks on The MidRule
	 *         Dot Version From Auto Complete Drop Down
	 * 
	 */

	public void click_AutoComplete() throws Exception {

		SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);
		oSeleniumUtils.is_WebElement_Displayed(autoselect);
		$(autoselect).click();
		SeleniumUtils.defaultWait(2000);
	}

	/**
	 * @author naga.sistla ThrowsException
	 * 
	 *         Gets the MidRule.Version and SubRule Value
	 * 
	 */

	public String get_Midrule_Version_Subrule(String headername) throws Exception {

		oSeleniumUtils.is_WebElement_Displayed(
				highlight_Midrule_Version_Subrule_Deactivated_Disabled_Retired_CPTARD_ICDARD_QuirkyDiag_MidRuleRelationships_DateAdded_DOSFrom_DOSTo(
						headername));
		String header_value = Midrule_Version_Subrule_Deactivated_Disabled_Retired_CPTARD_ICDARD_QuirkyDiag_MidRuleRelationships_DateAdded_DOSFrom_DOSTo(
				headername).getText();
		System.out.println(header_value);
		SeleniumUtils.defaultWait(1000);
		if (header_value.isEmpty()) {
			return header_value = "";
		} else {
			System.out.println(headername + " = " + header_value);
			return header_value;
		}

	}

	/**
	 * @author naga.sistla ThrowsException
	 * 
	 *         Gets the
	 *         Deactivated,Disabled,Retired,CPTARD,ICDARD,QuirkyDiag,MidRuleRelationships
	 *         Flag Values
	 * 
	 */

	public boolean get_Deactivated_Disabled_Retired_CPTARD_ICDARD_QuirkyDiag_MidRuleRelationships(String headername)
			throws Exception {
		oSeleniumUtils.is_WebElement_Displayed(
				highlight_Midrule_Version_Subrule_Deactivated_Disabled_Retired_CPTARD_ICDARD_QuirkyDiag_MidRuleRelationships_DateAdded_DOSFrom_DOSTo(
						headername));
		oSeleniumUtils.is_WebElement_Displayed(
				Midrule_Version_Subrule_Deactivated_Disabled_Retired_CPTARD_ICDARD_QuirkyDiag_MidRuleRelationships_DateAdded_DOSFrom_DOSTo(
						headername));
		String header_flag = Midrule_Version_Subrule_Deactivated_Disabled_Retired_CPTARD_ICDARD_QuirkyDiag_MidRuleRelationships_DateAdded_DOSFrom_DOSTo(
				headername).getText();
		SeleniumUtils.defaultWait(1000);
		if (header_flag.equalsIgnoreCase("Yes") || header_flag.equalsIgnoreCase("No")) {
			System.out.println(headername + " = " + header_flag);
		}
		return true;
	}

	/**
	 * @author naga.sistla ThrowsException
	 * 
	 *         Gets the DateAdded,DOSFrom,DOSTo Values
	 * 
	 */

	public String get_DateAdded_DOSFrom_DOSTo(String headername) throws Exception {
		oSeleniumUtils.is_WebElement_Displayed(
				Midrule_Version_Subrule_Deactivated_Disabled_Retired_CPTARD_ICDARD_QuirkyDiag_MidRuleRelationships_DateAdded_DOSFrom_DOSTo(
						headername));
		String header = Midrule_Version_Subrule_Deactivated_Disabled_Retired_CPTARD_ICDARD_QuirkyDiag_MidRuleRelationships_DateAdded_DOSFrom_DOSTo(
				headername).getText();
		SeleniumUtils.defaultWait(1000);
		return header;
	}

	/**
	 * @author naga.sistla ThrowsException
	 * 
	 *         Highlights and Gets the Description,SubRuleNotes,ConfigNotes,Payers
	 *         and gets the description value
	 * 
	 */

	public void get_Description_SubRuleNotes_ConfigNotes_Payers(String headername) throws Exception {
		oSeleniumUtils.is_WebElement_Displayed(highlight_Description_SubRuleNotes_ConfigNotes_Payers(headername));
		oSeleniumUtils.is_WebElement_Displayed(Description_SubRuleNotes_ConfigNotes_Payers(headername));
		String header = highlight_Description_SubRuleNotes_ConfigNotes_Payers(headername).getText();
		System.out.println(header);
		String header_description = Description_SubRuleNotes_ConfigNotes_Payers(headername).getText();
		System.out.println(header_description);
	}

	/**
	 * @author naga.sistla ThrowsException
	 * 
	 *         Highlights and Gets the
	 *         MidRuleDP,Jurisdictions,PolicyType,Topic,ClaimTypes,MRLOBs,DPBilateralType,DPKey,MRIndustryUpdInd,EditFlag,CVSource,ECLRule
	 *         Values
	 * 
	 */

	public String get_MidRuleDP_Jurisdictions_PolicyType_Topic_ClaimTypes_MRLOBs_DPBilateralType_DPKey_MRIndustryUpdInd_EditFlag_CVSource_ECLRule(
			String headername) throws Exception {
		
		$(midRule_DP_Section).isDisplayed();
		oSeleniumUtils.is_WebElement_Displayed(
				fieldlabel_Of_MidRuleDP_Jurisdictions_PolicyType_Topic_ClaimTypes_MRLOBs_DPBilateralType_DPKey_MRIndustryUpdInd_EditFlag_CVSource_ECLRule_RealTimeMR_PODMR_CVRule(
						headername));
		oSeleniumUtils.is_WebElement_Displayed(
				fieldvalue_Of_MidRuleDP_Jurisdictions_PolicyType_Topic_ClaimTypes_MRLOBs_DPBilateralType_DPKey_MRIndustryUpdInd_EditFlag_CVSource_ECLRule_RealTimeMR_PODMR_CVRule(
						headername));
		String header = fieldvalue_Of_MidRuleDP_Jurisdictions_PolicyType_Topic_ClaimTypes_MRLOBs_DPBilateralType_DPKey_MRIndustryUpdInd_EditFlag_CVSource_ECLRule_RealTimeMR_PODMR_CVRule(
				headername).getText();

		System.out.println(header);
		return header;

	}

	/**
	 * @author naga.sistla ThrowsException
	 * 
	 *         Highlights and Gets the RealTimeMR, PODMR, CVRule Values
	 * 
	 */

	public boolean get_RealTimeMR_PODMR_CVRule(String headername) throws Exception {
		oSeleniumUtils.is_WebElement_Displayed(
				fieldlabel_Of_MidRuleDP_Jurisdictions_PolicyType_Topic_ClaimTypes_MRLOBs_DPBilateralType_DPKey_MRIndustryUpdInd_EditFlag_CVSource_ECLRule_RealTimeMR_PODMR_CVRule(
						headername));
		oSeleniumUtils.is_WebElement_Displayed(
				fieldvalue_Of_MidRuleDP_Jurisdictions_PolicyType_Topic_ClaimTypes_MRLOBs_DPBilateralType_DPKey_MRIndustryUpdInd_EditFlag_CVSource_ECLRule_RealTimeMR_PODMR_CVRule(
						headername));
		String header = fieldvalue_Of_MidRuleDP_Jurisdictions_PolicyType_Topic_ClaimTypes_MRLOBs_DPBilateralType_DPKey_MRIndustryUpdInd_EditFlag_CVSource_ECLRule_RealTimeMR_PODMR_CVRule(
				headername).getText();
		if (header.equalsIgnoreCase("Yes") || header.equalsIgnoreCase("No")) {
			System.out.println(headername + " = " + header);
		}
		return true;

	}
}
