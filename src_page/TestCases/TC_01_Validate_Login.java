package TestCases;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Actions.Login;
import Base.BaseDriver;

public class TC_01_Validate_Login extends BaseDriver {

	private String testCaseName = this.getClass().getSimpleName();
	Login obj = null;
	//GoogleSearch searchPAge = null;
	

	@Before
	public void beforeTest() throws InterruptedException, IOException  {
		beforeClass(configData.get("Browser"), testCaseName);
		obj= new Login(driver);
	}
	
	@Test
	public void testMain()  {
		
		System.out.println("Init... Test Case");
		obj.openSite();
		obj.setUsername();
		obj.setPassword();
		obj.clickLogin();
		System.out.println("End... Test Case");
		
	}
	
	@After
	public void tearDown() throws InterruptedException{
		afterClass(testCaseName);
	}
}
