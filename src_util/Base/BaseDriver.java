package Base;

import java.io.IOException;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Util.ExcelUtil;

public class BaseDriver {
	/*
	 * This class will set the necessary parameters to run from an external file all the test cases we need
	 * The file layout is Name, Username, Password, BaseURL
	 * We use a Map(Collection) to save our parameters from the external file
	 */
	String path = System.getProperty("user.dir");
	protected Map<String, String> configData = ExcelUtil.getSpecifySheet("./Data/Data.xls", "TestData", "TC_01_Login");
    protected WebDriver driver = null;
    
    /*
     * Create a method to set the type of driver, this time we're gonna use geckodriver for firefox
     * and take the url from the Map
     */
	public void beforeClass(String driverType, String testCaseName) throws InterruptedException, IOException {

		System.out.println("Starting TestCase: " + testCaseName); 
		initWebDriver(driverType);
		driver.get(configData.get("BaseURL"));
		
	}
					
	/*
	 * Initialize the web driver
	 * We can add google or safari
	 */
	public void initWebDriver(String driverType) {

		switch (driverType.trim()) {
			case "firefox":
				driver = getFirefoxDriver();
				break;
		}	
	}

	/*
	 * I use a thread but is not necessary to understand why, but for referral it's a explicit wait
	 * it will wait until all the process ends, and quit the browser
	 */
	public void afterClass(String testCaseName) throws InterruptedException {
		
		Thread.sleep(3000);
		driver.quit();
		System.out.println("End Of TestCase:  " + testCaseName);
					
	}
	
	/*
	 * Get the driver in this case firefox driver
	 */
	public WebDriver getFirefoxDriver() {
		
		try {
			System.setProperty("webdriver.firefox.marionette", "../Drivers/geckodriver");
			driver = new FirefoxDriver();
			System.out.println("Firefox Driver Loaded"); 
		} catch (Exception e) {
			System.out.println("Error Loading Firefox Driver: " + e);
		}
		return driver;
	}

}