package Substitution_cipher.MonoAlphabetic_cipher;

public class AffineCipher {
	private static final int ALPHABET_SIZE = 26;
	private static String str;
	private static int key1;
	private static int key2;

	public AffineCipher(String str, int key1, int key2) {
		this.key1 = key1;
		this.key2 = key2;
		this.str = str;
	}

	private static void decryption() {
		int aInverse = 0;
		if (key1 != 1) {
			System.out.println("\n Inverse Key don't exist");
			return;
		}

		decrypt(key1, key2, str);
	}

	private static StringBuilder decrypt(int aInverse, int b, String ciphertext) {
		if (ciphertext == null || ciphertext.length() <= 0) {
			return null;
		}

		ciphertext = ciphertext.toLowerCase();
		StringBuilder plaintext = new StringBuilder();
		int z, j;

		for (int i = 0; i < ciphertext.length(); i++) {
			char agent = ciphertext.charAt(i);
			z = aInverse * ((agent - 97) - b);
			j = z < 0 ? minusMod(z, ALPHABET_SIZE) : z % ALPHABET_SIZE;
			plaintext.append((char) ('A' + j));
		}
		return plaintext;
	}

	private static int minusMod(int minus, int mod) {
		int a = Math.abs(minus);
		return (mod * ((a / mod) + 1)) - a;
	}

	private static int findInverse(double firstNumber, double anotherNumber) {
		int a1, b1, a2, b2, r, q, temp_a2, temp_b2, n1, n2, max;

		if (firstNumber > anotherNumber) {
			max = (int) firstNumber;
			n1 = (int) firstNumber;
			n2 = (int) anotherNumber;
		} else {
			max = (int) anotherNumber;
			n1 = (int) anotherNumber;
			n2 = (int) firstNumber;
		}

		a1 = b2 = 1;
		b1 = a2 = 0;
		temp_a2 = a2;
		temp_b2 = b2;

		r = n1 % n2;
		q = n1 / n2;

		while (r != 0) {
			n1 = n2;
			n2 = r;
			a2 = a1 - q * a2;
			b2 = b1 - q * b2;
			a1 = temp_a2;
			b1 = temp_b2;
			temp_a2 = a2;
			temp_b2 = b2;
			r = n1 % n2;
			q = n1 / n2;
		}

		int result;
		if (firstNumber == max) {
			if (a2 < 0) {
				result = (int) (a2 - anotherNumber * Math.floor(a2 / anotherNumber));
			} else {
				result = a2;
			}
		} else {
			if (b2 < 0) {
				result = (int) (b2 - anotherNumber * Math.floor(b2 / anotherNumber));
			} else
				result = b2;
		}
		return result;
	}

	public static String encryption() {
		boolean isAOk = false, isBOk = false;

		while (!isAOk) {
			if (gcd(key1, ALPHABET_SIZE) == 1) {
				isAOk = true;
			} else {
				System.out.println("'key1' is not ok, pls try again.");
				return null;
			}
		}

		while (!isBOk) {
			if (key2 != 1) {
				isBOk = true;
			} else {
				System.out.println("'key2' is not ok, pls try again.");
				return null;
			}
		}
		encrypt(str, key1, key2);
		return null;
	}

	private static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	private static StringBuilder encrypt(String plaintext, int a, int b) {
		if (plaintext == null || plaintext.length() <= 0) {
			return null;
		}

		plaintext = plaintext.toLowerCase();
		StringBuilder ciphertext = new StringBuilder();

		for (int i = 0; i < plaintext.length(); i++) {
			char agent = plaintext.charAt(i);
			int value = ((a * (agent - 97) + b) % ALPHABET_SIZE);
			ciphertext.append((char) (value + 97));
		}
		return ciphertext;
	}
}