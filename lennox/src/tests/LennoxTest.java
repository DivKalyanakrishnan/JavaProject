package tests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;


public class LennoxTest {
	static WebDriver driver = null;	
	LoginPage objLoginPage;
	HomePage objHomePage;
	AddLeadsPage objAddLeadsPage;
	
	@BeforeTest
    public void setup(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get("http://liidaveqa.com/");		
	}
	
	@Test(priority=0)
    public void testLogin(){
    	
    	//HomePage Navigation and Signin
    	objLoginPage = new LoginPage(driver);
        objLoginPage.clickSignin();
        String loginUrl = objLoginPage.getUrl();
        System.out.println(objLoginPage.getUrl());
        Assert.assertTrue(loginUrl.contains("www.liidaveqa.com/login"));
        
        //Enter Credentials and Login
        objLoginPage.setUserName("lenproautomation8@lenqat.com");
        objLoginPage.setPassword("Community17");
        objLoginPage.clickLogin();
        
        objHomePage = new HomePage(driver);
        System.out.println(objHomePage.getHomePageUserName());
        Assert.assertTrue(objHomePage.getHomePageUserName().contains("lenproautomation8"), "Login Credentials is incorrect");

     }
    @Test(priority=1, dependsOnMethods = {"testLogin"})
    public void testProposalNavigation() {
    	objHomePage.clickOnProposalLink();
    	
    	objAddLeadsPage = new AddLeadsPage(driver);
    	String leadsTitle = objAddLeadsPage.getTitle();
    	System.out.println(leadsTitle);
    	
    	Assert.assertTrue(leadsTitle.contains("Add Leads"), "Add Leads Page Navigation/Title is incorrect");
    }
    
    @Test(priority=2, dependsOnMethods = {"testProposalNavigation"})
    public void testLeadAdditionWithImage() {
    	objAddLeadsPage.setLeadValues();
    	
    	objAddLeadsPage.addImage();
    	System.out.println("Added Image from test--------");
    	
    	Boolean isSaved = objAddLeadsPage.clickOnSaveBtn();
    	System.out.println("isSaved ::" + isSaved);
    	
    	String actualMsgDisplayed = objAddLeadsPage.getSavedMessage(isSaved);
    	String expectedMsg = "Lead has been created/edited successfully.";
    	
    	if(isSaved)
    		Assert.assertEquals(actualMsgDisplayed,expectedMsg);
    	else
    		Assert.assertEquals(actualMsgDisplayed, "");
    }
    
    @Test(priority=3, dependsOnMethods = {"testProposalNavigation"})
    public void testLeadAdditionWithDocument() {
    	objAddLeadsPage.setLeadValues();
    	
    	objAddLeadsPage.addDocument();
    	System.out.println("Added Document from test--------");
    	
    	Boolean isSaved = objAddLeadsPage.clickOnSaveBtnForDocuments();
    	System.out.println("isSaved ::" + isSaved);
    	
    	String actualMsgDisplayed = objAddLeadsPage.getSavedMessage(isSaved);
    	String expectedMsg = "Lead has been created/edited successfully.";
    	
    	if(isSaved)
    		Assert.assertEquals(actualMsgDisplayed,expectedMsg);
    	else
    		Assert.assertEquals(actualMsgDisplayed, "");
    }
    @AfterTest
    public void close() {
    	driver.close();
    }
}
