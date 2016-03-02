package pitombatech;

// challenge UGLY NUMBERS

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Main {

	static int lenght;
	static int count = 0;
	static int quantityOfUglyStrings = 0;


	public static void main(String[] args) throws IOException {

		// The name of the file to open.
		String fileName = args[0];

		String line = null;

		FileReader fileReader = new FileReader(fileName);

		// Always wrap FileReader in BufferedReader.
		BufferedReader bufferedReader = new BufferedReader(fileReader);


		while ((line = bufferedReader.readLine()) != null) {

			String s = line;
			lenght = line.length();

			int result = howManyUglyCombinations(s);
			System.out.println(result);

			count = 0;
			quantityOfUglyStrings = 0;

		}
		bufferedReader.close();

	}

	public static boolean isUgly(long number) {
		if (number % 2 == 0 || number % 3 == 0 || number % 5 == 0 || number % 7 == 0 || number == 0)
			return true;

		return false;
	}

	public static int howManyUglyCombinations(String s) {
		if (s.length() == 0)
			return 0;
		else if (s.length() == 1) {
			if (isUgly(Integer.valueOf(s)))
				return 1;
			else
				return 0;
		} else {

			// calcular quantas combinaes
			countStrings(s);
			return quantityOfUglyStrings;

		}

	}

	public static void countStrings(String s) {
		count = numberOfSigns(s) + 1;
		// System.out.println("lenght=" + lenght + " count=" + count);

		if (count == lenght) {
			String out = s;
			long number;
			if (numberOfSigns(out) == 0)
				number = Long.valueOf(out);
			else
				number = convertStringToExpression(out);

			// System.out.println("s: "+ out+ " = "+(int) engine.eval(out));
			if (isUgly(number)) {
				quantityOfUglyStrings = quantityOfUglyStrings + 1;
			}
			return;
		}

		countStrings(addSign(s, '+', 2 * count));
		count = numberOfSigns(s) + 1;
		countStrings(addSign(s, '-', 2 * count));
		count = numberOfSigns(s) + 1;
		countStrings(addSign(s, ' ', 2 * count));

	}

	public static String addSign(String s, char c, int position) {
		// System.out.println("dividir em " + position + ": " + s);
		return s.substring(0, position - 1) + c + s.substring(position - 1, s.length());

	}

	public static int numberOfSigns(String s) {
		int quantity = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == ' ')
				quantity++;
		}
		return quantity;
	}

	public static long convertStringToExpression(String exp) {
		long result = 0;
		exp = exp.replaceAll("\\s+", "");
		
		String[] parts = exp.split(Pattern.quote("+"));
		for (int i = 0; i < parts.length; i++) {

			if (numberOfSigns(parts[i]) >= 1) {
				String[] partsNegative = parts[i].split(Pattern.quote("-"));
				for (int a = 0; a < partsNegative.length; a++) {
					if (a == 0)
						result = result + Long.valueOf(partsNegative[a]);
					else
						result = result - Long.valueOf(partsNegative[a]);
				}
			} else
				result = result + Long.valueOf(parts[i]);
		}
		
		return result;
	}

}
