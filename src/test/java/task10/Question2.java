package task10;

import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Question2 {

	public static void main(String[] args) {
		// launch the browser
		WebDriver driver = new ChromeDriver();
		
		// maximizing the window
		driver.manage().window().maximize();
		
		// navigating to the url
		driver.get("https://jqueryui.com/droppable/");
		
		// implicitly wait to load all the elements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// switch to frame
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		// find first element
		WebElement element1 = driver.findElement(By.id("draggable"));
		
		// find next element
		WebElement element2 = driver.findElement(By.id("droppable"));
		
		// create actions method
		Actions objAct = new Actions(driver);
		objAct.dragAndDrop(element1, element2).build().perform();
		
		// get the text
		String msg = element2.getText();
		String bgColor = element2.getCssValue("background-color");
		System.out.println("The colour of the element is " + bgColor);
		System.out.println("The message after drag and drop is:" + msg);
		
		// assert the colour
		Assert.assertEquals("rgba(255, 250, 144, 1)", bgColor);
		if (bgColor.equalsIgnoreCase("rgba(255, 250, 144, 1)")) {
			System.out.println("Dragged and dropped successfully and the color is changed!");
		} else {
			System.out.println("Drag and dropped failed!");
		}
		
		// assert the message
		if (msg.equalsIgnoreCase("Dropped!")) {
			System.out.println("Dragged and dropped successfully and dropped message is displayed!");
		} else {
			System.out.println("Drag and dropped failed!");
		}

		//Close the browser
		driver.quit();

	}

}
