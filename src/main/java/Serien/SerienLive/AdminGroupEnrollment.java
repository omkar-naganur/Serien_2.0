package Serien.SerienLive;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	
//	String groupname;
	

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
	
	@FindBy(xpath = "//input[@name='groupName']")
	WebElement groupNameSearchBar;
	
	@FindBy(xpath = "//input[@name='groupName']//..//button")
	WebElement groupNameSearchButton;
	
	@FindBy(xpath = "//div[@class='admin-overdue-bottom-table-cnt-grpeden']//div[3]")
	List<WebElement> getCoursesNameList;
	
	@FindBy(xpath = "//div[@class='admin-overdue-bottom-table-cnt-grpeden']//div[4]")
	List<WebElement> getGroupNameList;
	
	@FindBy(xpath = "//div[@class='admin-overdue-bottom-pagination-cnt-item'][2]")
	WebElement PagenationForwardButton;
	
	
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
			System.out.println("enrollmentCancel");
			Thread.sleep(1000);
		}
	}
	catch (Exception e) 
	{
		System.out.println("No Alaert Found");
	}
	
	String acttext= groupEnrollmetText.getText();
	
	if(acttext.equals(expTextInEnrollment)) 
	{
		System.out.println("finaly done");
	}
	else {
		System.out.println("something went wrong out of the try catch");
	}	
	
	}

	public void enrollmentConfirmatioInEnrloomentList (String CoursesName, String Groupname) throws Throwable
	{
		waitForWebElementTOApper(groupNameSearchBar);
		waitForWebElementTOApper(groupNameSearchButton);
		groupNameSearchBar.click();
		groupNameSearchBar.sendKeys(Groupname);
		groupNameSearchButton.click();
		
				waitForWebElementTOApper(getCoursesNameList);
				Thread.sleep(2000);
				ArrayList<String> lastArray = new ArrayList<String>() ;
				ArrayList<String> lastsArray = new ArrayList<String>() ;
				boolean milgya = false;
				while(!milgya) {
					ArrayList<String> ar = new ArrayList<String>();
					ArrayList<String> ars = new ArrayList<String>();
					for(int i = 0; i< getCoursesNameList.size(); i++) 
				      {   	  
				      String s = getCoursesNameList.get(i).getText();
				      String groupname = getGroupNameList.get(i).getText();
				         ar.add(s);
				         ars.add(groupname);
				         
				      }
					
					for(int i = 0 ; i < ar.size() ; i++) {
						System.out.println(ar.get(i)+ "=="+ ars.get(i));
						if(ar.get(i).equals(CoursesName)&& ars.get(i).equals(Groupname)){
							System.out.println("milgya***********************");
							milgya = true;
						}
					}
					if(!milgya) {
						if(lastArray.size()!= 0) {
					    	  boolean xyz = 	false;
					    	  for(int i = 0 ; i < lastArray.size() && i < ar.size();i++) {
					    		  System.out.println(lastArray.get(i)+" == "+ar.get(i));
					    		  if(!lastArray.get(i).equals(ar.get(i))) {
					    			  i = lastArray.size();
					    			  xyz = true;
					    		  }
					    	  }
					    	  System.out.println("xyz : "+ xyz);
					    	  if(!xyz) {
					    		  milgya = true;
					    		  System.out.println("NAhi mil raha");
					    	  }
					      }
					       lastArray = ar;
					       lastsArray = ars;
			        	 PagenationForwardButton.click();
			        	 Thread.sleep(2000);
					}else {
						System.out.println("milgya***********************kyu mara rahe ho");
					} 
				}

}}
	
	


