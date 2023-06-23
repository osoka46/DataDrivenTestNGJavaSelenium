package testcases;

import base.TestBase;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddCustomerTest extends TestBase {

    @Parameters({"firstName", "lastName", "postCode", "confirmation"})
    @Test()
    public void addCustomer(String firstName, String lastName, String postCode, String confirmation) {

     /*   String firstName = "osman";
        String lastName = "bzd";
        String postCode = "123";
        String confirmation = "Customer added successfully";*/
        Alert alert;


        clickElement(driver, "addCustomerBtn_CSS");
        typeText(driver, "firstName_CSS", firstName);
        typeText(driver, "lastName_CSS", lastName);
        typeText(driver, "postCode_CSS", postCode);
        clickElement(driver, "addBtn_CSS");


        /*driver.findElement(By.cssSelector(or.getProperty("addCustomerBtn_CSS"))).click();
        driver.findElement(By.cssSelector(or.getProperty("firstName_CSS"))).sendKeys(firstName);
        driver.findElement(By.cssSelector(or.getProperty("lastName_CSS"))).sendKeys(lastName);
        driver.findElement(By.cssSelector(or.getProperty("postCode_CSS"))).sendKeys(postCode);
        driver.findElement(By.cssSelector(or.getProperty("addBtn_CSS"))).click();*/

        expectedWait(driver, 5);
        alert = driver.switchTo().alert();
        String confirm = alert.getText();
        alert.accept();
        expectedWait(driver,5);
        Assert.assertTrue(confirm.contains(confirmation));

    }

    @DataProvider
    public Object[][] getData() {

        Sheet sheet = excel.getSheetByName("AddCustomerTest");
        Row row = sheet.getRow(1);
        int rowNumber = sheet.getPhysicalNumberOfRows();
        int cellNumber = row.getPhysicalNumberOfCells();

        Object[][] data = new Object[2][4];
        data[0][0] = "osman";
        data[0][1] = "bzda";
        data[0][2] = "12345";
        data[0][3] = "Customer added successfully";
        data[1][0] = "ali";
        data[1][1] = "yoo";
        data[1][2] = "54321";
        data[1][3] = "Customer added successfully";

        /*data[0][0] = row.getCell(0).getStringCellValue();
        data[0][1] = row.getCell(1).getStringCellValue();
        data[0][2] = row.getCell(2).getStringCellValue();
        data[0][3] = row.getCell(3).getStringCellValue();*/
        //data[0][1]=row.getCell(1).getStringCellValue();

        return data;
    }

}
