import java.io.IOException;
import java.util.Scanner;

import Substitution_cipher.MonoAlphabetic_cipher.AffineCipher;
import Substitution_cipher.MonoAlphabetic_cipher.MultiplicativeCipher;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Home.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws Exception {

        launch(args);

        // MultiplicativeCipher ob1 = new MultiplicativeCipher();
        // System.out.println(ob1.decrypt("Just keep Coding", 3));

        // Scanner sc = new Scanner(System.in);
        // int keysize;
        // String plaintext;

        // Scanner input = new Scanner(System.in);
        // System.out.println("Enter the size of key matrix\n");
        // keysize = input.nextInt();
        // System.out.println("Enter the key matrix");
        // int[][] arr = new int[keysize][keysize];
        // for (int i = 0; i < keysize; i++) {
        // for (int j = 0; j < keysize; j++) {
        // arr[i][j] = input.nextInt();
        // }
        // }
        // System.out.println("Enter the message to encrypt\n");
        // plaintext = input.next();

        // HillCipher1 hillCipher = new HillCipher1(arr, plaintext);
        // System.out.println(hillCipher.encrypt());
    }
}
