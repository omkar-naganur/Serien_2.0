package Serien.SerienLive;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Serien.AbstractComponents.abstractReusable;

public class Learning extends abstractReusable{

	WebDriver driver;
	public Learning(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//div[@class='sectionname MuiBox-root css-1isemmb'])[1]")
	WebElement coursesAcees;
	
	@FindBy(xpath = "(//div[@class='sectionname MuiBox-root css-1isemmb'])[2]")
	WebElement MicroLearnings;
	
	@FindBy(xpath = "(//div[@class='sectionname MuiBox-root css-1isemmb'])[3]")
	WebElement Webinars;
	
	@FindBy(xpath = "(//div[@class='sectionname MuiBox-root css-1isemmb'])[4]")
	WebElement Games;
	
	@FindBy(xpath = "//div[contains(@class, \"zoomtwo\")]/p")
	WebElement learningPageCoursesName;
	
	//List OF view all buttons
	
	@FindBy(xpath = "//div[contains(text(),'Courses')]/..//div[4]")
	WebElement coursesViewall;
	
	@FindBy(xpath = "//div[contains(text(),'Micro-learnings')]/..//div[4]")
	WebElement microLearningViewall;
	
	@FindBy(xpath = "//div[contains(text(),'Webinars')]/..//div[4]")
	WebElement WebinarsViewall;
	
	@FindBy(xpath = "//div[contains(text(),'Games')]/..//div[4]")
	WebElement gameViewall;
	
	//**********************************
	
	
	@FindBy(xpath = "//li[3]//div[1]//div[1]")
	WebElement learning;
	
	//Courses Elements
	
	@FindBy(xpath = "//button[@type='button']")
	WebElement startCourses;
	
	@FindBy(xpath = "(//div[@class='css-fk1ch0']//div)[1]")
	WebElement coursesTitle;
	
	@FindBy(xpath = "(//div[@class='css-fk1ch0']//div)[2]")
	WebElement coursesDescriptiuon;
	
	@FindBy(xpath = "(//div[@class='css-fk1ch0']//div)[3]//div[2]")
	WebElement CoursesComProgression;
	
	//@FindBy(xpath = "(//button[@type='button'])[2]")
	//WebElement start;
	
	@FindBy(xpath = "//div[@class='css-fk1ch0']//button")
	WebElement start;
	
	//div[@class='css-fk1ch0']//button
	
	// Scrom Elements
	
	@FindBy(id = "testdomel")
	WebElement iframeScrom;
	
	@FindBy(id = "courseFrame")
	WebElement courseFrame;
	
	//courseFrame
	
	@FindBy(xpath = "(//div[@class='message-box-buttons-panel__buttons'])//button[1]")
	WebElement resumeYes;
	
	@FindBy(xpath = "(//div[@class='message-box-buttons-panel__buttons'])//button[2]")
	WebElement resumeNo;
	
	
	
	public void scromCourseResume ()
	{
		waitForWebElementTOApper(iframeScrom);
		driver.switchTo().frame(iframeScrom);
		waitForWebElementTOApper(courseFrame);
		driver.switchTo().frame(courseFrame);
		waitForWebElementTOApper(resumeYes);
		waitForWebElementTOApper(resumeNo);
		resumeYes.click();
		driver.switchTo().defaultContent();
	}
	
	
	public void coursesPopup()
	{
		String SubAlertPoup=driver.switchTo().alert().getText();
		System.out.println(SubAlertPoup);
		driver.switchTo().alert().accept();
	}

	public ArrayList<String> learningPagePermissionsget()
	{
		waitForWebElementTOApper(MicroLearnings);
		String coursesActualPermission= coursesAcees.getText();
		String MicroLearningsActualPermission= MicroLearnings.getText();
		String WebinarsActualPermission= Webinars.getText();
		String GamesActualPermission= Games.getText();
		ArrayList<String> actualPermissionArryList = new ArrayList<String>();
		actualPermissionArryList.add(coursesActualPermission);
		actualPermissionArryList.add(MicroLearningsActualPermission);
		actualPermissionArryList.add(WebinarsActualPermission);
		actualPermissionArryList.add(GamesActualPermission);
		return actualPermissionArryList;
	}
		
	public void clickOnStartCourses ()
	{
		waitForWebElementTOApper(startCourses);
		startCourses.click();
	}
	
	public String getCoursesDetails() {
		waitForWebElementTOApper(coursesTitle);
		waitForWebElementTOApper(coursesDescriptiuon);
		waitForWebElementTOApper(CoursesComProgression);
		String ct=coursesTitle.getText();
		String cd=coursesDescriptiuon.getText();
		String ccp=CoursesComProgression.getText();
		System.out.println(ct);
		System.out.println(cd);
		System.out.println(ccp);
		return ct;
	}
	
	public void coursesStart() {
		waitForWebElementTOApper(start);
		start.click();
		
	}
	
	public String learningPageSampleCourseNameGet () {
		waitForWebElementTOApper(learningPageCoursesName);
		String sampleCoursesName =learningPageCoursesName.getText();
		System.out.println(sampleCoursesName);
		return sampleCoursesName ;
		
	}

}

