package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.algoritms.SteamCipher;

import java.io.IOException;

public class Text3bController {

    @FXML
    public TextField toWriteField;

    @FXML
    public TextField toKeyWriteField;

    @FXML
    public TextField toKeyWriteField2;

    @FXML
    public TextField outputField;

    @FXML
    public TextField toWriteField1;

    @FXML
    public TextField toKeyWriteField1;

    @FXML
    public TextField toKeyWriteField11;

    @FXML
    public TextField outputField1;

    @FXML
    public StackPane primaryText;

    @FXML
    public void switchLesson1(ActionEvent actionEvent) throws IOException {
        App.setRoot("Text");

    }
    @FXML
    public void switchLesson2(ActionEvent actionEvent) throws IOException {
        App.setRoot("Text2");
    }
    @FXML
    public void switchLesson3(ActionEvent actionEvent) {

    }
    @FXML
    public void switchLesson4(ActionEvent actionEvent) {

    }


    public void switchToAlg1Text(ActionEvent actionEvent) throws IOException {
        App.setRoot("Text3");
    }

    public void switchToAlg2File(ActionEvent actionEvent) throws IOException {
        App.setRoot("Files3");
    }

    public void switchToAlg2Text(ActionEvent actionEvent) {
    }


    public void submit(ActionEvent actionEvent) {
        SteamCipher algoritm = new SteamCipher();
        if (toWriteField.getText().isEmpty() == true || toKeyWriteField.getText().isEmpty() == true || toKeyWriteField2.getText().isEmpty() == true) {
            Stage stage = (Stage) primaryText.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Write text or key");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        } else if (algoritm.checkKeys(toKeyWriteField.getText(), toKeyWriteField2.getText()) == false) {
            Stage stage = (Stage) primaryText.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Your key or text in invalid");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        } else {
            try {
                outputField.setText(algoritm.encode(toWriteField.getText(), toKeyWriteField.getText(), toKeyWriteField2.getText()));
            }catch (Exception e){e.printStackTrace();}
            toWriteField.clear();
            toKeyWriteField.clear();
            toKeyWriteField2.clear();
            Stage stage = (Stage) primaryText.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Success");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        }

    }

    public void submit1(ActionEvent actionEvent) {
        SteamCipher algoritm = new SteamCipher();
            if (toWriteField1.getText().isEmpty() == true || toKeyWriteField1.getText().isEmpty() == true || toKeyWriteField11.getText().isEmpty() == true) {
                Stage stage = (Stage) primaryText.getScene().getWindow();
                Alert alert = new Alert(Alert.AlertType.ERROR, "Write text or key");
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.initOwner(stage);
                alert.showAndWait();
            } else if (algoritm.checkKeys(toKeyWriteField1.getText(), toKeyWriteField11.getText()) == false) {
                Stage stage = (Stage) primaryText.getScene().getWindow();
                Alert alert = new Alert(Alert.AlertType.ERROR, "Your key in invalid");
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.initOwner(stage);
                alert.showAndWait();
            } else {
                try {
                    outputField1.setText(algoritm.decode(toWriteField1.getText(), toKeyWriteField1.getText(), toKeyWriteField11.getText()));
                }catch (Exception e){e.printStackTrace();}
                toWriteField1.clear();
                toKeyWriteField1.clear();
                toKeyWriteField11.clear();
                Stage stage = (Stage) primaryText.getScene().getWindow();
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Success");
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.initOwner(stage);
                alert.showAndWait();
            }

    }
}
