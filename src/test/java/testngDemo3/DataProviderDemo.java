package testngDemo3;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataProviderDemo {


    @Test(dataProvider = "dp")
    public void testcase1(String userName, String password) {
        System.out.println(userName + "  " + password);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Test(dataProvider = "getDataFromExcelDataProvider")
    public void testcase2(String userName, String password) {
        System.out.println(userName + "  " + password);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @DataProvider(name = "dp")
    public Object[][] dataProviderCredential() {
        String[][] data = {
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"error_user", "secret_sauce"},
                {"visual_user", "secret_sauce"},
        };
        return data;
    }


    @DataProvider(name = "getDataFromExcelDataProvider")
    Object[][] getDataFromExcelDataProvider() {
        String[][] data = getDataForDataProvider();
        return data;
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
