package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.algoritms.SteamCipher;
import org.example.cryptography.SecondCryptoAlgorithms;
import org.example.cryptography.ThirdAlgoritms;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    public void submitEncryption(ActionEvent actionEvent) throws IOException {
        SteamCipher algoritm = new SteamCipher();
        if (encryptionKey.getText().isEmpty() == true || encryptionKey1.getText().isEmpty() == true || encryptionPath1.getText().isEmpty() == true || encryptionPath2.getText().isEmpty() == true) {
            Stage stage = (Stage) primaryPane.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Choose your files or write key");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        } else if(filePathCorect(encryptionPath1.getText(),encryptionPath2.getText(),0)==true) {
            Stage stage = (Stage) primaryPane.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong file or files paths");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        } else if(algoritm.checkKeys(encryptionKey.getText(),encryptionKey1.getText()) == false) {
            Stage stage = (Stage) primaryPane.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Your key in invalid");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        } else {
            algoritm.encodeFile(encryptionKey.getText(),encryptionKey1.getText(),encryptionPath1.getText(),encryptionPath2.getText());

            encryptionKey.clear();
            encryptionKey1.clear();
            encryptionPath1.clear();
            encryptionPath2.clear();

            Stage stage = (Stage) primaryPane.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Success");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        }

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

    public void submitDecryption(ActionEvent actionEvent) throws IOException {
        SteamCipher algoritm = new SteamCipher();
        if(decryptionKey.getText().isEmpty()==true || decryptionKey1.getText().isEmpty()==true || decryptionPath1.getText().isEmpty()==true || decryptionPath2.getText().isEmpty() == true) {
            Stage stage = (Stage) primaryPane.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Choose your files or write key");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        }else if(filePathCorect(decryptionPath1.getText() , decryptionPath2.getText() ,1)==true){
            Stage stage = (Stage) primaryPane.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong file or files paths");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();

        }else if(algoritm.checkKeys(decryptionKey.getText() ,decryptionKey1.getText()) == false) {
            Stage stage = (Stage) primaryPane.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Your key in invalid");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        }else{
            algoritm.decodeFile(decryptionKey.getText() ,decryptionKey1.getText(),decryptionPath1.getText(),decryptionPath2.getText());

            decryptionPath1.clear();
            decryptionPath2.clear();
            decryptionKey.clear();
            decryptionKey1.clear();

            Stage stage = (Stage) primaryPane.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Success");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        }
    }

    public boolean filePathCorect(String path1 , String path2 , int zeroForEncryptionOneForDecryption){
        Boolean exception = false;
        try {
            Files.readAllLines(Paths.get(path1));
        }
        catch(IOException e){
            exception = true;
            if(zeroForEncryptionOneForDecryption == 0) {
                encryptionPath1.clear();
            }else {
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
