package pitombatech;

// challenge 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MultiplesofaNumber {

	public static void main(String[] args) throws IOException {

		// The name of the file to open.
		String fileName = args[0];


		String line = null;

		FileReader fileReader = new FileReader(fileName);

		// Always wrap FileReader in BufferedReader.
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		while ((line = bufferedReader.readLine()) != null) {
			String[] numbers = line.split(",");
			int x = Integer.valueOf(numbers[0]);
			int n = Integer.valueOf(numbers[1]);
			int result = n;
			int multiplier = 2;
			while(result<x){
				result = n*multiplier;
				multiplier++;
			}
			System.out.println(result);
		}

		bufferedReader.close();

	}

}
