package pageObjectsFactory.pageObjects.login;

import general.manager.UsersManager;

import static org.junit.Assert.assertTrue;

import general.manager.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import pageObjectsFactory.PageFactory;


public class LoginPage extends DriverManager {

	@FindBy(css = "input[id='username']")
	protected WebElement username;

	@FindBy(css = "input[id='password']")
	protected WebElement password;

	@FindBy(css = "button[id='login']")
	protected WebElement login;

	@FindBy(css = "li#top-menu-profile > a > span:nth-of-type(2) > i")
	protected WebElement profileMenu;

	@FindBy(css = "li#top-menu-profile > div > div > div > ul > li:nth-of-type(6) > a > div:nth-of-type(2)")
	protected WebElement signOut;

	@FindBy(css = ".content-menu > ul:nth-child(1) > li:nth-child(3) > a:nth-child(1) > div:nth-child(2)")
	protected WebElement languages;

	@FindBy(css = ".inner-list > li:nth-child(1) > a:nth-child(1) > div:nth-child(2)")
	protected WebElement englishLanguage;

	@FindBy(css = ".inner-list > li:nth-child(2) > a:nth-child(1) > div:nth-child(2)")
	protected WebElement arabicLanguage;

	@FindBy(css = ".inner-list > li:nth-child(3) > a:nth-child(1) > div:nth-child(2)")
	protected WebElement frenchLanguage;

	@FindBy(css = "#body-loader")
	protected WebElement bodyLoader;
	@FindBy(id = "dashboard")
	protected WebElement dashboard;

	@FindBy(id = "notificationIcon")
	protected WebElement notificationIcon;
	@FindBy(id = "personal")
	protected WebElement personal;

	@FindBy(xpath = "//a[@class='linkable pointer']")
	protected WebElement forgetpassword;

	@FindBy(xpath = "//div[@class='error-msg ng-binding']")
	protected WebElement enterValidEmail;

	@FindBy(id = "msgBox-ok")
	protected WebElement msgBoxok;

	@FindBy(xpath = "//div[contains(text(),'Your password was successfully reset and sent to y')]")
	protected WebElement forgetMessage;

	public LoginPage(WebDriver driver) {
		super(driver);
		// org.openqa.selenium.support.PageFactory.initElements(this.driver, this);
	}

	public void logInto(UsersManager user) {

		String url = PageFactory.props.getProperty("env");
		PageFactory.instance().getWebDriver().get(url);
		// Thread.sleep(10000);
		String paGeURL = PageFactory.instance().getWebDriver().getCurrentUrl();
		if (paGeURL.contains("login")) {
			// try {
			waitUntilElemnetIsClickable(login);
			username.sendKeys(user.username);
			password.sendKeys(user.password);
			login.click();
		} else {
			waitUntilElemnetIsClickable(profileMenu);
			profileMenu.click();
			try {
				Thread.sleep(3000);
			} catch (Exception e) {

			}
			signOut.click();
			waitUntilElemnetIsClickable(login);
			username.sendKeys(user.username);
			password.sendKeys(user.password);
			login.click();
		}
	}

	public void openhomePage() {

		String url = PageFactory.props.getProperty("env");
		PageFactory.instance().getWebDriver().get(url);

	}

	public void invalid_login(UsersManager user) throws InterruptedException {
		waitUntilPageIsLoadded();
		login.click();
		String msg1 = enterValidEmail.getText();
		assertTrue(msg1.contains("Username is required"));
		openhomePage();
		waitUntilPageIsLoadded();
		username.sendKeys(user.username);
		login.click();
		String msg2 = enterValidEmail.getText();
		assertTrue(msg2.contains("Password is required"));
		openhomePage();
		waitUntilPageIsLoadded();
		username.sendKeys("Maria.Rosa@pexelz.com");
		password.sendKeys("test");
		login.click();
		String msg3 = enterValidEmail.getText();
		assertTrue(msg3.contains("Invalid username or password"));
	}

	public void forgetPasword() {
		waitUntilPageIsLoadded();
		username.sendKeys("Maria.Rosa@pexelz.com");
		forgetpassword.click();
		super.waitUntilElemnetIsClickable(msgBoxok);
		msgBoxok.click();
		super.waitUntilElemnetIsVisible(forgetMessage);
		super.isElementPresent(forgetMessage);
		assertTrue(forgetMessage.getText().contains("Your password was successfully reset and sent to your email."));

	}

	public void checkhomePage() throws InterruptedException {

		Thread.sleep(2000);
		String url = PageFactory.instance().getWebDriver().getCurrentUrl();
		assertTrue(url.contains("dashboard"));

		assertTrue(super.isElementPresent(dashboard));
		assertTrue(super.isElementPresent(notificationIcon));
		assertTrue(super.isElementPresent(personal));
		profileMenu.click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {

		}
		signOut.click();

	}

	public void changeTheLocale(String locale) {
		String url = PageFactory.props.getProperty("env");
		PageFactory.instance().getWebDriver().get(url);
		logInto(UsersManager.user1);
		waitUntilPageIsLoadded();
		profileMenu.click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {

		}
		Actions action = new Actions(PageFactory.instance().getWebDriver());

		switch (locale.toLowerCase()) {
		case "ar":
			action.moveToElement(languages).click(arabicLanguage).build().perform();
			break;
		case "en":
			action.moveToElement(languages).click(englishLanguage).build().perform();
			break;
		case "fr":
			action.moveToElement(languages).click(frenchLanguage).build().perform();
			break;
		default:
			action.moveToElement(languages).click(englishLanguage).build().perform();
		}
		try {
			Thread.sleep(3000);
		} catch (Exception e) {

		}
		System.out.println("Locale Has been Changed");

	}

	public void logout() throws InterruptedException {

		waitUntilElemnetIsClickable(profileMenu);
		waitUntilElementIsInvisible(bodyLoader);
		String url = PageFactory.props.getProperty("env");
		PageFactory.instance().getWebDriver().get(url);
		waitUntilPageIsLoadded();
		profileMenu.click();
		// waitUntilPageIsLoadded();
		Thread.sleep(3000);
		signOut.click();

	}

}