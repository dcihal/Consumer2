package com.d3.transactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.d3.dashboard.transactionsMapping;

public class transactionsActions {
	
    public void init(WebDriver driver, Long timeout)
    {

      	Mapping = new transactionsMapping(driver);
        PageFactory.initElements(driver, Mapping);
        Driver = driver;
        wait = new WebDriverWait(driver, timeout);
    	
    }

    public void transactionsButton(WebDriver driver)
    {
	    wait.until(ExpectedConditions.visibilityOf(Mapping.Transactions));	
	    Mapping.Transactions.click(); 
	}
    
}
