package task10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question1 {

	public static void main(String[] args) {
		// launch the browser
		WebDriver driver = new ChromeDriver();

		// maximizing the window
		driver.manage().window().maximize();

		// navigating to the url
		driver.get("https://jqueryui.com/datepicker/");

		// implicitly wait to load all the elements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// switch to the frame
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

		// click the date input field
		driver.findElement(By.xpath("//body/p/input")).click();
	
		// click the next month
		driver.findElement(By.xpath("//a[@title='Next']")).click();

		// click date 22
		WebElement date = driver.findElement(By.xpath("//a[@data-date='22']"));
		date.click();
		System.out.println("The Selected date is " + date.getText());

		//Close the browser
		driver.quit();
	}

}
