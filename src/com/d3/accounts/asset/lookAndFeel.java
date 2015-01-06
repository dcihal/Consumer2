package com.d3.accounts.asset;

	import java.io.File;
	import java.io.IOException;
	import java.sql.Date;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.*;
	import org.testng.annotations.*;
	import org.testng.ITestResult;

	import com.d3.accounts.accountsActions;
	import com.d3.dashboard.dashboardActions;
	import com.d3.help.helpActions;
	import com.d3.login.loginActions;
	import com.d3.messages.messagesActions;
	import com.d3.moneyMovement.moneyMovementActions;
	import com.d3.planning.planningActions;
	import com.d3.settings.settingsActions;
	import com.d3.testrails.D3TestRails;
	import com.d3.transactions.transactionsActions;
	import com.d3.utils.*;
	import com.d3.utils.Utils.BrowserType;
	//import com.gurock.testrail.APIException;

	public class lookAndFeel {

		public WebDriver driver;
		private BrowserType browser;
		String TestCase; 
		String TestRun = "1"; 
		loginActions LoginActions = new loginActions();
		dashboardActions DashboardActions = new dashboardActions();
		messagesActions MessagesActions = new messagesActions();
		accountsActions AccountsActions = new accountsActions();
		transactionsActions TransactionsActions = new transactionsActions();
		moneyMovementActions MoneyMovementActions = new moneyMovementActions();
		planningActions PlanningActions = new planningActions();
		helpActions HelpActions = new helpActions();
		settingsActions SettingsActions = new settingsActions();
			
		
		D3TestRails d3testrails = new D3TestRails();
		Utils utils = new Utils();
	   	//Properties p = Utils.loadProperties(".\\conf\\properties.properties");            


		@BeforeClass(alwaysRun = true)
		@Parameters({"browse", "WebdriverTimeout", "baseurl"})
		public void launchBrowser(@Optional("CHROME") String browse, String WebdriverTimeout, String baseurl)
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

		}
		
/*		@BeforeClass(alwaysRun = true)
		@Parameters({"testRailUrl", "testRailUserName", "testRailPassWord"})
		public void initTestRails(String testRailUrl, String testRailUserName, String testRailPassWord)
		{	
			d3testrails.InitRail(testRailUrl, testRailUserName, testRailPassWord);
		}*/
		
		
	  @Test(priority = 1, groups = {"accounts", "smoke", "regression"})
	  public void verifyHomepageTitle() {
		   TestCase = "12";
		   LoginActions.veriyHomePage(driver);
	  }
	    
	  @Test(priority = 2, groups = {"accounts", "smoke", "regression"})
	  @Parameters({"userName"})
	  public void verifyInvalidLogin(String userName) 
	  {
		   TestCase = "1";
		   LoginActions.loginUn(driver, userName);
		   LoginActions.loginPw(driver, "xxxxxx");
		   LoginActions.submit(driver);
		   //WebDriverWait wait = new WebDriverWait(driver, 10);
		   //wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='user-alert']"), "Invalid User Credentials"));
		   Utils.isTextPresent(driver, "Invalid");

	  }
	  
	  @Test(priority = 3, groups = {"accounts", "smoke", "regression"})
	  @Parameters({"userName", "passWord"})
	  public void verifyValidLogin(String userName, String passWord) 
	  {
		   TestCase = "2";
		   driver.findElement(By.name("user-name")).clear();
		   driver.findElement(By.name("password")).clear();
		   LoginActions.loginUn(driver, userName);
		   LoginActions.loginPw(driver, passWord);
		   LoginActions.submit(driver);
	  }
	  
	  @Test(priority = 4, groups = {"accounts", "smoke", "regression"})
	  @Parameters({"secretQuestion"})
	  public void verifySecretQuestion(String secretQuestion) 
	  {
		   TestCase = "13";
		   LoginActions.secretQuestion(driver, secretQuestion);
		   LoginActions.privateDevice(driver);
		   LoginActions.submit(driver);
		   Utils.isTextPresent(driver, "Last Login:");
		   Utils.isTextPresent(driver, "Logout");	   
		   Utils.isTextPresent(driver, "Samuel Adams III");
		  //String expectedTitle = "Welcome: Mercury Tours";
			//String actualTitle = driver.getTitle();
			//Assert.assertEquals(actualTitle, expectedTitle);
	  }

	 
 
	  /*@AfterMethod(alwaysRun = true)
	  public void updateTestRails(ITestResult result) 
	  {
	     if (result.getStatus() == ITestResult.SUCCESS) {
	        try {
				d3testrails.Passed(TestRun, TestCase, "It worked!");
			} catch (IOException | APIException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        //System.out.print("Successful TestRun [" + TestRun + "] TestCase[" + TestCase + "]\n");
	     }
	     else
	     {
	         try {
	 			d3testrails.Failed(TestRun, TestCase, "It failed!");
	 		} catch (IOException | APIException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	        //System.out.print("Failed TestRun [" + TestRun + "] TestCase[" + TestCase + "]\n");
	     }
	  }*/  
	     
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

