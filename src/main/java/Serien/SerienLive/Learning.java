package Serien.SerienLive;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Serien.AbstractComponents.abstractReusable;

public class Learning extends abstractReusable{

	WebDriver driver;
	public Learning(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//div[@class='sectionname MuiBox-root css-1isemmb'])[1]")
	WebElement coursesAcees;
	
	@FindBy(xpath = "(//div[@class='sectionname MuiBox-root css-1isemmb'])[2]")
	WebElement MicroLearnings;
	
	@FindBy(xpath = "(//div[@class='sectionname MuiBox-root css-1isemmb'])[3]")
	WebElement Webinars;
	
	@FindBy(xpath = "(//div[@class='sectionname MuiBox-root css-1isemmb'])[4]")
	WebElement Games;
	
	@FindBy(xpath = "//div[contains(@class, \"zoomtwo\")]/p")
	WebElement learningPageCoursesName;
	
	//List OF view all buttons
	
	@FindBy(xpath = "//div[contains(text(),'Courses')]/..//div[4]")
	WebElement coursesViewall;
	
	@FindBy(xpath = "//div[contains(text(),'Micro-learnings')]/..//div[4]")
	WebElement microLearningViewall;
	
	@FindBy(xpath = "//div[contains(text(),'Webinars')]/..//div[4]")
	WebElement WebinarsViewall;
	
	@FindBy(xpath = "//div[contains(text(),'Games')]/..//div[4]")
	WebElement gameViewall;
	
	//**********************************
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-9t70b9']/p")
	List<WebElement> getAllCoursesName;
	
	@FindBy(xpath = "//div[contains(@class, 'microlerningdiscription')]")
	List<WebElement> getMicroLearningNames;
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-1en0sct']//div")
	List<WebElement> gamesNames;
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-122xxno']//div[1]")
	List<WebElement> getallgamesNames;
	
	
	
	
	@FindBy(xpath = "//li[3]//div[1]//div[1]")
	WebElement learning;
	
	//Courses Elements
	
	@FindBy(xpath = "//button[@type='button']")
	WebElement startCourses;
	
	@FindBy(xpath = "//button[@type='button']")
	List<WebElement> startCoursesList;
	
	@FindBy(xpath = "(//div[@class='css-fk1ch0']//div)[1]")
	WebElement coursesTitle;
	
	@FindBy(xpath = "(//div[@class='css-fk1ch0']//div)[2]")
	WebElement coursesDescriptiuon;
	
	@FindBy(xpath = "(//div[@class='css-fk1ch0']//div)[3]//div[2]")
	WebElement CoursesComProgression;
	
	//@FindBy(xpath = "(//button[@type='button'])[2]")
	//WebElement start;
	
	@FindBy(xpath = "//div[@class='css-fk1ch0']//button")
	WebElement start;
	
	//div[@class='css-fk1ch0']//button
	
	// Scrom Elements
	
	@FindBy(id = "testdomel")
	WebElement iframeScrom;
	
	@FindBy(id = "courseFrame")
	WebElement courseFrame;
	
	//courseFrame
	
	@FindBy(xpath = "(//div[@class='message-box-buttons-panel__buttons'])//button[1]")
	WebElement resumeYes;
	
	@FindBy(xpath = "(//div[@class='message-box-buttons-panel__buttons'])//button[2]")
	WebElement resumeNo;
	
	
	
	public void scromCourseResume ()
	{
		waitForWebElementTOApper(iframeScrom);
		driver.switchTo().frame(iframeScrom);
		waitForWebElementTOApper(courseFrame);
		driver.switchTo().frame(courseFrame);
		waitForWebElementTOApper(resumeYes);
		waitForWebElementTOApper(resumeNo);
		resumeYes.click();
		driver.switchTo().defaultContent();
	}
	
	public void coursesPopup()
	{
		String SubAlertPoup=driver.switchTo().alert().getText();
		System.out.println(SubAlertPoup);
		driver.switchTo().alert().accept();
	}

	public ArrayList<String> learningPagePermissionsget()
	{
		waitForWebElementTOApper(MicroLearnings);
		String coursesActualPermission= coursesAcees.getText();
		String MicroLearningsActualPermission= MicroLearnings.getText();
		String WebinarsActualPermission= Webinars.getText();
		String GamesActualPermission= Games.getText();
		ArrayList<String> actualPermissionArryList = new ArrayList<String>();
		actualPermissionArryList.add(coursesActualPermission);
		actualPermissionArryList.add(MicroLearningsActualPermission);
		actualPermissionArryList.add(WebinarsActualPermission);
		actualPermissionArryList.add(GamesActualPermission);
		return actualPermissionArryList;
	}
		
	public void clickOnStartCourses ()
	{
		waitForWebElementTOApper(startCourses);
		startCourses.click();
	}
	
	public String getCoursesDetails() {
		waitForWebElementTOApper(coursesTitle);
		waitForWebElementTOApper(coursesDescriptiuon);
		waitForWebElementTOApper(CoursesComProgression);
		String ct=coursesTitle.getText();
		String cd=coursesDescriptiuon.getText();
		String ccp=CoursesComProgression.getText();
		System.out.println(ct);
		System.out.println(cd);
		System.out.println(ccp);
		return ct;
	}
	
	public void coursesStart() {
		waitForWebElementTOApper(start);
		start.click();
		
	}
	
	public Boolean CoursesNameValidationFromHRPanle (String CoursesName) throws Throwable  {
		waitForWebElementTOApper(learningPageCoursesName);
		String sampleCoursesName =learningPageCoursesName.getText();
		
		Boolean FlageCourseFound =false ;
		
		if(sampleCoursesName.equals(CoursesName)) {
			System.out.println("Courses Found = "+sampleCoursesName);
			FlageCourseFound = true ;
		}
		else {
			waitForWebElementTOApper(coursesViewall);
			coursesViewall.click();
			waitForWebElementTOApper(getAllCoursesName);
		//	Thread.sleep(2000);
			
			for(int i=0; i< getAllCoursesName.size(); i++)
			{
				String actCoursesName = getAllCoursesName.get(i).getText();
				
				if (actCoursesName.equals(CoursesName))
				{	
					System.out.println("Courses Found in view all section= "+actCoursesName);
					FlageCourseFound = true ;
				}
				else {
					 System.out.println("Courses not found in view all section");
					 FlageCourseFound = false ;
					 }
			}
		}
		
		return FlageCourseFound ;
		
	}
	
	public Boolean MicroLearningNameValidationFromHRPanle (String microLearning) throws Throwable  {
		Boolean FlageCourseFound =false ;
		waitForWebElementTOApper(getMicroLearningNames);
		
		ArrayList<String> lastArray = new ArrayList<String>() ;
		for (int i=0; i< getMicroLearningNames.size(); i++)
		{
			String mr =getMicroLearningNames.get(i).getText();
			lastArray.add(mr);
			
			if(mr.equals(microLearning)) {
				System.out.println("Courses Found = "+mr);
				FlageCourseFound = true ;
				break ;
			}
			else {
				waitForWebElementTOApper(microLearningViewall);
				microLearningViewall.click();
				waitForWebElementTOApper(getMicroLearningNames);
			//	Thread.sleep(2000);
				
				for(int j=0; i< getMicroLearningNames.size(); j++)
				{
					String actCoursesName = getMicroLearningNames.get(j).getText();
					
					if (actCoursesName.equals(microLearning))
					{	
						System.out.println("Courses Found in view all section= "+actCoursesName);
						FlageCourseFound = true ;
						break ;
					}
					else {
						 System.out.println("Courses not found in view all section");
						 FlageCourseFound = false ;
						 }
				}
			}
			break ;
		}	
		
		return FlageCourseFound ;
		
	}
	
	public Boolean gameNameValidationFromHRPanel(String gameName) throws Throwable {
	    Boolean flagCourseFound = false;
	    waitForWebElementTOApper(gamesNames);

	    for (WebElement game : gamesNames) {
	        String courseName = game.getText();
	        if (courseName.equals(gameName)) {
	            System.out.println("Course Found: " + courseName);
	            flagCourseFound = true;
	            break;
	        }
	    }

	    if (!flagCourseFound) {
	        waitForWebElementTOApper(gameViewall);
	        gameViewall.click();
	        waitForWebElementTOApper(getallgamesNames);

	        for (WebElement allGame : getallgamesNames) {
	            String actCoursesName = allGame.getText();
	            if (actCoursesName.equals(gameName)) {
	                System.out.println("Course Found in View All section: " + actCoursesName);
	                flagCourseFound = true;
	                break;
	            }
	        }
	    }

	    if (!flagCourseFound) {
	        System.out.println("Course not found in View All section");
	    }

	    return flagCourseFound;
	}
	
	public Boolean OpenTheCourses (String CoursesName) throws Throwable  {
		waitForWebElementTOApper(learningPageCoursesName);
		String sampleCoursesName =learningPageCoursesName.getText();
		
		Boolean FlageCourseFound =false ;
		
		if(sampleCoursesName.equals(CoursesName)) {
			System.out.println("Courses Found = "+sampleCoursesName);
			FlageCourseFound = true ;
			startCourses.click();
		}
		else {
			waitForWebElementTOApper(coursesViewall);
			coursesViewall.click();
			}
		
			waitForWebElementTOApper(getAllCoursesName);
		//	Thread.sleep(2000);
			
			for(int i=0; i< getAllCoursesName.size(); i++)
			{
				String actCoursesName = getAllCoursesName.get(i).getText();
				
				if (actCoursesName.equals(CoursesName))
				{	
					System.out.println("Courses Found in view all section= "+actCoursesName);
					FlageCourseFound = true ;
					startCoursesList.get(i).click();
				}
				
			}
		
		return FlageCourseFound ;
		
	}
		

}

