package Substitution_cipher.MonoAlphabetic_cipher;

public class AffineCipher {

	public static String encrypt(String input, int key1, int key2) {
		String str = "";
		for (int in = 0; in < input.length(); in++) {
			char get = input.charAt(in);
			if (Character.isLetter(get)) {
				get = (char) ((key1 * (int) (get + 'A') + key2) % 26 + 'A');
			}
			str += get;
		}
		return str;
	}

	public static String decrypt(String input, int key1, int key2) {
		String str = "";
		int x = 0;
		int inverse = 0;

		while (true) {
			inverse = key1 * x % 26;
			if (inverse == 1)
				break;
			x++;
		}

		for (int in = 0; in < input.length(); in++) {
			char get = input.charAt(in);
			if (Character.isLetter(get)) {
				get = (char) (x * ((get + 'A') - key2) % 26 + 'A');
			}
			str += get;
		}
		return str;
	}
}