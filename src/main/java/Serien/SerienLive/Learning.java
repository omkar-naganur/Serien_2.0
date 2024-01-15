package Serien.SerienLive;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	//get List Of Elements
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-9t70b9']/p")
	List<WebElement> getAllCoursesName;
	
	@FindBy(xpath = "//div[contains(@class, 'microlerningdiscription')]")
	List<WebElement> getMicroLearningNames;
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-1en0sct']//div")
	List<WebElement> gamesNames;
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-122xxno']//div[1]")
	List<WebElement> getallgamesNames;
	
	//*************************************
	//Courses OverView Page
	
	@FindBy(xpath = "//div[@role='alert']//div[2]")
	WebElement actDisclimerAlert;
	
	@FindBy(xpath = "//li[3]//div[1]//div[1]")
	WebElement learning;
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-1bvc4cc']/button")
	WebElement AcknowledgeButton;
	
	//Courses Elements
	
	@FindBy(xpath = "//button[@type='button']")
	WebElement startCourses;
	
	@FindBy(xpath = "//button[@type='button']")
	List<WebElement> startCoursesList;
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-ckyhk3']")
	List<WebElement> continueMicroLearning;
	
	@FindBy(xpath = "(//div[@class='css-fk1ch0']//div)[1]")
	WebElement coursesTitle;
	
	@FindBy(xpath = "(//div[@class='css-fk1ch0']//div)[2]")
	WebElement coursesDescriptiuon;
	
	@FindBy(xpath = "(//div[@class='css-fk1ch0']//div)[3]//div[2]")
	WebElement CoursesComProgression;
	
	@FindBy(xpath = "//div[@class='css-fk1ch0']//button")
	WebElement start;
	
	@FindBy(xpath = "(//div[@class='MuiBox-root css-gg4vpm']/p)[2]")
	WebElement insideCoursesProgress;
	
	@FindBy(xpath = "(//div[@class='MuiBox-root css-gg4vpm']/p)[1]")
	WebElement insideProgressOFMicroLearningAndGame;
	
	@FindBy(xpath = "(//div[@class='MuiBox-root css-12orj8g'])[1]")
	WebElement coursesForwordButton;
	
	@FindBy(xpath = "(//div[@class='MuiBox-root css-12orj8g'])[2]")
	WebElement coursesBackwordButton;
	
	
	//*************************************************
	
	// Scrom Elements
	
	@FindBy(id = "testdomel")
	WebElement iframeScrom;
	
	@FindBy(id = "courseFrame")
	WebElement courseFrame;
	
	//***********************************
	
	//courseFrame
	
	@FindBy(xpath = "(//div[@class='message-box-buttons-panel__buttons'])//button[1]")
	WebElement resumeYes;
	
	@FindBy(xpath = "(//div[@class='message-box-buttons-panel__buttons'])//button[2]")
	WebElement resumeNo;
	
	//****************************
	
	// iframe for videos
	@FindBy(xpath = "//iframe[@title]")
	WebElement iframeVideo;
	
	@FindBy(xpath = "//div[@class='TinyProgressBar_module_tinyBar__f8a567ff']")
	WebElement PlayOrPuseButton;
	
	//*************************************
	
	//Quiz 
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-1q2yoq2']//p")
	List<WebElement> getallOpetioninQuiz;
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-yuob64']//button")
	WebElement quizSubmitButton;
	
	@FindBy(xpath = "//div[@class='quiziEnd-heading']")
	WebElement quizSucessMeg;
	
	@FindBy(xpath = "//div[@class='quiziEnd-heading']/../..//button")
	WebElement quizSucessContinue;
	//**************************************
	
	//Certificate section
	
	@FindBy(xpath = "(//div[@class='node-container']//img)[2]")
	WebElement certificateDownloadButton;

	
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
		if(!FlageCourseFound) {
		
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
		}
		
		return FlageCourseFound ;
		
	}

	public String getDisclimerAlertMessage() throws Throwable {
		waitForWebElementTOApper(actDisclimerAlert);
		String actAler = actDisclimerAlert.getText();
		System.out.println(actAler);
		return actAler;
	}

	public void AccepectingAcknowledge() throws Throwable {
		
		try {
			
			waitForWebElementTOApper(AcknowledgeButton);
			AcknowledgeButton.click();	
			Thread.sleep(2000);
		
		} catch (Exception e) {
			Thread.sleep(1000);
			System.out.println("AcknowledgeButton not availabe");
		}
		
	}

	public Boolean coursesAceesProgressReading() {
		waitForWebElementTOApper(insideCoursesProgress);
	String	actProgress= insideCoursesProgress.getText();
	Boolean proMatch= actProgress.contains("0");
	return proMatch;
		
	}
	
	public Boolean MicroLearningAndGameAceesProgressReading() {
		waitForWebElementTOApper(insideProgressOFMicroLearningAndGame);
	String	actProgress= insideProgressOFMicroLearningAndGame.getText();
	Boolean proMatch= actProgress.contains("0");
	return proMatch;
		
	}

	public Boolean OpenTheMicroLearning (String microLearning) {
		Boolean FlageCourseFound = false;
				waitForWebElementTOApper(microLearningViewall);
				microLearningViewall.click();
				waitForWebElementTOApper(getMicroLearningNames);
			//	Thread.sleep(2000);
				
				for(int j=0; j< getMicroLearningNames.size(); j++)
				{
					String actCoursesName = getMicroLearningNames.get(j).getText();
					
					if (actCoursesName.equals(microLearning))
					{	
						System.out.println("Courses Found in view all section= "+actCoursesName);
						continueMicroLearning.get(j).click();
						FlageCourseFound = true ;
						break ;
					}
					else {
						 System.out.println("Courses not found in view all section");
						 FlageCourseFound = false ;
						 }
				}
				return FlageCourseFound ;
			}
	
	public Boolean OpenTheGame (String gameName) throws Throwable {
	    Boolean flagCourseFound = false;
	    waitForWebElementTOApper(gamesNames);

//	    for (WebElement game : gamesNames) {
//	        String courseName = game.getText();
//	        if (courseName.equals(gameName)) {
//	            System.out.println("Course Found: " + courseName);
//	            game.click();
//	            flagCourseFound = true;
//	            break;
//	        }
//	    }

	    if (!flagCourseFound) {
	        waitForWebElementTOApper(gameViewall);
	        gameViewall.click();
	        waitForWebElementTOApper(getallgamesNames);

	        for (WebElement allGame : getallgamesNames) {
	            String actCoursesName = allGame.getText();
	            if (actCoursesName.equals(gameName)) {
	                System.out.println("Course Found in View All section: " + actCoursesName);
	                allGame.click();
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

	public void coursesVideoAttend() throws Throwable {
		Thread.sleep(3000);
		driver.switchTo().frame(iframeVideo);
		Thread.sleep(3000);
		PlayOrPuseButton.click();
		driver.switchTo().defaultContent();
		Thread.sleep(10000);
		Boolean videoIteam= false;
	
		while (!videoIteam)
		{
		
		coursesBackwordButton.click();
			
				try {
					
					Thread.sleep(3000);
					System.out.println("start try");
					alertAccepectMethod();
					System.out.println("try");
					Thread.sleep(30000);
					
					
				} catch (Exception e) {
					videoIteam= true;
					System.out.println("catch");
				}
				System.out.println(videoIteam);	
		}
				
	}
	
	public Boolean coursesQuizWith2Question(String ans1, String ans2) throws Throwable {
		Boolean quizStatus= false;
		Thread.sleep(3000);
		
		for(int i=0; i<getallOpetioninQuiz.size(); i++)
		{
		String opect = getallOpetioninQuiz.get(i).getText();
		System.out.println("ANS 1."+opect);
			if(opect.equals(ans1))
			{
				getallOpetioninQuiz.get(i).click();
				System.out.println("clicked");
				Thread.sleep(2000);
				quizSubmitButton.click();
			}
		}
		
		
		for(int i=0; i<getallOpetioninQuiz.size(); i++)
		{
		String opect = getallOpetioninQuiz.get(i).getText();
		System.out.println("ANS 2. "+opect);
			if(opect.equals(ans2))
			{
				getallOpetioninQuiz.get(i).click();
				System.out.println("clicked");
				Thread.sleep(2000);
				quizSubmitButton.click();
			}
		}
		Thread.sleep(3000);
		
		String succMeg=quizSucessMeg.getText();
		
		if(succMeg.equals("Quiz completed successfully!"))
		{
			quizSucessContinue.click();
			quizStatus= true;
		}
		else {
			System.out.println(succMeg);
			quizStatus= false;
			
		}
		
		return quizStatus;
		
		
				
	}

	public Boolean coursesQuizWith1Question(String ans) throws Throwable {
		Boolean quizStatus= false;
		Thread.sleep(3000);
		
		for(int i=0; i<getallOpetioninQuiz.size(); i++)
		{
		String opect = getallOpetioninQuiz.get(i).getText();
		System.out.println("ANS 1. "+opect);
			if(opect.contains(ans))
			{
				getallOpetioninQuiz.get(i).click();
				System.out.println("clicked");
				Thread.sleep(2000);
				quizSubmitButton.click();
			}
		}
Thread.sleep(3000);
		
		String succMeg=quizSucessMeg.getText();
		
		if(succMeg.equals("Quiz completed successfully!"))
		{
			quizSucessContinue.click();
			quizStatus= true;
		}
		else {
			System.out.println(succMeg);
			quizStatus= false;
			
		}
		
		return quizStatus;
	}
	
	public void certificateValidation () throws Throwable
	{
		waitForWebElementTOApper(certificateDownloadButton);
		certificateDownloadButton.click();
		 String currentHandle= driver.getWindowHandle();
		
		 Set<String> handles=driver.getWindowHandles();
	        for(String actual: handles)
	        {
	          
	         if(!actual.equalsIgnoreCase(currentHandle))
	         {
	             //switching to the opened tab
	             driver.switchTo().window(actual);
	         }
	        }
	}
	
		

}

