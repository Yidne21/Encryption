public class HillCipher {
    int[][] key;
    String plaintext;

    HillCipher(int[][] key, String plaintext) {
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
                    sum += (key[i][j] % 26 * (plaintext.charAt(temp++) - 'a') % 26) % 26;
                    sum = sum % 26;
                }
                cipher += (sum + 'a');
            }
            k += key.length;
        }
        return cipher;
    }

}