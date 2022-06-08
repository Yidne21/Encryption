package Substitution_cipher.PolyAlphabetic_cipher;

public class HillCipher1 {
    int[][] key;
    String plaintext;

    public HillCipher1(int[][] key, String plaintext) {
        this.key = key;
        this.plaintext = plaintext;

    }

    public String encrypt() {
        int temp = (key.length - plaintext.length() % key.length) % key.length;
        for (int i = 0; i < temp; i++) {
            plaintext += 'x';
        }
        int k = 0;
        String cipher = "";
        while (k < plaintext.length()) {
            for (int i = 0; i < key.length; i++) {
                int sum = 0;
                temp = k;
                for (int j = 0; j < key.length; j++) {
                    sum += (key[i][j] % 26 * ((char) plaintext.charAt(temp++) - 'a') % 26) % 26;
                    sum = sum % 26;
                }
                cipher += (sum + 'a');
            }
            k += key.length;
        }
        return cipher;
    }

}