package Serien.SerienLive;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import serien.TestComponents.BaseTest;

public class HRlearning extends BaseTest{
	
	// Before run this class make Disclimer flase for the user "wisepot510@newnime.com"
	
	@Test(dataProvider = "getdata", priority = 1)
	public void ValidationOfDisclimerErrorMesg (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));
		Learning lr= new Learning(driver);
		lr.OpenTheCourses(input.get("CourseName"));
		lr.coursesStart();
		String actAlertMeg= lr.getDisclimerAlertMessage();
		Boolean alertMatch= actAlertMeg.equals(input.get("ExpDiscilemrAlertMeg"));
		Assert.assertTrue(alertMatch);
			
	}
	
	@Test(dataProvider = "getdata", priority = 2)
	public void ValidationOfDisclimerAccepectingAcknowledgeAndStartTheCourses (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));
		Learning lr= new Learning(driver);
		lr.OpenTheCourses(input.get("CourseName"));
		lr.AccepectingAcknowledge();
		lr.coursesStart();
		Boolean coursesStarted =lr.coursesAceesProgressReading();
		Assert.assertTrue(coursesStarted);
	}
	
	@Test(dataProvider = "getdataMicroLearning", priority = 3)
	public void ValidationOfDisclimerAccepectingAcknowledgeAndStartMicroLearning (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));
		Learning lr= new Learning(driver);
		lr.OpenTheMicroLearning(input.get("CourseName"));
		lr.AccepectingAcknowledge();
		lr.coursesStart();
		Boolean coursesStarted =lr.MicroLearningAndGameAceesProgressReading();
		Assert.assertTrue(coursesStarted);
	}
	
	@Test(dataProvider = "getdataGame", priority = 4)
	public void ValidationOfDisclimerAccepectingAcknowledgeAndStartGame (HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));
		Learning lr= new Learning(driver);
		lr.OpenTheGame(input.get("CourseName"));
		lr.AccepectingAcknowledge();
		lr.coursesStart();
		Boolean coursesStarted =lr.MicroLearningAndGameAceesProgressReading();
		Assert.assertTrue(coursesStarted);
	}
	
	@DataProvider
	public Object[][] getdata() throws Throwable
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//serien//Data//HRlearning.json");
		return new Object[][]  { {data.get(0)} };
	}
	
	@DataProvider
	public Object[][] getdataMicroLearning() throws Throwable
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//serien//Data//HRlearning.json");
		return new Object[][]  { {data.get(1)} };
	}
	
	@DataProvider
	public Object[][] getdataGame() throws Throwable
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//serien//Data//HRlearning.json");
		return new Object[][]  { {data.get(2)} };
	}
}
