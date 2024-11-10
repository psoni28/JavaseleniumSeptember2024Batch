package testngDemo4;

import org.testng.annotations.Test;

public class GroupDemo2 {

    @Test(groups = "regression")
    public void testcase5() {
        System.out.println("testcase5 is run");
    }

    @Test(groups = "smoke")
    public void testcase6() {
        System.out.println("testcase6 is run");
    }

    @Test(groups = {"regression","sanity"}, dependsOnGroups = "sanity")
    public void testcase7() {
        System.out.println("testcase7 is run");
    }
    @Test(groups = "smoke")
    public void testcase8() {
        System.out.println("testcase8 is run");
    }
}
