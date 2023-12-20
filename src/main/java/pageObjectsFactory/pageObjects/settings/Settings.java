package pageObjectsFactory.pageObjects.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import general.manager.DriverManager;



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