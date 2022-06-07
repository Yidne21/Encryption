package TranspositionCipher;

public class RailFenceCipher {

  private String str;
  private int key;

  public RailFenceCipher(String str, int key) {
    this.str = str;
    this.key = key;
  }

  public static String encryption(String str, int key) {

    boolean checkdown = false; // check whether it is moving downward or upward
    int j = 0;
    int row = key; // no of row is the no of rails entered by user
    int col = str.length(); // column length is the size of string
    char[][] a = new char[row][col];
    // we create a matrix of a of row *col size
    for (int i = 0; i < col; i++) { // matrix visitin in rails order and putting the character of plaintext
      if (j == 0 || j == row - 1)
        checkdown = !checkdown;
      a[j][i] = str.charAt(i);
      if (checkdown) {
        j++;
      } else
        j--;
    }
    // visiting the matrix in usual order to get ciphertext
    for (int i = 0; i < row; i++) {
      for (int k = 0; k < col; k++) {
        System.out.print(a[i][k] + "  ");
      }
      System.out.println();
    }
    String en = "";
    for (int i = 0; i < row; i++) {
      for (int k = 0; k < col; k++) {
        if (a[i][k] != 0)
          en = en + a[i][k];
      }
    }
    return en;// printing the ciphertext
  }

  public static String decryption(String str, int key) {

    boolean checkdown = false;
    int j = 0;
    int row = key;
    int col = str.length();
    char[][] a = new char[row][col];

    // first of all mark the rails position by * in the matrix
    for (int i = 0; i < col; i++) {
      if (j == 0 || j == row - 1)
        checkdown = !checkdown;
      a[j][i] = '*';
      if (checkdown)
        j++;
      else
        j--;
    }
    // now enter the character of cipheetext in the matrix positon that have *
    // symbol
    int index = 0;

    for (int i = 0; i < row; i++) {
      for (int k = 0; k < col; k++) {
        if (a[i][k] == '*' && index < str.length()) {
          a[i][k] = str.charAt(index++);
        }
      }
    }
    // visit each character in rails order as character are put in the encryption
    // function
    for (int i = 0; i < row; i++) {
      for (int k = 0; k < col; k++) {
        System.out.print(a[i][k] + "\t");
      }
      System.out.println();
    }
    checkdown = false;
    String s = "";
    j = 0;

    for (int i = 0; i < col; i++) {
      if (j == 0 || j == row - 1)
        checkdown = !checkdown;

      s += a[j][i];

      if (checkdown)
        j++;
      else
        j--;

    }
    return s;// print the plaintext that was decrypted by rail fence cipher

  }
}