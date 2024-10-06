package org.batch12;

import org.testng.annotations.*;

public class AnnotationExampleScenario {

    @BeforeSuite
    public void BeforeSuiteExample(){
        System.out.println("Before Suite is printed");
    }

    @AfterSuite
    public void AfterSuiteExample(){
        System.out.println("After Suite is printed");
    }

    @BeforeTest
    public void BeforeTestExample(){
        System.out.println("Before Test is printed");
    }

    @AfterTest
    public void AfterTestExample(){
        System.out.println("After Test is printed");
    }

    @Test
    public void TestOneExample(){
        System.out.println("Test 1 is printed");
    }

    @Test
    public void TestTwoExample(){
        System.out.println("Test 2 is printed");
    }

    @BeforeClass
    public void BeforeClassExample(){
        System.out.println("Before Class is printed");
    }

    @AfterClass
    public void AfterClassExample(){
        System.out.println("After Class is printed");
    }

    @BeforeMethod
    public void BeforeMethodExample(){
        System.out.println("Before Method is printed");
    }

    @AfterMethod
    public void AfterMethodExample(){
        System.out.println("After Method is printed");
    }

}
