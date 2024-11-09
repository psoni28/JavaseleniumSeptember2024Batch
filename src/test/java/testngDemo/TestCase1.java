package testngDemo;

import org.testng.annotations.*;

public class TestCase1 {


    @BeforeSuite
    public void BeforeSuite() {
        System.out.println("BeforeSuite");
    }

    @Test
    public void method1() {
        System.out.println("Test method 1");
    }

    @AfterMethod
    public void AfterMethod() {
        System.out.println("AfterMethod method 1");
    }

    @AfterClass
    public void AfterClass() {
        System.out.println("AfterClass");
    }

    @AfterTest
    public void AfterTest() {
        System.out.println("AfterTest");
    }

    @AfterSuite
    public void AfterSuite() {
        System.out.println("AfterSuite");
    }

    @BeforeTest
    public void BeforeTest() {
        System.out.println("BeforeTest");
    }

    @BeforeClass
    public void BeforeClass() {
        System.out.println("BeforeClass");
    }

    @BeforeMethod
    public void BeforeMethod() {
        System.out.println("BeforeMethod mehtod 1");
    }

}
