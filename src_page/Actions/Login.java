package Actions;

import Util.ExcelUtil;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import PageObjects.LoginPage;

public class Login {
	/*
	 * We are gonna use an external file to pass all the variables to our project
	 * so, we use a Map(Collection) to save our parameters, also our attributes will be protected type
	 */
	
	protected Map<String,String> dataValue = ExcelUtil.getSpecifySheet("./Data/Data.xls", "TestData", "TC_01_Login");
	protected WebDriver driver = null;
	
	//Call(Instance) to our LoginPage
	LoginPage objLogin = null;
	
	//Create a constructor to initialize our object that will be called from our test case class
	public Login(WebDriver driver) {
		super();
		this.driver = driver;
		
		//Initialize objLogin
		objLogin = new LoginPage(driver);
	}
	
	/*
	 * The following methods are our verifications or assertions to test the page.
	 * The prints are to see the result of each validation
	 * For this example we use try catch to get the exceptions in case of some method doesn't
	 * give the expected result.
	 * 
	 */
	
	/*
	 * In this case the methods will be void casue this are just actions and the output is our prints
	 */
	
	public void openSite() {
		try {
			//Verify if the title of the page is equals to the expected string
			if (objLogin.getPageTitle().equals("Facebook - Inicia sesión o regístrate")) {
				System.out.println("Result: Step 1 - Open site | Correct");
			} else {
				System.out.println("Result: Step 1 - Open site | Fail");
			}
		} catch (Exception e) {
			System.out.println("Something went wrong trying to load the site!! "+e);
		}
	}
	
	public void setUsername() {
		try {
			//Send text to the username input
			objLogin.getUsernameInput().sendKeys(dataValue.get("Username"));
			System.out.println("Result: Step 2 - Set username | Correct");
		} catch (Exception e) {
			System.out.println("Something went wrong on Step 2 trying to set the username!! "+e);
		}
	}
	
	public void setPassword() {
		try {
			//Send text to the password input
			objLogin.getPasswordInput().sendKeys(dataValue.get("Password"));
			System.out.println("Result: Step 3 - Set password | Correct");
		} catch (Exception e) {
			System.out.println("Something went wrong on Step 3 trying to set the password!! "+e);
		}
	}
	
	public void clickLogin() {
		try {
			//Do click to the login button
			objLogin.getLoginButton().click();
			System.out.println("Result: Step 3 - Set password | Correct");
		} catch(Exception e) {
			System.out.println("Something went wrong on Step 4 trying click the Login button!! "+e);
		}
	}
}
