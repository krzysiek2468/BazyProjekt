package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Files4Controller {

    //ENCRYPTION

    @FXML
    public TextField encryptionPath1;

    @FXML
    public TextField encryptionPath2;

    @FXML
    public Button encryptionSubmit;

    //DECRYPTION

    @FXML
    public TextField decryptionPath1;

    @FXML
    public TextField decryptionPath2;

    @FXML
    public Button decryptionSubmit;

    @FXML
    public void switchLesson1() throws IOException {
        App.setRoot("Files");
    }

    @FXML
    public void switchLesson2() throws IOException {
        App.setRoot("Files2");
    }

    @FXML
    public void switchLesson3() throws IOException {
        App.setRoot("Files3");
    }

    @FXML
    public void switchLesson4() throws IOException {
        App.setRoot("Files4");
    }

    public void switchToAlgText() throws IOException {
        App.setRoot("Text4");
    }

    public void switchToAlgFiles() throws IOException {
        App.setRoot("Files4");
    }

    public void getPath1Encryption() {

    }

    public void getPath2Encryption() {

    }

    public void getPath1Decryption() {

    }

    public void getPath2Decryption() {

    }

    public void submitEncryption() {

    }

    public void submitDecryption() {

    }
}
