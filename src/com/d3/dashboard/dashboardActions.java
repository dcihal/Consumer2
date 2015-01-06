package com.d3.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.d3.utils.Utils;


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
    
    public void quickPay(WebDriver driver)
    {
	    wait.until(ExpectedConditions.visibilityOf(Mapping.QuickPay));	
	    Mapping.QuickPay.click(); 
	}

    public void selectRecipient(WebDriver driver)
    {
	    wait.until(ExpectedConditions.visibilityOf(Mapping.SelectRecipient));	
	    Mapping.SelectRecipient.click(); 
	}
    
    public void myCreditCardAccount(WebDriver driver)
    {
	    wait.until(ExpectedConditions.visibilityOf(Mapping.MyCreditCardAccount));	
	    Actions action = new Actions(driver);    
	   		action.moveToElement(Mapping.MyCreditCardAccount).click().build().perform();   
    }

    public void setQuickPayAmount(WebDriver driver, String amount)
    {
	    wait.until(ExpectedConditions.visibilityOf(Mapping.Amount));	
	    new Actions(driver).moveToElement(Mapping.Amount).perform();
	    Mapping.Amount.sendKeys(amount);; 
    }
    
    public void quickPayCalendarCurrentDate(WebDriver driver)
    {
	    wait.until(ExpectedConditions.visibilityOf(Mapping.QuickPayCalendar));	
	    new Actions(driver).moveToElement(Mapping.QuickPayCalendar).perform();
	    Mapping.QuickPayCalendar.sendKeys(Utils.getDateMMddyyyywithSlash()); 
    }
    
    public void quickPayCalendarSpecificDate(WebDriver driver, String date)
    {
	    wait.until(ExpectedConditions.visibilityOf(Mapping.QuickPayCalendar));	
	    new Actions(driver).moveToElement(Mapping.QuickPayCalendar).perform();
	    Mapping.QuickPayCalendar.sendKeys(date); 
    }
    
    public void quickPaySubmitButton(WebDriver driver)
    {
	    wait.until(ExpectedConditions.visibilityOf(Mapping.QuickPaySubmit));	
	    Actions action = new Actions(driver);    
   		action.moveToElement(Mapping.QuickPaySubmit).click().build().perform();
    }
    
    public void quickPayConfirm(WebDriver driver)
    {
	    wait.until(ExpectedConditions.visibilityOf(Mapping.QuickPayConfirm));	
	    Actions action = new Actions(driver);    
   		action.moveToElement(Mapping.QuickPayConfirm).click().build().perform();   
    }    

}
