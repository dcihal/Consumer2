package com.d3.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.d3.dashboard.settingsMapping;

public class settingsActions {
	
    public void init(WebDriver driver, Long timeout)
    {

      	Mapping = new settingsMapping(driver);
        PageFactory.initElements(driver, Mapping);
        Driver = driver;
        wait = new WebDriverWait(driver, timeout);
    	
    }

    public void settingsButton(WebDriver driver)
    {
	    wait.until(ExpectedConditions.visibilityOf(Mapping.Settings));	
	    Mapping.Settings.click(); 
	}
    
}
