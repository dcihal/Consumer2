package com.d3.accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class accountsMapping {
	
    @FindBy(how = How.CSS, using = "div.nav-icon.accounts.center")
    
    public WebElement Accounts;

}
