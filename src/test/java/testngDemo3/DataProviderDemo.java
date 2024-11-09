package testngDemo3;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
}
