package Serien.SerienLive;

import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Serien.AbstractComponents.abstractReusable;

public class ProgressReport extends abstractReusable{

	WebDriver driver;
	public ProgressReport(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-1hpv8xz']//div[1]//div[1]")
	WebElement subText;
	
	@FindBy(xpath = "(//div[@class='MuiBox-root css-1ys9fue'])[1]")
	WebElement UserStartDate;
	
	@FindBy(xpath = "(//div[@class='MuiBox-root css-1ys9fue'])[2]")
	WebElement UserEndDate;
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-n4ie87']//div[@class='MuiBox-root css-13o8bqy']")
	List<WebElement> courseNames;
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-13o8bqy']")
	List<WebElement> courseNamesListInReport;
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-j4kjxm']")
	List<WebElement> MicroLearningListInReport;
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-5hqcx']")
	List<WebElement> GameNameListInReport;
	
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-n4ie87']//div[@class='MuiBox-root css-13o8bqy']/..//div[@class='MuiBox-root css-evh4dy']")
	WebElement exter;
	
	public ArrayList<String> SubscriptioDeatilsfromUser () throws Throwable
	{
		String subName=subText.getText();
		String actUserStartDate=UserStartDate.getText();
		String actUserEndDate=UserEndDate.getText();
		ArrayList<String> UserProgressReportSubData = new ArrayList<String>();
		UserProgressReportSubData.add(actUserStartDate);
		UserProgressReportSubData.add(actUserEndDate);
		return UserProgressReportSubData;
		
	}
	
	public ArrayList<String> getCoursesNameInReport() throws Throwable {
		Thread.sleep(1000);
		waitForWebElementTOApper(courseNamesListInReport);
		ArrayList<String> nameOfCourses = new ArrayList<String>();
		for(int i=0; i<courseNamesListInReport.size(); i++)
		{
			String coursesName=courseNamesListInReport.get(i).getText();
			nameOfCourses.add(coursesName);
		}
		return nameOfCourses;
	}
	
	public ArrayList<String> getMicroLearningNameInReport() throws Throwable {
		Thread.sleep(1000);
		waitForWebElementTOApper(MicroLearningListInReport);
		ArrayList<String> nameOfMicro = new ArrayList<String>();
		for(int i=0; i<MicroLearningListInReport.size(); i++)
		{
			String nameOfMicroLearning=MicroLearningListInReport.get(i).getText();
			nameOfMicro.add(nameOfMicroLearning);
		}
		return nameOfMicro;
	}
	
	public ArrayList<String> getGameNameInReport() throws Throwable {
		Thread.sleep(1000);
		waitForWebElementTOApper(GameNameListInReport);
		ArrayList<String> nameOfGame = new ArrayList<String>();
		for(int i=0; i<GameNameListInReport.size(); i++)
		{
			String nameOfGames=GameNameListInReport.get(i).getText();
			nameOfGame.add(nameOfGames);
		}
		return nameOfGame;
	}
		
	public void normalCourseslist (String courseName)
	{
		for (WebElement element : courseNames) {
		    if (element.getText().equals(courseName)) {
		    	waitForWebElementTOApper(exter);
		     // WebElement insideButton=  element.findElement(By.xpath("/..//div[@class='MuiBox-root css-evh4dy']"));
		      WebElement insideButton=  element.findElement(By.xpath("/..//img"));
		      insideButton.click();
		        break; 
		    }
		}
		
		
	}
	
	
	
}

