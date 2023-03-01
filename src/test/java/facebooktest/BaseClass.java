package facebooktest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;

	public BaseClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public void loadURL(String url) {
		driver.get(url);
	}

	public String pageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public Alert confirmAlert() {
		Alert alert = driver.switchTo().alert();
		return alert;
	}

	public void doubletimeclick() {
		Actions a = new Actions(driver);
		a.doubleClick();
	}

	public void sendKeys(String elementId, String keys) {
		WebElement we = driver.findElement(By.id(elementId));
		we.sendKeys(keys);
	}
	
	public void sendKeysXpathElement(String xpath, String keys) {
		WebElement we = driver.findElement(By.xpath(xpath));
		we.sendKeys(keys);
	}


	public void clickElement(String elementName) {
		driver.findElement(By.name(elementName)).click();
	}
	
	public void clickIdElement(String elementName) {
		driver.findElement(By.id(elementName)).click();
	}
	
	public void clickXpathElement(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void clickElement(String elementDetail, String type) {
		if(type.toUpperCase().equals("ID")) {
			driver.findElement(By.id(elementDetail)).click();
		}else if(type.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(elementDetail)).click();
		}else if(type.equalsIgnoreCase("name")) {
			driver.findElement(By.name(elementDetail)).click();
		}
	}
	
	public void select(String elementId, String selectOption) {
		WebElement we = driver.findElement(By.id(elementId));
		Select s = new Select(we);
		s.selectByVisibleText(selectOption);
	}

	public String getTextFromXpathElement(String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	
	public String getAttribute(String idElement, String attributeName) {
		return driver.findElement(By.id(idElement)).getAttribute(attributeName);
	}
	
	@SuppressWarnings("deprecation")
	public void implicitWait(long timeInSeconds) {
		driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
	}

	public void takeScreenshot(String outputFilePath) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(outputFilePath);
		FileUtils.copyFile(srcFile, destFile);
	}
	

}
