import com.jfoenix.controls.JFXButton;

import Substitution_cipher.MonoAlphabetic_cipher.CeasarCipher;
import Substitution_cipher.MonoAlphabetic_cipher.MultiplicativeCipher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextArea decrypt;

    @FXML
    private TextField key;

    @FXML
    private TextArea encrypt;

    @FXML
    private JFXButton exeBtn;

    @FXML
    private ChoiceBox<String> myComboBox;

    @FXML
    void initialize() {
        myComboBox.getItems().addAll("Ceasar Cipher", "HillCipher",
                "Multiplicative Cipher", "Playfair", "Affine Cipher", "Columnar Transposition");
        myComboBox.setValue("Ceasar Cipher");

    }

    String selectedItem;

    @FXML
    void cipher(ActionEvent event) {
        myComboBox.setOnAction((ActionEvent e) -> {
            selectedItem = myComboBox.getValue();
        });
        switch (selectedItem) {
            case "Ceasar Cipher":
                int k = Integer.parseInt(key.getText());
                if (decrypt.getText() == null && encrypt.getText() != null) {
                    new CeasarCipher();
                    decrypt.setText(CeasarCipher.encrypt(encrypt.getText(), k));
                } else {
                    new CeasarCipher();
                    encrypt.setText(CeasarCipher.decrypt(decrypt.getText(), k));
                }
                break;
            case "Multiplicative Cipher":
                int k1 = Integer.parseInt(key.getText());
                if (decrypt.getText() == null && encrypt.getText() != null) {
                    String value = new MultiplicativeCipher().encrypt(encrypt.getText(), k1);
                    decrypt.setText(value);
                } else {
                    String value = new MultiplicativeCipher().decrypt(decrypt.getText(), k1);
                    encrypt.setText(value);
                }
                break;
        }
    }
}
