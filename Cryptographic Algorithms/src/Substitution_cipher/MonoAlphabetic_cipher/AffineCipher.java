package Substitution_cipher.MonoAlphabetic_cipher;

public class AffineCipher {
	static String str;
	static int key1;
	static int key2;

	public AffineCipher(String str, int key1, int key2) {
		this.str = str;
		this.key1 = key1;
		this.key2 = key2;
	}

	public static String encrypt() {

		for (int i = 0; i < str.length(); i++) {
			str = str + (char) ((((key1 * str.charAt(i)) + key2) % 26) + 65);
		}
		System.out.println(str);
		return str;
	}

	public static String decrypt() {
		int key1Invers = 0;
		int flag = 0;
		for (int i = 0; i < 26; i++) {
			flag = (key1 * i) % 26;

			if (flag == 1) {
				key1Invers = i;
			}
		}
		for (int i = 0; i < str.length(); i++) {
			str = str + (char) (((key1Invers * ((str.charAt(i))))));
		}
		return str;
	}
}