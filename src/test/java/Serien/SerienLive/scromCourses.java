package Serien.SerienLive;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import serien.TestComponents.BaseTest;

public class scromCourses extends BaseTest {
	
	// don't use this class 
	
	String CoursesTitle;
	@Test(dataProvider = "getdata3")
	public void ValidationScromCoursesStartDate(HashMap<String, String> input) throws Throwable
	{
		LoginPage Dm= new LoginPage(driver);
		Dm.serienLogin(input.get("Useremail"), input.get("userpass"));
		Learning ler=new Learning(driver);
		ler.clickOnStartCourses();
		String CoursesTitle=ler.getCoursesDetails();
		ler.coursesStart();
		ler.scromCourseResume();
		ler.ProgresReport();
		ler.coursesPopup();
		ProgressReport pr=new ProgressReport(driver);
		pr.normalCourseslist(CoursesTitle);
	}

	@DataProvider
	public Object[][] getdata3()
	{
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("Useremail", "omkar@krishworks.com"); //dev
		//map.put("Useremail", "subhajit@krishworks.com");  //Prod
		map.put("userpass", "password");
		return new Object[][] {{map}};
	}

}
