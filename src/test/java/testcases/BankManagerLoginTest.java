package testcases;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BankManagerLoginTest extends TestBase {


    @Test
    public void loginButton() {
        logger.info("inside login test");
        driver.findElement(By.xpath(or.getProperty("bankManagerLoginButton"))).click();
        Reporter.log("Bank manager login button clicked");
        Assert.assertTrue(isElementDisplayed(By.cssSelector(or.getProperty("addCustomerBtn"))),"Login is not successful");
        logger.info("login test successfully executed.");
        //reporter.log seen on test output
        Reporter.log("login test successfully executed.");
    }


}
