package testcases;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BankManagerLoginTest extends TestBase {
    @BeforeClass
    public void HomePage() {
        driver.get(config.getProperty("homePage"));
        By cookies_accept = By.cssSelector(or.getProperty("acceptHomePageCookies"));
        expectedWait(driver, 20);
        driver.findElement(cookies_accept).click();
    }

    @Test
    public void aboutSogetiHeader() {
        String title;
        moveToElement(driver,"aboutUsHeader_XPATH");
        clickElement(driver,"aboutSogetiHeader_XPATH");
        title=driver.getTitle();
        verifyEquals("aboutSogetiHeader",title,"About Sogeti");

    }


    @Test
    public void loginButton() {
        System.out.println("dene");
       /* verifyEquals("BankManagerLoginTest","abc","ab");
        logger.info("inside login test");
        boolean addCustomerBtnDisplayed;
        clickElement(driver,"bankManagerLoginButton_XPATH");
        Reporter.log("Bank manager login button clicked");
        addCustomerBtnDisplayed=isElementDisplayed(By.cssSelector(or.getProperty("addCustomerBtn_CSS")));
        Assert.assertTrue(addCustomerBtnDisplayed,"Login is not successful");
        //Assert.fail();
        logger.info("login test successfully executed.");*/


    }
}
