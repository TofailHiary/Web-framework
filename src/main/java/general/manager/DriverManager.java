package general.manager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverManager {

	// private static ThreadLocal<WebDriver> driver = new
	// ThreadLocal<WebDriver>();
	// public static final ThreadLocal<Logger> log = new ThreadLocal<Logger>();
	private static WebDriver localDriver = null;
	protected static int timeOut = 30;
	public static WebDriverWait waitFor;
	public static Actions builder;
	public static Properties props = new Properties();

	public DriverManager(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public static WebDriver getDriver(String browser) {
		if (localDriver == null) {
			setWebDriver(createInstance(browser));
		}
		return localDriver;
	}

	public static WebDriver getInstance() {
		if (localDriver != null) {
			return localDriver;
		}
		return null;

	}

	public static WebDriver createInstance(String browserName) {
		WebDriver driver;
		// browserName = (browserName != null) ? browserName : "chrome";

		switch (browserName.toUpperCase()) {
		case "FIREFOX":

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();

			break;
		case "CHROME":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			break;
		case "EDGE":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			break;
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();

			break;
		}
		// maximize browser's window on start
		waitFor = new WebDriverWait(driver, timeOut);
		builder = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver + "has been opened");
		return driver;
	}

	private static enum Browser {
		FIREFOX, CHROME, IE, EDGE
	}

	public static void setWebDriver(WebDriver driver) {
		if (driver != null) {
			// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			localDriver = driver;
		}

	}

	public static void closeDriver() throws InterruptedException {
		if (localDriver != null) {
			// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// localDriver.close();
			localDriver.quit();
			// localDriver.manage().deleteAllCookies();
			localDriver = null;
			Thread.sleep(2000);

		}

	}

	public void waitUntilElemnetIsClickable(WebElement elemnet) {
		waitFor.until(ExpectedConditions.elementToBeClickable(elemnet));
		try {
			Thread.sleep(3000);
		} catch (Exception e) {

		}
	}

	public void waitUntilElemnetIsVisible(WebElement elemnet) {
		waitFor.until(ExpectedConditions.visibilityOf(elemnet));
		// ExpectedConditions.
		try {
			Thread.sleep(3000);
		} catch (Exception e) {

		}

	}

	public void waitUntilPageIsLoadded() {
		new WebDriverWait(pageObjectsFactory.PageFactory.instance().getWebDriver(), timeOut)
				.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
						.equals("complete"));
	}

	public void waitUntilElementIsInvisible(WebElement element) {
		waitFor.until(ExpectedConditions.invisibilityOf(element));
		try {
			Thread.sleep(3000);
		} catch (Exception e) {

		}
	}

	public void timetowait(int num) {
		try {
			long seconds = TimeUnit.SECONDS.toMillis(num);
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean isElementPresent(WebElement element) {
		try {
			element.isDisplayed(); // false.
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
