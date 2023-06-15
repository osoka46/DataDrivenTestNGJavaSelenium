package testcases;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @Test
    public void loginButton() throws InterruptedException {
        logger.info("inside login test");
        driver.findElement(By.xpath(or.getProperty("bankManagerLoginButton"))).click();
        Thread.sleep(3000);
        Assert.assertTrue(isElementDisplayed(By.cssSelector(or.getProperty("addCustomerBtn"))),"Login is not succesfull");
        logger.info("login test successfully executed.");
    }


}
