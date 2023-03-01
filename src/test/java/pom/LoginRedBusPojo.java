package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginRedBusPojo extends Base {
	
	public LoginRedBusPojo() {
		PageFactory.initElements(driver, this);
	}
	@FindBys({@FindBy(id="mobileNoInp"),@FindBy(xpath="//*[@id=\"mobileNoInp\"]")})
	private WebElement phoneNumber;
	
	
	
}
