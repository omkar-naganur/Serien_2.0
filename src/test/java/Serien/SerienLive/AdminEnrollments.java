package Serien.SerienLive;

import org.testng.annotations.Test;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import serien.TestComponents.BaseTest;

public class AdminEnrollments extends BaseTest{

	
	@Test(dataProvider = "getdata", priority = 1)
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
	
	@Test(dataProvider = "getdata", priority = 2)
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
	
	@DataProvider
	public Object[][] getdata()
	{
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("Useremail", "omkar@krishworks.com");
		map.put("userpass", "password");
		map.put("adminEmail", "admin@demo.com");
		map.put("adminPass", "pass2023");
		map.put("typeOfTraining", "course");
	//	map.put("typeOfTraining", "Micro course");
	//	map.put("typeOfTraining", "Games");
		map.put("CourseName", "Safety and inclusion at the workplace"); //Safety and inclusion at the workplace
		map.put("GroupName", "Sitero_PoSH_2023");
		map.put("dueDate", "12122024");
		map.put("MicroLearningCourses", "Confirmation bias");
		map.put("Gamesname", "Omkar test");
		
		return new Object[][] {{map}};
	}
}
