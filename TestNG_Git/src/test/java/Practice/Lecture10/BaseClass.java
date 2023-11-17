package Practice.Lecture10;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class BaseClass {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Practice.Lecture10.BaseClass's Before Test method");
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("Practice.Lecture10.BaseClass's After Test method");
    }
    @BeforeClass
    public void beforeClass() {
        System.out.println("Practice.Lecture10.BaseClass's Before Class method");
    }

    @Test
    public void testName() {
        System.out.println("Practice.Lecture10.BaseClass's Test method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Practice.Lecture10.BaseClass's After Class method");
    }

    public static class AssertionTests {

        @Test
        public void testHardAssert() {
            Assert.assertTrue(3>2);
            Assert.assertEquals("Text","Text1");
        }

        @Test
        public void testSoftAssert() {
            SoftAssert soft = new SoftAssert();

            soft.assertTrue(5==5);

            soft.assertTrue(5==6);

            soft.assertTrue(4==4);

            soft.assertAll();
        }
    }
}
