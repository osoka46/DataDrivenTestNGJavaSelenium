package base;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.ExcelReader;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    /*
    Webdriver/done
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
            if (config.getProperty("browser").equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/executables/geckodriver");
                driver = new FirefoxDriver();
            } else if (config.getProperty("browser").equals("chrome")) {
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
        WebElement webElement ;

        if (locatorType.equalsIgnoreCase("CSS")) {
            webElement = driver.findElement(By.cssSelector(or.getProperty(locator)));
        } else if (locatorType.equalsIgnoreCase("XPATH")) {
            webElement = driver.findElement(By.xpath(or.getProperty(locator)));
        } else if (locatorType.equalsIgnoreCase("ID")) {
            webElement = driver.findElement(By.id(or.getProperty(locator)));
        } else {
            webElement = driver.findElement(By.cssSelector(or.getProperty(locator)));
        }
        Reporter.log(webElement.toString() + "Webelemenet found");
        webElement.click();
        Reporter.log(webElement.toString() + " clicked.");
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
        Reporter.log("Webelemenet found");
        webElement.sendKeys(text);
        Reporter.log(text + " typed.");
    }
    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        logger.info("test execution completed.");
    }

    /*     public static void captureScreenShot(String testCaseName) {


        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String destinationFile = System.getProperty("user.dir") + "/src/test/java/screenShots/" + testCaseName + ".png";


        try {
            FileUtils.copyFile(source, new File(destinationFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/



}
