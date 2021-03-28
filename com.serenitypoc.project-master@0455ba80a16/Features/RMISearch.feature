#Author: Teja.Sistla
@RMISearch
Feature: RMISearchGUI

  #========================================================== SCENARIO-1 ===================================================================================
  Scenario: Search with the MidRule Dot Version
    Given Launch Browser and Login to RMI Application
    When Search with the Midule dot Version 75.1
    Then Validate the Values with the API 

