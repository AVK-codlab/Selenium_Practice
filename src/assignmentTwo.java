import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assignmentTwo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();

		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.name("password")).sendKeys("learning");
		driver.findElement(By.xpath("//label[@class='customradio'][2]")).click();

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#okayBtn")));

		driver.findElement(By.cssSelector("#okayBtn")).click();

		WebElement dropdown = driver.findElement(By.cssSelector("div select"));
		Select userType = new Select(dropdown);

		userType.selectByVisibleText("Consultant");

		driver.findElement(By.xpath("//input[@id='terms']")).click();
		driver.findElement(By.cssSelector("input.btn")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.btn-primary")));
		// products

		String itemNeeded[] = { "iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry" };

		List<WebElement> products = driver.findElements(By.cssSelector("h4.card-title"));
		int j = 0;

		for (int i = 0; i <= products.size(); i++) {
			String name = products.get(i).getText();
			// String productName = name[0];

			List item = Arrays.asList(itemNeeded);

			if (item.contains(name)) {
				j++;
				driver.findElements(By.xpath("//button[text()='Add ']")).get(i).click();
				if (j == itemNeeded.length) {
					break;
				}
			}

		}

		driver.findElement(By.cssSelector("a.btn-primary")).click();

	}

}
