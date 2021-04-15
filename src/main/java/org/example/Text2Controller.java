package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.algoritms.*;
import org.example.cryptography.SecondCryptoAlgorithms;

import java.io.IOException;

public class Text2Controller {

    //BUTTONS FROM SIDE MENU
    // TF - TEXT FIELD MODE BUTTON TO SWITCH TO FILE MODE

    @FXML
    public Button submit;

    @FXML
    public TextField toWriteField;

    @FXML
    public TextField toKeyWriteField;

    @FXML
    public TextField outputField;

    @FXML
    public Button submit1;

    @FXML
    public TextField toWriteField1;

    @FXML
    public TextField toKeyWriteField1;

    @FXML
    public TextField outputField1;

    @FXML
    public StackPane primaryText;

    public static enum STATE
    {
        FIRSTALGORITHM,
        SECONDALGORITHM,
        THIRDALGORITHM
    }
    public static STATE state = STATE.FIRSTALGORITHM;


    // changing algorithm in lesson

    @FXML
    public void switchToAlg1File() throws IOException {
        clearFields();
        Files2Controller.state = Files2Controller.STATE.FIRSTALGORITHM;
        App.setRoot("Files2");
    }

    @FXML
    public void switchToAlg2File() throws IOException {
        clearFields();
        Files2Controller.state = Files2Controller.STATE.SECONDALGORITHM;
        App.setRoot("Files2");
    }

    @FXML
    public void switchToAlg3File() throws IOException {
        clearFields();
        Files2Controller.state = Files2Controller.STATE.THIRDALGORITHM;
        App.setRoot("Files2");
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

    // to clear fields when  changing algoritm or mode
    public void clearFields(){
        toKeyWriteField.clear();
        toWriteField.clear();
        outputField.clear();
        toKeyWriteField1.clear();
        toWriteField1.clear();
        outputField1.clear();

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

            SecondCryptoAlgorithms algorithms = new SecondCryptoAlgorithms();

            try {
                outputField.setText(algorithms.encryptionText(toWriteField.getText(), toKeyWriteField.getText() , state));
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
    @FXML
    public void submit1() {
        if(toWriteField1.getText().isEmpty()==true || toKeyWriteField1.getText().isEmpty()==true ) {
            Stage stage = (Stage) primaryText.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Write text or key");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        }else if(checkKeyValidation(toKeyWriteField1.getText()) == false){
            Stage stage = (Stage) primaryText.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Your key in invalid");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        }else{

            SecondCryptoAlgorithms algorithms = new SecondCryptoAlgorithms();

            try {
                outputField1.setText(algorithms.decryptionText(toWriteField1.getText(), toKeyWriteField1.getText() , state));
            }catch (Exception e){
                e.printStackTrace();
            }

            toWriteField1.clear();
            toKeyWriteField1.clear();

            Stage stage = (Stage) primaryText.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Success");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        }
    }

    public boolean checkKeyValidation(String text){
        if(state == STATE.FIRSTALGORITHM){
            PrzestawienieMacierzowe3 alg = new PrzestawienieMacierzowe3();
            return alg.checkKey(text);
        }else if(state == STATE.SECONDALGORITHM){
            SzyfrCezara alg2 = new SzyfrCezara();
            return  alg2.checkKey(text);
        }else{
            SzyfrVigenerea alg3 = new SzyfrVigenerea();
            return alg3.checkKey(text);
        }

    }

}
