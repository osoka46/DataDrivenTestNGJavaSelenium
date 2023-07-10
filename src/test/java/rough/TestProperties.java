package rough;

import base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ExcelReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;

public class TestProperties extends TestBase{
  //  public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "/src/test/resources/excel/testdata.xlsx");


    public static void main(String[] args) {

       WebDriverManager.chromedriver().setup();

        //acceptCookie
        ChromeOptions options  = new ChromeOptions();
        //options.addArguments("incognito");
        options.addArguments("--disable-popup-blocking");
        driver=new ChromeDriver();
        driver.get("https://www.sogeti.com/");

        By cookies_accept = By.cssSelector(".acceptCookie");
        By contact=By.cssSelector("a[class='topMenuLink']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
        //wait.until(ExpectedConditions.elementToBeClickable(contact)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(cookies_accept));


        String title;
        driver.findElement(contact).click();

        System.out.println(driver.findElement(By.xpath("//div[@class='breadcrumbs-wrapper no-tag']")).getText());

    }
}
