package testcases;

import base.TestBase;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OpenAccountTest extends TestBase {

    @Parameters({"customer", "currency", "confirmation"})
    @Test()
    public void openAccount(String customer, String currency,String confirmation) {

     /*   String firstName = "osman";
        String lastName = "bzd";
        String postCode = "123";
        String confirmation = "Customer added successfully";*/

        Alert alert;
        clickElement(driver,"openAccount_CSS");
        expectedWait(driver,5);
        select(driver,"customer_CSS",customer);
        select(driver,"currency_CSS",currency);
        clickElement(driver,"process_CSS");

        alert=driver.switchTo().alert();
        String alertConfirmationText=alert.getText();
        alert.accept();
        Assert.assertTrue(alertConfirmationText.contains(confirmation),"Alert text is not confirmed");

    }
}
