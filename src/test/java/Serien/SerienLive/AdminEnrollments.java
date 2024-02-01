package Serien.SerienLive;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import serien.TestComponents.BaseTest;

public class AdminEnrollments extends BaseTest {
	
	@Test(dataProvider = "all3TypeCourses", priority = 1)
	public void CreatingGroupEnrollmentOfCourse (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("adminEmail"), input.get("adminPass"));
		AdminGroupEnrollment ae= new AdminGroupEnrollment(driver);
		ae.groupEnrollment();
		ae.gotoAddNewGroupEnrollment();
		ae.selectTrainingType(input.get("typeOfTraining"));
		ae.selectCourseName(input.get("CourseName"));
		ae.selectGroupName(input.get("groupName"));
		ae.selectDueDate(input.get("dueDate"));
		ae.saveGroupEnrollment();
	}
	
	@Test(dataProvider = "all3TypeCourses", priority = 2)
	public void ValidatingTheEnrollmentListForEnrollmentConfirmation (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("adminEmail"), input.get("adminPass"));
		AdminGroupEnrollment ae= new AdminGroupEnrollment(driver);
		ae.groupEnrollment();
		ae.enrollmentConfirmatioInEnrloomentList(input.get("CourseName"), input.get("groupName"));		
	}
	
	@Test(dataProvider = "coursesDeatilsOnly", priority = 3)
	public void validationOfCoursesEnrollmentFromHRpanle (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));
		Learning lr=new Learning(driver);
		Boolean CourseFound = lr.CoursesNameValidationFromHRPanle(input.get("CourseName"));
		Assert.assertTrue(CourseFound);
	}
	
	@Test(dataProvider = "MicroLearningOnlay", priority = 4)
	public void validationOfMicroLearningEnrollmentFromHRpanle (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));
		Learning lr=new Learning(driver);
		Boolean CourseFound = lr.MicroLearningNameValidationFromHRPanle(input.get("CourseName"));
		Assert.assertTrue(CourseFound);	
	}
	
	@Test(dataProvider = "GamesOnlay", priority = 5)
	public void validationOfGamesEnrollmentFromHRpanle (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));
		Learning lr=new Learning(driver);
		Boolean CourseFound = lr.gameNameValidationFromHRPanel(input.get("CourseName"));
		Assert.assertTrue(CourseFound);
	}
	
	@Test(dataProvider = "coursesDeatilsOnly", priority = 6)
	public void GetUserEnrollmentDetails (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("adminEmail"), input.get("adminPass"));
		AdminGroupEnrollment age= new AdminGroupEnrollment(driver);
		age.groupEnrollment();
		age.findingGroupEnrollment(input.get("CourseName"), input.get("groupName"));
		age.searchTheUserByEmail(input.get("Useremail"));
		ArrayList<String> indexCount = age.getUserEnrollmentDetails(input.get("Useremail"));
		Assert.assertTrue(indexCount.size()==10);
	}
	
	@Test(dataProvider = "all3TypeCourses", priority = 7)
	public void ComplateTheCourseforAParticularUser (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("adminEmail"), input.get("adminPass"));
		AdminGroupEnrollment age= new AdminGroupEnrollment(driver);
		age.groupEnrollment();
		age.findingGroupEnrollment(input.get("CourseName"), input.get("groupName"));
		age.searchTheUserByEmail(input.get("Useremail"));
		age.comapleTheUserProgress(input.get("Useremail"));
		Boolean statusMatch=age.validationUserCoursesStatusComplated(input.get("Useremail"));
		Assert.assertTrue(statusMatch);
	}
	
	@Test(dataProvider = "all3TypeCourses", priority = 8)
	public void deleteAll3Enrollments (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("adminEmail"), input.get("adminPass"));
		AdminGroupEnrollment age= new AdminGroupEnrollment(driver);
		age.groupEnrollment();
		age.DeleteGroupEnrollmets(input.get("CourseName"), input.get("groupName"));
	}
	
	@DataProvider
	public Object[][] GamesOnlay() throws Throwable
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//serien//Data//AdminEnrollments.json");
		return new Object[][]  { {data.get(2)} };
	}
	
	@DataProvider
	public Object[][] MicroLearningOnlay() throws Throwable
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//serien//Data//AdminEnrollments.json");
		return new Object[][]  { {data.get(1)} };
	}
	
	@DataProvider
	public Object[][] coursesDeatilsOnly() throws Throwable
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//serien//Data//AdminEnrollments.json");
		return new Object[][]  { {data.get(0)} };
	}
	
	@DataProvider
	public Object[][] all3TypeCourses() throws Throwable
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//serien//Data//AdminEnrollments.json");
		return new Object[][]  { {data.get(0)}, {data.get(1)}, {data.get(2)} };
	}
}
