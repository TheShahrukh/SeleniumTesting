import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;


/*I have added Comments with each piece of Code so your better Understanding*/
/*Please give FeedBack on shane.buriro@gmail.com* (Shahrukh Bashir)/
/*You can run each scenario with -- Right Click - Run as JavaApplication*/ 

public class ScenarioFour {
	
	public static void main(String[] args) throws InterruptedException {
		//Setting up chromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shane\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		//Implicitly Declaring TimeOut so that script doesnot Break if the webElement is not loaded yet.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://automation-test.v6.nadeem.tv/");
		
		//Defined this ActionClass Varible for MouseHover Feature(Edit and Delete)
		Actions actions = new Actions(driver);
		
		
		//Waiting Unitl SignIn Button is visible
		WebDriverWait d = new WebDriverWait(driver, 4);
		d.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@class='ng-star-inserted']//span[@class='text-white'][contains(text(),'Sign In')]")));
		
		
		//SignIn Process (Locating and Input)
		WebElement SignInButton = driver.findElement(By.xpath("//li[@class='ng-star-inserted']//span[@class='text-white'][contains(text(),'Sign In')]"));
		SignInButton.click();
		driver.findElement(By.xpath("//input[@id='EmailAddress']")).sendKeys("automation-tester@sharklasers.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Tester123");
		driver.findElement(By.xpath("//button[@id='Signin']")).click();
		Thread.sleep(4000);
		
		//Searched Video
		driver.findElement(By.xpath("//input[@id='top-search']")).sendKeys("Video");
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='btn btn-default m-t-xs']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//a[@title='Video'])[1]")).click();
		Thread.sleep(5000);
		
		//Scrolled Down to Comments Section
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
		
        
        //Comment -- I found 2 with same xpath so, used [2], as it will consider the second one,
		WebElement Comment = driver.findElement(By.xpath("(//textarea[@name='newComment'])[2]"));
		Comment.click();
		Comment.sendKeys("Comment BY Shahrukh");
		
		//PostButon
		driver.findElement(By.xpath("//button[@data-e2e-btn='Post']")).click();
			
		//Mouse Moved Towards Comment so that Edit Element can be visible
		WebElement target = driver.findElement(By.cssSelector("body.md-skin.fixed-sidebar.fixed-nav.mini-navbar.skin.bg-muted:nth-child(2) app-layout.ng-star-inserted:nth-child(3) div.background-transition.gray-bg:nth-child(2) playback-page.ng-star-inserted:nth-child(4) div.row.wrapper.wrapper-content div.col-sm-12.white-box div.full-width-layout div.row div.col-sm-12.col-lg-8.col-xl-9.ng-star-inserted div.ibox.float-e-margins.ng-star-inserted:nth-child(2) div.ibox-content.no-padding.bg-muted div.ng-star-inserted div.row:nth-child(2) div.col-sm-12 div.social-footer.bg-muted:nth-child(2) div.social-comment.m-b-md.ng-star-inserted:nth-child(1) > div.media-body.ng-star-inserted"));
		actions.moveToElement(target).perform();
		
		//Comment Editing..
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='ibox float-e-margins ng-star-inserted']//a[@class='pull-right text-navy visibility-visible ng-star-inserted']//i[@class='fas fa-pencil-alt']")).click();
		
		//as thr were many comments, so [3] will pick up last commented by me. 
		driver.findElement(By.xpath("(//textarea[@name='newComment'])[3]")).click();
		driver.findElement(By.xpath("(//textarea[@name='newComment'])[3]")).clear();
		driver.findElement(By.xpath("(//textarea[@name='newComment'])[3]")).sendKeys("Comement Edited");
		driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary pull-right m-t-sm m-r-xs ng-star-inserted']")).click();
		
		
		//Mouse Moved Towards Comment so that it can be deleted by making it visible
		WebElement targetTwo = driver.findElement(By.cssSelector("driver.findElement(By.cssSelector(\"body.md-skin.fixed-sidebar.fixed-nav.mini-navbar.skin.bg-muted:nth-child(2) app-layout.ng-star-inserted:nth-child(3) div.background-transition.gray-bg:nth-child(2) playback-page.ng-star-inserted:nth-child(4) div.row.wrapper.wrapper-content div.col-sm-12.white-box div.full-width-layout div.row div.col-sm-12.col-lg-8.col-xl-9.ng-star-inserted div.ibox.float-e-margins.ng-star-inserted:nth-child(2) div.ibox-content.no-padding.bg-muted div.ng-star-inserted div.row:nth-child(2) div.col-sm-12 div.social-footer.bg-muted:nth-child(2) div.social-comment.m-b-md.ng-star-inserted:nth-child(1) > div.media-body.ng-star-inserted"));
		actions.moveToElement(targetTwo).perform();
		
		
		//Deletin Comment
		WebElement deleteCommentButton = driver.findElement(By.xpath("//div[@class='ibox float-e-margins ng-star-inserted']//a[@class='pull-right m-l-xs text-navy m-r-xs visibility-visible']//i[@class='fas fa-times']"));
		deleteCommentButton.click();
		Thread.sleep(5000);
		
		//Logout!
		driver.findElement(By.xpath("//span[contains(text(),'Automation Tester')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();

		driver.close();
		
	}	
}
