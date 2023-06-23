package testcases;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BankManagerLoginTest extends TestBase {


    @Test
    public void loginButton() {
        verifyEquals("BankManagerLoginTest","abc","ab");
        logger.info("inside login test");
        boolean addCustomerBtnDisplayed;
        clickElement(driver,"bankManagerLoginButton_XPATH");
        Reporter.log("Bank manager login button clicked");
        addCustomerBtnDisplayed=isElementDisplayed(By.cssSelector(or.getProperty("addCustomerBtn_CSS")));
        Assert.assertTrue(addCustomerBtnDisplayed,"Login is not successful");
        logger.info("login test successfully executed.");

    }
}
