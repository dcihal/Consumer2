package com.d3.transactions;

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
import com.d3.transactions.transactionsActions;
import com.d3.login.loginActions;
import com.d3.testrails.D3TestRails;
import com.d3.utils.Utils;
import com.d3.utils.Utils.BrowserType;
import com.gurock.testrail.APIException;

	public class addAssetSubcategorySaveChanges {
		
		public WebDriver driver;
		private BrowserType browser;
		String TestCase; 
		String TestRun = "1"; 
			
		loginActions LoginActions = new loginActions();
		transactionsActions TransactionsActions = new transactionsActions();

		
		
		D3TestRails d3testrails = new D3TestRails();
		Utils utils = new Utils();

	   	//Properties p = Utils.loadProperties(".\\conf\\properties.properties");            


		@BeforeClass(alwaysRun = true)
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
			TransactionsActions.init(driver, timeout);

		}
					
		@BeforeClass(alwaysRun = true)
		@Parameters({"testRailUrl", "testRailUserName", "testRailPassWord"})
		public void initTestRails(String testRailUrl, String testRailUserName, String testRailPassWord)
		{	
			d3testrails.InitRail(testRailUrl, testRailUserName, testRailPassWord);
		}
		
		
		  @Test(priority = 37, groups = {"smoke", "regression"})
		  @Parameters({"userName", "passWord", "secretQuestion"})
		  public void verifyAddAssetSubcategorySaveChanges(String userName, String passWord, String secretQuestion) 
		  {
			   TestCase = "37";
			   LoginActions.loginUn(driver, userName);
			   LoginActions.loginPw(driver, passWord);
			   LoginActions.submit(driver);
			   LoginActions.secretQuestion(driver, secretQuestion);
			   LoginActions.privateDevice(driver);
			   LoginActions.submit(driver);
			   TransactionsActions.transactionsButton(driver);
			   TransactionsActions.clickFirstTransaction(driver);
			   TransactionsActions.clickTransactionCategory(driver);
			   TransactionsActions.addCategoryName(driver, "New Auto Test Cat Name");
			   TransactionsActions.clickSubcategoryButton(driver);
			   TransactionsActions.clickSelectParentDropdown(driver);
			   TransactionsActions.clickCategoryName(driver);	
			   TransactionsActions.clickCategorySubmitButton(driver);
			   TransactionsActions.clickCategoryPlusIcon(driver);
			   TransactionsActions.clickNewSubcategory(driver);
			   TransactionsActions.clickViewSimilarButton(driver);
			   Utils.isTextPresent(driver, "transaction(s) were found that could be recategorized.");
		  } 

	  @AfterMethod(alwaysRun = true)
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
	  }  
	     
	  @AfterMethod(alwaysRun = true)
	  public void takeScreenShotOnFailure(ITestResult testResult) throws IOException 
	  {
		  
			  Date date = new Date(System.currentTimeMillis());
		      String dateString = date.toString();
	      
	    	 if (testResult.getStatus() == ITestResult.FAILURE) { 
	    		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
	    		 FileUtils.copyFile(scrFile, new File(".\\Reports\\Screenshots\\" + testResult.getName()  + dateString + ".png")); 
	    		 } 
	  }
	  

	   
	  @AfterClass(alwaysRun = true)
	  public void terminateBrowser()
	  {
		  driver.quit();
	  }
	  
}
