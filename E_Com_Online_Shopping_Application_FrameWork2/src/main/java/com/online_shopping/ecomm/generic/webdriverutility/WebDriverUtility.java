package com.online_shopping.ecomm.generic.webdriverutility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	WebDriver driver = null;

	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitBasedOnCondition(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void switchToWindowByTitle(String title) {
		Set<String> allWindow = driver.getWindowHandles();
		for (String result : allWindow) {
			driver.switchTo().window(result);
			String titles = driver.getTitle();
			if (titles.contains(title)) {
				break;
			}
		}
	}

	public void switchToWindowByUrl(String partialUrl) {
		Set<String> allWindow = driver.getWindowHandles();
		for (String result : allWindow) {
			driver.switchTo().window(result);
			String currentURL = driver.getCurrentUrl();
			if (currentURL.contains(partialUrl)) {
				break;
			}
		}
	}

	public void switchToFrame(String name) {
		driver.switchTo().frame(name);
	}

	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);

	}

	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();

	}

	public void switchToAlertAndDismiss() {
		driver.switchTo().alert().dismiss();
	}

	public void select(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
		select.selectByValue(text);
	}

	public void select(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void scrollByAmount(WebDriver driver) {
		Actions action = new Actions(driver);
		action.scrollByAmount(0,400).perform();
	}
}
