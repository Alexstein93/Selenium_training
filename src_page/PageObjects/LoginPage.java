package PageObjects;

//Imports for Selenium library
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	//Declare an attribute protected of WebDriver type
	protected WebDriver driver;
	
	//Create a constructor to set the driver, it will accept as a parameter the driver
	public LoginPage(WebDriver driver) {
		//The super calls to the constructor from a superior class or high level class
		super();
		this.driver = driver;
	}
	
	/* 
	 * Below we start to "try" to get/obtain all the elements(Web Elements) that we find on the web page
	 * For example: input for username, password, name, last name, etc.
	 * We going to have only getters in this activity, each method will return a WebElement type, inside of the return
	 * we use WebDriverWait a implicit wait for the elements
	 */
	
	/* 
	 * If you get the title of the page you will return a String 
	 * becasue we are only taking the name not an element
	 */
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public WebElement getUsernameInput() {
		/*
		 * We return the "instance" of a WebDriverWait we pass the driver and time it has to wait until a
		 * expected condition in this case, the pressence of element located by the Id attribute: email
		 */
		return (new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.id("email"))));
	}
	
	public WebElement getPasswordInput() {
		/*
		 * We return the "instance" of a WebDriverWait we pass the driver and time it has to wait until a
		 * expected condition in this case, element to be clickable located by the Id attribute: pass
		 */
		return (new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.id("pass"))));
	}
	
	public WebElement getLoginButton() {
		/*
		 * We return the "instance" of a WebDriverWait we pass the driver and time it has to wait until a
		 * expected condition in this case, the attribute contain by Id attribue: loginbutton
		 */
		return (new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.id("loginbutton"))));
		
	}
	
}
