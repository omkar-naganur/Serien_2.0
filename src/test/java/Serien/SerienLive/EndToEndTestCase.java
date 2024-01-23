package Serien.SerienLive;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

import serien.TestComponents.BaseTest;

public class EndToEndTestCase extends BaseTest {
	
	@Test(dataProvider = "getdata2")
	public void FromAdminPanleExpireTheSubscription(HashMap<String, String> input) throws Throwable
	{
		String companyname=input.get("companyName");
		String groupName= input.get("groupName");
		String CourseName= input.get("CourseName");
		LoginPage Dm= new LoginPage(driver);
		Dm.serienLogin(input.get("AdminUseremail"), input.get("Adminuserpass"));
		AdminSetting as= new AdminSetting(driver);
		Dm.Setting();	
		as.CompanySettingsOpen();
		as.CompanyCreatePage();
		as.fillCompanyDeatils(companyname, input.get("startdate"), input.get("enddate"), input.get("noticeperiod"));
		as.verifiveCompanyName(companyname); 
		
		AdminGroupPage ag= new AdminGroupPage(driver);
		ag.groups();
		ag.creatingGroup(input.get("groupName"), companyname, input.get("groupExpDate"));
		ag.SearchingComapnyNameInGroupListSecond(groupName); 
		// user company and group changing
		
		AdminUser au= new AdminUser(driver);
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
		age.selectGroupName(input.get("GroupName"));
		age.selectDueDate(input.get("groupExpDate"));
		age.saveGroupEnrollment();  
		Boolean enrollmentMatch=age.enrollmentConfirmatioInEnrloomentList(CourseName, input.get("GroupName"));
		Assert.assertTrue(enrollmentMatch);
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
		ArrayList<String> coursesDeatils = pr.getUserCoursesDetails(input.get("Useremail"), input.get("empName"));
		System.out.println(coursesDeatils);
	}
	
	@DataProvider
	public Object[][] getdata2()
	{
		HashMap<String, String> map= new HashMap<String, String>();
		// Login deatils 
		map.put("Useremail", "omkar@krishworks.com");
		map.put("userpass", "password");
		map.put("AdminUseremail", "admin@demo.com");
		map.put("Adminuserpass", "pass2023");
		map.put("empName", "omkar123456");
		//*********************************
		Random rand = new Random();
		int rand_int1 = rand.nextInt(1000);
		String companyName = "TCS"+rand_int1;
		map.put("companyName", "TCS755");
		//***************************************
		   LocalDateTime currentLocalDateTime = LocalDateTime.now(); 
	        // Create DateTimeFormatter instance with specified format
	        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        // Format LocalDateTime to String
	        String formattedDateTime = currentLocalDateTime.format(dateTimeFormatter);  
		map.put("startdate", formattedDateTime);
	//**********************************************************
		map.put("enddate", "30-12-2024");
		map.put("noticeperiod", "10");
		map.put("expectedExpText", "Subscription Expired");
		map.put("GroupName", "TCS755Group1");
		map.put("groupExpDate", "30-12-2024");
		map.put("CourseName", "automatiom Test Training");
		map.put("typeOfTraining", "course");
		map.put("enrollmentDueDate", "30-12-2024");
		map.put("", "");
		map.put("cerLink", "//storage.googleapis.com/serein-devqa-internal-gcp.appspot.com/generatedCertificate/");
		
		//*********************************
		// courses answer
		
		map.put("quiz1Ans1", "Priya can reach out to both her company’s IC or the client's IC based on her comfort.");
		map.put("quiz1Ans2", "Three colleagues go to a cafe for a weekend brunch. One of them is verbally harassed by the staff of the restaurant.");
		map.put("quiz2Ans1", "The impact of Gaurav’s behaviour on Nisha is certainly more relevant here.");
		//*********************
		
		//progress report expected results
		map.put("totalEmp", "1");
		map.put("empComCourses", "1");
		map.put("empNotComCourses", "0");
		
		
	
		return new Object[][] {{map}};
	}
}
