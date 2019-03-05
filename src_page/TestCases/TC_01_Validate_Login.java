package TestCases;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Actions.Login;
import Base.BaseDriver;

public class TC_01_Validate_Login extends BaseDriver {

	//Obtain and store the test case name in a variable
	private String testCaseName = this.getClass().getSimpleName();
	Login obj = null;
	
	/*
	 * Method beforeClass set the driver for the browser and the test case name
	 */
	@Before
	public void beforeTest() throws InterruptedException, IOException  {
		beforeClass(configData.get("Browser"), testCaseName);
		obj= new Login(driver);
	}
	
	/*
	 * Call to the steps or our test case, they are in the Login class
	 */
	@Test
	public void testMain()  {
		
		System.out.println("Init... Test Case");
		obj.openSite();
		obj.setUsername();
		obj.setPassword();
		obj.clickLogin();
		System.out.println("End... Test Case");
		
	}
	
	/*
	 * Method afterClass quit the browser and print the test case name
	 */
	@After
	public void tearDown() throws InterruptedException{
		afterClass(testCaseName);
	}
}
