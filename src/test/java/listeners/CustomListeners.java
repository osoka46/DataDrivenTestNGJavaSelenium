package listeners;

import base.TestBase;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import utilities.TestUtil;


public class CustomListeners extends TestBase implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.log(result.getMethod().getMethodName()+" NOT successfully executed");
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        String path = System.getProperty("user.dir") + "/src/test/java/screenShotReports/1.png";
        Reporter.log("<a href=\"" + path + "\"><p align=\"left\">screenshot" + "</p>");
       /* Reporter.log();
        Reporter.log("<a href="/src/test/java/screenShotReports/1.png");
        Reporter.log("<a target=\"_blank\" href=path">ScreenShot</a>");
*/

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        Reporter.log(result.getMethod().getMethodName()+" successfully executed");

        String path = System.getProperty("user.dir") + "/src/test/java/screenShotReports/1.png";
        Reporter.log("<a target=\"_blank\" href=\"" + path + "\"><p align=\"left\">screenshot " + "</p>");
        Reporter.log("<br>");
        Reporter.log("<img src=\"System.getProperty(\"user.dir\") + \"/src/test/java/screenShotReports/1.png\" width =200 height=200></img>");
        Reporter.log("<img src=\"" + path + "\"width =200 height=200><p align=\"left\"> " + "</p>");



        //   Reporter.log("<a href=\"/src/test/java/screenShotReports/1.png"</a>     <p align=\"left\">Screenshot" + "</p>");
       /* Reporter.log();

        TestUtil.captureScreenShot(result.getMethod().getMethodName());
        Reporter.log(result.getName() + " listener ile  clicked.");  */


    }


}
