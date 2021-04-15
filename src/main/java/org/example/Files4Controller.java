package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
    public StackPane primaryPane;

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

    @FXML
    public void switchToAlgText() throws IOException {
        App.setRoot("Text4");
    }

    @FXML
    public void switchToAlgFiles() throws IOException {
        App.setRoot("Files4");
    }

    public void getPaths(TextField path) {
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
            path.setText(file.getPath());
        }
        else {
            System.out.println("error");
        }
    }
    public void getPath1Encryption() {
        getPaths(encryptionPath1);
    }

    public void getPath2Encryption() {
        getPaths(encryptionPath2);
    }

    public void getPath1Decryption() {
        getPaths(decryptionPath1);
    }

    public void getPath2Decryption() {
        getPaths(decryptionPath2);
    }

    public void submitEncryption() throws IOException {
        if (filePathCorrect(encryptionPath1.getText(), encryptionPath2.getText(), 0) == true) {
            Stage stage = (Stage) primaryPane.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong file or file paths");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        }
        else {
            encryptionPath1.clear();
            encryptionPath2.clear();

            Stage stage = (Stage) primaryPane.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Success");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        }
    }

    public void submitDecryption() {
        if (filePathCorrect(decryptionPath1.getText(), decryptionPath2.getText(), 1) == true) {
            Stage stage = (Stage) primaryPane.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong file or file paths");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        }
        else {
            decryptionPath1.clear();
            decryptionPath2.clear();

            Stage stage = (Stage) primaryPane.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Success");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        }
    }

    public boolean filePathCorrect(String path1 , String path2 , int zeroForEncryptionOneForDecryption){
        Boolean exception = false;
        try {
            Files.readAllLines(Paths.get(path1));
        }
        catch(IOException e){
            exception = true;
            if (zeroForEncryptionOneForDecryption == 0) {
                encryptionPath1.clear();
            } else {
                decryptionPath1.clear();
            }
        }

        try {
            Files.readAllLines(Paths.get(path2));
        }
        catch(IOException e){
            exception = true;
            if(zeroForEncryptionOneForDecryption == 0) {
                encryptionPath2.clear();
            }
            else {
                decryptionPath2.clear();
            }
        }
        return exception;
    }

}
