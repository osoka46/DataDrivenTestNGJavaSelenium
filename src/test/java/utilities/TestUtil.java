package utilities;

import base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class TestUtil extends TestBase {
    public static String screenShotPath;


    public static void captureScreenShot(String testCaseName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty(System.getProperty("user.dir") + "/src/test/java/screenShotReports" + testCaseName + ".png");

        try {
            FileUtils.copyFile(sourceFile, new File(destinationFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static void captureScreenShot(String testCaseName, WebDriver driver) {


        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String destinationFile = System.getProperty(System.getProperty("user.dir") + "/target/surefire-reports/html" + testCaseName + ".png");
        try {
            FileUtils.copyFile(source, new File(destinationFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
