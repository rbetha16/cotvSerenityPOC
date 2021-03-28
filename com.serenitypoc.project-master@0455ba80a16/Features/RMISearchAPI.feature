#Author: Teja.Sistla
@RMISearch
Feature: RMISearchAPI

  #========================================================== SCENARIO-1 ===================================================================================
  Scenario: Search with the MidRule Dot Version
    Given Send the MidRule Dot Version 75.1
    Then Validate the MidRule Dot Version API Status Code
    And Verify subRuleKey and reasonCode and bwReasonCode and ruleHeaderDesc and ruleHeaderKey and dpKeyForSubRuleKey

  #========================================================== SCENARIO-2 ===================================================================================
  Scenario: Search with the SubRule
    Given Send the SubRule Key 1860
    Then Validate the SubRule API Status Code
    And Verify deactivated and disabled and subRuleRetired and subRuleDescription and libraryStatusKey and dosFrom and dosTo

  #========================================================== SCENARIO-3 ===================================================================================
  Scenario: Search with the DPKey
    Given Send the DP Key 4719 and pagenum=1 and pagesize=1
    Then Validate the DPKey API Status Code
    And Verify subRulesTotalCount
