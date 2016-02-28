package pitombatech;

// challenge Fizz Buzz

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FizzBuzz {

	public static void main(String[] args) throws IOException {

		// The name of the file to open.
		String fileName = args[0];
		int numberOfTestCases = 0;

		// This will reference one line at a time
		String line = null;

		FileReader fileReader = new FileReader(fileName);

		// Always wrap FileReader in BufferedReader.
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		while ((line = bufferedReader.readLine()) != null) {

			String[] result = line.split("\\s+");
			int firstDivisor = Integer.valueOf(result[0]); // F
			int secondDivisor = Integer.valueOf(result[1]); // B
			int count = Integer.valueOf(result[2]);

			if (numberOfTestCases >= 20 || firstDivisor < 1 || firstDivisor > 20 || secondDivisor < 1
					|| secondDivisor > 20 || count < 21 || count > 100)
				break;

			if (numberOfTestCases != 0)
				System.out.println("");

			for (int i = 1; i <= count; i++) {

				if (i % firstDivisor == 0 && i >= firstDivisor) {
					System.out.print("F");
					if (i % secondDivisor == 0 && i >= secondDivisor)
						System.out.print("B");
				} else if (i % secondDivisor == 0 && i >= secondDivisor)
					System.out.print("B");
				else
					System.out.print(String.valueOf(i));
				if (i != count)
					System.out.print(" ");
			}

			numberOfTestCases++;
		}

		bufferedReader.close();

	}

}
