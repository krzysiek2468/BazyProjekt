package org.example;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.cryptography.FirstCryptoAlgorytm;

public class PrimaryController {

    @FXML
    public Button firstFileBtton;

    @FXML
    public Button secondFileButton;

    @FXML
    public Button submitButton;

    @FXML
    public TextField firstFileTextFiled;

    @FXML
    public TextField secondFileTextField;

    @FXML
    public VBox primaryWievId;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    @FXML
    public void firstFileChoser(ActionEvent actionEvent) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload File Path");
        fileChooser.getExtensionFilters().addAll(
//                new FileChooser.ExtensionFilter("ALL FILES", "*.*"),
//                new FileChooser.ExtensionFilter("ZIP", "*.zip"),
//                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("TEXT", "*.txt")
//                new FileChooser.ExtensionFilter("IMAGE FILES", "*.jpg", "*.png", "*.gif")
        );


        File file = fileChooser.showOpenDialog(primaryWievId.getScene().getWindow());

        if (file != null) {
            // pickUpPathField it's your TextField fx:id
            firstFileTextFiled.setText(file.getPath());

        } else  {
            System.out.println("error"); // or something else
        }
    }
    @FXML
    public void textToFirstField(ActionEvent actionEvent) {
    }
    @FXML
    public void textToSecondField(ActionEvent actionEvent) {
    }
    @FXML
    public void secondFileChoser(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload File Path");
        fileChooser.getExtensionFilters().addAll(
//                new FileChooser.ExtensionFilter("ALL FILES", "*.*"),
//                new FileChooser.ExtensionFilter("ZIP", "*.zip"),
//                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("TEXT", "*.txt")
//                new FileChooser.ExtensionFilter("IMAGE FILES", "*.jpg", "*.png", "*.gif")
        );


        File file2 = fileChooser.showOpenDialog(primaryWievId.getScene().getWindow());

        if (file2 != null) {
            // pickUpPathField it's your TextField fx:id
            secondFileTextField.setText(file2.getPath());

        } else  {
            System.out.println("error"); // or something else
        }
    }
    @FXML
    public void submmit(ActionEvent actionEvent) {

        if(firstFileTextFiled.getText().isEmpty()==true || secondFileTextField.getText().isEmpty()==true) {
            Stage stage = (Stage) primaryWievId.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Choose your files");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        }else{

            FirstCryptoAlgorytm firstCryptoAlgorytm = new FirstCryptoAlgorytm();
            firstCryptoAlgorytm.encrytpion(firstFileTextFiled.getText() , secondFileTextField.getText());

            firstFileTextFiled.clear();
            secondFileTextField.clear();

            Stage stage = (Stage) primaryWievId.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Succes");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        }

    }
}
