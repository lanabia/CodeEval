package pitombatech;

// PRIME PALINDROME

public class PrimePalindrome {

	public static void main(String[] args) {

		// the largest prime palindrome less than 1000

		for (int i = 999; i >= 0; i--) {

			if (isPrime(i) && isPalindrome(i)) {
				System.out.println(i);
				break;
			}
		}
	}

	public static boolean isPrime(int number) {
		for (int i = 2; i <= number - 1; i++) {
			if (number % i == 0)
				return false;
		}
		return true;
	}

	public static boolean isPalindrome(int number) {

		if (number < 10 || (number % 10 == number / 100))
			return true;

		return false;
	}

}
