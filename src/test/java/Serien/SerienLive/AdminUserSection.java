package Serien.SerienLive;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import serien.TestComponents.BaseTest;

public class AdminUserSection extends BaseTest{

	
	@Test(dataProvider = "getdata", priority = 1)
	public void UserCoursesProgressReset (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("adminEmail"), input.get("adminPass"));
		AdminUser au= new AdminUser(driver);
		au.users();
		au.searchByEmail(input.get("Useremail"));
		Thread.sleep(3000);
		au.clickOnViewButton();
		au.deleteProgress(input.get("CourseName"));	
	}
	
	@Test(dataProvider = "getdata", priority = 2)
	public void UserCoursesDeatilsFeatch (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("adminEmail"), input.get("adminPass"));
		AdminUser au= new AdminUser(driver);
		au.users();
		au.searchByEmail(input.get("Useremail"));
		Thread.sleep(3000);
		au.clickOnViewButton();
		ArrayList<String> userCoursesDeatil = au.getUserdeatilsOfTheCourses(input.get("CourseName"));
		System.out.println(userCoursesDeatil.get(6));
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
		map.put("CourseName", "Descriptive & prescriptive stereotypes"); //Safety and inclusion at the workplace
		map.put("GroupName", "Sitero_PoSH_2023");
		map.put("dueDate", "12122024");
		map.put("MicroLearningCourses", "Confirmation bias");
		map.put("Gamesname", "Omkar test");
		
		return new Object[][] {{map}};
	}
}
