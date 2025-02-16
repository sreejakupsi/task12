package task11;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

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
		driver.get("https://the-internet.herokuapp.com/windows");
		
		// implicitly wait to load all the elements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// click to open new window
		WebElement newPage = driver.findElement(By.xpath("//a[text()='Click Here']"));
		newPage.click();
		System.out.println(newPage.getText());
		String mainWindowHandle = driver.getWindowHandle();
		System.out.println("Main Window Handle: " + mainWindowHandle);

		// get all window handles
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("All Window Handles: " + allWindowHandles);

		// iterate through the window
		Iterator<String> iterator = allWindowHandles.iterator();
		while (iterator.hasNext()) {
			String childWindow = iterator.next();
			if (!mainWindowHandle.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				String text = driver.findElement(By.xpath("//div/h3")).getText();
				System.out.println("Text from new window :" + text);
				driver.close();// close the new window
			}
		}

		driver.switchTo().window(mainWindowHandle);
		System.out.println("Switched back to main window");

		// Close the browser
		driver.quit();

	}

}
