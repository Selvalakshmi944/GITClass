package testcase;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pom.Base;

public class LoginRedBus {
	private static Base base;
	
	@BeforeClass
	public static void openBrowser() {
		base =new Base();
		
	}
	
	@Before
	public void loadUrl(){
		base.loadURL("https://www.redbus.in/");
		
	}
	@Test
	public void testlogin() {
		
	}

}
