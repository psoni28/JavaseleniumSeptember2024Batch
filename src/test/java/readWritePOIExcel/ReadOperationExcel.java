package readWritePOIExcel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadOperationExcel {

    public static void main(String[] args) {

        String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testData.xlsx";
        File file = new File(filePath);
        //xlsx
        //XSSFWorkbook

        //xls
        //HSSFWorkbook
        try {
            FileInputStream fis = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(fis);


            Sheet sheet = workbook.getSheet("Sheet1");

            int totalRows = sheet.getLastRowNum();
            int totalcolumn = sheet.getRow(0).getLastCellNum();


            for (int r = 0; r < totalRows + 1; r++) {
                for (int c = 0; c < totalcolumn; c++) {
                    System.out.print(sheet.getRow(r).getCell(c).getStringCellValue() + " | ");
                }
                System.out.println();
            }
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String[][] getDataForDataProvider() {
        String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testData.xlsx";
        File file = new File(filePath);

        String[][] data = null;

        try {
            FileInputStream fis = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet("Sheet1");
            int totalRows = sheet.getLastRowNum();
            int totalcolumn = sheet.getRow(0).getLastCellNum();

            data = new String[totalRows + 1][totalcolumn];

            for (int r = 0; r < totalRows + 1; r++) {
                for (int c = 0; c < totalcolumn; c++) {
                    data[r][c] = sheet.getRow(r).getCell(c).getStringCellValue();
                }
                System.out.println();
            }
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
