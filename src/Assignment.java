import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.cssSelector("input[minlength='2']")).sendKeys("User");
		driver.findElement(By.name("email")).sendKeys("user@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("12345678");
		driver.findElement(By.id("exampleCheck1")).click();
		
		WebElement select = driver.findElement(By.id("exampleFormControlSelect1"));
		
		Select dropdown = new Select(select);
		dropdown.selectByVisibleText("Male");
		
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.xpath("//*[@name='bday']")).sendKeys("01/01/1990");
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
		
	}

}
