package Serien.SerienLive;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import serien.TestComponents.BaseTest;

public class HRprogressReport extends BaseTest{
	
	@Test(dataProvider = "getdata", priority = 1)
	public void ValidationOfDisclimerErrorMesg (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));
		ProgressReport pr= new ProgressReport(driver);
		pr.ProgresReport();
		ArrayList<String> nameOfCourses = pr.getCoursesNameInReport();
		System.out.println(nameOfCourses);
		Boolean coursesMatch=nameOfCourses.contains(input.get("CourseName"));
		Assert.assertTrue(coursesMatch);
		
	
			
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
		map.put("CourseName", "Safety and inclusion at the workplace"); 
	//	map.put("CourseName", "Prevention of sexual harassment in the workplace – Hindi"); 
		map.put("GroupName", "Sitero_PoSH_2023");
		map.put("dueDate", "12122024");
		map.put("MicroLearningCourses", "Affinity bias");
		map.put("Gamesname", "Omkar test");
		map.put("ExpDiscilemrAlertMeg", "Please Acknowledge Disclaimer First !");
		
		return new Object[][] {{map}};
	}
}
