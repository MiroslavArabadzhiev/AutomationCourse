package Homeworks;

import java.util.Locale;
import java.util.Scanner;
import java.text.NumberFormat;

public class Lecture4_HW {
        public static void main(String[] args) {

            System.out.print("Select a Homework to display: ");
            Scanner scanner = new Scanner(System.in);
            String Homeworks = scanner.nextLine();

            switch (Homeworks) {

                case "1" -> slide30();
                case "2" -> HW1();
                case "3" -> HW2();
                case "4" -> HW3();
                case "5" -> HW4();
                case "6" -> HW5();
                case "7" -> HW6();
                case "8" -> HW7();

                default -> System.out.println("Invalid task. Please select a valid task.");
            }
        }

    // The exercise from slide 30 of the Lecture
    private static void slide30() {

        //Get the value of a

        System.out.print("a: ");
        Scanner scanner = new Scanner(System.in);
        float a = Float.parseFloat(scanner.nextLine());

        //Get the value of b

        System.out.print("b: ");
        scanner = new Scanner(System.in);
        float b = Float.parseFloat(scanner.nextLine());

        //Get the value of c

        System.out.print("c: ");
        scanner = new Scanner(System.in);
        float c = Float.parseFloat(scanner.nextLine());

        //Calculate if a triangle can be formed and which one

        if (a + b + c != 180)
            System.out.println("Невалиден триъгълник! Сборът от ъглите трябва да е 180 градуса!");
        else {
            if (a == 60 && b == 60 && c == 60)
                System.out.println("Браво! Вие създадохте равностранен триъгълник!");
            else if (a == b || a == c || b == c)
                System.out.println("Браво! Вие създадохте равнобедрен триъгълник!");
            else if (a < 90 && b < 90 && c < 90)
                System.out.println("Браво! Вие създадохте остроъгълен триъгълник!");
            else if (a == 90 || b == 90 || c == 90)
                System.out.println("Браво! Вие създадохте правоъгълен триъгълник!");
            else if (a > 90 || b > 90 || c > 90)
                System.out.println("Браво! Вие създадохте тъпоъгълен триъгълник!");
            else
                System.out.println("Браво! Вие създадохте разностранен триъгълник!");
        }
    }


    // Exercise 1 - Print the days of the week based on the user digit 1-7 input
    private static void HW1() {

        //Get the user digit

        System.out.print("Please select a number from 1 to 7: ");
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        switch (number) {

            case 1 -> System.out.println("The " + number + "st day of the week is Monday");
            case 2 -> System.out.println("The " + number + "nd day of the week is Tuesday");
            case 3 -> System.out.println("The " + number + "rd day of the week is Wednesday");
            case 4 -> System.out.println("The " + number + "th day of the week is Thursday");
            case 5 -> System.out.println("The " + number + "th day of the week is Friday");
            case 6 -> System.out.println("The " + number + "th day of the week is Saturday");
            case 7 -> System.out.println("The " + number + "th day of the week is Sunday");

            default -> System.out.println("This is not a number from 1 to 7!");

        }
    }


    // Exercise 2 - Eligible for work based on age
    private static void HW2() {

        //Get the user's age

        System.out.print("Enter your age: ");
        Scanner scanner = new Scanner(System.in);
        int age = Integer.parseInt(scanner.nextLine());

        if (age >= 16)
            System.out.println("You are eligible to work.");
        else
            System.out.println("You are not eligible to work.");

        }


    // Exercise 3 - Calculate Revenue
    private static void HW3() {

        //Get the unit price

        System.out.print("Enter unit price: ");
        Scanner scanner = new Scanner(System.in);
        float unitPrice = Float.parseFloat(scanner.nextLine());

        //Get the quantity

        System.out.print("Enter quantity: ");
        scanner = new Scanner(System.in);
        int quantity = Integer.parseInt(scanner.nextLine());

        //Calculate the Revenue

        float revenue = quantity * unitPrice;

        // Apply the discount

        if (quantity >= 100 && quantity <= 120) {

            float discount = (float) (revenue * 0.15);
            revenue = (float) (revenue * 0.85);

            System.out.println("The revenue from sale: " + NumberFormat.getCurrencyInstance(Locale.US).format(revenue));
            System.out.print("Discount: " + NumberFormat.getCurrencyInstance(Locale.US).format(discount));
            System.out.print(" (15%)");
        }
        else if (quantity > 120) {

            float discount = (float) (revenue * 0.15);
            revenue = (float) (revenue * 0.80);

            System.out.println("The revenue from sale: " + NumberFormat.getCurrencyInstance(Locale.US).format(revenue));
            System.out.print("Discount: " + NumberFormat.getCurrencyInstance(Locale.US).format(discount));
            System.out.print(" (20%)");
        }
    }


    // Exercise 4 - The largest number in an array
    private static void HW4() {

        int arr[] = {2,11,45,9};

        int max = arr[0];

        for (int i=0; i<arr.length; i++)
        {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.print("The largest number is: " + max);
    }


    // Exercise 5 - The best vacation
    private static void HW5() {

        //Beach or Mountain

        System.out.print("Where would you like to go? Please type Beach or Mountain: ");
        Scanner scanner = new Scanner(System.in);
        String beachMountain = scanner.nextLine();

        //Budget

        System.out.print("Budget per person per day: ");
        scanner = new Scanner(System.in);
        int budget = Integer.parseInt(scanner.nextLine());

        //Destination

        if (beachMountain.equals("Beach") && budget < 50)
            System.out.println("The best destination for you is Bulgaria.");
        else {
            if (beachMountain.equals("Beach") && budget >= 50)
                System.out.println("The best destination for you is outside Bulgaria.");
            else if (beachMountain.equals("Mountain") && budget < 30)
                System.out.println("The best destination for you is Bulgaria.");
            else if (beachMountain.equals("Mountain") && budget >= 30)
                System.out.println("The best destination for you is outside Bulgaria.");
            else
                System.out.println("There is no information about this type of vacation.");
        }
    }


    // Exercise 6 - Numbers divisible by 5
    private static void HW6() {

        int arr[] = {12, 15, 32, 42, 55, 75, 122, 132, 150, 180, 200};

        for (int i=0; i<arr.length; i++)
        {
            if (arr[i] % 5 == 0 && arr[i] < 150)
                System.out.println(arr[i]);
            else if (arr[i] > 150)
                break;
        }
    }


    // Exercise 7 - Reverse the list
    private static void HW7() {

        int arr[] = {10, 20, 30, 40, 50};

        for (int i=arr.length - 1; i > -1; i--)
                System.out.println(arr[i]);
    }
}