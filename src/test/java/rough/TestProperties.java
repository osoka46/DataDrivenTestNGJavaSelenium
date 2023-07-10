package rough;

import base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestProperties {

    TestBase testBase=new TestBase();
   public static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        //acceptCookie
        ChromeOptions options  = new ChromeOptions();
        //options.addArguments("incognito");
        options.addArguments("--disable-popup-blocking");
        driver=new ChromeDriver();
        driver.get("https://www.sogeti.com/");

        By cookies_accept = By.cssSelector(".acceptCookie");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(cookies_accept));


        String title;
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//span[text()='About us']")));
        driver.findElement(By.xpath("//a[text()='About Sogeti']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@class='breadcrumbs-wrapper no-tag']")).getText());


    }


}
