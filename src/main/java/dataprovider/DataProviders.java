package dataprovider;

import org.testng.annotations.DataProvider;

import utilities.ExcelUtility;

public class DataProviders {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        ExcelUtility.loadExcel("TestData/LoginData.xlsx", "LoginData");

        int rows = ExcelUtility.getRowCount();
       // int cols = ExcelUtility.getColumnCount();
        int cols = 2;

        Object[][] data = new Object[rows - 1][cols];

        for (int i = 1; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                data[i - 1][j] = ExcelUtility.getCellData(i, j);

            }
        }

        ExcelUtility.closeExcel();

        return data;
    }
}