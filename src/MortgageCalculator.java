import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;


public class MortgageCalculator {

    public static void main (String [] args) {

        final byte monthsInYear = 12;
        final byte percentage = 100;

        int principal = 0;
        float monthlyInterestRate = 0;
        int numberOfPayments= 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Please enter a value between $1,000 and $1,000,000");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterestRate = scanner.nextFloat();
            if (annualInterestRate >= 1 && annualInterestRate <= 30) {
                monthlyInterestRate = annualInterestRate / monthsInYear / percentage;
                break;
            }
            System.out.println("Please enter a value between 1 and 30");
        }

        while (true) {
            System.out.print("Period (Years): ");
            byte period = scanner.nextByte();
            if (period >= 1 && period <= 30) {
                numberOfPayments = period * monthsInYear;
                break;
            }
            System.out.println("Please enter a value between 1 and 30");
        }

        double mortgageMonthlyPayment = principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        String mortgageMonthlyPaymentFormatted = NumberFormat.getCurrencyInstance(Locale.US).format(mortgageMonthlyPayment);

        System.out.println("Monthly Mortgage Payment: " + mortgageMonthlyPaymentFormatted);
    }
}