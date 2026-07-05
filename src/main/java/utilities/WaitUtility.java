package utilities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public WaitUtility(WebDriver driver) {
		  this.driver = driver;
	      this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}
	
	public void waitForVisability(By locatory) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locatory));
	}
	public void waitForClicable(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

}
