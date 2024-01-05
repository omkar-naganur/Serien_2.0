package Serien.SerienLive;

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
		ae.selectCourseName(input.get(""));
		ae.selectGroupName(input.get(""));
		
		
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
		map.put("CourseName", "");
		map.put("GroupName", "");
		
		
		return new Object[][] {{map}};
	}
}