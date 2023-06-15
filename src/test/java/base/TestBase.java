package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    /*
    Webdriver/done
    Properties/done
    Logs, log4j, .log, lopg4j.properties,logger
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
    public static Logger logger=Logger.getLogger("Logger");
    static {
        PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/test/resources/log4j.properties");
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

        }
        if (config.getProperty("browser").equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/executables/geckodriver");
            driver = new FirefoxDriver();
        }
        else if (config.getProperty("browser").equals("chrome")) {
            //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/executables/chromedriver");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/executables/chromedriver");
            driver = new ChromeDriver();
        }
        logger.info(config.getProperty("browser")+" browser activated.");
        driver.get(config.getProperty("testingUrl"));
        logger.info("navigated to "+config.getProperty("testingUrl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitWait")), TimeUnit.SECONDS);

    }
    public boolean isElementDisplayed(By by)
    {
        try {
            driver.findElement(by);
            return true;
        }catch (NoSuchElementException e)
        {
            return false;
        }

    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        logger.info("test execution completed.");

    }


}
