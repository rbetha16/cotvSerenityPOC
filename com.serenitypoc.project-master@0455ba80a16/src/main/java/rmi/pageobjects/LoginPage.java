package rmi.pageobjects;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.WhenPageOpens;
import rmi.utilities.GenericUtils;
import rmi.utilities.ProjectVariables;
import rmi.utilities.SeleniumUtils;


public class LoginPage extends PageObject {

	@FindBy(id = "okta-signin-username")
	public WebElementFacade UserName_Txt;
	
	@FindBy(id = "okta-signin-password")
	public WebElementFacade Password_Txt;
	
	@FindBy(id = "okta-signin-submit")
	public WebElementFacade Login_Btn; 
	
	
	
	@WhenPageOpens
    public void waitUntilTitleAppears() {		
		UserName_Txt.withTimeoutOf(ProjectVariables.MID_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible();  
		Password_Txt.withTimeoutOf(ProjectVariables.MID_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible();  
		
		Login_Btn.withTimeoutOf(ProjectVariables.MID_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible();  
    }

	public void Login_to_the_RMI_application() throws Exception {
		getDriver().manage().window().maximize();
		SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);
		// Enter Username
		
		oSeleniumUtils.highlightElement(UserName_Txt);
		UserName_Txt.withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible().clear();
		UserName_Txt.waitUntilVisible().sendKeys(ProjectVariables.USER_NAME);
		// Enter Password
		oSeleniumUtils.highlightElement(Password_Txt);
		Password_Txt.waitUntilVisible().clear();
		
		//Need to user Genereic Utils to Decode the password GenericUtils.decode(ProjectVariables.PASSWORD)
		Password_Txt.waitUntilVisible().sendKeys(ProjectVariables.PASSWORD);
		oSeleniumUtils.Click_given_WebElement(Login_Btn);
	
		
	}
	
	
	
	

 }
