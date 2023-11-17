package test.java;

import org.testng.annotations.*;

public class TestNGParameters {

    @Parameters({"full-name"})
    @Test
    public void testSingleParameter(String name) {
        System.out.println("My name is " + name);
    }
    @Parameters({"num1", "num2"})
    @Test
    public void testMultiParameters(int num1, int num2) {
        int result = num1 + num2;
        System.out.println(num1 + "+" + num2 + "=" + result);
    }

    @Parameters({"user-name"})
    @Test
    public void testOptionalParameter(@Optional("guest") String user) {
        System.out.println("Welcome " + user);
    }

}
