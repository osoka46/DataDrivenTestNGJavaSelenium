package testcases;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class HomePageJoinUsHeaderTest extends TestBase {


    @Test(groups = {"smoke"})
    public void aboutSogetiHeader() {
        String text;
        String parentPage;
        String childPage;
        moveToElement(driver, "joinUsHeader_XPATH");
        clickElement(driver, "jobsAtSogetiHeader_XPATH");
        clickElement(driver, "jobsAtSogetiGermany_XPATH");
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        parentPage = iterator.next();
        childPage = iterator.next();
        driver.switchTo().window(childPage);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(or.getProperty("jobsAtSogetiGermanyCookies"))));
        driver.findElement(By.cssSelector(or.getProperty("jobsAtSogetiGermanyCookies"))).click();
        text=driver.findElement(By.xpath("//span[text()='Offene Stellen']")).getText();
        verifyEquals("aboutSogetiHeader","Offene Stellen",text);
        driver.switchTo().window(parentPage);
    }
    @Test(groups = {"smoke"})
    public void joinUsBecomeYourBestHeader() {
        String title;
        moveToElement(driver, "joinUsHeader_XPATH");
        clickElement(driver, "joinUsBecomeYourBestHeader_XPATH");
        title= driver.getTitle();
        verifyEquals("joinUsBecomeYourBestHeader", title, "Become your Best");
    }

    @Test(groups = {"smoke"})
    public void joinUsSoleadHeader() {
        String title;
        moveToElement(driver, "joinUsHeader_XPATH");
        clickElement(driver, "joinUsSoleadHeader_XPATH");
        title= driver.getTitle();
        verifyEquals("joinUsSoleadHeader", title, "SoLEAD");
    }
}

