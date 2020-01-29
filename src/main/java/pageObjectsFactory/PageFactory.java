package pageObjectsFactory;

import general.manager.DriverManager;
import general.manager.PropertiesManager;
import general.manager.UsersManager;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pageObjectsFactory.pageObjects.login.HomePage;
import pageObjectsFactory.pageObjects.login.LoginPage;
import pageObjectsFactory.pageObjects.requests.My365Requests;
import pageObjectsFactory.pageObjects.settings.peopleSettings.BenefitsTypesAndPlans;
import pageObjectsFactory.pageObjects.settings.peopleSettings.PeopleSettings;
import pageObjectsFactory.pageObjects.settings.Settings;

import java.util.HashMap;
import java.util.Properties;


/**
 * Created by Amal on 1/14/2019.
 */
public class PageFactory {

    public static Properties props = new Properties();
    public static Properties localeProps = new Properties();
    public static HashMap users;
    public static Properties extentReportProps = new Properties();
    //public static UsersManager users = new UsersManager();

    // Pages
    private static PageFactory _pageFactory;
    private LoginPage _LoginPage;
    private My365Requests _my365Requests;
    private Settings _settings;
    private PeopleSettings _peopleSettings;
    private BenefitsTypesAndPlans _benefitsTypesAndPlans;
    private HomePage _homePage;

    public PageFactory(){
        initWebDriver();


        // this.setExtentReportProps(PropertiesManager.getExtentReportProperties());
        // PropertiesManager.updateProperties("src/test/resources/extent.properties", extentReportProps, "extent.reporter.html.out" , "test-output/HtmlReport/report" + System.currentTimeMillis() +".html");

        /*ResourcesManager.load();*/
    }

	public void initWebDriver() {
		this.setProps(PropertiesManager.getProperties());
		this.setProps(PropertiesManager.getPropertiesofenv());
        this.setLocaleProps(PropertiesManager.getLocaleProperties(props.getProperty("localeToRun")));
        DriverManager.getDriver(props.getProperty("browserValue"));
        UsersManager.loadUsers();
	}

    public PageFactory(String locale){
        try{
            PageFactory._pageFactory.loginPage().changeTheLocale(locale);
        }
        catch (Exception e){
            Assert.assertEquals("Locale has not been changed", "expected", "actual");
        }

    }


    public static PageFactory instance(){
        if (_pageFactory == null) {
            _pageFactory = new PageFactory();
        }
        return _pageFactory;
    }

    public LoginPage loginPage() {
   
            _LoginPage = new LoginPage(getWebDriver()); 
        return _LoginPage;
    }

    public My365Requests my365RequestsPage() {
    
            _my365Requests = new My365Requests(getWebDriver());  
        return _my365Requests;
    }

    public Settings settingsPage() {
   
            _settings = new Settings(getWebDriver()); 
        return _settings;
    }

    public PeopleSettings peopleSettingsPage() {
       
            _peopleSettings = new PeopleSettings(getWebDriver());  
        return _peopleSettings;
    }

    public BenefitsTypesAndPlans benefitsTypesAndPlans() {
        
            _benefitsTypesAndPlans = new BenefitsTypesAndPlans(getWebDriver());
        return _benefitsTypesAndPlans;
    }
    
    
    public HomePage homepage() {
     
        	_homePage = new HomePage(getWebDriver());     
        return _homePage;
    }


    public WebDriver getWebDriver() {
        return DriverManager.getInstance();
    }

    

    public void setProps(Properties props) {
        this.props = props;
    }

    public Properties getProps() {
        return props;
    }

    public void setLocaleProps(Properties props) {
        this.localeProps = props;
    }

    public Properties getLocaleProps() {
        return localeProps;
    }

	public void closeDriver() throws InterruptedException {
		DriverManager.closeDriver();
		
	}

 




}
