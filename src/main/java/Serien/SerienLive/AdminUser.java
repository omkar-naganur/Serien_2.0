package Serien.SerienLive;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Driver;

import Serien.AbstractComponents.abstractReusable;
import freemarker.core.ReturnInstruction.Return;

public class AdminUser extends abstractReusable {

	WebDriver driver;
	public AdminUser(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='/admin/users']")
	WebElement User;
	
	@FindBy(xpath = "//input[@placeholder='Enter Username']")
	WebElement UserNameSearchFiled;
	
	@FindBy(xpath = "(//button)[1]")
	WebElement UserNameSearchButton;
	
	@FindBy(xpath = "//div[@class='admin-overdue-bottom-table-cnt-usr']//select")
	WebElement UserActionDropdown;
	
	By LoginB =By.xpath("//button[@type='submit']");
	
	@FindBy(xpath = "//div[@class='admin-overdue-bottom-table-td']")
	List<WebElement> userallDetails;	
	//AddUser OR Edit User Page elements
	
	@FindBy (xpath = "//select[@id='company']")
	WebElement companyNameDropDown;
	
	@FindBy(xpath = "(//button)[1]")
	WebElement userSave;
	
	@FindBy(xpath = "(//button)[2]")
	WebElement userCancel;
	
	@FindBy(xpath = "(//button)[3]")
	WebElement userBack;
	
	@FindBy(xpath = "//div[@class='spinner-container']")
	WebElement LoadingScreeen;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement emailSearch;
	
	@FindBy(xpath = "//input[@name='email']/../div")
	WebElement emailSearchButton;
	
	@FindBy(id = "name")
	WebElement nameFiled;
	
	// User View section Elements
	
	@FindBy(xpath = "//div[@class='admin-overdue-bottom-table-td'][1]")
	List<WebElement> coursesName;	
	
	@FindBy(xpath = "//div/select")
	List<WebElement> actions;	
	
	//*********************
	
	
	public void GotoUser () throws Throwable
	{
		User.click();
	}

	// Below 3 methods Click on action Button Edit View & delete 
	
	public void clickOnEditButton () throws Throwable
	{
		Select se = new Select(UserActionDropdown);
		se.selectByVisibleText("Edit");
	}
	public void clickOnViewButton() {
		Select se = new Select(UserActionDropdown);
		se.selectByVisibleText("View");	
	}
	public void clickOnDeleteButton() {
		Select se = new Select(UserActionDropdown);
		se.selectByVisibleText("Delete");	
	}
	//**************************************************
	
	// Below Methods for User section search operations
	
	public void SearchByUserName(String userName) {
		//waitForElementTODissApper(LoadingScreeen);
		waitForWebElementTOApper(userallDetails);
		UserNameSearchFiled.click();
		UserNameSearchFiled.sendKeys(userName);
		waitForWebElementTOApper(UserNameSearchButton);
		UserNameSearchButton.click();
	}
	
	public void searchByEmail(String email) throws Throwable
	{
		waitForWebElementTOApper(emailSearch);
		emailSearch.click();
		emailSearch.sendKeys(email);
		emailSearchButton.click();
		Thread.sleep(2000);
	}
	
	//**********************************************************
	
	public void EditUserCompany (String companyName)
	{
		Select se = new Select(companyNameDropDown);
		se.selectByVisibleText(companyName);
		userSave.click();
	}
	
	public String validateTheCompanyNameFromUser (String companyName)
	{
		waitForWebElementTOApper(userallDetails);
		WebElement selectedElement = null;
		String lo=null;

		for (WebElement element : userallDetails) {
		    if (element.getText().equals(companyName)) {
		        selectedElement = element;
		        break; // Found the desired element, so exit the loop.
		    }
		}

		if (selectedElement != null) {
		    // Perform your actions with the selectedElement here
			 lo=selectedElement.getText();
			System.out.println(lo);
		} else {
		    // Handle the case when the element is not found
			System.out.println("Your Subscription not found");
			System.out.println(selectedElement);
		}
		
		return lo;
	}
	
	public void UserEditOrSaveCancel ()
	{
		userCancel.click();
	}
	
	public void changeUsername (String name) throws Throwable
	{
		waitForWebElementTOApper(nameFiled);
		Thread.sleep(3000);
		nameFiled.clear();
		nameFiled.sendKeys(name);	
	}
	
	public void saveUserDeatils () throws Throwable
	{
		waitForWebElementTOApper(userSave);
		userSave.click();
		Thread.sleep(2000);
		alertAccepectMethod();
//		Alert alr = driver.switchTo().alert();
//		String text=alr.getText();
//		System.out.println(text);
//		alr.accept();
	}

	public void deleteProgress(String courses) throws Throwable{
		
		Thread.sleep(5000);
		waitForWebElementTOApper(coursesName);
		
		for(int i=0;i<coursesName.size(); i++)
		{
		String actCourses =coursesName.get(i).getText();
		if (actCourses.equals(courses))
		{
			Select test= new Select(actions.get(i));
			test.selectByVisibleText("Delete Progress");
		}
		}
	}

	
}

