package javaStream;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamDemoSelenium {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> listItem = driver.findElements(By.xpath("//tr/td[1]"));

		List<String> originalList = listItem.stream().map(s -> s.getText()).collect(Collectors.toList());

		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		Assert.assertTrue(originalList.equals(sortedList));

		List<String> price;
		do {
			List<WebElement> newListItem = driver.findElements(By.xpath("//tr/td[1]"));
			price = newListItem.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeg(s))
					.collect(Collectors.toList());
			price.forEach(a -> System.out.println(a));

			if (price.size() < 1) {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		} while (price.size() < 1);
		filter(driver);

	}

	private static String getPriceVeg(WebElement s) {

		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();

		return priceValue;
	}

	public static void filter(WebDriver driver) {
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> filterResult = driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> itemResult = filterResult.stream().filter(item -> item.getText().contains("Rice"))
				.collect(Collectors.toList());
		Assert.assertEquals(filterResult, itemResult);

	}

}
