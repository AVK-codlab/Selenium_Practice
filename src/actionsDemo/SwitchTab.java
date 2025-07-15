package actionsDemo;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchTab {

	public static void main(String[] args) {

			WebDriver driver = new ChromeDriver();
			
			driver.get("https://rahulshettyacademy.com/loginpagePractise/");
			driver.manage().window().maximize();
			
			driver.findElement(By.cssSelector("a[target='_blank']")).click();
			
			ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tab.get(1));
			System.out.println(driver.findElement(By.xpath("//p[@class='im-para red']")).getText());
			driver.findElement(By.xpath("//p[@class='im-para red']")).getText();
			String email = driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
			
			driver.switchTo().window(tab.get(0));
			driver.findElement(By.id("username")).sendKeys(email);;
	}

}
