package Substitution_cipher.MonoAlphabetic_cipher;

public class Ceasar_cipher {
	public static final String alpha = "abcdefghijklmnopqrstuvwxyz";

	// Encrypts text using a shift od s
	public static String encrypt(String message, int Key) {
		message = message.toLowerCase();
		String cipherText = "";
		for (int i = 0; i < message.length(); i++) {
			int charPosition = alpha.indexOf(message.charAt(i));
			int keyVal = (Key + charPosition) % 26;
			char replaceVal = alpha.charAt(keyVal);
			cipherText += replaceVal;
		}
		return cipherText;
	}

	public static String decrypt(String cipherText, int Key) {
		cipherText = cipherText.toLowerCase();
		String message = "";
		for (int ii = 0; ii < cipherText.length(); ii++) {
			int charPosition = alpha.indexOf(cipherText.charAt(ii));
			int keyVal = (charPosition - Key) % 26;
			if (keyVal < 0) {
				keyVal = alpha.length() + keyVal;
			}
			char replaceVal = alpha.charAt(keyVal);
			message += replaceVal;
		}
		return message;
	}
}
