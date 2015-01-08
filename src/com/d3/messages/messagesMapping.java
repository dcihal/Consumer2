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
    
    @FindBy(how = How.CLASS_NAME, using = "dropdown-toggle")
    
    public WebElement SearchCategory;
    
    
    @FindBy(how = How.CLASS_NAME, using = "icon-calendar")
    
    public WebElement MessagesCalendar;
    
    @FindBy(how = How.NAME, using = "startDate")
    
    public WebElement MessagesCalendarStartDate;
    
    @FindBy(how = How.NAME, using = "endDate")
    
    public WebElement MessagesCalendarEndDate;
    
    @FindBy(how = How.LINK_TEXT, using = "Search")
    
    public WebElement MessagesSearch;
    
    
      

}
