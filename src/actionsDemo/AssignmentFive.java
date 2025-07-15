package actionsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AssignmentFive {

	public static void main(String[] args) {
		
		WebDriver driver =  new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("checkBoxOption2")).click();
		String text = driver.findElement(By.xpath("//fieldset/label[@for='benz']")).getText();
		
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		
		Select value = new Select(dropdown);
		
		value.selectByVisibleText(text);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(text);
		driver.findElement(By.cssSelector("#alertbtn")).click();
		String message = driver.switchTo().alert().getText();
		
		Assert.assertTrue(message.contains(text));
		driver.switchTo().alert().accept();

	}

}
