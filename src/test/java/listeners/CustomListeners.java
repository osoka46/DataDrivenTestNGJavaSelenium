package listeners;

import base.TestBase;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListeners extends TestBase implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }


}
