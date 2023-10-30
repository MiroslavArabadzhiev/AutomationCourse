public class Methods {
    public static void main(String[] args) {
        printName("Miro");
        printName("Ivan");
        printName("Pesho");
        printNameAge("Miro", 28);
        printNameAge("Ivan", 29);
        printNameAge("Pesho", 30);
        System.out.println(returnSum(2, 3));
        checkAge(20); // Call the checkAge method and pass along an age of 20

        int myNum1 = plusMethod(8, 5);
        double myNum2 = plusMethod(4.3, 6.26);
        System.out.println("int: " + myNum1);
        System.out.println("double: " + myNum2);

        Dog d1 = new Dog();
        d1.displayInfo();

    }

    static void printName(String fname) {
        System.out.println(fname);
    }

    static void printNameAge(String fname, int age) {
        System.out.println(fname + " is " + age);
    }

    static int returnSum(int x, int y) {
        return x + y;
    }

    // Create a checkAge() method with an integer variable called age
    static void checkAge(int age) {
        // If age is less than 18, print "access denied"
        if (age < 18) {
            System.out.println("Access denied - You are not old enough!");
            // If age is greater than 18, print "access granted"
        } else {
            System.out.println("Access granted - You are old enough!");
        }
    }

    static int plusMethod (int x, int y) {
        return x + y;
    }
    static double plusMethod (double x, double y) {
        return x + y;
    }

}
