package Practice.Lecture10;

import org.testng.annotations.Test;

public class PriorityTests {

    @Test(priority = 0)
    public void testPrio3() {
        System.out.println("Priority 3");
    }

    @Test(priority = -1)
    public void testPrio2() {
        System.out.println("Priority 2");
    }

    @Test(priority = 1)
    public void testPrio1() {
        System.out.println("Priority 1");
    }
}
