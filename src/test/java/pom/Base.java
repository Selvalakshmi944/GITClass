package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;

	public Base() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
	}

	public void loadURL(String url) {
		driver.get(url);
	}

	public void sendKeys(WebElement we, String keys) {
		we.sendKeys(keys);
	}
	
	public void getText(WebElement we) {
		we.getText();
	}

	public void click(WebElement we) {
		we.click();
	}

	public void close() {
		driver.close();
	}
}
