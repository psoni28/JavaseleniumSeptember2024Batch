package testngDemo4;

import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupDemo {

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("before group method is called");
    }

    @AfterGroups
    public void aftergroup() {
        System.out.println("after group method is called");
    }

    @Test(groups = {"sanity", "smoke"}, enabled = true)
    public void testcase1() {
       // Assert.fail("purposefully failed test case1");
        // Assert.assertTrue(false,"condition for title is not satisfied");
        // Assert.assertEquals("test1", "test2", "this is not matching");
        System.out.println("testcase1 is run");
    }

    @Test(groups = {"sanity", "smoke"}, enabled = true, dependsOnMethods = "testcase1")
    public void testcase2() {
        System.out.println("testcase2 is run");
    }

    @Test(groups = {"regression"}, dependsOnMethods = "testcase2")
    public void testcase3() {
        System.out.println("testcase3 is run");
    }

    @Test(groups = {"sanity", "smoke"}, dependsOnMethods = "testcase3")
    public void testcase4() {
        System.out.println("testcase4 is run");
    }
}
