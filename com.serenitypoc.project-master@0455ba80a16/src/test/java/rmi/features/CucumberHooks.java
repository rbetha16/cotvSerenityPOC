package rmi.features;

import cucumber.api.java.After;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.pages.Pages;


public class CucumberHooks {
	
	@ManagedPages
	private Pages pages;
	
	
   
    
    @After 
    public void cleanUp(){ 
    	
    	pages.getDriver().quit(); 
     } 

}
