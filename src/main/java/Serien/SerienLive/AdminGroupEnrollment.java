package Serien.SerienLive;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
	
	@FindBy(xpath = "//div[@class='admin-overdue-bottom-table-cnt-grpeden']/div[8]//select")
	List<WebElement>  UserActionDropdown;
	
	// Group enrollment view section elements
	
	@FindBy(xpath = "//input[@type='text']")
	WebElement searchBar ;
	
	@FindBy(xpath = "//input[@type='text']/..//div")
	WebElement searchButton ;
	
	@FindBy(xpath = "//input[@value='empName']")
	WebElement employeeNameRadoButton ;
	
	@FindBy(xpath = "//input[@value='empEmail']")
	WebElement employeeEmailRadoButton ;
	
	@FindBy(xpath = "//div[contains(text(),'Clear')]")
	WebElement clear ;
	
	@FindBy(xpath = "//button/div[contains(text(),'Complete course')]")
	WebElement completeCourse ;
	
	@FindBy(xpath = "//button/div[contains(text(),'Download report')]")
	WebElement downloadReport ;
	
	@FindBy(xpath = "//button/div[contains(text(),'send reminder')]")
	WebElement sendReminder ;
	
	@FindBy(xpath = "//div[@class='admin-overdue-bottom-table-cnt']//div[3]")
	List<WebElement>  ListOfEmail ;
	
	@FindBy(xpath = "//div[@class='admin-overdue-bottom-table-cnt']//div[1]")
	List<WebElement>  srno ;
	
	@FindBy(xpath = "//div[@class='admin-overdue-bottom-table-cnt']//div[2]")
	List<WebElement>  name ;
	
	@FindBy(xpath = "//div[@class='admin-overdue-bottom-table-cnt']//div[4]")
	List<WebElement>  CourseName ;
	
	@FindBy(xpath = "//div[@class='admin-overdue-bottom-table-cnt']//div[5]")
	List<WebElement>  TotalLessonCount ;
	
	@FindBy(xpath = "//div[@class='admin-overdue-bottom-table-cnt']//div[6]")
	List<WebElement>  LessonCompleted ;
	
	@FindBy(xpath = "//div[@class='admin-overdue-bottom-table-cnt']//div[7]")
	List<WebElement>  StartDate ;
	
	@FindBy(xpath = "//div[@class='admin-overdue-bottom-table-cnt']//div[8]")
	List<WebElement>  CompletionDate ;
	
	@FindBy(xpath = "//div[@class='admin-overdue-bottom-table-cnt']//div[9]")
	List<WebElement>  Status ;
	
	@FindBy(xpath = "//div[@class='admin-overdue-bottom-table-cnt']//div[10]")
	List<WebElement>  Action ;
	
	@FindBy(xpath = "//div[@class='admin-overdue-bottom-table-cnt']")
	List<WebElement>  ListOfDeatils ;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	List<WebElement>  checkbox ;
	
	@FindBy(xpath = "//select/option[2]")
	List<WebElement> DownloadCertificate ;
	
	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	WebElement selectAllCheckBox ;
	
	//************************************************
	
	// Courses Complation Dilog box
	
	@FindBy(xpath = "//div[@role='dialog']")
	WebElement dialogBOX ;
	
	@FindBy(xpath = "//div[contains(text(),' Module name')]/..//input[@type='checkbox']")
	WebElement selectAllModuleCheckBox ;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement save ;
	
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

	public boolean enrollmentConfirmatioInEnrloomentList (String CoursesName, String Groupname) throws Throwable
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
					    	  boolean xyz = false;
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
				return milgya;

}
	
	public boolean findingGroupEnrollment (String CoursesName, String Groupname) throws Throwable
	{
//		waitForWebElementTOApper(groupNameSearchBar);
//		waitForWebElementTOApper(groupNameSearchButton);
//		groupNameSearchBar.click();
//		groupNameSearchBar.sendKeys(Groupname);
//		groupNameSearchButton.click();
		
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
							Thread.sleep(1000);
							System.out.println(i);
							clickOnViewButton(i-1);
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
				return milgya;

}
	public void clickOnViewButton(int i) {
		Select se = new Select(UserActionDropdown.get(i));
		se.selectByVisibleText("View");	
	}

	public void searchTheUserByEmail(String email) throws Throwable {
		Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -500)");
		Thread.sleep(1000);
		employeeEmailRadoButton.click();
		searchBar.click();
		searchBar.sendKeys(email);
		searchButton.click();
		Thread.sleep(2000);
		
	}

	public ArrayList<String> getUserEnrollmentDetails(String email) throws Throwable {
		
		ArrayList<String> enrollmentDeatils = new ArrayList<String>() ;
		Thread.sleep(2000);
		waitForWebElementTOApper(ListOfEmail);
		for(int i=0; i<ListOfEmail.size(); i++)
		{
		String actemail=ListOfEmail.get(i).getText();
		
		if (actemail.equals(email)) {
			
			enrollmentDeatils.add(srno.get(i).getText());
			enrollmentDeatils.add(name.get(i).getText());
			enrollmentDeatils.add(ListOfEmail.get(i).getText());
			enrollmentDeatils.add(CourseName.get(i).getText());
			enrollmentDeatils.add(TotalLessonCount.get(i).getText());
			enrollmentDeatils.add(LessonCompleted.get(i).getText());
			enrollmentDeatils.add(StartDate.get(i).getText());
			enrollmentDeatils.add(CompletionDate.get(i).getText());
			enrollmentDeatils.add(Status.get(i).getText());
			try {
				enrollmentDeatils.add(getCertificateURL(i));
				
			} catch (Exception e) {
				System.out.println("certificate not available");
				enrollmentDeatils.add("certificate not available");
			}
			
				
		}
				
		}
		System.out.println(enrollmentDeatils);
		return enrollmentDeatils ;
	}
	
	public String getCertificateURL(int i) throws Throwable {
		Boolean certifite= false;
	//	Thread.sleep(2000);
		DownloadCertificate.get(i-1).click();
		Thread.sleep(2000);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();	
		String parentWindowID=it.next();
		String childWindowID=it.next();
		driver.switchTo().window(childWindowID);
		String certificateURL= driver.getCurrentUrl();	
		Thread.sleep(2000);
		System.out.println(certificateURL);
		driver.close();
		driver.switchTo().window(parentWindowID);
		return certificateURL;
	}

	public void comapleTheUserProgress(String email) throws Throwable {
	
		for(int i=0; i<ListOfEmail.size(); i++)
		{
		String actemail=ListOfEmail.get(i).getText();
		Thread.sleep(2000);
		if (actemail.equals(email)) {
			checkbox.get(i).click();
			Thread.sleep(1000);
			completeCourse.click();
			Thread.sleep(1000);
			selectAllModuleCheckBox.click();
			Thread.sleep(1000);
			save.click();
			Thread.sleep(2000);
			alertAccepectMethod();
			
		}
		
	}
	}

	public Boolean validationUserCoursesStatusComplated(String email) throws Throwable {
		
		ArrayList<String> enrollmentDeatils = new ArrayList<String>() ;
		clear.click();
		Thread.sleep(1000);
		searchTheUserByEmail(email);
		enrollmentDeatils=getUserEnrollmentDetails(email);
		Thread.sleep(2000);
		String coursesStatus= enrollmentDeatils.get(8);
		System.out.println(coursesStatus);
		Boolean statusMatch =coursesStatus.equals("Completed");
		return statusMatch;
		
	}
	
	public void creatingNewGroupEnrollemnt (String typeOfTraining, String CourseName, String GroupName, String groupExpDate) throws Throwable {
		gotoAddNewGroupEnrollment();
		selectTrainingType(typeOfTraining);
		selectCourseName(CourseName);
		selectGroupName(GroupName);
		selectDueDate(groupExpDate);
		saveGroupEnrollment();  
		Thread.sleep(2000);
		ScrollUp500();
	}
	
	public boolean DeleteGroupEnrollmets (String CoursesName, String Groupname) throws Throwable
	{
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
							Thread.sleep(1000);
							System.out.println(i);
							clickOnDeleteButton(i-1);
							Thread.sleep(1000);
							alertAccepectMethod();
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
				return milgya;

}

	public void clickOnDeleteButton(int i) {
		Select se = new Select(UserActionDropdown.get(i));
		se.selectByVisibleText("Delete");	
		
	}
	
}
	
