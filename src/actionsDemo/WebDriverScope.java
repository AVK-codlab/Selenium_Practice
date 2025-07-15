package actionsDemo;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverScope {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		System.out.println(driver.findElements(By.tagName("a")).size());

		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());

		WebElement columndriver = driver.findElement(By.xpath("//td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());

		for (int i = 1; i < columndriver.findElements(By.tagName("a")).size(); i++) {
			String linktab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(linktab);
			Thread.sleep(5000);
		}
		
			ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
	//	for(int j = 1; j<=tab.size(); j++) {
			int j = 1;
			while(j < tab.size()) {
				System.out.println(driver.switchTo().window(tab.get(j)).getTitle());
				j++;
		//		driver.switchTo().window(tab.get(0));
		}
		

	}

}
