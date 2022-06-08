package Substitution_cipher.PolyAlphabetic_cipher;

// File name:HillCipher.java
import java.util.*;

public class HillCipher {
    String allChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    int indexOfChar(char c) {
        for (int i = 0; i < allChar.length(); i++) {
            if (allChar.charAt(i) == c)
                return i;
        }
        return -1;
    }

    char charAtIndex(int pos) {
        return allChar.charAt(pos);
    }
}

class Hill {

    Hill(int block) {
        this.block = block;
    }

    HillCipher b1 = new HillCipher();
    int block = 2;
    int key[][] = new int[block][block];

    public void keyInsert() throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter key Matrix");
        for (int i = 0; i < block; i++) {
            for (int j = 0; j < block; j++) {
                key[i][j] = scn.nextInt();
            }
        }
    }

    public void KeyInverseInsert() throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter key Inverse Matrix:");
        for (int i = 0; i < block; i++) {
            for (int j = 0; j < block; j++) {
                key[i][j] = scn.nextInt();
            }
        }
    }

    public String encryptBlock(String plain) throws Exception {
        plain = plain.toUpperCase();
        int a[][] = new int[block][1], sum = 0;
        int cipherMatrix[][] = new int[block][1];
        String cipher = "";

        for (int i = 0; i < block; i++) {
            a[i][0] = b1.indexOfChar(plain.charAt(i));
        }

        for (int i = 0; i < block; i++) {
            for (int j = 0; j < 1; j++) {
                for (int k = 0; k < block; k++) {
                    sum = sum + key[i][k] * a[k][j];
                }
                cipherMatrix[i][j] = sum % 26;
                sum = 0;
            }
        }

        for (int i = 0; i < block; i++) {
            cipher += b1.charAtIndex(cipherMatrix[i][0]);
        }
        return cipher;
    }

    public String encrypt(String plainText) throws Exception {
        String cipherText = "";
        keyInsert();

        plainText = plainText.toUpperCase();

        int len = plainText.length();
        // System.out.println(plainText.substring(1,2+1));

        while (len % block != 0) {
            plainText += "X";
            System.out.println(len);
            len = plainText.length();
        }

        for (int i = 0; i < len - 1; i = i + block) {
            cipherText += encryptBlock(plainText.substring(i, i + block));
            cipherText += " ";
        }
        return cipherText;
    }

    public String decryptBlock(String cipher) throws Exception {
        cipher = cipher.toUpperCase();
        int a[][] = new int[block][1], sum = 0;
        int plainMatrix[][] = new int[block][1];
        String plain = "";

        for (int i = 0; i < block; i++) {
            a[i][0] = b1.indexOfChar(cipher.charAt(i));
        }

        for (int i = 0; i < block; i++) {
            for (int j = 0; j < 1; j++) {
                for (int k = 0; k < block; k++) {
                    sum = sum + key[i][k] * a[k][j];
                }
                while (sum < 0) {
                    sum += 26;
                }
                plainMatrix[i][j] = sum;
                sum = 0;
            }
        }

        for (int i = 0; i < block; i++) {
            plain += b1.charAtIndex(plainMatrix[i][0]);
        }
        return plain;
    }

    public String Decrypt(String cipherText) throws Exception {
        String plainText = "";
        KeyInverseInsert();
        cipherText = cipherText.replaceAll(" ", "");

        cipherText = cipherText.toUpperCase();

        int len = cipherText.length();

        for (int i = 0; i < len - 1; i = i + block) {
            plainText += decryptBlock(cipherText.substring(i, i + block));
            plainText += " ";
        }
        return plainText;
    }

}