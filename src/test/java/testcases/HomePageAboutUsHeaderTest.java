package testcases;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HomePageAboutUsHeaderTest extends TestBase {

  /*  @BeforeSuite
    public void acceptCookies()
    {
        By cookies_accept = By.cssSelector(or.getProperty("acceptHomePageCookies"));
        expectedWait(driver, 20);
        driver.findElement(cookies_accept).click();
    }*/

    @Test(groups = {"smoke"})
    public void aboutSogetiHeader() {
        String title;
        moveToElement(driver, "aboutUsHeader_XPATH");
        clickElement(driver, "aboutSogetiHeader_XPATH");
        title = driver.getTitle();
        verifyEquals("aboutSogetiHeader", title, "About Sogeti");
    }

    @Test(groups = {"regression"})
    public void breadCrumbAboutSogeti() {
        moveToElement(driver, "aboutUsHeader_XPATH");
        clickElement(driver, "aboutSogetiHeader_XPATH");
        isElementDisplayed(driver, "breadCrumbAboutSogeti_XPATH");
    }

    @Test(groups = {"smoke"})
    public void corporateSocialResponsibilityHeader() {
        String title;
        moveToElement(driver, "aboutUsHeader_XPATH");
        clickElement(driver, "corporateSocialResponsibilityHeader_XPATH");
        title = driver.getTitle();
        verifyEquals("corporateSocialResponsibilityHeader", title, "Corporate Social Responsibility");

    }

    @Test(groups = {"regression"})
    public void breadCrumbCorporateSocialResponsibility() {
        moveToElement(driver, "aboutUsHeader_XPATH");
        clickElement(driver, "corporateSocialResponsibilityHeader_XPATH");
        isElementDisplayed(driver, "breadCrumbCorporateSocialResponsibility_XPATH");
    }


    @Test(groups = {"smoke"})
    public void historyHeader() {
        String title;
        moveToElement(driver, "aboutUsHeader_XPATH");
        clickElement(driver, "historyHeader_XPATH");
        title = driver.getTitle();
        verifyEquals("aboutUsHeader", title, "History");

    }

    @Test(groups = {"regression"})
    public void breadCrumbHistory() {
        moveToElement(driver, "aboutUsHeader_XPATH");
        clickElement(driver, "historyHeader_XPATH");
        isElementDisplayed(driver, "breadCrumbHistory_XPATH");
    }


    @Test(groups = {"smoke"})
    public void celebrating20YearsHeader() {
        String title;
        moveToElement(driver, "aboutUsHeader_XPATH");
        clickElement(driver, "celebrating20YearsHeader_XPATH");
        title = driver.getTitle();
        verifyEquals("celebrating20YearsHeader", title, "Celebrating 20 years");
        driver.navigate().back();

    }

    @Test(groups = {"regression"})
    public void breadCrumbCelebrating20Years() {
        moveToElement(driver, "aboutUsHeader_XPATH");
        clickElement(driver, "celebrating20YearsHeader_XPATH");
        isElementDisplayed(driver, "breadCrumbCelebrating20Years_XPATH");
        driver.navigate().back();
    }

    @Test(groups = {"smoke"})
    public void passionForSportHeader() {
        String title;
        moveToElement(driver, "aboutUsHeader_XPATH");
        clickElement(driver, "passionForSportHeader_XPATH");
        title = driver.getTitle();
        verifyEquals("passionForSportHeader", title, "Passion for sport");
    }

    @Test(groups = {"regression"})
    public void breadCrumbPassionForSport() {
        moveToElement(driver, "aboutUsHeader_XPATH");
        clickElement(driver, "passionForSportHeader_XPATH");
        isElementDisplayed(driver, "breadCrumbPassionForSport_XPATH");
    }

    @Test(groups = {"smoke"})
    public void ourOfficesHeader() {
        String title;
        moveToElement(driver, "aboutUsHeader_XPATH");
        clickElement(driver, "ourOfficesHeader_XPATH");
        title = driver.getTitle();
        verifyEquals("ourOfficesHeader", title, "ourOfficesHeader");

    }

    @Test(groups = {"regression"})
    public void breadCrumbOurOffices() {
        moveToElement(driver, "aboutUsHeader_XPATH");
        clickElement(driver, "ourOfficesHeader_XPATH");
        isElementDisplayed(driver, "breadCrumbOurOffices_XPATH");

    }

    @Test(groups = {"smoke"})
    public void sogetiExtendsLocalPresenceHeader() {
        String title;
        moveToElement(driver, "aboutUsHeader_XPATH");
        clickElement(driver, "sogetiExtendsLocalPresenceHeader_XPATH");
        title = driver.getTitle();
        verifyEquals("sogetiExtendsLocalPresenceHeader", title, "sogeti Extends Local Presence");
    }
    @Test(groups = {"regression"})
    public void breadCrumbSogetiExtendsLocalPresence() {
        moveToElement(driver, "aboutUsHeader_XPATH");
        clickElement(driver, "sogetiExtendsLocalPresenceHeader_XPATH");
        isElementDisplayed(driver, "breadCrumbSogetiExtendsLocalPresence_XPATH");

    }

}
