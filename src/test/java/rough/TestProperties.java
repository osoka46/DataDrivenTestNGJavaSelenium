package rough;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;

public class TestProperties {

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/excel/testdata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//excel dosyasindaki sayfa sayisi
        int sheetCount = workbook.getNumberOfSheets();
//0. indexdeki sayfa
        XSSFSheet sheet = workbook.getSheetAt(0);
//bulunan sayfanin adi
        String sayfa = workbook.getSheetName(0);
//sayfa adindan sayfaya erismek icin atama yaptik
        XSSFSheet sheet1 = workbook.getSheet(sayfa);
//column sayisina falan ulasmak icin row iterate yaptik
        Iterator<Row> rows = sheet.iterator();
        Row firstRow = rows.next();
//herbir row daki kutucuklara ulasmak icin
        Iterator<Cell> cells = firstRow.cellIterator();
//kurucuktaki elemanlar
        Cell cell = cells.next();
        if (cell.getCellType() == CellType.STRING) {
            String text = cell.getStringCellValue();
            System.out.println(text);
        }
        if (cell.getCellType() == CellType.NUMERIC) {
            double value = cell.getNumericCellValue();
            System.out.println(value);

        }
        fis.close();

        Row row=sheet.getRow(1);
        int rowNumber=sheet.getPhysicalNumberOfRows();
        int cellNumber=row.getPhysicalNumberOfCells();


        Object  [][]data=new Object[rowNumber][cellNumber];
        for (int i=0;i<rowNumber;i++)
        {
            for (int k=0;k<cellNumber;k++)
            {
                data[i][k]=row.getCell(k);
                System.out.println(data[i][k]);

            }

        }
        System.out.println("=============");
        System.out.println(data[0][0]);
        System.out.println(data[0][1]);
        System.out.println(data[0][2]);

        //System.out.println(Arrays.deepToString(data));


    }
}
