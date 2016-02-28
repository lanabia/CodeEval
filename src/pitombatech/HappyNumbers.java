package pitombatech;

// challenge HAPPY NUMBERS

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HappyNumbers {

	public static void main(String[] args) throws IOException {

		String fileName = args[0];

		String line = null;
		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		while ((line = bufferedReader.readLine()) != null) {
			int number = Integer.valueOf(line);
			System.out.println(verifyHappyNumber(number));

		}

		bufferedReader.close();

	}

	public static int verifyHappyNumber(int number) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		int newNumber = number;
		while (number > 0) {
			results.add(newNumber);
			int sum = sumSquareDigits(newNumber);
			// System.out.println(sum);
			if (sum == 1) // happy number return 1
				return 1;
			if (results.contains(sum))
				return 0;

			newNumber = sum;
		}
		return 0;
	}

	public static int sumSquareDigits(int x) {
		int aux = x;
		int sum = 0;
		while (aux >= 10) {
			sum = (int) (sum + Math.pow(aux % 10, 2));
			aux = (aux - (aux % 10)) / 10;
		}
		sum = (int) (sum + Math.pow(aux % 10, 2));
		aux = (aux - (aux % 10)) / 10;
		return sum;
	}

}
