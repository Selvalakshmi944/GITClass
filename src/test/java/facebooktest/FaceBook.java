package facebooktest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {
	public static void main(String[] args) throws IOException {
		File dataFile = new File("D:\\Selvalakshmi\\seleniumworkspace\\facebooktest\\data\\Book2.xlsx");
		FileInputStream fis = new FileInputStream(dataFile);
		Workbook w = new XSSFWorkbook(fis);
		Sheet s = w.getSheet("LoginDetails");
		Row r = s.getRow(0);
		int nor = s.getPhysicalNumberOfRows();
		int noc = r.getPhysicalNumberOfCells();
		for (int i = 1; i < nor; i++) {
			r = s.getRow(i);
			Cell cell = r.getCell(0);
			Cell cell1 = r.getCell(1);
			String outputMessage = loginAccount(cell.getStringCellValue(), cell1.getStringCellValue(), i);
			System.out.println(outputMessage);
			Cell cell2 = r.createCell(2);
			cell2.setCellValue(outputMessage);
		}
		FileOutputStream fout = new FileOutputStream(dataFile);
		w.write(fout);
	}

	public static String loginAccount(String email, String password, int count) throws IOException {
		BaseClass bs = new BaseClass();
		bs.loadURL("https://www.facebook.com/");
		bs.sendKeys("email", email);
		bs.sendKeys("pass", password);
		bs.clickElement("login");
		bs.takeScreenshot("D:\\Selvalakshmi\\test\\case_"+count+".png");
		return bs.getTextFromXpathElement("//*[@id=\"loginform\"]/div[2]/div[2]");
	}

	public static String loginAccount1(String email, String password) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		WebElement userName = driver.findElement(By.id("email"));
		WebElement passElement = driver.findElement(By.id("pass"));
		userName.sendKeys(email);
		passElement.sendKeys(password);
		WebElement buttonLogin = driver.findElement(By.name("login"));
		buttonLogin.click();
		WebElement message = driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[2]/div[2]"));
		return message.getText();

	}

}
