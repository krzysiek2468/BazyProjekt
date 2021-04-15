package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.algoritms.PrzestawienieMacierzowe1;
import org.example.algoritms.PrzestawienieMacierzowe2;
import org.example.algoritms.RailFence;
import org.example.cryptography.FirstCryptoAlgorithms;

import java.io.IOException;

public class TextController {

    @FXML
    public Button submit;

    @FXML
    public TextField toWriteField;

    @FXML
    public TextField toKeyWriteField;

    @FXML
    public TextField outputField;

    @FXML
    public StackPane primaryText;

    public static enum STATE
    {
        FIRSTALGORITHM,
        SECONDALGORITHM,
        THIRDALGORITHM
    }
    public static STATE state = STATE.FIRSTALGORITHM;


    // changing algoritm in lesson

    @FXML
    public void switchToAlg1File() throws IOException {
        clearFields();
        FilesController.state = FilesController.STATE.FIRSTALGORITHM;
        App.setRoot("Files");
    }

    @FXML
    public void switchToAlg2File() throws IOException {
        clearFields();
        FilesController.state = FilesController.STATE.SECONDALGORITHM;
        App.setRoot("Files");
    }

    @FXML
    public void switchToAlg3File() throws IOException {
        clearFields();
        FilesController.state = FilesController.STATE.THIRDALGORITHM;
        App.setRoot("Files");
    }

    @FXML
    public void switchToAlg1Text() {
        if(state != STATE.FIRSTALGORITHM){
            clearFields();
            state = STATE.FIRSTALGORITHM;
        }

    }

    @FXML
    public void switchToAlg2Text() {
        if(state != STATE.SECONDALGORITHM){
            clearFields();
            state = STATE.SECONDALGORITHM;
        }
    }

    @FXML
    public void switchToAlg3Text() {
        if(state != STATE.THIRDALGORITHM){
            clearFields();
            state = STATE.THIRDALGORITHM;
        }
    }

    // to clear fields when  changing algorithm or mode
    public void clearFields(){
        toKeyWriteField.clear();
        toWriteField.clear();
        outputField.clear();

    }

    // switching between lessons
    //empty for now

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
    public void submit() {
        if(toWriteField.getText().isEmpty()==true || toKeyWriteField.getText().isEmpty()==true ) {
            Stage stage = (Stage) primaryText.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Write text or key");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        }else if(checkKeyValidation(toKeyWriteField.getText()) == false){
            Stage stage = (Stage) primaryText.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Your key in invalid");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        }else{

            FirstCryptoAlgorithms firstCryptoAlgorithms = new FirstCryptoAlgorithms();

            try {
                outputField.setText(firstCryptoAlgorithms.encrytpionText(toWriteField.getText(), toKeyWriteField.getText() , state));
            }catch (Exception e){
                e.printStackTrace();
            }

            toWriteField.clear();
            toKeyWriteField.clear();

            Stage stage = (Stage) primaryText.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Success");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        }
    }

    public boolean checkKeyValidation(String text){
        if(state == STATE.FIRSTALGORITHM){
            RailFence alg = new RailFence();
            return alg.checkKey(text);
        }else if(state == STATE.SECONDALGORITHM){
            PrzestawienieMacierzowe1 alg2 =new PrzestawienieMacierzowe1();
            return  alg2.checkKey(text);
        }else{
            PrzestawienieMacierzowe2 alg3 = new PrzestawienieMacierzowe2();
            return alg3.checkKey(text);
        }

    }


}
