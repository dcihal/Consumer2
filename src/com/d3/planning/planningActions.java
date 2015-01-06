package com.d3.planning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.d3.dashboard.planningMapping;

public class planningActions {
	
    public void init(WebDriver driver, Long timeout)
    {

      	Mapping = new planningMapping(driver);
        PageFactory.initElements(driver, Mapping);
        Driver = driver;
        wait = new WebDriverWait(driver, timeout);
    	
    }
    
    public void planningButton(WebDriver driver)
    {
	    wait.until(ExpectedConditions.visibilityOf(Mapping.Planning));	
	    Mapping.Planning.click(); 
	}
    
}
