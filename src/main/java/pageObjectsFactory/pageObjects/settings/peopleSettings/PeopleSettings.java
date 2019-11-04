package pageObjectsFactory.pageObjects.settings.peopleSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import general.manager.DriverManager;


/**
 * Created by IntelliJ IDEA.
 * User: Amal.K
 * Date: 3/4/2019
 * Time: 12:23 PM
 * To change this template use File | Settings | File and Code Templates.
 */
public class PeopleSettings extends DriverManager {


    @FindBy(css = "div.col-md-6:nth-child(5) > a:nth-child(1)")
    protected WebElement benefitsTypesAndPlans;

    public PeopleSettings(WebDriver driver) {
        super(driver);
        // org.openqa.selenium.support.PageFactory.initElements(this.driver, this);
    }


    public void openBenefitsTypesAndPlans() {
        waitUntilElemnetIsClickable(benefitsTypesAndPlans);
        benefitsTypesAndPlans.click();
    }
}