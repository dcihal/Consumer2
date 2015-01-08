package com.d3.messages;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.d3.accounts.accountsActions;
import com.d3.dashboard.dashboardActions;
import com.d3.help.helpActions;
import com.d3.login.loginActions;
import com.d3.messages.messagesActions;
import com.d3.moneyMovement.moneyMovementActions;
import com.d3.planning.planningActions;
import com.d3.settings.settingsActions;
//import com.d3.testrails.D3TestRails;
import com.d3.transactions.transactionsActions;
import com.d3.utils.Utils;
import com.d3.utils.Utils.BrowserType;
//import com.gurock.testrail.APIException;

public class searchMessageContent {
	
	public WebDriver driver;
	private BrowserType browser;
	String TestCase; 
	String TestRun = "16"; 
	loginActions LoginActions = new loginActions();
	dashboardActions DashboardActions = new dashboardActions();
	messagesActions MessagesActions = new messagesActions();
	accountsActions AccountsActions = new accountsActions();
	transactionsActions TransactionsActions = new transactionsActions();
	moneyMovementActions MoneyMovementActions = new moneyMovementActions();
	planningActions PlanningActions = new planningActions();
	helpActions HelpActions = new helpActions();
	settingsActions SettingsActions = new settingsActions();
	//D3TestRails d3testrails = new D3TestRails();
	Utils utils = new Utils();

   	//Properties p = Utils.loadProperties(".\\conf\\properties.properties");            


	@BeforeClass
	@Parameters({"browse", "WebdriverTimeout", "baseurl"})
	public void launchBrowser(@Optional("FIREFOX") String browse, String WebdriverTimeout, String baseurl)
	{
    	switch (browse)
    	{
    	    case "FIREFOX": 
    	    	browser = Utils.BrowserType.FIREFOX;
            	break;
    	    case "IE":
    	    	browser = Utils.BrowserType.IE;
            	break;
            case "CHROME":
            	browser = Utils.BrowserType.CHROME;
            	break;
            default:
            	browser = Utils.BrowserType.FIREFOX;
            	break;
            	

    	}
    	
        //String webdriverTimeout = p.getProperty("WebdriverTimeout");
    	Long timeout = Long.valueOf(WebdriverTimeout);
        driver = Utils.getWebDriver(browser, timeout); 
		
		driver.get(baseurl);
		LoginActions.init(driver, timeout);
		DashboardActions.init(driver, timeout);
		MessagesActions.init(driver, timeout);

	}
				
/*	@BeforeClass
	@Parameters({"testRailUrl", "testRailUserName", "testRailPassWord"})
	public void initTestRails(String testRailUrl, String testRailUserName, String testRailPassWord)
	{	
		d3testrails.InitRail(testRailUrl, testRailUserName, testRailPassWord);
	}*/
	
	
	  @Test(priority = 17, groups = {"smoke", "regression"})
	  @Parameters({"userName", "passWord", "secretQuestion"})
	  public void verifySearchMessageContent(String userName, String passWord, String secretQuestion) throws InterruptedException 
	  {
		   TestCase = "333";
		   LoginActions.loginUn(driver, userName);
		   LoginActions.loginPw(driver, passWord);
		   LoginActions.submit(driver);
		   LoginActions.secretQuestion(driver, secretQuestion);
		   LoginActions.privateDevice(driver);
		   LoginActions.submit(driver);
		   MessagesActions.messagesButton(driver);
		   MessagesActions.searchField(driver, "Internal Transfer Created Alert from your bank");
		   Utils.isTextPresent(driver, "Internal Transfer Created Alert from your bank");
		   // STILL NEED TO DO AN ASSERT THAT TEXT IS NOT PRESENT ON THE PAGE //
		   //Utils.isTextNotPresent(driver, "Successful Transfer Alert from your bank");
	  } 

/*  @AfterMethod
  public void updateTestRails(ITestResult result) 
  {
     if (result.getStatus() == ITestResult.SUCCESS) {
        try {
			d3testrails.Passed(TestRun, TestCase, "It worked!");
		} catch (IOException | APIException e) {
			e.printStackTrace();
		}
        //System.out.print("Successful TestRun [" + TestRun + "] TestCase[" + TestCase + "]\n");
     }
     else
     {
         try {
 			d3testrails.Failed(TestRun, TestCase, "It failed!");
 		} catch (IOException | APIException e) {
 			e.printStackTrace();
 		}
        //System.out.print("Failed TestRun [" + TestRun + "] TestCase[" + TestCase + "]\n");
     }
  }*/  
     
  @AfterMethod
  public void takeScreenShotOnFailure(ITestResult testResult) throws IOException 
  {
	  
		  Date date = new Date(System.currentTimeMillis());
	      String dateString = date.toString();
      
    	 if (testResult.getStatus() == ITestResult.FAILURE) { 
    		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
    		 FileUtils.copyFile(scrFile, new File(".\\Reports\\Screenshots\\" + testResult.getName()  + dateString + ".png")); 
    		 } 
  }
  

   
  @AfterClass
  public void terminateBrowser()
  {
	  driver.quit();
  }



}
