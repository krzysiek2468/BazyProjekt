package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import org.example.cryptography.ThirdAlgoritms;

import java.io.File;
import java.io.IOException;

public class Files3Controller {

    @FXML
    public Button encryptionSubmit;

    @FXML
    public TextField encryptionKey;

    @FXML
    public TextField encryptionKey1;

    @FXML
    public TextField encryptionPath2;

    @FXML
    public TextField encryptionPath1;

    //DECRYPTION

    @FXML
    public Button decryptionSubmit;

    @FXML
    public TextField decryptionKey;

    @FXML
    public TextField decryptionKey1;

    @FXML
    public TextField decryptionPath2;

    @FXML
    public TextField decryptionPath1;

    @FXML
    public StackPane primaryPane;

    @FXML
    public void switchLesson1(ActionEvent actionEvent) throws IOException {
        App.setRoot("Files");

    }
    @FXML
    public void switchLesson2(ActionEvent actionEvent) throws IOException {
        App.setRoot("Files2");
    }
    @FXML
    public void switchLesson3(ActionEvent actionEvent){

    }
    @FXML
    public void switchLesson4(ActionEvent actionEvent) {

    }
    @FXML
    public void switchLesson5(ActionEvent actionEvent) {

    }
    @FXML
    public void switchLesson6(ActionEvent actionEvent) {

    }
    @FXML
    public void switchLesson7(ActionEvent actionEvent) {

    }

    public void switchToAlg2File(ActionEvent actionEvent) {
    }

    public void switchToAlg2Text(ActionEvent actionEvent) throws IOException {
        App.setRoot("Text3b");
    }

    public void switchToAlg1Text(ActionEvent actionEvent) throws IOException {
        App.setRoot("Text3");
    }

    public void getPath1Encryption(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload File Path");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("ALL FILES", "*.*"),
                new FileChooser.ExtensionFilter("ZIP", "*.zip"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("TEXT", "*.txt"),
                new FileChooser.ExtensionFilter("IMAGE FILES", "*.jpg", "*.png", "*.gif")
        );

        File file = fileChooser.showOpenDialog(primaryPane.getScene().getWindow());

        if (file != null) {
            // pickUpPathField it's your TextField fx:id
            encryptionPath1.setText(file.getPath());

        } else  {
            System.out.println("error"); // or something else
        }
    }

    public void getPath2Encryption(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload File Path");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("ALL FILES", "*.*"),
                new FileChooser.ExtensionFilter("ZIP", "*.zip"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("TEXT", "*.txt"),
                new FileChooser.ExtensionFilter("IMAGE FILES", "*.jpg", "*.png", "*.gif")
        );


        File file = fileChooser.showOpenDialog(primaryPane.getScene().getWindow());

        if (file != null) {
            // pickUpPathField it's your TextField fx:id
            encryptionPath2.setText(file.getPath());

        } else  {
            System.out.println("error"); // or something else
        }
    }

    public void submitEncryption(ActionEvent actionEvent) {
        ThirdAlgoritms algoritm = new ThirdAlgoritms();

        algoritm.encryption(encryptionPath1.getText() ,encryptionPath2.getText());
    }

    public void getPath1Decryption(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload File Path");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("ALL FILES", "*.*"),
                new FileChooser.ExtensionFilter("ZIP", "*.zip"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("TEXT", "*.txt"),
                new FileChooser.ExtensionFilter("IMAGE FILES", "*.jpg", "*.png", "*.gif")
        );

        File file = fileChooser.showOpenDialog(primaryPane.getScene().getWindow());

        if (file != null) {
            // pickUpPathField it's your TextField fx:id
            decryptionPath1.setText(file.getPath());

        } else  {
            System.out.println("error"); // or something else
        }
    }

    public void getPath2Decryption(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload File Path");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("ALL FILES", "*.*"),
                new FileChooser.ExtensionFilter("ZIP", "*.zip"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("TEXT", "*.txt"),
                new FileChooser.ExtensionFilter("IMAGE FILES", "*.jpg", "*.png", "*.gif")
        );

        File file = fileChooser.showOpenDialog(primaryPane.getScene().getWindow());

        if (file != null) {
            // pickUpPathField it's your TextField fx:id
            decryptionPath2.setText(file.getPath());

        } else  {
            System.out.println("error"); // or something else
        }
    }

    public void submitDecryption(ActionEvent actionEvent) {
    }
}
