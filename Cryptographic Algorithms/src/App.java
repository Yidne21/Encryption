import java.util.Scanner;

import Substitution_cipher.MonoAlphabetic_cipher.AffineCipher;
import Substitution_cipher.MonoAlphabetic_cipher.MultiplicativeCipher;

public class App {
    public static void main(String[] args) throws Exception {
        // Scanner sc = new Scanner(System.in);
        AffineCipher multiplicative = new AffineCipher("Abel", 4, 3);
        String decryptedString = multiplicative.encryption();
        System.out.println(decryptedString);
    }
}
