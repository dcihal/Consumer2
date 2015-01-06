package com.d3.accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class accountsActions {
	
    public WebDriver Driver;
    public String TimeToWait; 
    public accountsMapping Mapping;
    public WebDriverWait wait;
	
    public void init(WebDriver driver, Long timeout)
    {

      	Mapping = new accountsMapping(driver);
        PageFactory.initElements(driver, Mapping);
        Driver = driver;
        wait = new WebDriverWait(driver, timeout);
    	
    }
    
    public void accountsButton(WebDriver driver)
    {
	    wait.until(ExpectedConditions.visibilityOf(Mapping.Accounts));	
	    Mapping.Accounts.click(); 
	}

}
