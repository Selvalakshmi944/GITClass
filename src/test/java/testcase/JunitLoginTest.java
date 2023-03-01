package testcase;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pom.Base;
import pom.LoginPojo;

public class JunitLoginTest {

	private static Base base;

	@BeforeClass
	public static void openBrowser() {
		base = new Base();
	}

	@Before
	public void loadUrl() {
		System.out.println(System.currentTimeMillis());
		base.loadURL("https://facebook.com");
	}

	@Test
	public void testValidLogin() {
		LoginPojo lp = new LoginPojo();
		lp.sendKeys(lp.getUserElement(), "selvalakshmi@gmail.com");
		assertEquals("selvalakshmi@gmail.com", lp.getUserElement().getAttribute("value"));
		lp.sendKeys(lp.getPassElement(), "1235");
		assertEquals("1235", lp.getPassElement().getAttribute("value"));
		lp.click(lp.getBtnLogin());
	}

	@Test
	public void testUserNameInvalidLogin() {
		LoginPojo lp = new LoginPojo();
		lp.sendKeys(lp.getUserElement(), "test@gmail.com");
		lp.sendKeys(lp.getPassElement(), "1235");
		lp.click(lp.getBtnLogin());
	}

	@After
	public void endTime() {
		System.out.println(System.currentTimeMillis());
	}

	@AfterClass
	public static void close() {
		base.close();
	}

}
