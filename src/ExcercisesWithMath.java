public class ExcercisesWithMath {
    public static void main(String[] args) {
        arithmeticOperations();
        assignmentOperators();
        autoOperatorDemo();
        logicalOperatorDemo();
        comparisaonOperators();
        ternaryOperatorDemo();
        ifStatements();
        nestedIfExample();
        ifElseExample();
        IfElseIfExample();
        switchCaseExample();

    }


    private static void arithmeticOperations() {
        int num1 = 100;
        int num2 = 20;

        System.out.println("num1 + num2: " + (num1 + num2));
        System.out.println("num1 - num2: " + (num1 - num2));
        System.out.println("num1 * num2: " + (num1 * num2));
        System.out.println("num1 / num2: " + (num1 / num2));
        System.out.println("num1 % num2: " + (num1 % num2));
        System.out.println();
        System.out.println();
    }

    private static void assignmentOperators() {

        int num1 = 10;
        int num2 = 20;

        num2 = num1;
        System.out.println("= Output: " + num2);

        num1 = 10;
        num2 = 20;

        num2 += num1;
        System.out.println("+= Output: " + num2);

        num1 = 10;
        num2 = 20;

        num2 -= num1;
        System.out.println("-= Output: " + num2);

        num1 = 10;
        num2 = 20;

        num2 *= num1;
        System.out.println("*= Output: " + num2);

        num1 = 10;
        num2 = 20;

        num2 /= num1;
        System.out.println("/= Output: " + num2);

        num1 = 10;
        num2 = 20;

        num2 %= num1;
        System.out.println("%= Output: " + num2);
        System.out.println();
        System.out.println();
    }

    private static void autoOperatorDemo() {

        int num1 = 100;
        int num2 = 200;

        num1++;
        num2--;
        System.out.println("num1++ is: " + num1);
        System.out.println("num2-- is: " + num2);
        System.out.println();
        System.out.println();
    }

    private static void logicalOperatorDemo() {

        boolean b1 = true;
        boolean b2 = false;

        System.out.println("b1 && b2: " + (b1 && b2));
        System.out.println("b1 || b2: " + (b1 || b2));
        System.out.println("!(b1 && b2): " + !(b1 && b2));

        System.out.println();
        System.out.println();
    }


    private static void comparisaonOperators() {

        System.out.println("==: " + (2 + 1 == 2 + 2)); //False
        System.out.println("==: " + (3 + 1 == 2 + 2)); //True
        System.out.println(">: " + (3 + 2 > 2 + 2)); //True
        System.out.println(">=: " + (5 >= 5)); //True

        System.out.println();
        System.out.println();
    }


    private static void ternaryOperatorDemo() {

        int num1, num2;
        num1 = 25;
        /* num1 is not equal to 10 that's why
         * the second value after colon is assigned
         * to the variable num2
         */
        num2 = (num1 == 10) ? 100 : 200;
        System.out.println("num2: " + num2);

        /* num1 is equal to 25 that's why
         * the first value is assigned
         * to the variable num2
         */
        num2 = (num1 == 25) ? 100 : 200;
        System.out.println("num2: " + num2);

        System.out.println();
        System.out.println();
    }


    private static void ifStatements() {

        int num = 70;

        if (num < 100) {
            System.out.println("The number is less than 100");

            System.out.println();
            System.out.println();
        }
    }


    private static void nestedIfExample() {

        int num = 70;

        if (num < 100) {
            System.out.print(num + " is less than 100");
            if (num > 50) {
                System.out.print(" and greater than 50");
            }
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

    }


    private static void ifElseExample() {

        int num = 120;

        if (num < 50) {
            System.out.println("num is less than 50");
        } else {
            System.out.println("num is greater than or equal to 50");
        }

        System.out.println();
        System.out.println();

    }


    private static void IfElseIfExample() {

        int num = 10000;

        if (num < 100 && num >= 1) {
            System.out.println("It's a two digit number!");
        } else if (num < 1000 && num >= 100) {
            System.out.println("It's a three digit number!");
        } else if (num < 10000 && num >= 1000) {
            System.out.println("It's a four digit number!");
        } else {
            System.out.println("number is not between 1 & 9999");
        }

        System.out.println();
        System.out.println();

    }


    private static void switchCaseExample() {

        int i = 2;

        switch (i) {
            case 1:
                System.out.println("Case1");
                break;
            case 2:
                System.out.println("Case2");
                break;
            case 3:
                System.out.println("Case3");
                break;
            default:
                System.out.println("Default");
        }
    }
}