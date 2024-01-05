package Serien.SerienLive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	
	public void selectCourseName (String training) throws Throwable
	{
		
		waitForWebElementTOApper(SelectTrainingCourse);
		Select tty=new Select(SelectTrainingCourse);
		Thread.sleep(2000);
		tty.selectByVisibleText(training);
	}
	
	
}

