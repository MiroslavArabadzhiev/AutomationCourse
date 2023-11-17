import org.testng.annotations.Test;

public class GroupTest {

    @Test(groups = "Smoke")
    public void testSmokeGroup1(){
    }

    @Test(groups = "Smoke")
    public void testSmokeGroup2() {
    }

    @Test(groups = "Regression")
    public void testRegressionGroup1(){
    }

    @Test(groups = "Regression")
    public void testRegressionGroup2() {
    }

    @Test(groups = {"Regression","Smoke"})
    public void testSmokeRegression() {
    }
}
