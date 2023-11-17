package test.java;

import org.testng.annotations.Test;

import java.io.IOException;

public class ExceptionsTestNG {

    @Test(expectedExceptions = RuntimeException.class)
    public void testExcept1() {
        System.out.println("Exception Test 1");
        throw new RuntimeException("Pass");
    }

    @Test(expectedExceptions = IOException.class)
    public void testExcept2() {
        System.out.println("Exception Test 2");
        throw new RuntimeException("Fail");
    }

    @Test(expectedExceptions = {IOException.class, RuntimeException.class})
    public void testExcept3() {
        System.out.println("Exception Test 3");
        throw new RuntimeException("Fail");
    }

}
