package general.Utitlities;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

import org.apache.commons.io.FileUtils;


public class ScreenShotsHelper {

    public static String takeScreenShot(WebDriver driver) {
        String imagePath = System.getProperty("user.dir")+"\\test-output\\HtmlReport\\screenshots\\" + System.currentTimeMillis() + ".png";
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
// Now you can do whatever you need to do with it, for example copy somewhere
            FileUtils.copyFile(scrFile, new File(imagePath));
        } catch (Exception e) {

        }

        return imagePath;
    }
}