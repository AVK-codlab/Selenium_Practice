package actionsDemo;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentThree {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Click Here")).click();
		
		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(tab.get(1));
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		
		driver.switchTo().window(tab.get(0));
		System.out.println(driver.findElement(By.tagName("h3")).getText());
	}

}
