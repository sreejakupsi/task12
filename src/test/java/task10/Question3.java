package task10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Question3 {

	public static void main(String[] args) {
		// launch the browser
		WebDriver driver = new ChromeDriver();
		
		// maximizing the window
		driver.manage().window().maximize();
		
		// navigating to the url
		driver.get("https://www.guvi.in/");
		
		// implicitly wait to load all the elements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// click the signup button and get the text to conform the current page
		driver.findElement(By.xpath("//a[text()='Sign up']")).click();
		String signUp = driver.getTitle();
		System.out.println(signUp);

		// fill the fields required
		driver.findElement(By.id("name")).sendKeys("KupsiKumar");// name
		driver.findElement(By.id("email")).sendKeys("sreejakumar@gmail.com");// email
		driver.findElement(By.id("password")).sendKeys("GUVI@1234");// password
		driver.findElement(By.id("mobileNumber")).sendKeys("9489738085");// phonenumber
		driver.findElement(By.id("signup-btn")).click();// signup
		WebElement sel1 = driver.findElement(By.id("profileDrpDwn"));// current profile
		sel1.click();
		Select dropDown1 = new Select(sel1);
		dropDown1.selectByValue("Student");
		WebElement sel2 = driver.findElement(By.id("degreeDrpDwn"));// degree
		sel2.click();
		Select dropDown2 = new Select(sel2);
		dropDown2.selectByVisibleText("B.E. / B.Tech. Computer Science");
		WebElement sel3 = driver.findElement(By.id("year"));// passed out
		sel3.click();
		sel3.sendKeys("2023");
		driver.findElement(By.id("details-btn")).click();// submit
		driver.navigate().back();

		//click on the login button and check the current page
		driver.findElement(By.id("login-btn")).click();
		String login = driver.getTitle();
		System.out.println(login);
		
		//fill the required fields
		driver.findElement(By.id("email")).sendKeys("sreejakumar2907@gmail.com");//email
		driver.findElement(By.id("password")).sendKeys("GUVI@1234");//password
		driver.findElement(By.id("login-btn")).click();//login btn
		
		//Close the browser
		driver.quit();


	}

}
