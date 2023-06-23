package listeners;

import base.TestBase;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import utilities.TestUtil;


public class CustomListeners extends TestBase implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
       /* System.setProperty("org.uncommons.reportng.escape-output", "false");
        String testMethodName=result.getMethod().getMethodName();
        String screenShotName=TestUtil.captureScreenShot(testMethodName);

        String path = System.getProperty("user.dir") + "/src/test/java/screenShots/"+screenShotName+".png";
        Reporter.log("<a target=\"_blank\" href=\"" + path + "\"><p align=\"left\">screenshot " + "</p>");
        Reporter.log("<br>");
        Reporter.log("<br>");
       Reporter.log("<img src=\"System.getProperty(\"user.dir\") + \"/src/test/java/screenShotReports/1.png\" width =200 height=200></img>");
        Reporter.log("<img src=\"" + path + "\"width =200 height=200><p align=\"left\"> " + "</p>");*/
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        String testMethodName=result.getMethod().getMethodName();
        String screenShotName=TestUtil.captureScreenShot(testMethodName);

        String path = System.getProperty("user.dir") + "/src/test/java/screenShots/"+screenShotName+".png";

        Reporter.log("<a target=\"_blank\" href=\"" + path + "\"><p align=\"left\">screenshot " + "</p>");
        Reporter.log("<br>");
        Reporter.log("<br>");
        Reporter.log("<img src=\"" + path + "\"width =200 height=200><p align=\"left\"> " + "</p>");


    }

    @Override
    public void onTestStart(ITestResult result) {
        boolean isTestCaseModeOn=TestUtil.isTestRunnable(result.getMethod().getMethodName(),excel);
       if (!isTestCaseModeOn)
       {
           throw new SkipException("skipping the test " +result.getMethod().getMethodName()+" as the run mode is off ");
       }

    }
}
