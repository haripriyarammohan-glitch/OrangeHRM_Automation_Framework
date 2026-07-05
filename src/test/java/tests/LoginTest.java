package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import dataprovider.DataProviders;
import driver.DriverFactory;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends BaseTest {

    private static int rowNumber = 1;

//    @Test(
//    	    dataProvider = "loginData",
//    	    dataProviderClass = DataProviders.class
//    	)
//    public void verifyValidLogin(String username, String password) {
//    	
//    	System.out.println("Current Thread : " + Thread.currentThread().getId());
//
//        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
//
//        try {
//
//            loginPage.login(username, password);
//
//            ExcelUtility.loadExcel("TestData/LoginData.xlsx", "LoginData");
//
//            ExcelUtility.setCellData(rowNumber, 2, "PASS");
//
//            ExcelUtility.closeExcel();
//
//            rowNumber++;
//
//           Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("dashboard"));
//            //Assert.fail("Testing Retry Analyzer");
//
//        } catch (Exception e) {
//
//            ExcelUtility.loadExcel("TestData/LoginData.xlsx", "LoginData");
//
//            ExcelUtility.setCellData(rowNumber, 2, "FAIL");
//
//            ExcelUtility.closeExcel();
//
//            rowNumber++;
//
//            Assert.fail(e.getMessage());
//        }
//    }
    
    
    
    @Test
    public void verifyValidLogin() {

        System.out.println(
            "Browser Thread : " + Thread.currentThread().getId()
        );

        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

        loginPage.login("Admin", "admin123");

        Assert.assertTrue(
            DriverFactory.getDriver()
                         .getCurrentUrl()
                         .contains("dashboard")
        );
    }
}