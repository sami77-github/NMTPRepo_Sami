package com.tekpyramid.vtiger.generic.webdriverutility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility_2 {
	
	// Implicitly Wait
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
	}
	
	// Explicitly wait
		public void waitForelementtoLoad(WebDriver driver,WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		// Switch to tab by url
		public void switchToWindowByUrl(WebDriver driver , String partialurl) {
			Set<String> ids = driver.getWindowHandles();
			for (String id : ids) {
				driver.switchTo().window(id);
				String url = driver.getCurrentUrl();
				if(url.contains(partialurl)) {
					break;
				}
			}
		}
		
		// Switch to tab by Title
			public void switchToWindowByTitle(WebDriver driver , String partialtitle) {
				Set<String> ids = driver.getWindowHandles();
				for (String id : ids) {
					driver.switchTo().window(id);
					String title = driver.getTitle();
					if(title.contains(partialtitle)) {
						break;
					}
				}
			}
			
			// Switch to Frame
			public void switchToFrameByIndex(WebDriver driver , int index) {
				driver.switchTo().frame(index);
			}
			
			public void switchToFrameByName(WebDriver driver , String name) {
				driver.switchTo().frame(name);
			}
			
			public void switchToFrameById(WebDriver driver , String id) {
				driver.switchTo().frame(id);
			}
			
			public void switchToFrame(WebDriver driver , WebElement element) {
				driver.switchTo().frame(element);
			}
			
			// Switch To alert
			public void switchToAlertAccept(WebDriver driver) {
				driver.switchTo().alert().accept();
			}
			
			public void switchToAlertDissmis(WebDriver driver) {
				driver.switchTo().alert().dismiss();
			}
			
			// Handle dropdown
			public void selectByIndex(WebElement element , int index) {
				Select sel = new Select(element);
				sel.selectByIndex(index);
			}
			
			public void selectByValue(WebElement element , String value) {
				Select sel = new Select(element);
				sel.selectByValue(value);
			}
			
			public void selectByVisibleText(WebElement element , String text) {
				Select sel = new Select(element);
				sel.selectByVisibleText(text);
			}
			
			// KeyBoard & Mouse Actions 
			public void moveToElement(WebDriver driver , WebElement element) {
				Actions action = new Actions(driver);
				action.moveToElement(element);
			}

}
