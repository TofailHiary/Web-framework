package pageObjectsFactory.pageObjects.settings.peopleSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import general.manager.DriverManager;


/**
 * Created by IntelliJ IDEA.
 * User: Amal.K
 * Date: 3/27/2019
 * Time: 11:41 AM
 * To change this template use File | Settings | File and Code Templates.
 */
public class JordanSocialSecurityUDW extends DriverManager {

    @FindBy(css = "div.item:nth-child(9) > div:nth-child(1)")
    protected WebElement jordanSocialSecurityUDW;

    public JordanSocialSecurityUDW(WebDriver driver) {
        super(driver);
    }
}