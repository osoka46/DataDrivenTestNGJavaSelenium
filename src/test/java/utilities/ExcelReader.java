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
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Sheet getSheetByName(String sheetName) {

        sheet = workbook.getSheet(sheetName);

        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {


        }
        Row firstRow = rowIterator.next();



      /*  Iterator<Row>rows=sheet.iterator();
        Row firstRow= rows.next();
//herbir row daki kutucuklara ulasmak icin
        Iterator<Cell>cells=firstRow.cellIterator();
//kurucuktaki elemanlar
        Cell cell= cells.next();
//celldeki veriyi stringe cevirdik ama bir sayisal ifade varsa exception atacaktir. o nedenle once kontrol edilmelidir.
        if(cell.getCellType()== CellType.STRING)
        {
            String text=cell.getStringCellValue();
        }
        if(cell.getCellType()==CellType.NUMERIC){
            double value=cell.getNumericCellValue();
        }
    }*/
        return null;

    }
}
