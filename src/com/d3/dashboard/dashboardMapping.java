package com.d3.dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class dashboardMapping {
	
	public WebDriver driver;

    public dashboardMapping(WebDriver driver)
    {
        this.driver = driver;
    }

public WebElement Manage;
	
    @FindBy(how = How.CSS, using = "button.btn.flipper-button.plan-button")
//  @FindBy(how = How.XPATH, using = "//img[contains(@src,'assets/img/glyphicons_173_play_right.png')]")
    
	public WebElement Plan;
    
    @FindBy(how = How.CSS, using = "button.create-budget.btn.pull-right")
    
    public WebElement CreateBudget;
    
	
}
