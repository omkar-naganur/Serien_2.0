package Serien.SerienLive;

import org.testng.annotations.Test;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import serien.TestComponents.BaseTest;

public class HRCoursesComplation extends BaseTest{
	
	@Test(dataProvider = "getdata", priority = 1)
	public void ValidationOfCoursesAttend (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));
		Learning lr= new Learning(driver);	
		lr.OpenTheCourses(input.get("CourseName"));
	//	lr.AccepectingAcknowledge();
		lr.coursesStart();
//		lr.coursesVideoAttend();
//		Boolean quizStatus=lr.coursesQuizWith2Question(input.get("quiz1Ans1"), input.get("quiz1Ans2"));
//		Assert.assertTrue(quizStatus);
		lr.coursesVideoAttend();
		lr.PDFComplation();
		Boolean quizStatus1=lr.coursesQuizWith1Question(input.get("quiz2Ans1"));
		Assert.assertTrue(quizStatus1);
		
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("Useremail", "omkar@krishworks.com");
		map.put("userpass", "password");
		map.put("adminEmail", "admin@demo.com");
		map.put("adminPass", "pass2023");
		map.put("CourseName", "automatiom Test Training");
		//write answers
		map.put("quiz1Ans1", "Priya can reach out to both her company’s IC or the client's IC based on her comfort.");
		map.put("quiz1Ans2", "Three colleagues go to a cafe for a weekend brunch. One of them is verbally harassed by the staff of the restaurant.");
		map.put("quiz2Ans1", "The impact of Gaurav’s behaviour on Nisha is certainly more relevant here.");
		//worng answers       
	//	map.put("quizAns1", "Priya must only reach out to her company’s IC for any complaint against her colleague Ravi and the client’s IC for complaint against John.");
	//	map.put("quizAns2", "A client requesting for sexual favours over a video call in exchange for their buy-in.");
		
		return new Object[][] {{map}};
	}
}
