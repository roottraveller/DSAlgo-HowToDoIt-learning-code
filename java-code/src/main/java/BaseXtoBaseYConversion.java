import java.util.Scanner;

public class BaseXtoBaseYConversion {

    public static String convertBaseXtoBaseY(String inputNumber, final int inputBase, final int outputBase) {
        int decimal = baseXToDecimal(inputNumber, inputBase);
        return decimalToBaseY(decimal, outputBase);
    }

    private static int baseXNumeric(char input) {
        if (input >= '0' && input <= '9') {
            return input - '0';
        } else if (input >= 'a' && input <= 'z') {
            return input - 'a' + 10;
        } else if (input >= 'A' && input <= 'Z') {
            return input - 'A' + 10;
        } else {
            return -1; // Invalid input
        }
    }

    public static int baseXToDecimal(String input, final int base) {
        if (input.length() == 0) {
            return -1; // Empty input
        }

        int decimalValue = 0;
        int placeValue = 0;

        for (int index = input.length() - 1; index >= 0; index--) {
            int digitValue = baseXNumeric(input.charAt(index));
            if (digitValue < 0 || digitValue >= base) {
                return -1; // Invalid digit for the base
            }
            decimalValue += digitValue * pow(base, placeValue);
            placeValue++;
        }

        return decimalValue;
    }

    private static int pow(int base, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    private static char baseYCharacter(int input) {
        if (input >= 0 && input <= 9) {
            return (char) (input + '0');
        } else {
            return (char) ('a' + (input - 10));
        }
    }

    public static String decimalToBaseY(int input, int base) {
        if (base < 2 || base > 36) {
            return "Invalid base"; // Base must be between 2 and 36
        }

        StringBuilder result = new StringBuilder();

        while (input > 0) {
            int remainder = input % base;
            input = input / base;
            result.insert(0, baseYCharacter(remainder)); // Insert characters at the beginning for correct order
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter: number baseX baseY");

        while (true) {
            String inputNumber = scanner.next();
            int inputBase = scanner.nextInt();
            int outputBase = scanner.nextInt();

            String outputNumber = convertBaseXtoBaseY(inputNumber, inputBase, outputBase);
            System.out.println("Result = " + outputNumber);
        }
    }
}
