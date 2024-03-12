import java.util.Scanner;
 
	/* 
	* author : roottraveller, nov 4th 2017
	*/
 
public class BaseXtoBaseYConversion {
 
	BaseXtoBaseYConversion() {
	}
 
	public static String convertBaseXtoBaseY(String inputNumber, final int inputBase, final int outputBase) {
		int decimal = baseXToDecimal(inputNumber, inputBase);
		return decimalToBaseY(decimal, outputBase);
	}
 
    private static int baseXNumeric(char input) {
        if (input >= '0' && input <= '9') {
            return Integer.parseInt(input + "");
        } else if (input >= 'a' && input <= 'z') {
            return (input - 'a') + 10;
        } else if (input >= 'A' && input <= 'Z') {
			return (input - 'A') + 10;
		} else {
			return Integer.MIN_VALUE;
		}
    }
 
    public static int baseXToDecimal(String input, final int base) {
		if(input.length() <= 0) {
			return Integer.MIN_VALUE;
		}
 
        int decimalValue = 0;
		int placeValue = 0;
 
        for (int index = input.length() - 1; index >= 0; index--) {
            decimalValue += baseXNumeric(input.charAt(index)) * (Math.pow(base, placeValue));
			placeValue++;
        }
 
        return decimalValue;
    }
 
   private static char baseYCharacter(int input) {
        if (input >= 0 && input <= 9) {
            String str = String.valueOf(input);
            return str.charAt(0);
        } else {
            return  (char) ('a' + (input - 10));
			//return  ('A' + (input - 10));
        }
    }
 
    public static String decimalToBaseY(int input, int base) {
        String result = "";
 
        while (input > 0) {
            int remainder = input % base;
            input = input / base;
            result = baseYCharacter(remainder) + result;  // Important, Notice the reverse order here
        }
 
        return result;
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		System.out.println("Enter : number baseX baseY");
 
		while(true) {
			String inputNumber = scanner.next();
			int inputBase      = scanner.nextInt();
			int outputBase     = scanner.nextInt();
 
			String outputNumber = convertBaseXtoBaseY(inputNumber, inputBase, outputBase);
			System.out.println("Result = " + outputNumber);
		}
    }
}
