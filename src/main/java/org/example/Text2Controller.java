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
        FIRSTALGORITM,
        SECONDALGORITM,
        THIRDALGORITM
    }
    public static STATE state = STATE.FIRSTALGORITM;


    // changing algoritm in lesson

    @FXML
    public void switchToAlg1File(ActionEvent actionEvent) throws IOException {
        clearFields();
        Files2Controller.state = Files2Controller.STATE.FIRSTALGORITM;
        App.setRoot("Files2");
    }

    @FXML
    public void switchToAlg2File(ActionEvent actionEvent) throws IOException {
        clearFields();
        Files2Controller.state = Files2Controller.STATE.SECONDALGORITM;
        App.setRoot("Files2");
    }

    @FXML
    public void switchToAlg3File(ActionEvent actionEvent) throws IOException {
        clearFields();
        Files2Controller.state = Files2Controller.STATE.THIRDALGORITM;
        App.setRoot("Files2");
    }

    @FXML
    public void switchToAlg1Text(ActionEvent actionEvent) {
        if(state != STATE.FIRSTALGORITM){
            clearFields();
            state = STATE.FIRSTALGORITM;
        }

    }

    @FXML
    public void switchToAlg2Text(ActionEvent actionEvent) {
        if(state != STATE.SECONDALGORITM){
            clearFields();
            state = STATE.SECONDALGORITM;
        }
    }

    @FXML
    public void switchToAlg3Text(ActionEvent actionEvent) {
        if(state != STATE.THIRDALGORITM){
            clearFields();
            state = STATE.THIRDALGORITM;
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
    public void switchLesson1(ActionEvent actionEvent) throws IOException {
        App.setRoot("Text");

    }
    @FXML
    public void switchLesson2(ActionEvent actionEvent) {

    }
    @FXML
    public void switchLesson3(ActionEvent actionEvent) {

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

    @FXML
    public void submit(ActionEvent actionEvent) {
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
    public void submit1(ActionEvent actionEvent) {
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
        if(state == STATE.FIRSTALGORITM){
            PrzestawienieMacierzowe3 alg = new PrzestawienieMacierzowe3();
            return alg.checkKey(text);
        }else if(state == STATE.SECONDALGORITM){
            SzyfrCezara alg2 = new SzyfrCezara();
            return  alg2.checkKey(text);
        }else{
            SzyfrVigenerea alg3 = new SzyfrVigenerea();
            return alg3.checkKey(text);
        }

    }

}
