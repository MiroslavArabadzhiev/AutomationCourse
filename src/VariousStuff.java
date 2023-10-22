import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class VariousStuff {

    public static void main (String[] args) {

        String [] fruits = {"Banana", "Mango", "Orange"};

        for (int i = 0; i < fruits.length; i++)
            System.out.println(fruits[i]);

        for (String fruit : fruits)
            System.out.println(fruit);

    }


    public static class Various {

        public static void main (String [] args) {
            byte age = 30;
            long viewCount = 3_123_456_789L;
            float price = 10.99F;
            char letter = 'A';
            boolean isEligible = false;
            Date now = new Date();

            String message = "Hello \"World\"";
            String newLine = "\nThe message";
            String tab = "\n\tThe tab message";

            int[] numbers = {2, 3, 5, 1, 4};

            int[][] numbersArray = { {1,2,3}, {4,5,6} };

            Arrays.sort(numbers);

            //System.out.println(Arrays.deepToString(numbersArray));

            //Constant
            final float pi = 3.14F;

            String x = "1";
            int y = Integer.parseInt(x) + 2;

            int result = (int) Math.round(Math.random() * 100);

            String result1 =  NumberFormat.getPercentInstance().format(0.1);


            //Scanner scanner = new Scanner(System.in);
            //System.out.print("Name: ");
            //String name = scanner.nextLine().trim();

            // System.out.println("You are " + name);


            //int temperature = 12;
            //boolean booleanResult = temperature > 20 && temperature < 30;
            // System.out.println(booleanResult);


            boolean hasHighIncome  = true;
            boolean hasGoodCredit = true;
            boolean hasCriminalRecord = true;
            boolean isEligible1  = (hasHighIncome || hasGoodCredit) && !hasCriminalRecord;
            //System.out.println(isEligible1);






            //int income = 120_000;
            //String className = income > 100_000 ? "First" : "Economy" ;
            //System.out.println(className);


            String role = "admin";

            switch (role) {
                case "admin":
            //        System.out.println("You are an admin");
                    break;

                case "moderator":
            //        System.out.println("You are a moderator");
                    break;

                default:
            //        System.out.println("You are a guest");
                    break;
            }



            //for (int i = 0; i < 5; i++)
            //    System.out.println("Hello World");


            Scanner scanner = new Scanner(System.in);
            String input = "";
            //while (true) {
            //    System.out.print("Input: ");
            //    input = scanner.next().toLowerCase();
            //    if (input.equals("pass"))
            //        continue;
            //    if (input.equals("quit"))
            //        break;
            //    System.out.println(input);
            }

            //do {
            //    System.out.print("Input: ");
            //    input = scanner.next().toLowerCase();
            //    System.out.println(input);
            //} while (!input.equals("quit"));


        }
}
