package Homeworks.Lecture6_HW;

import java.util.Scanner;
public class Lecture6_HW {
    public static void main(String[] args) {

        System.out.print("Select a Homework to display: ");
        Scanner scanner = new Scanner(System.in);

        String Homeworks = scanner.nextLine();

        switch (Homeworks) {

            case "1" -> System.out.println(findSmallestNumber(2.4, 5.1, 8.3));
            case "2" -> System.out.println(computeAverage(2, 6, 8));
            case "3" -> displayMiddleCharacter("Animal");
            case "4" -> System.out.println(countWords(" Hello To This Awesome World "));

            default -> System.out.println("Invalid task. Please select a valid task.");
        }
    }

    // First Homework - Write a Java method to find the smallest number among three numbers
    private static double findSmallestNumber(double a, double b, double c) {

        double smallestNumber = 0;

        if (a < b && a < c) {
            smallestNumber = a;
        } else if (b < a && b < c) {
            smallestNumber = b;
        } else if (c < a && c < b) {
            smallestNumber = c;
        }
        return smallestNumber;
    }

    // Second Homework - Write a Java method to compute the average of three numbers
    private static double computeAverage(double a, double b, double c) {

        double average = 0;

        average = (a + b + c) / 3;

        return average;
    }

    // Third Homework - Write a Java method to display the middle character of a string
    private static void displayMiddleCharacter(String value) {

        int lenght;
        int position;

        if (value.length() % 2 == 0) {
            position = value.length() / 2 - 1;
            lenght = 2;
        } else {
            position = value.length() / 2;
            lenght = 1;
        }
        System.out.println(value.substring(position, position + lenght));
    }

    // Fourth Homework - Write a Java method to display the middle character of a string
    private static int countWords(String text) {

        String trimmedText = text.trim();
        int counter = 0;
        int textLenght = trimmedText.length();

        if (textLenght > 1) {
            counter++;
            for (int i = 1; i < textLenght; i++) {
                if (trimmedText.charAt(i) == ' ') {
                    counter++;
                }
            }
        }
        return counter;
    }
}
