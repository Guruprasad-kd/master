import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the principal:");
        int principal = scanner.nextInt();

        System.out.println("Enter the annual interest rate:");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        System.out.println("Enter the period (in years):");
        int years = scanner.nextInt();
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        Locale locale = new Locale("en","us");
        String mortgageFormatted = NumberFormat.getCurrencyInstance(locale).format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}
