package testcases;

import base.TestBase;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCustomerTest extends TestBase {

    @Test()
    public void addCustomer() {

        String firstName = "osman";
        String lastName = "bzd";
        String postCode = "123";
        String confirmation = "Customer added successfully";
        Alert alert;

        driver.findElement(By.cssSelector(or.getProperty("addCustomerBtn"))).click();
        driver.findElement(By.cssSelector(or.getProperty("firstName"))).sendKeys(firstName);
        driver.findElement(By.cssSelector(or.getProperty("lastName"))).sendKeys(lastName);
        driver.findElement(By.cssSelector(or.getProperty("postCode"))).sendKeys(postCode);
        driver.findElement(By.cssSelector(or.getProperty("addBtn"))).click();
        expectedWait(driver, 2);
        alert=driver.switchTo().alert();
        String confirm = alert.getText();
        alert.accept();
        Assert.assertTrue(confirm.contains(confirmation));
    }

    @DataProvider
    public Object[][] getData() {

        Sheet sheet = excel.getSheetByName("AddCustomerTest");
        Row row = sheet.getRow(1);
        int rowNumber = sheet.getPhysicalNumberOfRows();
        int cellNumber = row.getPhysicalNumberOfCells();

        Object[][] data = new Object[1][4];
        data[0][0] = row.getCell(0).getStringCellValue();
        data[0][1] = row.getCell(1).getStringCellValue();

        data[0][2] = row.getCell(2).getStringCellValue();
        data[0][3] = row.getCell(3).getStringCellValue();
        //data[0][1]=row.getCell(1).getStringCellValue();

        return data;
    }

}
