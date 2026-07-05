package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
	private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	public boolean isDashBoardDisplayed() {
		waitUtility.waitForVisability(dashboardHeader);
		return driver.findElement(dashboardHeader).isDisplayed();
	}

}
