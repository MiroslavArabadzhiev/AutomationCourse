package test.java;

import org.testng.annotations.*;

public class ChildClass extends BaseClass {
    @BeforeMethod
    public void beforeChildMethod() {
        System.out.println("ChildClass's Before Test method");
    }
    @AfterMethod
    public void afterChildMethod() {
        System.out.println("ChildClass's After Test method");
    }
    @BeforeClass
    public void beforeChildClass() {
        System.out.println("ChildClass's Before Class method");
    }
    @AfterClass
    public void afterChildClass() {
        System.out.println("ChildClass's After Class method");
    }
    @Test
    public void testCase() {
        System.out.println("===== Executing actual test ======");
    }
}