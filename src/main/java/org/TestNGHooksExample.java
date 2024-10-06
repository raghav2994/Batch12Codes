package org;

import org.testng.annotations.*;

public class TestNGHooksExample {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite Hook");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite Hook");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test Hook");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test Hook");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class Hook");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class Hook");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method Hook");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method Hook");
    }

    @Test(alwaysRun = false)
    public void testMethod() {
        System.out.println("Test Method");
    }

    @Test
    public void testMethod2() {
        System.out.println("Test Method 2");
    }
}
