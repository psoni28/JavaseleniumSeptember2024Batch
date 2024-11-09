package testngDemo;

import org.testng.annotations.*;

public class TestCase2 {

    @Test
    public void method2() {
        System.out.println("Test method 2");
    }

    @AfterMethod
    public void AfterMethod() {
        System.out.println("AfterMethod method2");
    }

    @BeforeMethod
    public void BeforeMethod() {
        System.out.println("BeforeMethod method2");
    }


    @BeforeClass
    public void BeforeClass() {
        System.out.println("BeforeClass");
    }


    @AfterClass
    public void AfterClass() {
        System.out.println("AfterClass");
    }


}
