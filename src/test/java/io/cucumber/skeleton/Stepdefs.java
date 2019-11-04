package io.cucumber.skeleton;

import com.cucumber.listener.Reporter;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import general.manager.DriverManager;
import general.manager.PropertiesManager;
import general.manager.UsersManager;
import io.qameta.allure.Allure;

import org.apache.commons.io.FileUtils;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.asserts.SoftAssert;

import pageObjectsFactory.PageFactory;
import pageObjectsFactory.pageObjects.login.LoginPage;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Stepdefs {

    private static boolean dunit = false;
    //public PageFactory pageFac = PageFactory.instance();
    //public PageFactory toChangeLocale = new PageFactory();
   // private SoftAssertions softAssertions = new SoftAssertions();
SoftAssert softAssertions = new SoftAssert();

    public Stepdefs() throws InterruptedException {
    }

   @Before
   public void beforeAll(Scenario Scenario) {
          System.out.println("Scenario " + Scenario.getName()+ " has been started" );
          DriverManager.getDriver(PageFactory.instance().getProps().getProperty("browserValue"));
   }

    @Given("^I have (\\d+) cukes in my belly$")
    public void I_have_cukes_in_my_belly(int cukes)  {
        // Belly belly = new Belly();
        //belly.eat(cukes);
        System.out.println("Executeddddddddddddddddddddddddddd");
    }

    @Given("^the user have logged into the system$")
    public void theUserHaveLoggedIntoTheSystem() {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        //UsersManager user1 = (UsersManager) PageFactory.users.get("user1");
        PageFactory.instance().loginPage().logInto(UsersManager.user1);
    }

    @When("^a user create a request$")
    public void aUserCreateARequest() throws InterruptedException  {
        // Write code here that turns the phrase above into concrete actions
        PageFactory.instance().my365RequestsPage().navigateToMy365Requests();
        PageFactory.instance().my365RequestsPage().addNewRequest();
    }

    @Then("^Check request is created$")
    public void checkRequestIsCreated() throws Throwable {

        PageFactory.instance().my365RequestsPage().checkRequestWasCreated();

    }
    
    
    @When("^User create a new task$")
    public void userCreateaNewTask() throws InterruptedException  {
        // Write code here that turns the phrase above into concrete actions
        PageFactory.instance().my365RequestsPage().navigateToMytasks();
        PageFactory.instance().my365RequestsPage().addNewTask();
       
    }

    @Then("^Check task created$")
    public void checkTaskCreated() throws Throwable {

        PageFactory.instance().my365RequestsPage().checkTaskCreated();
        PageFactory.instance().loginPage().logout();
    }
    
    
@Given("^OpenBrowser$")
public void openBrowser(){
PageFactory.instance().loginPage().openhomePage();	
}
    @After
/**
 * Embed a screenshot in test report if test is marked as failed
 */
    public void embedScreenshot(Scenario scenario) throws IOException, InterruptedException {
        Allure.addDescription("UI Automation Report");
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) PageFactory.instance().getWebDriver();
            File source = ts.getScreenshotAs(OutputType.FILE);
            String dest = "./target/allure-results/" + System.currentTimeMillis() + ".png";
            File destination = new File(dest);
            FileUtils.copyFile(source, destination);
            FileInputStream inputstream = new FileInputStream(new File(dest).getAbsolutePath());
            Allure.addAttachment("Screenshot", "Image", inputstream, ".png");
        }
        

//        PageFactory._driver.manage().deleteAllCookies();
   //     PageFactory.instance().closeDriver();
//        PageFactory.setWebDriver(DriverManager.getDriver(PageFactory.props.getProperty("browserValue")));
//         PageFactory._driver.close();
        // pageFac.setWebDriver(DriverManager.createInstance(PageFactory.props.getProperty("browserValue")));
        //PageFactory._driver.
     DriverManager.closeDriver();   

    }
    
    

    @Given("^the user have logged into the system using \"(.*?)\" credentials$")
    public void theUserHaveLoggedIntoTheSystemUsingUserCredentials(String user) {


        // UsersManager userObj = (UsersManager) PageFactory.users.get(user.toLowerCase());
        PageFactory.instance().loginPage().logInto(UsersManager.getUserObject(user));
    }

    
    @When("^the user navigate to the systems page$")
    public void theUserNavigateToTheSystemsPage() {
        PageFactory.instance().settingsPage().navigateToPeopleSettings();
    }

    @And("^navigate to Benefits Types And Plans page$")
    public void navigateToBenefitsTypesAndPlansPage() {
        PageFactory.instance().peopleSettingsPage().openBenefitsTypesAndPlans();
    }

    @And("^open the settings for \"([^\"]*)\" Benefits$")
    public void openTheSettingsForBenefits(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        PageFactory.instance().benefitsTypesAndPlans().openABenefitSettings(arg0);
      //  Thread.sleep(10000);
    }

    @Given("^false step$")
    public void falseStep() {
       // Assert.assertEquals(5 , 4);
       // softAssertions.assertThat("d").isEqualTo("y").as("tese");
        softAssertions.assertEquals("y", "t", "dssdfsf");
    }

    @And("^True step$")
    public void trueStep() {
       // Assert.assertEquals(5,5);
        softAssertions.assertEquals("r", "t", "dssssss");
        softAssertions.assertAll();
    }

    @Then("^check the settings for \"([^\"]*)\" Benefit$")
    public void checkTheSettingsForBenefit(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        PageFactory.instance().benefitsTypesAndPlans().openABenefitSettings(arg0);
        PageFactory.instance().benefitsTypesAndPlans().checkABenefitSetting(arg0);
        //throw new PendingException();
    }

/*    @After
    public void logoutOfTheSystem() throws InterruptedException {

        //pageFac.loginPage().logout();
        pageFac._driver.manage().deleteAllCookies();
       // pageFac._driver.manage().

    }*/

/*    @Before
    public void clearDriverCookies(){
        pageFac._driver.getSessionStorage().clear();
    }*/

    @Given("^I want to open home page$")
    public void openHomepage()
    
    {
    	 PageFactory.instance().loginPage().openhomePage();
    	 
    }
   @When("^I want to login invalid$")
   public void invalid_login() throws InterruptedException {
	   PageFactory.instance().loginPage().invalid_login(UsersManager.userinvalid);
   }
   
   @Then("Check if the password reset successfully")
   public void forgetPassword() {
	   PageFactory.instance().loginPage().forgetPasword();
	   
	
   }
   @Then("^I want to login username and password$")
   public void loginto()
    {
	   PageFactory.instance().loginPage().logInto(UsersManager.user1);
	   
    }

   @Then("^Check if the user on Home page$")
   
   public void checkhomePage() throws InterruptedException
   {
	   
	   PageFactory.instance().loginPage().checkhomePage();
   }
   
 @Then("^Check all dashboard$")
   
   public void checkdashboard() throws InterruptedException
   {
	   
	   PageFactory.instance().homepage().check_dashboard();
	   PageFactory.instance().loginPage().logout();
	   
   }
 @Then("^Open left hand menu$")
 
 public void openLeftHandMenu() throws InterruptedException
 {
	   
	   PageFactory.instance().homepage().checkLeftHandMenu();
	   PageFactory.instance().loginPage().logout();
	   
 }
   

}
