package edu.dashasutunkina;

import java.math.BigInteger;
import java.util.Scanner;

public class factorial {

    public static final int MAX_ALLOWED_INPUT = 200;

    public static void main(String[] args) {
        System.out.printf("Enter number for factorial calculation (less than %s): ", MAX_ALLOWED_INPUT);
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        BigInteger result;
        try {
            result = factorialRecursion(number);
//            result = factorialWithForLoop(number);
            System.out.printf("Result of %s factorial = %s%n", number, result);
        } catch (RuntimeException e) {
            System.out.printf("Result of %s factorial is not possible to " +
                    "calculate due to a violation of max allowed value %s.%n", number, MAX_ALLOWED_INPUT);
        }
    }

    public static BigInteger factorialWithForLoop(int number) throws RuntimeException {
        checkInputForMaximumValueAndThrowExceptionIfHigher(number);
        BigInteger result = BigInteger.valueOf(1);
        for (BigInteger bi = result; bi.compareTo(BigInteger.valueOf(number)) <= 0; bi = bi.add(BigInteger.valueOf(1))) {
            result = result.multiply(bi);
        }
        return result;
    }

    public static BigInteger factorialRecursion(int number) {
        checkInputForMaximumValueAndThrowExceptionIfHigher(number);
        BigInteger result = BigInteger.valueOf(1);
        if (number == 1) {
            return result;
        }
        return factorialRecursion(number -1).multiply(BigInteger.valueOf(number));
    }

    private static void checkInputForMaximumValueAndThrowExceptionIfHigher(int number) {
        if (number > MAX_ALLOWED_INPUT) {
            throw new RuntimeException("Please use number less than " + MAX_ALLOWED_INPUT);
        }
    }
}