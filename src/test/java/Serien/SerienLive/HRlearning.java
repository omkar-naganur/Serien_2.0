package Serien.SerienLive;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import serien.TestComponents.BaseTest;

public class HRlearning extends BaseTest{
	
	// Before run this class make Disclimer flase for the user "wisepot510@newnime.com"
	
	ArrayList<String> coursesNames = new ArrayList<>();
	
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
		coursesNames.add(input.get("CourseName"));
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
		coursesNames.add(input.get("CourseName"));
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
		coursesNames.add(input.get("CourseName"));
	}
	
	@Test(dataProvider = "getdataGame", priority = 5)
	public void DeleteUserProgressForMakeDisclimerTrue (HashMap<String, String> input) throws Throwable
	{	
		LoginPage.serienLogin(input.get("adminEmail"), input.get("adminPass"));
		AdminUser au= new AdminUser(driver);
		au.users();
		au.searchByEmail(input.get("Useremail"));
		Thread.sleep(3000);
		au.clickOnViewButton();
		Thread.sleep(3000);
		for(int i=0; i<coursesNames.size(); i++) {
			au.deleteProgress(coursesNames.get(i));
			Thread.sleep(3000);
		}
		
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
