package testcases;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageWhyUsHeaderTest extends TestBase {


    @Test(groups={"smoke"})
    public void clientStoriesHeader() {
        String title;
        moveToElement(driver,"whyUsHeader_XPATH");
        clickElement(driver,"clientStoriesHeader_XPATH");
        title=driver.getTitle();
        verifyEquals("clientStoriesHeader",title,"Client Stories");

    }
    @Test(groups={"smoke"})
    public void offShoreDeliveryHeader() {
        String title;
        moveToElement(driver,"whyUsHeader_XPATH");
        clickElement(driver,"offShoreDeliveryHeader_XPATH");
        title=driver.getTitle();
        verifyEquals("offShoreDeliveryHeader",title,"Offshore Delivery");

    }
    @Test(groups={"smoke"})
    public void partnersHeader() {
        String title;
        moveToElement(driver,"whyUsHeader_XPATH");
        clickElement(driver,"partnersHeader_XPATH");
        title=driver.getTitle();
        verifyEquals("partnersHeader",title,"Partners");

    }
    @Test(groups={"smoke"})
    public void awardWinningHeader() {
        String title;
        moveToElement(driver,"whyUsHeader_XPATH");
        clickElement(driver,"awardWinningHeader_XPATH");
        title=driver.getTitle();
        verifyEquals("awardWinningHeader",title,"Award Winning");

    }
}
