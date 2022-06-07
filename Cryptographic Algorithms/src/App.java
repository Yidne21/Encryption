import java.util.Scanner;

import Substitution_cipher.MonoAlphabetic_cipher.AffineCipher;
import Substitution_cipher.MonoAlphabetic_cipher.MultiplicativeCipher;

public class App {
    public static void main(String[] args) throws Exception {
        // Scanner sc = new Scanner(System.in);
        AffineCipher multiplicative = new AffineCipher("Abel", 4, 3);
        String decryptedString = multiplicative.encryption();
        System.out.println(decryptedString);
        
         int keysize;
        String plaintext;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of key matrix\n");
        keysize = input.nextInt();
        System.out.println("Enter the key matrix");
        int[][] arr = new int[keysize][keysize];
        for (int i = 0; i < keysize; i++) {
            for (int j = 0; j < keysize; j++) {
                arr[i][j] = input.nextInt();
            }
        }
        System.out.println("Enter the message to encrypt\n");
        plaintext = input.next();

        HillCipher hillCipher = new HillCipher(arr, plaintext);
        System.out.println(hillCipher.encrypt());
    }
}
