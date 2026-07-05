package utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

    public static String captureScreenshot(WebDriver driver, String testName) {

    	String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        String filePath = "Screenshots" + File.separator + testName + "_" + timeStamp + ".png";

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File destination = new File(filePath);

        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filePath;
    }
}