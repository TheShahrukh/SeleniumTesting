import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/*I have added Comments with each piece of Code so your better Understanding*/
/*Please give FeedBack on shane.buriro@gmail.com* (Shahrukh Bashir)/
/*You can run each scenario with -- Right Click - Run as JavaApplication*/

public class ScenarioFive {

	public static void main(String[] args) throws InterruptedException {
		
		
		//Setting up chromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shane\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		//Implicitly Declaring TimeOut so that script doesnot Break if the webElement is not loaded yet.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		driver.get("https://automation-test.v6.nadeem.tv/");
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
		
		//finding New Video Upload Button (+)
		driver.findElement(By.xpath("//i[@class='fas fa-plus fa-stack-1x fa-inverse']")).click();
		Thread.sleep(2000);
		
		//•	Navigate to upload media screen
		driver.findElement(By.xpath("//i[@class='fas fa-upload fa-5x']")).click();
		Thread.sleep(2000);
		
		//Uploading Video
		driver.findElement(By.xpath("//input[@data-e2e-input='uploadCtrl']")).sendKeys("C:\\Users\\shane\\Downloads\\testingvideotwo.mp4");
		//Save and Close
		driver.findElement(By.xpath("//button[@data-e2e-btn='SaveAndClose']")).click();
		Thread.sleep(2000);
		
		//Tracking Workflow
		//Clicked SideBar
		driver.findElement(By.xpath("//i[@class='fas fa-bars']")).click();
		Thread.sleep(2000);
		//navigated Control Pannel
		driver.findElement(By.xpath("//a[contains(text(),'Control Panel')]")).click();
		Thread.sleep(2000);
		//Navigated to Workflow
		driver.findElement(By.xpath("//a[contains(text(),'Workflows')]")).click();
		Thread.sleep(2000);
		
		//Navigated to Search bar and search query = testingvideoTwo (Which I uplaoded first)
		driver.findElement(By.xpath("//input[@id='top-search']")).sendKeys("testingvideotwo");
		driver.findElement(By.xpath("//button[@class='btn btn-default m-t-xs']")).click();
		Thread.sleep(2000);
		
		//Navigated to my video
		driver.findElement(By.xpath("//a[@title='testingvideotwo']")).click();
		Thread.sleep(15000);
		
		//Finally Logout
		driver.findElement(By.xpath("//span[contains(text(),'Automation Tester')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
		
		
		Thread.sleep(5000);
		driver.close();
		
		

	}
}
