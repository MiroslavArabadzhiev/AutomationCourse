package Homeworks;

import java.util.LinkedList;
import java.util.Scanner;
public class Lecture5_HW {
    public static void main(String[] args) {

        System.out.print("Select a Homework to display: ");
        Scanner scanner = new Scanner(System.in);

        String Homeworks = scanner.nextLine();

        switch (Homeworks) {

            case "1" -> printSum();
            case "2" -> printElementsMatrix();
            case "3" -> printElementsMatrixScanner();
            case "4" -> printLargest();
            case "5" -> reverseLinkedList();
            case "6" -> sumOfDiagonal();
            case "7" -> palindrom();
            default -> System.out.println("Invalid task. Please select a valid task.");
        }
    }

    // First Homework - Print sum of given array elements
    private static void printSum() {

        int[] array = {10,20,30};

        System.out.println(array[0] + array[2]);
    }

    // Second Homework - Print elements of a given 2-d matrix with 4 rows and 3 columns
    private static void printElementsMatrix() {

        int[][] arr = new int[4][3];

        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[0][2] = 3;
        arr[1][0] = 4;
        arr[1][1] = 5;
        arr[1][2] = 6;
        arr[2][0] = 7;
        arr[2][1] = 8;
        arr[2][2] = 9;
        arr[3][0] = 10;
        arr[3][1] = 11;
        arr[3][2] = 12;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }

    // Third Homework - Print elements of a given 2-d matrix with dynamic rows and columns taken from user input
    private static void printElementsMatrixScanner() {

        //Get the value of the rows

        System.out.print("Rows: ");
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();

        //Get the value of the columns

        System.out.print("Columns: ");
        scanner = new Scanner(System.in);
        int columns = scanner.nextInt();

        //Checks if the matrix has any input
        if (rows == 0 && columns == 0)
            System.out.println("The matrix has no rows and no columns!");

        int[][] matrix = new int[rows][columns];

        int n = 0;

        //Populates the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = n;
                n++;
            }
        }

        //Prints the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }

    // Fourth Homework - Find the biggest element of an array and print it in the console
    private static void printLargest() {

        int [] arr = {20, 30, 25, 44, 33, 12, 31, 3};

        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        System.out.println("The largest number is: " + max);
    }

    // Fifth Homework - Reverse the order of the elements in a LinkedList using algorithm
    private static void reverseLinkedList() {

        LinkedList<String> cars = new LinkedList<String>();
        LinkedList<String> carsReversed = new LinkedList<String>();

        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");

        System.out.println("Elements before reversing: " + cars);

        for (int i = cars.size() - 1; i >= 0; i--) {
            carsReversed.add(cars.get(i));
        }
        System.out.println("Elements after reversing: " + carsReversed);
    }

    // Sixth Homework - Find sum of the diagonal of a given 2d matrix with 4 rows and 4 columns
    private static void sumOfDiagonal() {

        int[][] arr = new int[4][4];

        arr[0][0] = 1; // Main 1
        arr[0][1] = 2;
        arr[0][2] = 3;
        arr[0][3] = 2; // Secondary 4
        arr[1][0] = 4;
        arr[1][1] = 2; // Main 2
        arr[1][2] = 5; // Secondary 3
        arr[1][3] = 6;
        arr[2][0] = 7;
        arr[2][1] = 3; // Secondary 2
        arr[2][2] = 3; // Main 3
        arr[2][3] = 9;
        arr[3][0] = 10; // Secondary 1
        arr[3][1] = 11;
        arr[3][2] = 12;
        arr[3][3] = 4; // Main 4

        int sumMain = 0;
        int sumSecondary = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // Check for main diagonal element
                if (i == j) {
                    sumMain += arr[i][j];
                }

                // Check for secondary diagonal element
                if (i + j == arr.length - 1) {
                    sumSecondary += arr[i][j];
                }
            }
        }
        System.out.println("The sum of the Main diagonal is: " + sumMain);
        System.out.println("The sum of the Secondary diagonal is: " + sumSecondary);
    }

    // Seventh Homework - Write a program which validate whether given string is palindrome
    private static void palindrom() {

        //Get the value of the rows

        System.out.print("Word: ");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        boolean flag = true;

        //Converts the given string into lowercase
        word = word.toLowerCase();

        //Iterate the string forward and backward, compare one character at a time until middle of the string is reached
        for (int i = 0; i < word.length()/2; i++) {
            if (word.charAt(i) != word.charAt(word.length()-i-1)) {
                flag = false;
                break;
            }
        }
        if (flag)
            System.out.println("The word is a palindrome");
        else
            System.out.println("The word is a not palindrome");
    }
}