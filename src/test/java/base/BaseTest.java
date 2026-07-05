package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import driver.DriverFactory;
import utilities.ConfigReader;

public class BaseTest {

//    @BeforeMethod
//    @Parameters("browser")
//    public void setUp(String browser) {
//
//        DriverFactory.initDriver(browser);
//
//        DriverFactory.getDriver().manage().window().maximize();
//
//        DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
//    }
//
//    @AfterMethod
//    public void tearDown() {
//
//        DriverFactory.quitDriver();
//    }
	
	
	
	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) {

	    try {

	        System.out.println("Starting Browser : " + browser);

	        DriverFactory.initDriver(browser);

	        System.out.println("Driver Created");

	        DriverFactory.getDriver().manage().window().maximize();

	        System.out.println("Window Maximized");

	        DriverFactory.getDriver().get(ConfigReader.getProperty("url"));

	        System.out.println("URL Opened");

	    } catch (Exception e) {

	        System.out.println("ERROR IN BEFORE METHOD");

	        e.printStackTrace();

	        throw e;
	    }
	}
}