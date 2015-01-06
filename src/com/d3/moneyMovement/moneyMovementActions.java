package com.d3.moneyMovement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.d3.dashboard.moneyMovementMapping;

public class moneyMovementActions {
	
    public void init(WebDriver driver, Long timeout)
    {

      	Mapping = new moneyMovementMapping(driver);
        PageFactory.initElements(driver, Mapping);
        Driver = driver;
        wait = new WebDriverWait(driver, timeout);
    	
    }
    
    public void moneyMovementButton(WebDriver driver)
    {
	    wait.until(ExpectedConditions.visibilityOf(Mapping.MoneyMovement));	
	    Mapping.MoneyMovement.click(); 
	}

}
