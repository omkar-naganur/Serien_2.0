package Serien.SerienLive;

import org.testng.annotations.Test;

import static org.testng.Assert.assertThrows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import serien.TestComponents.BaseTest;

public class HRprogressReport extends BaseTest {
	
	@Test(dataProvider = "normalCourses", priority = 1)
	public void ValidatingEnrolledCoursesNameShouldDisplayInHRprogressReportPage (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));
		ProgressReport pr= new ProgressReport(driver);
		pr.ProgresReport();
		ArrayList<String> nameOfCourses = pr.getCoursesNameInReport();
		System.out.println(nameOfCourses);
		Boolean coursesMatch=nameOfCourses.contains(input.get("CourseName"));
		Assert.assertTrue(coursesMatch);		
	}
	
	@Test(dataProvider = "microLearning", priority = 2)
	public void ValidatingEnrolledMicroLearningNameShouldDisplayInHRprogressReportPage (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));
		ProgressReport pr= new ProgressReport(driver);
		pr.ProgresReport();
		ArrayList<String> nameOfMicroLearning = pr.getMicroLearningNameInReport();
		System.out.println(nameOfMicroLearning);
		Boolean microLearningMatch=nameOfMicroLearning.contains(input.get("CourseName"));
		Assert.assertTrue(microLearningMatch);		
	}
	
	@Test(dataProvider = "games", priority = 3)
	public void ValidatingEnrolledGameNameShouldDisplayInHRprogressReportPage (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));
		ProgressReport pr= new ProgressReport(driver);
		pr.ProgresReport();
		ArrayList<String> nameOfGames = pr.getGameNameInReport();
		System.out.println(nameOfGames);
		Boolean gameMatch=nameOfGames.contains(input.get("CourseName"));
		Assert.assertTrue(gameMatch);		
	}
	
	@Test(dataProvider = "all3typeCoursesDeatils", priority = 4)
	public void ValidatingContsInreport (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));
		Thread.sleep(5000);
		ProgressReport pr= new ProgressReport(driver);
		pr.ProgresReport();
		// Below code is Dynamic for all the type of Courses, Micro Learning, Games you need to pass the name only
		ArrayList<String> Count =pr.getAllCountsInProgressReport(input.get("CourseName"));
		System.out.println(Count);
		int countTotalnoofemployees =Integer.parseInt(Count.get(0));
		int countEmployeesCompletedCourse =Integer.parseInt(Count.get(1));
		int countEmployeesNotCompletedCourse =Integer.parseInt(Count.get(2));
		Assert.assertTrue(countTotalnoofemployees==1);
		System.out.println(countTotalnoofemployees);
		Assert.assertTrue(countEmployeesCompletedCourse==0);
		System.out.println(countEmployeesCompletedCourse);
		Assert.assertTrue(countEmployeesNotCompletedCourse==1);
		System.out.println(countEmployeesNotCompletedCourse);
		
	}
	
	
	@Test(dataProvider = "all3typeCoursesDeatils", priority = 5)
	public void ValidatingSearchBarByEmployeeNameAndEmployeeEmail (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));
		Thread.sleep(5000);
		ProgressReport pr= new ProgressReport(driver);
		pr.ProgresReport();
		pr.enterningToCourses(input.get("CourseName"));
		Boolean emailValidation=pr.validatonOfSearchBarWithEmail(input.get("Useremail"), input.get("userName"));
		Assert.assertTrue(emailValidation);
		Boolean nameValidation=pr.validatonOfSearchBarWithUserName(input.get("userName"));
		Assert.assertTrue(nameValidation);
			
	}
	
	@DataProvider
	public Object[][] normalCourses() throws Throwable
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//serien//Data//HRprogressReport.json");
		return new Object[][]  { {data.get(0)} };
	}
	
	@DataProvider
	public Object[][] microLearning() throws Throwable
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//serien//Data//HRprogressReport.json");
		return new Object[][]  { {data.get(1)} };
	}
	
	@DataProvider
	public Object[][] games() throws Throwable
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//serien//Data//HRprogressReport.json");
		return new Object[][]  { {data.get(2)} };
	}
	
	@DataProvider
	public Object[][] all3typeCoursesDeatils() throws Throwable
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//serien//Data//HRprogressReport.json");
		return new Object[][]  { {data.get(0)}, {data.get(1)}, {data.get(2)} };
	}
}
