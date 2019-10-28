package main.java.algorithm;


public class PrimeFactor {

    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);

        System.out.print( "Enter a positive integer: ");
        long number = input.nextLong();

        System.out.println("The factors for " + number + " is");
        long factor = 2;
        while (factor <= number) {
            if (number % factor == 0) {
                number = number / factor;
                System.out.print(factor+" fewfefwff");
            } else {
                factor++;
            }
        }

    }
}
