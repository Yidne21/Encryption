package Substitution_cipher.MonoAlphabetic_cipher;

public class MultiplicativeCipher {

    String str = "";
    int key;

    public String encrypt(String string, int k) {
        String CipheredText = "";
        for (int i = 0; i < str.length(); i++) {
            char t = str.charAt(i);
            int charNum = (char) t - 97;
            int c = (k * charNum) % 26;
            char newC = (char) (c + 97);
            CipheredText += newC;
        }
        return CipheredText;
    }

    public String decrypt(String string, int k) {
        String PlainText = "";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int charNum = (char) c - 97;

            int decipher = ((modInverse(key, 26)) * (charNum)) % 26;

            char newC = (char) (decipher + 97);
            PlainText += newC;
        }
        return PlainText;
    }

    public static int modInverse(int a, int m) {
        a = a % m;
        for (int i = 1; i < m; i++) {
            if ((a * i) % m == 1)
                return i;
        }
        return 1;
    }
}