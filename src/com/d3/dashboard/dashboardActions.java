package com.d3.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class dashboardActions {
	
    public WebDriver Driver;
    public String TimeToWait; 
    public dashboardMapping Mapping;
    public WebDriverWait wait;
	
	
    public void init(WebDriver driver, Long timeout)
    {

      	Mapping = new dashboardMapping(driver);
        PageFactory.initElements(driver, Mapping);
        Driver = driver;
        wait = new WebDriverWait(driver, timeout);
    	
    }
    
    public void planButton(WebDriver driver)
    {
	    wait.until(ExpectedConditions.visibilityOf(Mapping.Plan));	
	    Mapping.Plan.click(); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn.active.flipper-button.plan-button")));
    }
    
    public void createBudget(WebDriver driver)
    {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn.active.flipper-button.plan-button")));
	    wait.until(ExpectedConditions.visibilityOf(Mapping.CreateBudget));	
	    Mapping.CreateBudget.click(); 
	}
    
    public void manageButton(WebDriver driver)
    {
	    wait.until(ExpectedConditions.visibilityOf(Mapping.Manage));	
	    Mapping.Manage.click(); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn.active.flipper-button.manage-button")));
	}
    

}
