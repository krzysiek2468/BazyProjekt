package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Text4Controller {

    //ENCRYPTION
    @FXML
    public TextField toWriteTextEncryption;

    @FXML
    public Button encryptionButton;

    @FXML
    public TextArea encryptionResult;

    //DECRYPTION

    @FXML
    public TextField toWriteTextDecryption;

    @FXML
    public Button decryptionButton;

    @FXML
    public TextArea decryptionResult;

    @FXML
    public void switchLesson1() throws IOException {
        App.setRoot("Text");
    }

    @FXML
    public void switchLesson2() throws IOException {
        App.setRoot("Text2");
    }

    @FXML
    public void switchLesson3() throws IOException {
        App.setRoot("Text3");
    }

    @FXML
    public void switchLesson4() throws IOException {
        App.setRoot("Text4");
    }

    @FXML
    public void switchToAlgText() throws IOException {
        App.setRoot("Text4");
    }

    @FXML
    public void switchToAlgFiles() throws IOException {
        App.setRoot("Files4");
    }
}
