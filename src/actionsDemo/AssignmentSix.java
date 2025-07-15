package actionsDemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentSix {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");

		WebElement tableRow = driver.findElement(By.name("courses"));
		System.out.println(tableRow.findElements(By.tagName("tr")).size());

		WebElement tableColumn = driver.findElement(By.xpath("//table[@name='courses']/tbody/tr"));
		System.out.println(tableColumn.findElements(By.tagName("th")).size());

		WebElement tablevalue = driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[3]"));
		List<WebElement> table = tablevalue.findElements(By.tagName("td"));

		for (int i = 0; i < table.size(); i++) {
			System.out.println(table.get(i).getText());
		}

	}

}
