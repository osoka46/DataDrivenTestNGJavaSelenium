package testcases;

import base.TestBase;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;

public class HomePageContactHeaderTest extends TestBase {

    @Test(dataProvider = "getContactInfo")
    public void generalEnquiries(String purpose, String firstName, String lastName, String jobTitle, String email, String phone, String company, String position, String country, String message) {

        clickElement(driver, "contactPageHeader_CSS");
        select(driver, "purposeOfContact_CSS", purpose);
        typeText(driver, "firstName_XPATH", firstName);
        typeText(driver, "lastname_XPATH", lastName);
        typeText(driver, "jobTitle_XPATH", jobTitle);
        typeText(driver, "email_XPATH", email);
        typeText(driver, "phoneNumber_XPATH", phone);
        typeText(driver, "companyName_XPATH", company);
        select(driver, "position_XPATH", position);
        select(driver, "country_XPATH", country);
        typeText(driver, "message_XPATH", message);
        clickElement(driver, "iAgree_XPATH");
        clickElement(driver,"submit_XPATH");
        isElementDisplayed(driver,"invalidCaptcha_XPATH");
    }

    @DataProvider
    public Object[][] getContactInfo() {
        Object[][] data;
        String sheetName = "HomePageContactHeaderTest";
        XSSFSheet sheet = excel.getSheetByName(sheetName);
        Iterator<Row> rows = sheet.iterator();
        Row firstRow = rows.next();
        int rowNumber = sheet.getPhysicalNumberOfRows();
        int cellNumber = firstRow.getPhysicalNumberOfCells();
        data = new Object[rowNumber - 1][cellNumber];
        for (int tempA = 0; tempA < rowNumber - 1; tempA++) {
            for (int tempB = 0; tempB < cellNumber; tempB++) {
                data[tempA][tempB] = sheet.getRow(tempA + 1).getCell(tempB).toString();
            }
        }
        return data;
    }


}

