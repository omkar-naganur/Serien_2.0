package Serien.SerienLive;

import org.testng.annotations.Test;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import serien.TestComponents.BaseTest;

public class HRCoursesComplation extends BaseTest{
	
	@Test(dataProvider = "getdata", priority = 1)
	public void ValidationOfDisclimerErrorMesg (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));
		Learning lr= new Learning(driver);
		lr.OpenTheCourses(input.get("CourseName"));
		lr.AccepectingAcknowledge();
		lr.coursesStart();
		lr.coursesVideoAttend();
		Boolean quizStatus=lr.coursesQuizAttend(input.get("quizAns1"), input.get("quizAns2"));
		Assert.assertTrue(quizStatus);
		lr.coursesVideoAttend();
		
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("Useremail", "omkar@krishworks.com");
		map.put("userpass", "password");
		map.put("adminEmail", "admin@demo.com");
		map.put("adminPass", "pass2023");
		//write answers
		map.put("quizAns1", "Priya can reach out to both her company’s IC or the client's IC based on her comfort.");
		map.put("quizAns2", "Three colleagues go to a cafe for a weekend brunch. One of them is verbally harassed by the staff of the restaurant.");
		//worng answers
	//	map.put("quizAns1", "Priya must only reach out to her company’s IC for any complaint against her colleague Ravi and the client’s IC for complaint against John.");
	//	map.put("quizAns2", "A client requesting for sexual favours over a video call in exchange for their buy-in.");
		
		return new Object[][] {{map}};
	}
}
