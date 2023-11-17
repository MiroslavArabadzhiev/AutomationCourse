package Homeworks.Lecture10;

import org.testng.Assert;
import org.testng.annotations.*;

public class Lecture10_HW {

    @DataProvider(name = "numbersAddition")
    public Object[][] numbersAddition() {
        return new Object[][]{{2, 3, 5}, {5, 7, 9}};
    }

    @Test(dataProvider = "numbersAddition", groups = "Smoke Tests")
    public void testAddition (int a, int b, int expectedSum) {
        int sum = a + b;
        Assert.assertEquals(sum, expectedSum);
    }
    @DataProvider(name = "numbersSubtraction")
    public Object[][] numbersSubtraction() {
        return new Object[][]{{10, 8, 2}, {3, 2, 4}};
    }
    @Test(dataProvider = "numbersSubtraction", groups = "Smoke Tests")
    public void testSubtraction (int a, int b, int expectedSum) {
        int sum = a - b;
        Assert.assertEquals(sum, expectedSum);
    }
    @DataProvider(name = "numbersMultiplication")
    public Object[][] numbersMultiplication() {
        return new Object[][]{{2, 3, 6}, {2, 3, 9}};
    }
    @Test(dataProvider = "numbersMultiplication", groups = "Regression Tests")
    public void testMultiplication (int a, int b, int expectedSum) {
        int sum = a * b;
        Assert.assertEquals(sum, expectedSum);
    }
    @DataProvider(name = "numbersDivision")
    public Object[][] numbersDivision() {
        return new Object[][]{{10, 2, 5}, {9, 3, 6}};
    }
    @Test(dataProvider = "numbersDivision", groups = "Regression Tests")
    public void testDivision (int a, int b, int expectedSum) {
        int sum = a / b;
        Assert.assertEquals(sum, expectedSum);
    }
    @DataProvider(name = "numbersModule")
    public Object[][] numbersModule() {
        return new Object[][]{{10, 2, 0}, {9, 2, 0}};
    }
    @Test(dataProvider = "numbersModule", groups = "Regression Tests")
    public void testModule (int a, int b, int expectedSum) {
        int sum = a % b;
        Assert.assertEquals(sum, expectedSum);
    }
}
