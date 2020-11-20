package ua.ithlillel.dnipro.Cherednychenko;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {
    static int number;
    static int DIGITQUANTITY = 4;

    public static void main(String[] args) {
        // write your code here
        System.out.println("Program that counts total amount of digits");
        System.out.println("============================================\n");

        System.out.println("Please enter number that includes " + DIGITQUANTITY + " digits: ");
        number = getNumber();

        System.out.println("The total amount of all digits is " + countDigitAmount(number));
    }

    private static int countDigitAmount(int number) {
        int[] inputArray = convertInputArray(number);
        int digitAmount = 0;
        for (int i = 0; i < inputArray.length; i++) {
            digitAmount = digitAmount + inputArray[i];
        }
        return digitAmount;
    }


    private static int getNumber() {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        while (!sc.hasNextInt()) {
            System.out.println("Incorrect input! Please enter digits: ");
            result = sc.nextInt();
        }
        result = sc.nextInt();
        if (DIGITQUANTITY != 0 && ((int) (result / Math.pow(10, DIGITQUANTITY)) > 1 & (int) (result / Math.pow(10, DIGITQUANTITY - 1)) > 10)) {
            System.out.println("Incorrect input! Please enter number that includes " + DIGITQUANTITY + " digits: ");
            getNumber();
        }
        return result;
    }

    private static int[] convertInputArray(int input) {

        int[] convertedInputIntArray = new int[DIGITQUANTITY];
        int rate = DIGITQUANTITY;
        try {

            for (int i = 0; i < DIGITQUANTITY; i++) {
                if (rate > 1) {
                    convertedInputIntArray[i] = (int) (input / Math.pow(10, rate - 1));
                    input = (int) (input - convertedInputIntArray[i] * Math.pow(10, rate - 1));
                    rate = rate - 1;
                } else {
                    convertedInputIntArray[i] = input;
                }
            }
        } catch (Exception e) {

        }
        return convertedInputIntArray;
    }
}
