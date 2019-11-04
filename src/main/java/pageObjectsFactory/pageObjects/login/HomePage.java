package pageObjectsFactory.pageObjects.login;

import general.manager.DriverManager;
import general.manager.PropertiesManager;
import general.manager.UsersManager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import pageObjectsFactory.PageFactory;
import pageObjectsFactory.pageObjects.login.HomePage;
import pageObjectsFactory.pageObjects.login.LoginPage;
import pageObjectsFactory.pageObjects.requests.My365Requests;
import pageObjectsFactory.pageObjects.settings.peopleSettings.BenefitsTypesAndPlans;
import pageObjectsFactory.pageObjects.settings.peopleSettings.PeopleSettings;
import pageObjectsFactory.pageObjects.settings.Settings;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class HomePage  extends DriverManager{

	  public  HomePage(WebDriver driver) {
	super(driver);
}
	  @FindBy(xpath  = "//img[@ng-show='dashboardImagePath']")
	    protected WebElement ceo;
	 
	  @FindBy(xpath  = "//span[contains(text(),'Be Motivated')]")
	    protected WebElement Motivated;
	  
	  @FindBy(xpath  = "//img[@class='ceo-img']")
	    protected WebElement ceoimage;
	  
	  @FindBy(xpath  = "//i[@class='ico-purple-x-big']")
	    protected WebElement ceoclose;
	  
	  @FindBy(xpath  = "//div[@class='my-team mgb-20 text-uppercase ng-scope']")
	    protected WebElement myteampic;
	  
	  @FindBy(xpath  = "//div[@class='see-team hover-underline']//a[@class='ng-binding']")
	    protected WebElement myteambutton;
	
	  @FindBy(xpath  = "//div[@class='over-head gray-bg side-info-emp mgb--75 org-slider ng-isolate-scope']//img[@class='ng-scope']")
	    protected WebElement myteamimage;
	
	  @FindBy(xpath  = "//div[@class='emp-card-inno-666 org-slide ng-scope selected']//img[@class='ng-scope']")
	    protected WebElement myteamimage2;
	
	  @FindBy(xpath  = "//div[@class='emp-card-inno-666 org-slide ng-scope selected']//i[@title='Business Card']")
	    protected WebElement Business_Card;
	    
	  @FindBy(xpath  = "//i[@class='ico-add-email']")
	    protected WebElement add_email;
	  @FindBy(xpath  = "//i[@class='ico-add-phone']")
	    protected WebElement add_phone;
	  @FindBy(xpath  = "//i[@class='ico-add-cell']")
	    protected WebElement add_cell;
	    
	  @FindBy(css = ".ico-purple-x-big")
	    protected WebElement close;  
	
	  @FindBy(xpath  = "//div[@class='name ng-scope']")
	    protected WebElement benefits;
	  
	  @FindBy(xpath  = "//a[@class='check-benefits hover-underline ng-binding']")
	    protected WebElement checkbenefits;
	  
	  @FindBy(xpath  = "//a[contains(text(),'http://www.cnn.com')]")
	    protected WebElement linkbenefits;
	  
	  
	  @FindBy(xpath  = "//div[@class='lk ng-binding']")
	    protected WebElement vacationbutton;
	  
	  @FindBy(xpath  = "//div[@class='settings-menu']//i[@class='fa fa-cog']")
	    protected WebElement vacationtype;
	  
	  @FindBy(xpath  = "//span[@class='title ng-scope']")
	    protected WebElement textvacation;
	  
	  @FindBy(xpath  = "//button[@type='submit']")
	    protected WebElement save;
	  @FindBy(xpath  = "//button[@type='button']")
	    protected WebElement cancel;
	  
	  @FindBy(xpath  = "//i[@class='time-rep-days day-1']")
	    protected WebElement Overdue;
	
	  @FindBy(xpath  = "//div[@class='fill-hours-cont']//a[@class='hover-underline ng-binding']")
	    protected WebElement hours;
	  @FindBy(xpath  = "//div[@class='week ng-scope selected']")
	    protected WebElement calendarview;
	  @FindBy(xpath  = "//span[@class='k-picker-wrap k-state-default k-state-hover k-state-focused k-state-active k-state-border-down']//span[@class='k-icon k-i-calendar'][contains(text(),'select')]")
	    protected WebElement calendar;
	
	  @FindBy(xpath  = "//div[@class='col-md-6 height-225 cf']")
	    protected WebElement attendance;
	  @FindBy(xpath  = "//span[@class='title ng-binding']")
	    protected WebElement myattendance;
	
	  @FindBy(xpath  = "//div[@class='text-right see-req']//a[@class='hover-underline ng-binding']")
	    protected WebElement myrequest;
	  
	  @FindBy(xpath  = "//span[@class='text-uppercase ng-scope']")
	    protected WebElement Anniversary;
	
	  @FindBy(xpath  = "//div[@class='task-title ng-binding']")
	    protected WebElement mytasks;
	  @FindBy(xpath  = "//a[@href='/module/my365#/personal']//p//i")
	    protected WebElement personal;
	  @FindBy(xpath  = "//li[@id='time']//i")
	    protected WebElement time;
	
	  @FindBy(xpath  = "//span[contains(text(),'Employee Requests')]")
	    protected WebElement Employee_Requests;
	  @FindBy(xpath  = "//span[contains(text(),'tasks')]")
	    protected WebElement tasks;
	  
	  @FindBy(xpath  = "//span[contains(text(),'notifications')]")
	    protected WebElement notifications;
	  @FindBy(xpath  = "//span[contains(text(),'Grievance')]")
	    protected WebElement Grievance;
	  @FindBy(xpath  = "//span[contains(text(),'Loans')]")
	    protected WebElement Loans;
	  @FindBy(xpath  = "//span[contains(text(),'corporate')]")
	    protected WebElement corporate;
	  @FindBy(xpath  = "//span[contains(text(),'options')]")
	    protected WebElement options;
	  @FindBy(linkText= "Personal Information")
	    protected WebElement  Personal_Information;
	  
	  @FindBy(xpath  = "//span[@class='title ng-scope']")
	    protected WebElement  textPersonal_Information;
	  @FindBy(xpath  = "//*[@id=\"left-side-menu\"]/div/div/ul/li")
	    protected List<WebElement>  left_side_menu;
	  

public void check_dashboard() {
	
	PageFactory.instance().loginPage().openhomePage();
	super.waitUntilPageIsLoadded();
	super.timetowait(2);
	assertTrue(ceo.isDisplayed() && Motivated.isDisplayed() && myteampic.isDisplayed() &&  myteambutton.isDisplayed() 
			&& benefits.isDisplayed() && checkbenefits.isDisplayed() && vacationbutton.isDisplayed() 
			&& Overdue.isDisplayed() && hours.isDisplayed() && attendance.isDisplayed() 
			&& myrequest.isDisplayed() && Anniversary.isDisplayed() && mytasks.isDisplayed());
	
		
}



public void checkLeftHandMenu() {
	
for (int i=0;i<left_side_menu.size();i++){
	super.waitUntilElemnetIsClickable(left_side_menu.get(i));
	left_side_menu.get(i).click();
	super.waitUntilPageIsLoadded();	
				
				 
	}
	
}



}



