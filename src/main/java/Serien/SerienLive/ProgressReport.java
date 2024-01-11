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
	List<WebElement> courseNames1;
	////div[@class='MuiBox-root css-1vsn9zb']/div[@class='MuiBox-root css-1732m2u']/div[2]
	
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
		waitForWebElementTOApper(courseNames1);
		ArrayList<String> nameOfCourses = new ArrayList<String>();
		for(int i=0; i<courseNames1.size(); i++)
		{
			String coursesName=courseNames1.get(i).getText();
			//System.out.println(coursesName);
			nameOfCourses.add(coursesName);
		}
		return nameOfCourses;
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

