package testngDemo4;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GroupDemo4 {

    @Test
    public void testcase() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(false);
        softAssert.assertTrue(false);
        softAssert.assertTrue(false);
        softAssert.assertTrue(false);
        softAssert.assertTrue(false);

        softAssert.assertAll();
    }

    @Test
    public void testcaseWithHardAssert() {

        Assert.assertTrue(false);
        Assert.assertTrue(true);
        Assert.assertTrue(true);
        Assert.assertTrue(true);
        Assert.assertTrue(true);

        System.out.println("");
    }
}
