package org;

import org.testng.annotations.*;

public class HooksExample {

    @BeforeSuite
    public void beforeSuiteMethod()
    {
        System.out.println("Before Suite Method");
    }

    @BeforeClass
    public void beforeClassMethod(){
        System.out.println("Before Class Method");
    }

    @BeforeMethod
    public void beforeMethodMethod(){
        System.out.println("Before Method Method");
    }

    @BeforeTest
    public void beforeTestMethod(){
        System.out.println("Before Test Method");
    }

    @Test
    public void testOne(){
        System.out.println("Test One");
    }

    @Test
    public void testTwo(){
        System.out.println("Test Two");
    }

    @AfterMethod
    public void afterMethodMethod(){
        System.out.println("After Method Method");
    }

    @AfterClass
    public void afterClassMethod(){
        System.out.println("After Class Method");
    }

    @AfterTest
    public void afterTestMethod(){
        System.out.println("After Test Method");
    }

    @AfterSuite
    public void afterSuiteMethod(){
        System.out.println("After Suite Method");
    }
}
