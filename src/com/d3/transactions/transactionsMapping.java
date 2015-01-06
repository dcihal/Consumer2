package com.d3.transactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class transactionsMapping {
	
	public WebDriver driver;

    public transactionsMapping(WebDriver driver)
    {
        this.driver = driver;
    }

    @FindBy(how = How.CSS, using = "div.nav-icon.transactions.center")
    
    public WebElement Transactions;
	
}
