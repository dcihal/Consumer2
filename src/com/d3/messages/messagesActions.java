package com.d3.messages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class messagesActions {
	
    public WebDriver Driver;
    public String TimeToWait; 
    public messagesMapping Mapping;
    public WebDriverWait wait;
	
	
    public void init(WebDriver driver, Long timeout)
    {

      	Mapping = new messagesMapping(driver);
        PageFactory.initElements(driver, Mapping);
        Driver = driver;
        wait = new WebDriverWait(driver, timeout);
    	
    }
	
    public void messagesButton(WebDriver driver)
    {
	    wait.until(ExpectedConditions.visibilityOf(Mapping.Messages));	
	    Mapping.Messages.click(); 
	}

}
