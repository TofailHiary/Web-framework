package pageObjectsFactory.pageObjects.settings.peopleSettings;

import org.testng.asserts.SoftAssert;

import general.manager.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



/**
 * Created by IntelliJ IDEA.
 * User: Amal.K
 * Date: 3/4/2019
 * Time: 3:31 PM
 * To change this template use File | Settings | File and Code Templates.
 */
public class BenefitsTypesAndPlans extends DriverManager {

    @FindBy(css = "div.item:nth-child(9) > div:nth-child(1)")
    protected WebElement jordanSocialSecurityUDW;

    @FindBy(css = "div.item:nth-child(9) > div:nth-child(2) > span:nth-child(2)")
    protected WebElement changeStatusButton;

    private SoftAssert softAssertions = new SoftAssert();

    public BenefitsTypesAndPlans(WebDriver driver) {
        super(driver);
    }

    public void openABenefitSettings(String planToOpen) {

        switch (planToOpen.toLowerCase()) {
            case "jordan social security - udw":
                waitUntilElemnetIsClickable(jordanSocialSecurityUDW);
                jordanSocialSecurityUDW.click();
                break;
            default:
                waitUntilElemnetIsClickable(jordanSocialSecurityUDW);
                jordanSocialSecurityUDW.click();
        }

    }

/*    public void disableABenefit(String benefit) {

    }

    public void enableABenefit(String benefit) {

    }*/

    public Boolean returnBenefitStatus(String benefit) {

        return true;
    }

    public void checkABenefitSetting(String benefit) {
        Boolean isEnabled = returnBenefitStatus(benefit);
        /*
        if Benefit is Enabled try to disable and vice versa
         */
        if (isEnabled) {
            changeTheBenefitStatus(benefit);
            isEnabled = returnBenefitStatus(benefit);
            softAssertions.assertFalse(isEnabled, "Benefit is not disabled as expected");
            changeTheBenefitStatus(benefit);
            isEnabled = returnBenefitStatus(benefit);
            softAssertions.assertTrue(isEnabled, "Benefit is not enabled as expected");

        }else{
            changeTheBenefitStatus(benefit);
            isEnabled = returnBenefitStatus(benefit);
            softAssertions.assertTrue(isEnabled, "Benefit is not enabled as expected");
            changeTheBenefitStatus(benefit);
            isEnabled = returnBenefitStatus(benefit);
            softAssertions.assertFalse(isEnabled, "Benefit is not disabled as expected");

        }
    }

    private void changeTheBenefitStatus(String benefit) {

    }

    //public void checkIfBene

}