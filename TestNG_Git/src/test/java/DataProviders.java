import org.testng.*;
import org.testng.annotations.*;

public class DataProviders {

//    @DataProvider(name = "generateValues")
//    public Object[][] generateValues() {
//        return new Object[][]{{"First-Value"}, {"Second-Value"}, {"Third-Value"}};
//    }
//
//
//    @Test(dataProvider = "generateValues")
//    public void testDataProvider(String val) {
//        System.out.println("Passed Parameter Is : " + val);
//    }
//
//    @Test(dataProvider = "generateValues")
//    public void testDataProvider2(String val) {
//        System.out.println("Passed Parameter Is : " + val);
//    }


    @DataProvider(name = "generateNumbers")
    public Object[][] generateNumbers() {
        return new Object[][]{{2, 3, 5}, {5, 7, 9}};
    }

    @Test(dataProvider = "generateNumbers")
    public void testDataProviderMultipleParameters(int a, int b, int expectedSum) {
        int sum = a + b;
        Assert.assertEquals(sum, expectedSum);
    }
}
