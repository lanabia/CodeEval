package pitombatech;

// challenge Pascals Triangle

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PascalsTriangle {

	public static void main(String[] args) throws IOException {

		String fileName = args[0];

		String line = null;
		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		while ((line = bufferedReader.readLine()) != null) {
			int depth = Integer.valueOf(line);
			ArrayList<int[]> rows = new ArrayList<int[]>();
			int[] row = { 1 };
			if (depth >= 1) {
				rows.add(row);
				printArray(row, false);
			}
			for (int quantityOfElements = 2; quantityOfElements <= depth; quantityOfElements++) {
				row = new int[quantityOfElements];
				for (int i = 0; i < quantityOfElements; i++) {
					if (i == 0 || i == quantityOfElements - 1)
						row[i] = 1;
					else
						row[i] = rows.get(quantityOfElements - 2)[i - 1] + rows.get(quantityOfElements - 2)[i];
				}
				rows.add(row);
				if (quantityOfElements == depth)
					printArray(row, true);
				else
					printArray(row, false);
			}
			System.out.println();
		}

		bufferedReader.close();

	}

	public static void printArray(int[] array, boolean last) {
		if (last)
			for (int i = 0; i < array.length; i++) {
				if (i != array.length - 1)
					System.out.print(array[i] + " ");
				else
					System.out.print(array[i]);
			}

		else
			for (int i : array)
				System.out.print(i + " ");

		// System.out.println();
	}

}
