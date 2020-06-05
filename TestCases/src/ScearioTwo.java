import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
/*I have added Comments with each piece of Code so your better Understanding*/
/*Please give FeedBack on shane.buriro@gmail.com* (Shahrukh Bashir)/
/*You can run each scenario with -- Right Click - Run as JavaApplication*/
public class ScearioTwo {
	
	public static void main(String[] args) throws InterruptedException {
		//Setting up chromeDriver

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shane\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		//Implicitly Declaring TimeOut so that script doesnot Break if the webElement is not loaded yet.
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		//Getting the URL in Chrome
		driver.get("https://automation-test.v6.nadeem.tv/");
		
		
		//Find SignInButton
		WebElement SignInButton = driver.findElement(By.xpath("//li[@class='ng-star-inserted']//span[@class='text-white'][contains(text(),'Sign In')]"));
		SignInButton.click();
		
		//Filling Up LoginCredentials
		driver.findElement(By.xpath("//input[@id='EmailAddress']")).sendKeys("automation-tester@sharklasers.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Tester123");
		
		//Find SignInButton and Click!
		driver.findElement(By.xpath("//button[@id='Signin']")).click();
		Thread.sleep(3000);
		
		//Finding SearchBar and Inout given "Video"
		driver.findElement(By.xpath("//input[@id='top-search']")).sendKeys("Video");
		Thread.sleep(1000);
		
		//Clicked SearchedButton
		driver.findElement(By.xpath("//button[@class='btn btn-default m-t-xs']")).click();
		Thread.sleep(1000);
		
		//Cleared the SearchInputText
		driver.findElement(By.xpath("//input[@id='top-search']")).clear();
		
		//Cicked The First Video of SearchedResult.
		driver.findElement(By.xpath("//a[@title='Video']")).click();
		Thread.sleep(6000);
		
		//Signedout.
		driver.findElement(By.xpath("//span[contains(text(),'Automation Tester')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
		
	}

}
