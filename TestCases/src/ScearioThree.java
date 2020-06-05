import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*I have added Comments with each piece of Code so your better Understanding*/
/*Please give FeedBack on shane.buriro@gmail.com* (Shahrukh Bashir)/
/*You can run each scenario with -- Right Click - Run as JavaApplication*/

public class ScearioThree {
	public static void main(String[] args) throws InterruptedException {
		
		//Setting up chromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shane\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Implicitly Declaring TimeOut so that script doesnot Break if the webElement is not loaded yet.
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.get("https://automation-test.v6.nadeem.tv/");
		
		
		//SignIN--Process (LoginCredentials/Locating WebElements--Etc)
		WebElement SignInButton = driver.findElement(By.xpath("//li[@class='ng-star-inserted']//span[@class='text-white'][contains(text(),'Sign In')]"));
		SignInButton.click();
		driver.findElement(By.xpath("//input[@id='EmailAddress']")).sendKeys("automation-tester@sharklasers.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Tester123");
		driver.findElement(By.xpath("//button[@id='Signin']")).click();
		Thread.sleep(3000);
		
		//SearchVideo with searchQuery "Video"
		driver.findElement(By.xpath("//input[@id='top-search']")).sendKeys("Video");
		driver.findElement(By.xpath("//button[@class='btn btn-default m-t-xs']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='top-search']")).clear();
		driver.findElement(By.xpath("(//a[@title='Video'])[1]")).click();
		
		
		//Liked Video
		driver.findElement(By.xpath("//span[@class='p1 fa-stack fa-lg pull-right ng-star-inserted']//i[@id='thumbsUp']")).click();
		Thread.sleep(2000);
		
		//Marked Favorite
		driver.findElement(By.xpath("//span[@class='fa-stack fa-lg pull-right ng-star-inserted']//i[@id='thumbsUp']")).click();
		
		
		//Logout!
		driver.findElement(By.xpath("//span[contains(text(),'Automation Tester')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
		
		
		
	}
}
