package Serien.SerienLive;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import serien.TestComponents.BaseTest;

public class AdminEnrollments extends BaseTest {
	
	@Test(dataProvider = "CreatingGroupEnrollmentOfCourse", priority = 1)
	public void CreatingGroupEnrollmentOfCourse (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("adminEmail"), input.get("adminPass"));
		AdminGroupEnrollment ae= new AdminGroupEnrollment(driver);
		ae.groupEnrollment();
		ae.gotoAddNewGroupEnrollment();
		ae.selectTrainingType(input.get("typeOfTraining"));
		ae.selectCourseName(input.get("CourseName"));
		ae.selectGroupName(input.get("GroupName"));
		ae.selectDueDate(input.get("dueDate"));
		ae.saveGroupEnrollment();
		
	}
	
	@Test(dataProvider = "ValidatingTheEnrollmentListForEnrollmentConfirmation", priority = 2)
	public void ValidatingTheEnrollmentListForEnrollmentConfirmation (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("adminEmail"), input.get("adminPass"));
		AdminGroupEnrollment ae= new AdminGroupEnrollment(driver);
		ae.groupEnrollment();
		ae.enrollmentConfirmatioInEnrloomentList(input.get("CourseName"), input.get("GroupName"));		
	}
	
	@Test(dataProvider = "getdata", priority = 3)
	public void validationOfCoursesEnrollmentFromHRpanle (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));
		Learning lr=new Learning(driver);
		Boolean CourseFound = lr.CoursesNameValidationFromHRPanle(input.get("CourseName"));
		Assert.assertTrue(CourseFound);
	}
	
	@Test(dataProvider = "getdata", priority = 4)
	public void validationOfMicroLearningEnrollmentFromHRpanle (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));
		Learning lr=new Learning(driver);
		Boolean CourseFound = lr.MicroLearningNameValidationFromHRPanle(input.get("MicroLearningCourses"));
		Assert.assertTrue(CourseFound);	
	}
	
	@Test(dataProvider = "getdata", priority = 5)
	public void validationOfGamesEnrollmentFromHRpanle (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));
		Learning lr=new Learning(driver);
		Boolean CourseFound = lr.gameNameValidationFromHRPanel(input.get("Gamesname"));
		Assert.assertTrue(CourseFound);
	}
	
	@Test(dataProvider = "getdata1", priority = 6)
	public void GetUserEnrollmentDetails (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("adminEmail"), input.get("adminPass"));
		AdminGroupEnrollment age= new AdminGroupEnrollment(driver);
		age.groupEnrollment();
		age.findingGroupEnrollment(input.get("Courses"), input.get("group"));
		age.searchTheUserByEmail(input.get("Useremail"));
		age.getUserEnrollmentDetails(input.get("Useremail"));
	}
	
	@Test(dataProvider = "getdata1", priority = 7)
	public void ComplateTheCourseforAParticularUser (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("adminEmail"), input.get("adminPass"));
		AdminGroupEnrollment age= new AdminGroupEnrollment(driver);
		age.groupEnrollment();
		age.findingGroupEnrollment(input.get("Courses"), input.get("group"));
		age.searchTheUserByEmail(input.get("Useremail"));
		age.comapleTheUserProgress(input.get("Useremail"));
		Boolean statusMatch=age.validationUserCoursesStatusComplated(input.get("Useremail"));
		Assert.assertTrue(statusMatch);
	}
	
	@DataProvider
	public Object[][] getdata1()
	{
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("Useremail", "omkar@krishworks.com");
		map.put("userpass", "password");
		map.put("adminEmail", "admin@demo.com");
		map.put("adminPass", "pass2023");
		map.put("Courses", "Gender stereotypes");
		map.put("group", "TCS");
		
		return new Object[][] {{map}};
	}
	
	@DataProvider
	public Object[][] getdata() throws Throwable
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//serien//Data//EndToEndTestCase.json");
		return new Object[][]  { {data.get(0)}, {data.get(1)}, {data.get(0)} };
	}
	
	@DataProvider
	public Object[][] ValidatingTheEnrollmentListForEnrollmentConfirmation() throws Throwable
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//serien//Data//EndToEndTestCase.json");
		return new Object[][]  { {data.get(0)}, {data.get(1)}, {data.get(0)} };
	}
	
	@DataProvider
	public Object[][] CreatingGroupEnrollmentOfCourse() throws Throwable
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//serien//Data//EndToEndTestCase.json");
		return new Object[][]  { {data.get(0)}, {data.get(1)}, {data.get(0)} };
	}
}
