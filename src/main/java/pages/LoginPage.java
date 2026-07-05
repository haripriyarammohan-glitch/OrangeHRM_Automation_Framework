package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import reports.ExtentLogger;

public class LoginPage extends BasePage {

    private By usernameTextbox = By.name("username");
    private By passwordTextbox = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {

        type(usernameTextbox, username);

        ExtentLogger.info("Entered Username");
    }

    public void enterPassword(String password) {

        type(passwordTextbox, password);

        ExtentLogger.info("Entered Password");
    }

    public void clickLogin() {

        click(loginButton);

        ExtentLogger.info("Clicked Login Button");
    }

    public HomePage login(String username, String password) {

        enterUsername(username);

        enterPassword(password);

        clickLogin();

        ExtentLogger.pass("Login completed successfully");

        return new HomePage(driver);
    }

}