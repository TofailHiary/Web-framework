package pageObjectsFactory.pageObjects.requests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import general.manager.DriverManager;

import pageObjectsFactory.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class My365Requests extends DriverManager {
	public int numOftasks;
	public static String title;

	@FindBy(css = "i[id='ico-modules-three']")
	protected WebElement viewModules;

	@FindBy(css = "a[id='my365']")
	protected WebElement my365;

	@FindBy(css = "li[id='requests']")
	protected WebElement employeeRequests;

	@FindBy(css = ".glyphicon-plus")
	protected WebElement addNewRequest;

	@FindBy(id = "openNewTask")
	protected WebElement openNewTask;

	@FindBy(css = "input[id='newRequestTitle']")
	protected WebElement newRequestTitle;

	@FindBy(id = "addTaskName")
	protected WebElement addTaskName;

	@FindBy(css = "button[id='newRequestSend']")
	protected WebElement newRequestSend;

	@FindBy(css = "input[id='requestSearch']")
	protected WebElement requestSearch;
	@FindBy(css = "input[id='taskByMeSearch']")
	protected WebElement tasksearch;

	@FindBy(css = "#gridRequets-7168cff3-1d81-40a9-b505-33340cc073a5 > div.k-grid-content > table > tbody > tr > td.text-left")
	protected WebElement firstRecord;

	@FindBy(css = "td.text-left")
	protected WebElement firsttask;

	@FindBy(css = "#body-loader")
	protected WebElement bodyLoader;

	@FindBy(css = ".toast-message > div:nth-child(1)")
	protected WebElement toastMessage;

	@FindBy(css = "div.modal-body:nth-child(1)")
	protected WebElement addRequestDialog;

	@FindBy(css = "#requestTypeOpen > div:nth-child(1) > div:nth-child(1)")
	protected WebElement numberOfOpenRequests;

	public static String numberOfOpenRequestsBefore = "";
	public static String toast = "";
	public static int tasksAssignedByMeOpenBefore;
	@FindBy(css = "div.selected div.body div.ng-binding.number")
	protected WebElement tasksAssignedByMeOpen;

	@FindBy(xpath = "//span[contains(text(),'tasks')]")
	protected WebElement mytasks;

	@FindBy(xpath = "//a[@placeholder='Select a Person']//span[@class='select2-arrow ui-select-toggle']")
	protected WebElement select_person;

	@FindBy(xpath = "//DIV[@ng-bind-html='employee.name | highlight: $select.search'][text()='Maria Rosa']")
	protected WebElement addmember;

	@FindBy(xpath = "//input[@id='addTaskDueDate']")
	protected WebElement calendar;
	@FindBy(id = "addTaskSave")
	protected WebElement addTaskSave;
	@FindBy(id = "addTaskEmployees")
	protected WebElement addTaskEmployees;

	public My365Requests(WebDriver driver) {
		super(driver);
		// org.openqa.selenium.support.PageFactory.initElements(this.driver, this);
	}

	public void navigateToMy365Requests() {
		waitUntilElemnetIsClickable(viewModules);
		viewModules.click();
		waitUntilElemnetIsClickable(my365);
		my365.click();
		waitUntilElemnetIsClickable(employeeRequests);
		employeeRequests.click();
		waitUntilElemnetIsClickable(addNewRequest);
		waitUntilElementIsInvisible(bodyLoader);
	}

	public void addNewRequest() throws InterruptedException {

		waitUntilElemnetIsVisible(numberOfOpenRequests);
		numberOfOpenRequestsBefore = numberOfOpenRequests.getText();
		addNewRequest.click();
		// Thread.sleep(10000);

		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
		title = ft.format(dNow);

		waitUntilElemnetIsVisible(newRequestTitle);
		newRequestTitle.sendKeys(title);
		newRequestSend.click();
		// waitUntilElementIsInvisible(newRequestSend);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {

		}
		toast = toastMessage.getText();
		// waitUntilElementIsInvisible(toastMessage);
		// Thread.sleep(10000);
		// Thread.sleep(10000);
	}

	public void checkRequestWasCreated() {

		waitUntilElemnetIsVisible(requestSearch);

		requestSearch.sendKeys(title);

		try {
			Thread.sleep(3000);
		} catch (Exception e) {

		}
		waitUntilElemnetIsVisible(firstRecord);

		assertEquals(title, firstRecord.getText());

		assertEquals(PageFactory.localeProps.getProperty("addRequestToast"), toast);
		Integer expectedNumberOfOpenRequests = Integer.valueOf(numberOfOpenRequestsBefore) + 1;
		assertEquals(numberOfOpenRequests.getText(), expectedNumberOfOpenRequests.toString());
		// PageFactory.instance()._driver.findElement(By.xpath("dasdad"))
	}

	public void navigateToMytasks() {
		waitUntilElemnetIsClickable(viewModules);
		viewModules.click();
		waitUntilElemnetIsClickable(my365);
		my365.click();
		waitUntilElemnetIsClickable(mytasks);
		mytasks.click();
		waitUntilElemnetIsClickable(openNewTask);
		waitUntilElementIsInvisible(bodyLoader);
	}

	public void addNewTask() {

		// Thread.sleep(3000);
		tasksAssignedByMeOpenBefore = Integer.parseInt(tasksAssignedByMeOpen.getText());
		// numOftasks=Integer.parseInt(tasksAssignedByMeOpenBefore);
		openNewTask.click();
		// Thread.sleep(10000);
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
		title = ft.format(dNow);
		waitUntilElemnetIsVisible(addTaskName);
		waitUntilPageIsLoadded();
		addTaskName.sendKeys(title);
		select_person.click();
		waitUntilElemnetIsVisible(addmember);
		addmember.click();
		calendar.sendKeys("29/06/2020");
		waitUntilElemnetIsClickable(addTaskSave);
		// waitUntilElementIsInvisible(newRequestSend);
		addTaskSave.click();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {

		}
		toast = toastMessage.getText();

	}

	public void checkTaskCreated() {

		waitUntilElemnetIsVisible(tasksearch);

		tasksearch.sendKeys(title);

		try {
			Thread.sleep(3000);
		} catch (Exception e) {

		}
		waitUntilElemnetIsVisible(firsttask);
		assertEquals(title, firsttask.getText());
		assertEquals(PageFactory.localeProps.getProperty("addRequestToast"), toast);
		int numtasksafter = Integer.parseInt(tasksAssignedByMeOpen.getText());
		assertEquals(tasksAssignedByMeOpenBefore + 1, numtasksafter);

	}

	public void waitUntilMy365RequestPageIsLoaded() {
		waitUntilPageIsLoadded();
	}
}