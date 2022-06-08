package Substitution_cipher.MonoAlphabetic_cipher;

public class MultiplicativeCipher {

    String str;
    int key;

    public MultiplicativeCipher() {
        this.str = str;
        this.key = key;
    }

    public String encrypt(String string, int k) {
        String cipher_text = "";
        System.out.println("Encrypted text is");
        int n = str.length();
        System.out.println("Enter the value by which each letter of the string is to be shifted");
        char ch1[] = str.toCharArray();
        char ch3;
        for (int i = 0; i < n; i++) {
            if (Character.isLetter(ch1[i])) {
                ch3 = (char) (((int) ch1[i] * key - 97) % 26 + 97);
                cipher_text = cipher_text + ch3;
            } else if (ch1[i] == ' ') {
                cipher_text = cipher_text + ch1[i];
            }
        }
        return cipher_text;
    }

    public String decrypt(String string, int k) {

        // String plaintext; //string ciphertext=" ";
        String plain_text = "";
        int inv = 0;
        int check = 0;
        for (int i = 0; i < 26; i++) {
            check = (i * key) % 26;
            if (check == 1) {
                inv = i;
                break;
            }
        }
        if (check != 1) {
            System.out.println("\n Inverse Key don't exist");
            return null;
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                plain_text += (char) ((inv * ((int) str.charAt(i) - 65)) % 26 + 65);
            } else {
                plain_text += (char) ((inv * (int) (str.charAt(i) - 97)) % 26 + 97);
            }
        }
        return plain_text;
    }
}