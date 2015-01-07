package com.d3.messages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class messagesMapping {
	
	public WebDriver driver;

    public messagesMapping(WebDriver driver)
    {
        this.driver = driver;
    }
	
    @FindBy(how = How.CSS, using = "div.nav-icon.messages.center")
    
    public WebElement Messages;
    
    @FindBy(how = How.NAME, using = "searchTerm")
    
    public WebElement SearchField;
    
    @FindBy(how = How.CLASS_NAME, using = "icon-search")
    
    public WebElement SearchSubmit;

}
