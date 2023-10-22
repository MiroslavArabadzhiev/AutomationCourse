import java.util.Scanner;

public class FizzBuzz {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number: ");
        int number = scanner.nextInt();

// Always put the most specific case on the top and the most generic case on the bottom
        if (number % 5 == 0 && number % 3 ==0)
            System.out.println("FizzBuzz");
        else if (number % 5 == 0)
            System.out.println("Fizz");
        else if (number % 3 ==0)
            System.out.println("Buzz");
        else
            System.out.println("The number " + number + " is not divisible neither by 5, nor by 3");
    }


}
