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
import org.example.algoritms.*;
import org.example.cryptography.SecondCryptoAlgorithms;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Files2Controller {

    @FXML
    public Button encryptionSubmit;

    @FXML
    public TextField encryptionKey;

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
    public TextField decryptionPath2;

    @FXML
    public TextField decryptionPath1;

    @FXML
    public StackPane primaryPane;


    // states to change algoritms in one lesson
    public static enum STATE
    {
        FIRSTALGORITHM,
        SECONDALGORITHM,
        THIRDALGORITHM
    }
    public static STATE state = STATE.FIRSTALGORITHM;


    // changing algoritm in lesson

    @FXML
    public void switchToAlg1File() {
        if(state != STATE.FIRSTALGORITHM){
            clearFields();
            state = STATE.FIRSTALGORITHM;
            System.out.println("1");
        }
    }

    @FXML
    public void switchToAlg2File() {
        if(state != STATE.SECONDALGORITHM){
            clearFields();
            state = STATE.SECONDALGORITHM;
            System.out.println("2");
        }
    }

    @FXML
    public void switchToAlg3File() {
        if(state != STATE.THIRDALGORITHM){
            clearFields();
            state = STATE.THIRDALGORITHM;
            System.out.println("3");
        }
    }

    @FXML
    public void switchToAlg1Text() throws IOException {
        clearFields();
        Text2Controller.state = Text2Controller.STATE.FIRSTALGORITHM;
        App.setRoot("Text2");
    }

    @FXML
    public void switchToAlg2Text(ActionEvent actionEvent) throws IOException {
        clearFields();
        Text2Controller.state = Text2Controller.STATE.SECONDALGORITHM;
        App.setRoot("Text2");
    }

    @FXML
    public void switchToAlg3Text(ActionEvent actionEvent) throws IOException {
        clearFields();
        Text2Controller.state = Text2Controller.STATE.THIRDALGORITHM;
        App.setRoot("Text2");
    }

    // to clear fields when  changing algoritm or mode
    public void clearFields(){
        decryptionKey.clear();
        decryptionPath1.clear();
        decryptionPath2.clear();
        encryptionKey.clear();
        encryptionPath1.clear();
        encryptionPath2.clear();
    }

    // switching between lessons
    //empty for now

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

    // choosing file
    // trochę powtarzania kodu , nie wiem czy nie zmienić
    @FXML
    public void getPath1Encryption() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload File Path");
        fileChooser.getExtensionFilters().addAll(
//                new FileChooser.ExtensionFilter("ALL FILES", "*.*"),
//                new FileChooser.ExtensionFilter("ZIP", "*.zip"),
//                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("TEXT", "*.txt")
//                new FileChooser.ExtensionFilter("IMAGE FILES", "*.jpg", "*.png", "*.gif")
        );

        File file = fileChooser.showOpenDialog(primaryPane.getScene().getWindow());

        if (file != null) {
            // pickUpPathField it's your TextField fx:id
            encryptionPath1.setText(file.getPath());

        } else  {
            System.out.println("error"); // or something else
        }

    }

    @FXML
    public void getPath2Encryption() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload File Path");
        fileChooser.getExtensionFilters().addAll(
//                new FileChooser.ExtensionFilter("ALL FILES", "*.*"),
//                new FileChooser.ExtensionFilter("ZIP", "*.zip"),
//                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("TEXT", "*.txt")
//                new FileChooser.ExtensionFilter("IMAGE FILES", "*.jpg", "*.png", "*.gif")
        );

        File file = fileChooser.showOpenDialog(primaryPane.getScene().getWindow());

        if (file != null) {
            // pickUpPathField it's your TextField fx:id
            encryptionPath2.setText(file.getPath());

        } else  {
            System.out.println("error"); // or something else
        }
    }

    @FXML
    public void getPath1Decryption() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload File Path");
        fileChooser.getExtensionFilters().addAll(
//                new FileChooser.ExtensionFilter("ALL FILES", "*.*"),
//                new FileChooser.ExtensionFilter("ZIP", "*.zip"),
//                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("TEXT", "*.txt")
//                new FileChooser.ExtensionFilter("IMAGE FILES", "*.jpg", "*.png", "*.gif")
        );

        File file = fileChooser.showOpenDialog(primaryPane.getScene().getWindow());

        if (file != null) {
            // pickUpPathField it's your TextField fx:id
            decryptionPath1.setText(file.getPath());

        } else  {
            System.out.println("error"); // or something else
        }
    }

    @FXML
    public void getPath2Decryption() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload File Path");
        fileChooser.getExtensionFilters().addAll(
//                new FileChooser.ExtensionFilter("ALL FILES", "*.*"),
//                new FileChooser.ExtensionFilter("ZIP", "*.zip"),
//                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("TEXT", "*.txt")
//                new FileChooser.ExtensionFilter("IMAGE FILES", "*.jpg", "*.png", "*.gif")
        );

        File file = fileChooser.showOpenDialog(primaryPane.getScene().getWindow());

        if (file != null) {
            // pickUpPathField it's your TextField fx:id
            decryptionPath2.setText(file.getPath());

        } else  {
            System.out.println("error"); // or something else
        }
    }


    @FXML
    public void submitEncryption() {
        if (encryptionKey.getText().isEmpty() == true || encryptionPath1.getText().isEmpty() == true || encryptionPath2.getText().isEmpty() == true) {
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
        } else if(checkKeyValidation(encryptionKey.getText()) == false) {
            Stage stage = (Stage) primaryPane.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Your key in invalid");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        } else {
            SecondCryptoAlgorithms algorithms = new SecondCryptoAlgorithms();

            algorithms.encryption(encryptionPath1.getText() , encryptionPath2.getText() ,encryptionKey.getText() , 0 , state);

            encryptionKey.clear();
            encryptionPath1.clear();
            encryptionPath2.clear();

            Stage stage = (Stage) primaryPane.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Success");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        }
    }

    @FXML
    public void submitDecryption() {
        if(decryptionKey.getText().isEmpty()==true || decryptionPath1.getText().isEmpty()==true || decryptionPath2.getText().isEmpty() == true) {
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

        }else if(checkKeyValidation(decryptionKey.getText()) == false) {
            Stage stage = (Stage) primaryPane.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Your key in invalid");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        }else{

            SecondCryptoAlgorithms algoritms = new SecondCryptoAlgorithms();

            algoritms.encryption(decryptionPath1.getText() , decryptionPath2.getText() , decryptionKey.getText() , 1 , state);

            decryptionPath1.clear();
            decryptionPath2.clear();
            decryptionKey.clear();

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

    public boolean checkKeyValidation(String text){
        if(state == STATE.FIRSTALGORITHM){
            PrzestawienieMacierzowe3 alg = new PrzestawienieMacierzowe3();
            return alg.checkKey(text);
        }else if(state ==STATE.SECONDALGORITHM){
            SzyfrCezara alg2 = new SzyfrCezara();
            return alg2.checkKey(text);
        }else{
            SzyfrVigenerea alg3 = new SzyfrVigenerea();
            return alg3.checkKey(text);
        }

    }
}