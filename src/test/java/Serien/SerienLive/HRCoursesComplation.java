package Serien.SerienLive;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import serien.TestComponents.BaseTest;

public class HRCoursesComplation extends BaseTest {
	
	@Test(dataProvider = "getDataCourses", priority = 1)
	public void ValidationOfCoursesAttend (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));
		Learning lr= new Learning(driver);	
		lr.OpenTheCourses(input.get("CourseName"));
		lr.AccepectingAcknowledge();
		lr.coursesStart(); 
		lr.coursesVideoAttend();
		Boolean quizStatus=lr.coursesQuizWith2Question(input.get("quiz1Ans1"), input.get("quiz1Ans2"));
		Assert.assertTrue(quizStatus);
		lr.coursesVideoAttend();
		lr.PDFComplation();
		lr.getCoursesProgressInIntger();
		Boolean quizStatus1=lr.coursesQuizWith1Question(input.get("quiz2Ans1"));
		Assert.assertTrue(quizStatus1);
		int actProgress=lr.getCoursesProgressInIntger();
		Assert.assertTrue(actProgress==100);
		Boolean certmatch=lr.certificateValidation();
		Assert.assertTrue(certmatch);
		
	}
	
	@Test(dataProvider = "getDataMicroLearning", priority = 2)
	public void ValidationOfMicroLearningAttend (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));
		Learning lr= new Learning(driver);	
		lr.OpenTheMicroLearning(input.get("CourseName"));
		lr.coursesStart(); 
		lr.coursesVideoAttend();
		Boolean quizStatus1=lr.coursesQuizWith1Question(input.get("quiz1Ans1"));
		Assert.assertTrue(quizStatus1);
		lr.PDFComplation();
		int actProgress=lr.getMicroLearningProgressInIntger();
		Assert.assertTrue(actProgress==100);
		Boolean certmatch=lr.certificateValidation();
		Assert.assertTrue(certmatch);
		
	}
	
	@Test(dataProvider = "getDataGames", priority = 3)
	public void ValidationOfGameAttend (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));
		Learning lr= new Learning(driver);	
		lr.OpenTheGame(input.get("CourseName"));
		lr.AccepectingAcknowledge();
		lr.coursesStart(); 
	}
	
	@Test(dataProvider = "DataClearOrTearDown", priority = 4)
	public void all3CoursesProgressReset (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("adminEmail"), input.get("adminPass"));
		AdminUser au= new AdminUser(driver);
		au.users();
		au.searchByEmail(input.get("Useremail"));
		au.clickOnViewButton();
		au.deleteProgress(input.get("CourseName"));
		au.users();
	}
	
	@DataProvider
	public Object[][] getDataCourses() throws Throwable //for only Courses
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//serien//Data//HRCoursesComplation.json");
		return new Object[][]  { {data.get(0)} };
	}
	
	@DataProvider
	public Object[][] getDataMicroLearning() throws Throwable //for only MicroLearning
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//serien//Data//HRCoursesComplation.json");
		return new Object[][]  { {data.get(1)} };
	}
	
	@DataProvider
	public Object[][] getDataGames() throws Throwable //for only games
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//serien//Data//HRCoursesComplation.json");
		return new Object[][]  { {data.get(2)} };
	}
	
	@DataProvider
	public Object[][] DataClearOrTearDown() throws Throwable //for only games
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//serien//Data//HRCoursesComplation.json");
		return new Object[][]  { {data.get(0)}, {data.get(1)}, {data.get(2)} };
	}
	
}
