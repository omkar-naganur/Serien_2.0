package Serien.SerienLive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.util.Assert;

import Serien.AbstractComponents.abstractReusable;

public class AdminGroupEnrollment extends abstractReusable{

	WebDriver driver;
	public AdminGroupEnrollment(WebDriver driver)
	{
		super (driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='/admin/groupEnrollmentEdits/']")
	WebElement addNewGroupEnrollment;
	
	@FindBy(xpath = "//a[@href='/admin/settings']/..")
	WebElement SettingA;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement LoginButton;
	
	@FindBy(xpath = "//select[@class='admin-course-main-top-select ']")
	WebElement SelectTrainingCourse;
	
	@FindBy(id = "course-ids")
	WebElement SelectCourseName;
	
	@FindBy(id = "group-ids")
	WebElement SelectGroupName;
	
	@FindBy(xpath = "//input[@type='date']")
	WebElement DueDate;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement enrollmentSave;
	
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	WebElement enrollmentCancel;
	
	@FindBy(xpath = "//a[@href='/admin/groupEnrollmentEdits/']/button")
	WebElement groupEnrollmetText;
	
	
	public void gotoAddNewGroupEnrollment () throws Throwable
	{
		waitForWebElementTOApper(addNewGroupEnrollment);
		addNewGroupEnrollment.click();
	}
	
	public void selectTrainingType (String training) throws Throwable
	{	
		waitForWebElementTOApper(SelectTrainingCourse);
		Select tty=new Select(SelectTrainingCourse);
		Thread.sleep(2000);
		tty.selectByVisibleText(training);
	}
	
	public void selectCourseName (String CourseName) throws Throwable
	{	
		waitForWebElementTOApper(SelectCourseName);
		Select tty=new Select(SelectCourseName);
		Thread.sleep(2000);
		tty.selectByVisibleText(CourseName);
	}
	
	public void selectGroupName (String GroupName) throws Throwable
	{
		waitForWebElementTOApper(SelectGroupName);
		Select tty=new Select(SelectGroupName);
		Thread.sleep(2000);
		tty.selectByVisibleText(GroupName);
	}
	
	public void selectDueDate (String date) throws Throwable
	{
		waitForWebElementTOApper(DueDate);
		DueDate.sendKeys(date);
	}
	
	public void saveGroupEnrollment () throws Throwable
	{

	String expTextInEnrollment = "AddNewGroupEnrollment";
	
	enrollmentSave.click();
	Thread.sleep(2000);
	try
	{
		String actMes=alertAccepectMethod();
		System.out.println("act mes"+actMes);
		String  error= "GroupEnrollment already created with this groupId and courseId use can select other options";
		if (actMes.equals(error))
		{
			enrollmentCancel.click();
		}
	
	}
	catch (Exception e) {
		
		System.out.println("something went wrong in catch block");
		
	}
	Thread.sleep(1000);
	
	String acttext= groupEnrollmetText.getText();
	
	if(acttext.equals(expTextInEnrollment)) 
	{
		System.out.println("finaly done");
	}
	else {
		System.out.println("something went wrong out of the try catch");
	}	
	
	}}
	
	


