package readWritePOIExcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class WriteDataToExcel {

    public static void main(String args[]) {

        String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testData.xlsx";

        String[] data = {"user7", "pass7"};

        File file = new File(filePath);
        try {
            FileInputStream fis = new FileInputStream(file);

            Workbook workbook = new XSSFWorkbook(fis);

            Sheet sheet = workbook.getSheet("Sheet1");

            int totalRows = sheet.getLastRowNum();
            int totalColumn = sheet.getRow(0).getLastCellNum();

            Row newRow = sheet.createRow(totalRows + 1);
            for (int c = 0; c < totalColumn; c++) {
                Cell cell = newRow.createCell(c);
                cell.setCellValue(data[c]);
            }
            fis.close();

            FileOutputStream fos = new FileOutputStream(file);
            workbook.write(fos);
            fos.close();

            System.out.println("File data is successfully added");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
