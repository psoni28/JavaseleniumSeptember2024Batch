package testngDemo4;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDemo3 {

    @Test(invocationCount = 10)
    public void testcase9() {
        System.out.println("testcase9 is run");
    }
}
