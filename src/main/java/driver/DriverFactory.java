package driver;
import org.openqa.selenium.WebDriver;
import utilities.ConfigReader;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static void initDriver(String browser) {
		
		System.out.println(
			    "Launching " + browser +
			    " | Thread : " + Thread.currentThread().getId()
			);
		switch(browser.toLowerCase()) {
		
		case "chrome" :
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			break;
			
		case "firefox" :
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			break;
			
		case "edge" :
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
			break;
			
		default : 
			throw new IllegalArgumentException("Invalid Browser " + browser);
		
		}
	}
	
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	
	public static void quitDriver() {
		
		if(driver.get() != null) {
			driver.get().quit();
			driver.remove();;
		}
	}
	
}
