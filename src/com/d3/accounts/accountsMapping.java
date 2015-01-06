package com.d3.accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class accountsMapping {
	
	public WebDriver driver;

    public accountsMapping(WebDriver driver)
    {
        this.driver = driver;
    }
	
    @FindBy(how = How.CSS, using = "div.nav-icon.accounts.center")
    
    public WebElement Accounts;

}
