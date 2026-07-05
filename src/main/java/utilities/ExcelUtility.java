package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    private static Workbook workbook;
    private static Sheet sheet;
    private static String filePath;

    public static void loadExcel(String path, String sheetName) {

        try {

            filePath = path;

            FileInputStream fis = new FileInputStream(path);

            workbook = new XSSFWorkbook(fis);

            sheet = workbook.getSheet(sheetName);

            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getRowCount() {

        return sheet.getPhysicalNumberOfRows();

    }

    public static int getColumnCount() {

        return sheet.getRow(0).getPhysicalNumberOfCells();

    }

    public static String getCellData(int rowNumber, int columnNumber) {

        Row row = sheet.getRow(rowNumber);

        if (row == null) {
            return "";
        }

        Cell cell = row.getCell(columnNumber);

        if (cell == null) {
            return "";
        }

        DataFormatter formatter = new DataFormatter();

        return formatter.formatCellValue(cell);
    }

    public static void setCellData(int rowNumber, int columnNumber, String value) {

        try {

            Row row = sheet.getRow(rowNumber);

            if (row == null) {
                row = sheet.createRow(rowNumber);
            }

            Cell cell = row.getCell(columnNumber);

            if (cell == null) {
                cell = row.createCell(columnNumber);
            }

            cell.setCellValue(value);

            FileOutputStream fos = new FileOutputStream(filePath);

            workbook.write(fos);

            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void closeExcel() {

        try {

            if (workbook != null) {
                workbook.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}