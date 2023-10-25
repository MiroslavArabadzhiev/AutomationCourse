package Homeworks;// First Homework - Store your names in 3 different variables and print your whole name


import java.util.Scanner;

public class Lecture2_HW {
    public static void main(String[] args) {

        System.out.print("Select a Homework to display: ");
        Scanner scanner = new Scanner(System.in);

        String Homeworks = scanner.nextLine();

        switch (Homeworks) {

            case "1" -> printName();
            case "2" -> printTrianglePerimeter();
            case "3" -> printTriangleArea();
            case "4" -> printPineTree();
            case "5" -> printTrianglePerimeterScanner();
            case "6" -> printTriangleAreaScanner();
            case "7" -> CalculateDays();
            default -> System.out.println("Invalid task. Please select a valid task.");
        }

    }


    // First Homework - Store your names in 3 different variables and print your whole name
    private static void printName() {

        String FirstName = "Miroslav";
        String MiddleName = "Rumenov";
        String LastName = "Arabadzhiev";

        String fullName = FirstName + " " + MiddleName + " " + LastName;

        System.out.println("Homeworks.HW1: " + " " + fullName);

    }




    // Second Homework - Print the perimeter of a triangle by given sides. Use formula to calculate it
    private static void printTrianglePerimeter(){

        float a = 5.3F;
        float b = 4.2F;
        float c = 3.14F;


        float perimeter = a + b + c;

        System.out.println("HW2: " + " " + perimeter);
    }




    // Third Homework - Print the area of a triangle by given sides. Use formula to calculate it
    private static void printTriangleArea(){

        float a = 5.1F;
        float h = 2.4F;


        float area = (a * h) / 2;

        System.out.println("HW3: " + " " + area);
    }




    // Forth Homework - Print pine tree using asterisks in the console
    private static void printPineTree(){

        System.out.println("HW4: ");

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10 - i; j++)
                System.out.print(" ");
            for (int k = 0; k < (2 * i + 1); k++)
                System.out.print("*");

            System.out.println();
        }
    }




    // Fifth Homework - Using Java input (Scanner) fine tune tasks 2 and 3
    private static void printTrianglePerimeterScanner(){


        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter a: ");
        float a1 = Float.parseFloat(myObj.nextLine());

        System.out.println("Enter b: ");
        float b1 = Float.parseFloat(myObj.nextLine());

        System.out.println("Enter c: ");
        float c1 = Float.parseFloat(myObj.nextLine());


        float perimeter = a1 + b1 + c1;

        System.out.println("HW5 Perimeter: " + " " + perimeter);
    }


    private static void printTriangleAreaScanner(){


        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter a: ");
        float a2 = Float.parseFloat(myObj.nextLine());

        System.out.println("Enter h: ");
        float h2 = Float.parseFloat(myObj.nextLine());


        float area = (a2 * h2) / 2;

        System.out.println("HW5 Area: " + " " + area);

    }



    // Sixth Homework - Calculate years, days and hours based on minutes inputted
    private static void CalculateDays(){

        double minutesInYear = 60 * 24 * 365;

        Scanner input = new Scanner(System.in);

        System.out.print("Input the number of minutes: ");

        double min = input.nextDouble();

        long years = (long) (min / minutesInYear);
        int days = (int) (min / 60 / 24) % 365;
        int hours = (int) (min / 60 ) % 365;

        System.out.println((int) min + " minutes is approximately " + years + " years, " + days + " days and " + hours + " hours");
    }
}