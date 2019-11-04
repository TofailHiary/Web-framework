package pageObjectsFactory.pageObjects.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import general.manager.DriverManager;


/**
 * Created by IntelliJ IDEA.
 * User: Amal.K
 * Date: 3/4/2019
 * Time: 12:25 PM
 * To change this template use File | Settings | File and Code Templates.
 */
public class Settings extends DriverManager {

    @FindBy(css = "i[id='ico-modules-three']")
    protected WebElement viewModules;


    @FindBy(css = "#settings")
    protected WebElement settingsModule;

    @FindBy(css = "#general")
    protected WebElement generalSettings;

    @FindBy(css = "li.people")
    protected WebElement peopleSettings;

    @FindBy(css = "li.time")
    protected WebElement timeSettings;



    public Settings(WebDriver driver) {
        super(driver);
        // org.openqa.selenium.support.PageFactory.initElements(this.driver, this);
    }

    public void navigateToPeopleSettings() {
        waitUntilElemnetIsClickable(viewModules);
        viewModules.click();
        waitUntilElemnetIsClickable(settingsModule);
        settingsModule.click();
        waitUntilElemnetIsClickable(peopleSettings);
        peopleSettings.click();
/*        waitUntilElemnetIsClickable(timeSettings);
        timeSettings.click();*/
    }


}