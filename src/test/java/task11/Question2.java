package task11;

import java.time.Duration;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question2 {

	public static void main(String[] args) {
		// launch the browser
		WebDriver driver = new ChromeDriver();

		// maximizing the window
		driver.manage().window().maximize();

		// navigating to the url
		driver.get("http://the-internet.herokuapp.com/nested_frames");

		// implicitly wait to load all the elements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// switch to the top frame
		driver.switchTo().frame("frame-top");

		// verify the number of frames
		List<WebElement> numberOfFrames = driver.findElements(By.tagName("frame"));
		System.out.println("Number of frames in frame-top:" + numberOfFrames.size());

		// find left frame
		driver.switchTo().frame("frame-left");
		WebElement leftText = driver.findElement(By.tagName("body"));
		System.out.println("Left frame text:" + leftText.getText());

		// switch to the top frame
		driver.switchTo().parentFrame();

		// find the middle frame
		driver.switchTo().frame("frame-middle");
		WebElement middleText = driver.findElement(By.tagName("body"));
		System.out.println("Middle frame text:" + middleText.getText());

		// switch to the top frame
		driver.switchTo().parentFrame();

		// find the right frame
		driver.switchTo().frame("frame-right");
		WebElement rightText = driver.findElement(By.tagName("body"));
		System.out.println("Right frame text:" + rightText.getText());

		// switch back to main page
		driver.switchTo().defaultContent();

		// switch to the bottom frame
		driver.switchTo().frame("frame-bottom");
		WebElement bottomText = driver.findElement(By.tagName("body"));
		System.out.println("Bottom frame text:" + bottomText.getText());

		// switch to the top frame
		driver.switchTo().parentFrame();

		// page title
		String title = driver.getTitle();
		System.out.println(title);

		if (title.equalsIgnoreCase("Frames")) {
			System.out.println("The Title of the page is" + title);
		} else {
			System.out.println("The title of the page is not defined");
		}

		// Close the browser
		driver.quit();

	}

}
