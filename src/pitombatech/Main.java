package pitombatech;

// challenge 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		// The name of the file to open.
		String fileName = args[0];

		String line = null;

		FileReader fileReader = new FileReader(fileName);

		// Always wrap FileReader in BufferedReader.
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		double pi = pi();

		while ((line = bufferedReader.readLine()) != null) {
			int n = Integer.valueOf(line);

		}

		bufferedReader.close();

	}

	static public double pi() {
		
		double pi = 3;
		// The Bailey–Borwein–Plouffe formula (BBP) for calculating π was discovered in 1995 
		// by Simon Plouffe. Using base 16 math, the formula can compute any particular 
		// digit of π—returning the hexadecimal value of the digit—without
		// having to compute the intervening digits (digit extraction).
		
		
		
		double aux = 2;
		
//		while(!hasDecimals(pi)){
//			pi = pi + 4/(aux*(aux+1)*(aux+2)) - 4/((aux+2)*(aux+3)*(aux+4)); 
//			System.out.println(pi);
//			aux = aux+4;
//		}
		

		return pi;

	}

	static public boolean hasDecimals(double number) {
		String text = Double.toString(Math.abs(number));
		int decimalPlaces = text.length() - 1;
		if (decimalPlaces == 4999)
			return true;
		return false;
	}

}
