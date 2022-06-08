package Substitution_cipher.PolyAlphabetic_cipher;

public class VigenereCipher {
	String str;
	String key;

	public VigenereCipher(String str, String key) {
		this.str = str;
		this.key = key;
	}

	static String generateKey(String str, String key) {
		int x = str.length();
		for (int i = 0;; i++) {
			if (x == i)
				i = 0;
			if (key.length() == str.length())
				break;
			key += (key.charAt(i));
		}
		return key;
	}

	static String encrypt(String str, String key) {
		String cipher_text = "";
		try {
			for (int i = 0; i < str.length(); i++) {
				int x = (str.charAt(i) + key.charAt(i)) % 26;
				x += 'A';
				cipher_text += (char) (x);
			}
		} catch (Exception e) {
			System.out.println("Problem here");
		}
		return cipher_text;
	}

	public static String decrypt(String cipher_text, String key) {
		String orig_text = "";
		for (int i = 0; i < cipher_text.length() &&
				i < key.length(); i++) {
			// converting in range 0-25
			int x = (cipher_text.charAt(i) -
					key.charAt(i) + 26) % 26;
			// convert into alphabets(ASCII)
			x += 'A';
			orig_text += (char) (x);
		}
		return orig_text;
	}

	// This function will convert the lower case character to Upper case
	public static String LowerToUpper(String s) {
		StringBuffer str = new StringBuffer(s);
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLowerCase(s.charAt(i))) {
				str.setCharAt(i, Character.toUpperCase(s.charAt(i)));
			}
		}
		s = str.toString();
		return s;
	}

	public static void main(String[] args) {
		System.out.println(VigenereCipher.encrypt("who", "key"));
	}
}
