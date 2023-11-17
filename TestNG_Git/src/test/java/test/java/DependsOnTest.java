package test.java;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnTest {

    @Test(dependsOnGroups = "group.dependency")
    public void testDependsOnGroup() {
        System.out.println("This method depends on group.dependency");
    }

    @Test(groups = "group.dependency")
    public void testGroupDependency() {
        System.out.println("This method is part of group.dependency");
        Assert.assertTrue(false);
    }

    @Test(groups = "group.dependency")
    public void testGroupDependency2() {
        System.out.println("This method is part of group.dependency again");
    }

    @Test(dependsOnMethods = "testGroupDependency")
    public void testMethodDependency2() {
        System.out.println("This method will execute if another method succeeds");
    }


}
