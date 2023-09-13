package Serien.SerienLive;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import serien.TestComponents.BaseTest;

public class CourseDataAndProgression extends BaseTest {
	
	@Test(dataProvider = "getdata2")
	public void ValidationCourse(HashMap<String, String> input) throws Throwable
	{
		LoginPage Dm= new LoginPage(driver);
		Dm.serienLogin(input.get("Useremail"), input.get("userpass"));
		Learning ler=new Learning(driver);
		ler.clickOnStartCourses();
		ler.getCoursesDetails();
		ler.coursesStart();
		// need to change the courses then start the test
	}

	@DataProvider
	public Object[][] getdata2()
	{
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("Useremail", "omkar@krishworks.com");
		//map.put("Useremail", "subhajit@krishworks.com");
		map.put("userpass", "password");
		return new Object[][] {{map}};
	}

}
