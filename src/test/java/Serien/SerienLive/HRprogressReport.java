package Serien.SerienLive;

import org.testng.annotations.Test;

import static org.testng.Assert.assertThrows;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import serien.TestComponents.BaseTest;

public class HRprogressReport extends BaseTest{
	
	@Test(dataProvider = "getdata", priority = 1)
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
	
	@Test(dataProvider = "getdata", priority = 2)
	public void ValidatingEnrolledMicroLearningNameShouldDisplayInHRprogressReportPage (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));
		ProgressReport pr= new ProgressReport(driver);
		pr.ProgresReport();
		ArrayList<String> nameOfMicroLearning = pr.getMicroLearningNameInReport();
		System.out.println(nameOfMicroLearning);
		Boolean microLearningMatch=nameOfMicroLearning.contains(input.get("MicroLearningCourses"));
		Assert.assertTrue(microLearningMatch);		
	}
	
	@Test(dataProvider = "getdata", priority = 3)
	public void ValidatingEnrolledGameNameShouldDisplayInHRprogressReportPage (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));
		ProgressReport pr= new ProgressReport(driver);
		pr.ProgresReport();
		ArrayList<String> nameOfGames = pr.getGameNameInReport();
		System.out.println(nameOfGames);
		Boolean gameMatch=nameOfGames.contains(input.get("Gamesname"));
		Assert.assertTrue(gameMatch);		
	}
	
	@Test(dataProvider = "getdata", priority = 4)
	public void ValidatingContsInreport  (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));
		Thread.sleep(5000);
		ProgressReport pr= new ProgressReport(driver);
		pr.ProgresReport();
		// Below code is Dynamic for all the type of Courses, Micro Learning, Games you need to pass the name only
		ArrayList<String> Count =pr.getAllCountsInProgressReport(input.get("anyCourseName"));
		System.out.println(Count);
		int countTotalnoofemployees =Integer.parseInt(Count.get(0));
		int countEmployeesCompletedCourse =Integer.parseInt(Count.get(1));
		int countEmployeesNotCompletedCourse =Integer.parseInt(Count.get(2));
		System.out.println(countTotalnoofemployees);
		System.out.println(countEmployeesCompletedCourse);
		System.out.println(countEmployeesNotCompletedCourse);
			
	}
	
	@Test(dataProvider = "getdata", priority = 5)
	public void ValidatingSearchBarByEmployeeNameAndEmployeeEmail (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));
		Thread.sleep(5000);
		ProgressReport pr= new ProgressReport(driver);
		pr.ProgresReport();
		pr.enterningToCourses(input.get("anyCourseName"));
		Boolean emailValidation=pr.validatonOfSearchBarWithEmail(input.get("Useremail"), input.get("userName"));
		Assert.assertTrue(emailValidation);
		Boolean nameValidation=pr.validatonOfSearchBarWithUserName(input.get("userName"));
		Assert.assertTrue(nameValidation);
		
			
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
		map.put("CourseName", "Omkar test"); 
	//	map.put("CourseName", "Prevention of sexual harassment in the workplace – Hindi"); 
		map.put("GroupName", "Sitero_PoSH_2023");
		map.put("dueDate", "12122024");
		map.put("MicroLearningCourses", "Affinity bias");
		map.put("Gamesname", "Omkar test");
		map.put("ExpDiscilemrAlertMeg", "Please Acknowledge Disclaimer First !");
		map.put("anyCourseName", "Omkar test"); 
		map.put("userName", "omkar123456"); 
		
		return new Object[][] {{map}};
	}
}
