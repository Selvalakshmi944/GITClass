package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPojo extends Base {
	
	public LoginPojo() {
		PageFactory.initElements(driver, this);
	}

	@FindBys({ @FindBy(id = "email"), @FindBy(xpath = "//input[@type='text']") })
	private WebElement userElement;

	@FindAll({ @FindBy(id = "pass"), @FindBy(xpath = "//input[@type='pass']") })
	private WebElement passElement;

	@FindBy(name = "login")
	private WebElement btnLogin;

	public WebElement getUserElement() {
		return userElement;
	}

	public WebElement getPassElement() {
		return passElement;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

}
