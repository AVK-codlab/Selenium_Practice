import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleClass {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:/eclipse/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");	
		System.out.println("Launched Google");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		WebElement e = driver.findElement(By.name("q"));
		e.sendKeys("India");
		e.submit();
		driver.quit();
	}

}