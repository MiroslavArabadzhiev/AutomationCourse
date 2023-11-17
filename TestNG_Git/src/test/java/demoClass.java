import org.testng.annotations.*;

public class demoClass {

    @BeforeSuite(alwaysRun = true)
    public void testBeforeSuite(){
        System.out.println("Before Suite");
    }
    @BeforeTest
    public void testBeforeTest(){
        System.out.println("Before Test");
    }
    @BeforeClass
    public void testBeforeClass(){
        System.out.println("Before Class");
    }
    @BeforeMethod
    public void testBeforeMethod(){
        System.out.println("Before Method");
    }
    @Test
    public void testName1() {
        System.out.println("Hello World!");
    }
    @Test
    public void testName2() {
        System.out.println("Hello World Again!");
    }
    @AfterMethod
    public void testAfterMethod(){
        System.out.println("After Method");
    }
    @AfterClass
    public void testAfterClass(){
        System.out.println("After Class");
    }
    @AfterTest
    public void testAfterTest(){
        System.out.println("After Test");
    }
    @AfterSuite
    public void testAfterSuite(){
        System.out.println("After Suite");
    }
}