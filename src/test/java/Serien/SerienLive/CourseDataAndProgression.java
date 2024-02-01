package Serien.SerienLive;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import serien.TestComponents.BaseTest;

public class CourseDataAndProgression extends BaseTest {
	
	// this class for only trailes purpose not need to run in regression 
	
	@Test(dataProvider = "getdata2")
	public void ValidationCourse(HashMap<String, String> input) throws Throwable
	{
		LoginPage Dm= new LoginPage(driver);
		Dm.serienLogin(input.get("Useremail"), input.get("userpass"));
		Learning ler=new Learning(driver);
		//get courses name courses name is equle to "Safety and inclusion at the workplace" 
		//then click on start courses button other wise click on view all button
	
		String ActCourse =driver.findElement(By.xpath("//div[@class='MuiBox-root css-0']//div[@class='zoomtwo courseNameAnd_Enroll_box MuiBox-root css-0']")).getText();
		String expCourse = "Safety and inclusion at the workplace"; 
		
		System.out.println(ActCourse);
	
		if(ActCourse.equals(expCourse))
		{
			ler.clickOnStartCourses();
		}
		else 
		{
//			Courses viewall button	
		driver.findElement(By.xpath("//div[@class='MuiBox-root css-0']//div[@class='sectionnameall MuiBox-root css-1fgpa29']")).click();	
		}
		
		List<WebElement> coursesName = driver.findElements(By.xpath("//p[contains(text(),'')]"));
		//waitForWebElementTOApper(coursesName);
		List<WebElement> countinue = driver.findElements(By.xpath("//div[@class='MuiBox-root css-bktdhr']//button"));
		//waitForWebElementTOApper(countinue);
		
		for(int i = 0;i<coursesName.size();i++){
			System.out.println(coursesName.get(i).getText());
		}
		System.out.println("Total number of Courses = " + coursesName.size());
		
		for(int i = 0;i<coursesName.size();i++){
			String cn=coursesName.get(i).getText();			
			if(cn.equals(expCourse))
			{
				countinue.get(i).click();	
				break;
			}
		}
		
		ler.coursesStart();
		//above method not woking that wy i right this line
		Actions actions=new Actions(driver);
		WebElement start= driver.findElement(By.xpath("//div[@class='css-fk1ch0']//button"));
		Thread.sleep(2000);
		actions.click(start).perform();
		
		// get module s name
		Thread.sleep(2000);
		
		// List<WebElement> moduleName = driver.findElements(By.id("//div[@class='MuiBox-root css-i7dvqn']//p[@class='MuiTypography-root MuiTypography-body1 css-ukixra']"));
		List<WebElement> moduleName = driver.findElements(By.id("//div[@class='MuiBox-root css-0']/button"));
	//    //div[@class='MuiBox-root css-0']/button
		for(int i = 0;i<moduleName.size();i++){
			Actions actions2=new Actions(driver);
			WebElement test = moduleName.get(i);
			Thread.sleep(2000);
			actions.click(test).perform();
			
			
			moduleName.get(i).click();
			System.out.println(moduleName.get(i).getText());
		}
		
		// need to change the courses then start the test
		//modules name
	//	 //p[@class='MuiTypography-root MuiTypography-body1 css-ukixra']
	
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
// git changes test  
}
