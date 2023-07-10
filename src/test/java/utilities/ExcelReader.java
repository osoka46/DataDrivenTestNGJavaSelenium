package utilities;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;


public class ExcelReader {
    public String path;
    public FileInputStream fis = null;
    public FileOutputStream out = null;
    private XSSFWorkbook workbook = null;
    private XSSFSheet sheet = null;
    private XSSFRow row = null;
    private XSSFCell cell = null;

    public ExcelReader(String path) {
        this.path = path;
        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public XSSFSheet getSheetByName(String sheetName) {
        sheet = workbook.getSheet(sheetName);
        return sheet;
    }

    public Row getRowByIndex(XSSFSheet sheet,int index)
    {
        Iterator<Row> rows=sheet.iterator();
        while (rows.hasNext()&&index+1>0)
        {
            index--;
            Row row=rows.next();
        }
        return row;
    }
}
