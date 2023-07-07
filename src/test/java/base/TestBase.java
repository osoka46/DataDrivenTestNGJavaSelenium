package base;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.ExcelReader;
import utilities.TestUtil;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    /*
    Web driver/done
    Properties/done
    Logs, log4j, .log, log4j.properties,logger
    ExtentReports
    DB
    Excel
    Mail
    Reports
    Jenkins
    * */
    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties or = new Properties();
    public static FileInputStream fis;
    public static Logger logger = Logger.getLogger("Logger");
    public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "/src/test/resources/excel/testdata.xlsx");
    public static WebDriverWait wait;
    public static String browser;

    static {
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/resources/log4j.properties");
    }


    @BeforeSuite
    public void setUp() {
        if (driver == null) {
            try {
                fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/config.properties");
                config.load(fis);
                logger.info("config file loaded.");
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            try {
                fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/or.properties");
                or.load(fis);
                logger.info("or file loaded.");
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            String browserName;

            if (System.getProperty("browser")!=null)
            {
                browserName=System.getProperty("browser");
            }else {
                browserName=config.getProperty("browser");
            }

            if (browserName.equals("firefox")) {
                //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/executables/geckodriver");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if (browserName.equals("chrome")) {
                //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/executables/chromedriver");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/executables/chromedriver");
                driver = new ChromeDriver();
            }
        }

        logger.info(config.getProperty("browser") + " browser activated.");
        driver.get(config.getProperty("testingUrl"));
        logger.info("navigated to " + config.getProperty("testingUrl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitWait")), TimeUnit.SECONDS);
    }

    public boolean isElementDisplayed(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void expectedWait(WebDriver driver, long time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
    }

    public void clickElement(WebDriver driver, String locator) {
        String locatorType = locator.split("_")[1];
        WebElement webElement;

        if (locatorType.equalsIgnoreCase("CSS")) {
            webElement = driver.findElement(By.cssSelector(or.getProperty(locator)));
        } else if (locatorType.equalsIgnoreCase("XPATH")) {
            webElement = driver.findElement(By.xpath(or.getProperty(locator)));
        } else if (locatorType.equalsIgnoreCase("ID")) {
            webElement = driver.findElement(By.id(or.getProperty(locator)));
        } else {
            webElement = driver.findElement(By.cssSelector(or.getProperty(locator)));
        }
        Reporter.log(webElement.toString() + "Web elemenet found");
        webElement.click();
        Reporter.log(webElement + " clicked.");
    }


    public void typeText(WebDriver driver, String locator, String text) {
        String locatorType = locator.split("_")[1];
        WebElement webElement;

        if (locatorType.equalsIgnoreCase("CSS")) {
            webElement = driver.findElement(By.cssSelector(or.getProperty(locator)));
        } else if (locatorType.equalsIgnoreCase("XPATH")) {
            webElement = driver.findElement(By.xpath(or.getProperty(locator)));
        } else if (locatorType.equalsIgnoreCase("ID")) {
            webElement = driver.findElement(By.id(or.getProperty(locator)));
        } else {
            webElement = driver.findElement(By.cssSelector(or.getProperty(locator)));
        }
        Reporter.log("Web elemenet found");
        webElement.sendKeys(text);
        Reporter.log(text + " typed.");
    }

    public void select(WebDriver driver, String locator, String value) {
        String locatorType = locator.split("_")[1];
        WebElement dropDownWebElement;
        Select select;

        if (locatorType.equalsIgnoreCase("CSS")) {
            dropDownWebElement = driver.findElement(By.cssSelector(or.getProperty(locator)));
        } else if (locatorType.equalsIgnoreCase("XPATH")) {
            dropDownWebElement = driver.findElement(By.xpath(or.getProperty(locator)));
        } else if (locatorType.equalsIgnoreCase("ID")) {
            dropDownWebElement = driver.findElement(By.id(or.getProperty(locator)));
        } else {
            dropDownWebElement = driver.findElement(By.cssSelector(or.getProperty(locator)));
        }
        Reporter.log("Dropdown found");
        select = new Select(dropDownWebElement);
        System.out.println(value);
        select.selectByVisibleText(value);

        Reporter.log(value + " selected.");
    }


    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        logger.info("test execution completed.");
    }

    public static void verifyEquals(String testMethodName, String expected, String actual) {
        try {
            Assert.assertEquals(expected, actual);

        } catch (Throwable e) {

            String screenShotName = TestUtil.captureScreenShot(testMethodName);
            String path = System.getProperty("user.dir") + "/src/test/java/screenShots/" + screenShotName + ".png";
            Reporter.log("<a target=\"_blank\" href=\"" + path + "\"><p align=\"left\">screenshot " + "</p>");
            TestUtil.captureScreenShot(testMethodName);
            Reporter.log("<br>" + "Verification failure" + "<br>" + e.getMessage() + "<br>");
            Reporter.log("<img src=\"" + path + "\"width =200 height=200><p align=\"left\"> " + "</p>");
        }
    }

    public static void verifyNotEquals(String expected, String message) {
        try {
            Assert.assertNotEquals(expected, message);

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void verifyTrue(boolean expected, String message) {
        try {
            Assert.assertTrue(expected, message);

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
