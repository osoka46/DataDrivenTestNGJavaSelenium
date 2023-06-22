package testcases;

import base.TestBase;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OpenAccountTest extends TestBase {

    @Parameters({"customer", "currency", "confirmation"})
    @Test()
    public void openAccount(String customer, String currency) {

     /*   String firstName = "osman";
        String lastName = "bzd";
        String postCode = "123";
        String confirmation = "Customer added successfully";*/
        Alert alert;




        /*driver.findElement(By.cssSelector(or.getProperty("addCustomerBtn_CSS"))).click();
        driver.findElement(By.cssSelector(or.getProperty("firstName_CSS"))).sendKeys(firstName);
        driver.findElement(By.cssSelector(or.getProperty("lastName_CSS"))).sendKeys(lastName);
        driver.findElement(By.cssSelector(or.getProperty("postCode_CSS"))).sendKeys(postCode);
        driver.findElement(By.cssSelector(or.getProperty("addBtn_CSS"))).click();*/

        expectedWait(driver, 5);
        alert = driver.switchTo().alert();
        String confirm = alert.getText();
        alert.accept();


    }



}
