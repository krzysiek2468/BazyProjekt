package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    public StackPane primaryText;

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

    @FXML
    public void submitEncryption() {
        if (toWriteTextEncryption.getText().isEmpty() == true) {
            Stage stage = (Stage) primaryText.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Write text");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        } else {
            try {
                encryptionResult.setText("Test");
            } catch(Exception e) {
                e.printStackTrace();
            }
            toWriteTextEncryption.clear();

            Stage stage = (Stage) primaryText.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Success");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        }
    }
    @FXML
    public void submitDecryption() {
        if (toWriteTextDecryption.getText().isEmpty() == true) {
            Stage stage = (Stage) primaryText.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Write text");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        } else {
            try {
                decryptionResult.setText("Test");
            } catch(Exception e) {
                e.printStackTrace();
            }
            toWriteTextDecryption.clear();

            Stage stage = (Stage) primaryText.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Success");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        }
    }
}
