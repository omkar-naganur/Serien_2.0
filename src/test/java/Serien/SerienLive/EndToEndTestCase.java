package Serien.SerienLive;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

import serien.TestComponents.BaseTest;

public class EndToEndTestCase extends BaseTest {
	
	@Test(dataProvider = "NewCompanyWithHRcoursesComplation", priority = 1)
	public void NewCompanyWithHRcoursesComplation (HashMap<String, String> input) throws Throwable {
		AdminSetting as= new AdminSetting(driver);
		int number=as.randomNumberGenerater();
		String companyname= (input.get("companyName")+number);
		String groupName= input.get("GroupName")+number;
		String CourseName= input.get("CourseName");
		LoginPage Dm= new LoginPage(driver);
		Dm.serienLogin(input.get("AdminUseremail"), input.get("Adminuserpass"));
		
		Dm.Setting();	
		as.CompanySettingsOpen();
		as.CompanyCreatePage();
		as.fillCompanyDeatils(companyname, input.get("startdate"), input.get("enddate"), input.get("noticeperiod"));
		as.verifiveCompanyName(companyname); 
		
		AdminGroupPage ag= new AdminGroupPage(driver);
		Thread.sleep(2000);
		ag.groups();
		ag.creatingGroup(groupName, companyname, input.get("groupExpDate"));
		ag.SearchingComapnyNameInGroupListSecond(groupName);  
		// user company and group changing 
		
		AdminUser au= new AdminUser(driver); 
		Thread.sleep(1000);
		au.ScrollUp500();
        Thread.sleep(1000);
		au.users();
		au.searchByEmail(input.get("Useremail"));
		au.clickOnEditButton();
		au.EditUserCompanyAndGroup(companyname, groupName); 
		// group enrollment for courses 
		AdminGroupEnrollment age= new AdminGroupEnrollment(driver);
		age.groupEnrollment();
		age.gotoAddNewGroupEnrollment();
		age.selectTrainingType(input.get("typeOfTraining"));
		age.selectCourseName(CourseName);
		age.selectGroupName(groupName);
		age.selectDueDate(input.get("groupExpDate"));
		age.saveGroupEnrollment();  
		Thread.sleep(2000);
		age.ScrollUp500();
//		Boolean enrollmentMatch=age.enrollmentConfirmatioInEnrloomentList(CourseName, groupName);
//		Assert.assertTrue(enrollmentMatch);
		age.adminLogout(); 
		Profile profile=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass")); 
		Learning hrl= new Learning(driver);
		Boolean coursesMatch= hrl.CoursesNameValidationFromHRPanle(CourseName);
		Assert.assertTrue(coursesMatch);
		// courses  complation section 
		hrl.OpenTheCourses(CourseName);
		hrl.AccepectingAcknowledge();
		hrl.coursesStart(); 
		hrl.coursesVideoAttend();
		Boolean quizStatus=hrl.coursesQuizWith2Question(input.get("quiz1Ans1"), input.get("quiz1Ans2"));
		Assert.assertTrue(quizStatus);
		hrl.coursesVideoAttend();
		hrl.PDFComplation();
		hrl.getCoursesProgressInIntger(); 
		Boolean quizStatus1=hrl.coursesQuizWith1Question(input.get("quiz2Ans1"));
		Assert.assertTrue(quizStatus1);
		int actProgress=hrl.getCoursesProgressInIntger();
		Assert.assertTrue(actProgress==100); 
		String certificateLink= hrl.getCertificate();
		Assert.assertTrue(certificateLink.contains(input.get("cerLink")));   
		//*******************************************
		ProgressReport pr =new ProgressReport(driver);
		pr.ProgresReport();
		ArrayList<String> coursesName = pr.getCoursesNameInReport();
		Assert.assertTrue(coursesName.contains(CourseName));
		ArrayList<String> listofcount = pr.getAllCountsInProgressReport(CourseName);
		String totalemp = listofcount.get(0);
		Assert.assertTrue(totalemp.equals(input.get("totalEmp")));
		String empComCourses = listofcount.get(1);
		Assert.assertTrue(empComCourses.equals(input.get("empComCourses")));
		String empNotComCourses = listofcount.get(2);
		Assert.assertTrue(empNotComCourses.equals(input.get("empNotComCourses")));
		ArrayList<String> HrPanleUserDeatils = pr.getUserCoursesDetails(input.get("Useremail"), input.get("empName"));
		System.out.println(HrPanleUserDeatils);
		String Status=HrPanleUserDeatils.get(6);
		Assert.assertTrue(Status.equals("Completed"));
		pr.Profile();
		pr.userLogout(); 
		
		//admin verification
		Dm.serienLogin(input.get("AdminUseremail"), input.get("Adminuserpass"));
		age.groupEnrollment();
		age.findingGroupEnrollment(CourseName, groupName);
		age.searchTheUserByEmail(input.get("Useremail"));
		ArrayList<String> adminViewUserCoursesDeatils = age.getUserEnrollmentDetails(input.get("Useremail"));
		String ComplationDateinHrPanle= adminViewUserCoursesDeatils.get(7);
		// we need to write the equeales method here for hr panle details and admin panle deatils
		Assert.assertTrue(adminViewUserCoursesDeatils.get(8).equals(HrPanleUserDeatils.get(6))); 
		System.out.println("Courses Status matched");
		Assert.assertTrue(adminViewUserCoursesDeatils.get(7).equals(HrPanleUserDeatils.get(5)));
		System.out.println(" Courses complation date");
		Assert.assertTrue(adminViewUserCoursesDeatils.get(6).equals(HrPanleUserDeatils.get(4)));
		System.out.println("Courses start date");
		Assert.assertTrue(adminViewUserCoursesDeatils.get(5).equals(HrPanleUserDeatils.get(2)));	
		System.out.println("lesson complated");
		Assert.assertTrue(adminViewUserCoursesDeatils.get(4).equals(HrPanleUserDeatils.get(1)));
		System.out.println("Courses Total lessons");
		//*************************
		// user progress reset
		au.users();
		au.searchByEmail(input.get("Useremail"));
		Thread.sleep(3000);
		au.clickOnViewButton();
		au.deleteProgress(input.get("CourseName"));	
		au.users();
		au.adminLogout();  
		Thread.sleep(2000);
		// ensure the courses progress reste reflacting to Hr panle 
		
		Dm.serienLogin(input.get("Useremail"), input.get("userpass"));
		Boolean coursesMatch1= hrl.CoursesNameValidationFromHRPanle(CourseName);
		Assert.assertTrue(coursesMatch1);
		int progress=hrl.getCoursesProgressOnly(CourseName);
		Assert.assertTrue(progress==0);
		
	}
	
	@Test(dataProvider = "ValidationOfCoursesComplationFromTheAdmin", priority = 2)
	public void ValidationOfCoursesComplationFromTheAdmin (HashMap<String, String> input) throws Throwable {
		AdminGroupPage group= new AdminGroupPage(driver);
		int number=group.randomNumberGenerater();
		String companyName = input.get("companyName");
		String groupName = input.get("groupName")+number;
		String typeOfTraining = input.get("typeOfTraining");
		String CourseName = input.get("CourseName");
		String adminEmail = input.get("adminEmail");
		String adminPass= input.get("adminPass");
		String userEmail = input.get("userEmail");
		String userPass = input.get("userPass");
		
		Profile profile=LoginPage.serienLogin(input.get("adminEmail"), input.get("adminPass"));
		group.groups();
		group.creatingGroup(groupName, companyName, input.get("groupExp"));
		AdminUser au= new AdminUser(driver);
		au.users();
		au.searchByEmail(input.get("userEmail"));
		au.clickOnEditButton();
		au.EditUserCompanyAndGroup(companyName, groupName);
//		
		AdminGroupEnrollment enrollment= new AdminGroupEnrollment(driver);
		enrollment.groupEnrollment();
		enrollment.creatingNewGroupEnrollemnt(typeOfTraining, CourseName, groupName, input.get("groupExp"));
		enrollment.adminLogout();
		
		LoginPage.serienLogin(input.get("userEmail"), input.get("userPass"));
		Learning lr= new Learning(driver);
		int beforeCom=lr.getCoursesProgressOnly(CourseName);
		Assert.assertTrue(beforeCom==0);
		lr.Profile();
		lr.Logout();
		
		LoginPage.serienLogin(input.get("adminEmail"), input.get("adminPass"));
		enrollment.groupEnrollment();
		enrollment.findingGroupEnrollment(CourseName, groupName);
		enrollment.comapleTheUserProgress(input.get("userEmail"));
		enrollment.groupEnrollment();
		enrollment.Logout();
		
		LoginPage.serienLogin(input.get("userEmail"), input.get("userPass"));
		int afterCom=lr.getCoursesProgressOnly(CourseName);
		Assert.assertTrue(afterCom==100);
		
//		//*******************************************
		ProgressReport pr =new ProgressReport(driver);
		pr.ProgresReport();
		ArrayList<String> coursesName = pr.getCoursesNameInReport();
		Assert.assertTrue(coursesName.contains(CourseName));
		ArrayList<String> listofcount = pr.getAllCountsInProgressReport(CourseName);
		String totalemp = listofcount.get(0);
		Assert.assertTrue(totalemp.equals(input.get("totalEmp")));
		String empComCourses = listofcount.get(1);
		Assert.assertTrue(empComCourses.equals(input.get("empComCourses")));
		String empNotComCourses = listofcount.get(2);
		Assert.assertTrue(empNotComCourses.equals(input.get("empNotComCourses")));
		ArrayList<String> HrPanleUserDeatils = pr.getUserCoursesDetails(input.get("userEmail"), input.get("empName"));
		System.out.println(HrPanleUserDeatils);
		String Status=HrPanleUserDeatils.get(6);
		Assert.assertTrue(Status.equals("Completed"));
		pr.Profile();
		pr.userLogout();
		
		//admin verification
		LoginPage.serienLogin(adminEmail, adminPass);
		enrollment.groupEnrollment();
		enrollment.findingGroupEnrollment(CourseName, groupName);
		enrollment.searchTheUserByEmail(userEmail);
		ArrayList<String> adminViewUserCoursesDeatils = enrollment.getUserEnrollmentDetails(userEmail);
		String ComplationDateinHrPanle= adminViewUserCoursesDeatils.get(7);
	//	 we need to write the equeales method here for hr panle details and admin panle details
		Assert.assertTrue(adminViewUserCoursesDeatils.get(8).equals(HrPanleUserDeatils.get(6))); 
		System.out.println("Courses Status matched");
		Assert.assertTrue(adminViewUserCoursesDeatils.get(7).equals(HrPanleUserDeatils.get(5)));
		System.out.println(" Courses complation date");
		Assert.assertTrue(adminViewUserCoursesDeatils.get(6).equals(HrPanleUserDeatils.get(4)));
		System.out.println("Courses start date");
		Assert.assertTrue(adminViewUserCoursesDeatils.get(5).equals(HrPanleUserDeatils.get(2)));	
		System.out.println("lesson complated");
		Assert.assertTrue(adminViewUserCoursesDeatils.get(4).equals(HrPanleUserDeatils.get(1)));
		System.out.println("Courses Total lessons");
		Assert.assertTrue(adminViewUserCoursesDeatils.get(9).equals(HrPanleUserDeatils.get(7)));
		System.out.println("Certificate matched");
		
		// user progress reset
		au.users();
		au.searchByEmail(input.get("Useremail"));
		Thread.sleep(3000);
		au.clickOnViewButton();
		au.deleteProgress(input.get("CourseName"));	
		au.users();
		au.adminLogout();  
		Thread.sleep(2000);
		
	}
	
	@Test(dataProvider = "ValidationOfGroupDateExpiredDataSheet", priority = 3)
	public void ValidationOfGroupDateExpired (HashMap<String, String> input) throws Throwable{
		AdminGroupPage group= new AdminGroupPage(driver);
		int number=group.randomNumberGenerater();
		String companyName = input.get("companyName");
		String groupName = input.get("groupName")+number;
		String typeOfTraining = input.get("typeOfTraining");
		String CourseName = input.get("CourseName");
		String adminEmail = input.get("adminEmail");
		String adminPass= input.get("adminPass");
		String userEmail = input.get("userEmail");
		String userPass = input.get("userPass");
		String groupExpValid = input.get("groupExpValid");
		String groupExpInValid = input.get("groupExpInValid");
		
		LoginPage.serienLogin(adminEmail, adminPass);
		group.groups();
		group.creatingGroup(groupName, companyName, groupExpValid);
		
		AdminUser au= new AdminUser(driver);
		// Create a new group
		au.users();
		au.searchByEmail(userEmail);
		au.clickOnEditButton();
		au.EditUserCompanyAndGroup(companyName, groupName);
		
		// creating new group enrollment
		AdminGroupEnrollment enrollment= new AdminGroupEnrollment(driver);
		enrollment.groupEnrollment();
		enrollment.creatingNewGroupEnrollemnt(typeOfTraining, CourseName, groupName, groupExpValid);
		
		enrollment.SwitchToUser(userEmail, userPass);
		// ensuring the courses present or not
		Learning learning= new Learning(driver);
		Boolean coursesMatch=learning.CoursesNameValidationFromHRPanle(CourseName);
		Assert.assertTrue(coursesMatch);
		
		// ensuring the group expire messge not displaying
		ProgressReport pr= new ProgressReport(driver);
		pr.ProgresReport();
		pr.searchGroupName(groupName);
		Boolean megMatchFalse = pr.VaildationOfGroupExpiredMessage();
		Assert.assertFalse(megMatchFalse);
		learning.SwitchToAdmin(adminEmail, adminPass);
		
		// updating the group expire date
		group.groups();
		group.UpdateGroupExpiredDate(groupExpInValid, groupName);
		group.SwitchToUser(userEmail, userPass);
		
		//ensuring the group expire message displaying
		pr.ProgresReport();
		pr.searchGroupName(groupName);
		Boolean megMatchTrue = pr.VaildationOfGroupExpiredMessage();
		Assert.assertTrue(megMatchTrue);
		
	}
	
	@DataProvider
	public Object[][] ValidationOfGroupDateExpiredDataSheet () throws Throwable
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//serien//Data//EndToEndTestCase.json");
		return new Object[][]  { {data.get(1)} };
	}
	
	@DataProvider
	public Object[][] ValidationOfCoursesComplationFromTheAdmin() throws Throwable
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//serien//Data//EndToEndTestCase.json");
		return new Object[][]  { {data.get(0)} };
	}
	
	@DataProvider
	public Object[][] NewCompanyWithHRcoursesComplation() throws Throwable
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//serien//Data//EndToEndTestCase.json");
		return new Object[][]  { {data.get(3)} };
	}
}
