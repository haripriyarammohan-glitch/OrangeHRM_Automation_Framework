package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WaitUtility;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtility waitUtility;
    
    protected void click(By locator) {
        waitUtility.waitForClicable(locator);
        driver.findElement(locator).click();
    }
    
    protected void type(By locator, String text) {
        waitUtility.waitForVisability(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    protected boolean isDisplayed(By locator) {
        waitUtility.waitForVisability(locator);
        return driver.findElement(locator).isDisplayed();
    }

    protected String getText(By locator) {
        waitUtility.waitForVisability(locator);
        return driver.findElement(locator).getText();
    }

    public BasePage(WebDriver driver) {

        this.driver = driver;
        this.waitUtility = new WaitUtility(driver);
        }

}