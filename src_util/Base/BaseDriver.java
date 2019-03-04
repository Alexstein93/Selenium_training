package Base;

import java.io.IOException;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Util.ExcelUtil;

public class BaseDriver {
	
	String path = System.getProperty("user.dir");
	protected Map<String, String> configData = ExcelUtil.getSpecifySheet("./Data/Data.xls", "TestData", "TC_01_Login");
    protected WebDriver driver = null;

	public void beforeClass(String driverType, String testCaseName) throws InterruptedException, IOException {

		System.out.println("Starting TestCase: " + testCaseName); 
		initWebDriver(driverType);
		driver.get(configData.get("BaseURL"));
		
	}
					
	public void initWebDriver(String driverType) {

		switch (driverType.trim()) {
			case "firefox":
				driver = getFirefoxDriver();
				break;
		}	
	}

	public void afterClass(String testCaseName) throws InterruptedException {
		
		Thread.sleep(3000);
		driver.quit();
		System.out.println("End Of TestCase:  " + testCaseName);
					
	}
	
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