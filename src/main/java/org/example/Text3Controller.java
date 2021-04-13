package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.algoritms.*;

import java.io.IOException;

public class Text3Controller {

    @FXML
    public TextArea algorithmOutput;

    @FXML
    public TextField toKeyWriteField;

    @FXML
    public TextField toKeyWriteField1;

    @FXML
    public StackPane primaryText;

    public static enum STATE
    {
        WORKING,
        STOP
    }

    public static STATE state = STATE.STOP;

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
    

    public void switchToAlg1Text() {

    }

    public void switchToAlg2File() throws IOException {
        App.setRoot("Files3");
    }

    public void switchToAlg2Text() throws IOException {
        App.setRoot("Text3b");
    }

    public void submit() throws InterruptedException {

        if (state == STATE.WORKING) {

            state = STATE.STOP;


        } else {

            LFSR algorithm = new LFSR();
            if (toKeyWriteField.getText().isEmpty() == true || toKeyWriteField1.getText().isEmpty() == true) {
                Stage stage = (Stage) primaryText.getScene().getWindow();
                Alert alert = new Alert(Alert.AlertType.ERROR, "Write text or key");
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.initOwner(stage);
                alert.showAndWait();
            } else if (algorithm.checkKeys(toKeyWriteField.getText(), toKeyWriteField1.getText()) == false) {
                Stage stage = (Stage) primaryText.getScene().getWindow();
                Alert alert = new Alert(Alert.AlertType.ERROR, "Your key in invalid");
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.initOwner(stage);
                alert.showAndWait();
            } else {
                state = STATE.WORKING;
                algorithm.algorithm(toKeyWriteField.getText(), toKeyWriteField1.getText(), algorithmOutput, state);
            }
        }
    }
}
