package org.example;

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
import org.example.cryptography.FirstCryptoAlgorytm;

import java.io.IOException;

public class TextController {
    //BUTTONS FROM TOP MENU
    // TB[NUMBER] - MODE WITH TEXT FIELD
    @FXML
    public Button TB1;

    @FXML
    public Button TB2;

    @FXML
    public Button TB3;

    @FXML
    public Button TB4;

    @FXML
    public Button TB5;

    @FXML
    public Button TB6;

    @FXML
    public Button TB7;

   //BUTTONS FROM SIDE MENU
    // TF - TEXT FIELD MODE BUTTON TO SWITCH TO FILE MODE

    @FXML
    public Button TF1;

    @FXML
    public Button TT1;

    @FXML
    public Button TF2;

    @FXML
    public Button TT2;

    @FXML
    public Button TF3;

    @FXML
    public Button TT3;

    //CENTRAL PANE FIELDS

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

    public enum STATE
    {
        FIRSTALGORITM,
        SECONDALGORITM,
        THIRDALGORITM
    }
    public static STATE state = STATE.FIRSTALGORITM;


    // changing algoritm in lesson

    @FXML
    public void switchToAlg1File() throws IOException {
        clearFields();
        FilesController.state = FilesController.STATE.FIRSTALGORITM;
        App.setRoot("Files");
    }

    @FXML
    public void switchToAlg2File() throws IOException {
        clearFields();
        FilesController.state = FilesController.STATE.SECONDALGORITM;
        App.setRoot("Files");
    }

    @FXML
    public void switchToAlg3File() throws IOException {
        clearFields();
        FilesController.state = FilesController.STATE.THIRDALGORITM;
        App.setRoot("Files");
    }

    @FXML
    public void switchToAlg1Text() {
        if(state != STATE.FIRSTALGORITM){
            clearFields();
            state = STATE.FIRSTALGORITM;
        }

    }

    @FXML
    public void switchToAlg2Text() {
        if(state != STATE.SECONDALGORITM){
            clearFields();
            state = STATE.SECONDALGORITM;
        }
    }

    @FXML
    public void switchToAlg3Text() {
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

    }

    // switching between lessons
    //empty for now

    @FXML
    public void switchLesson1() {

    }
    @FXML
    public void switchLesson2() {

    }
    @FXML
    public void switchLesson3() {

    }
    @FXML
    public void switchLesson4() {

    }
    @FXML
    public void switchLesson5() {

    }
    @FXML
    public void switchLesson6() {

    }
    @FXML
    public void switchLesson7() {

    }

    @FXML
    public void submit() {
        if(toWriteField.getText().isEmpty()==true || toKeyWriteField.getText().isEmpty()==true ) {
            Stage stage = (Stage) primaryText.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Write text, or key");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();

        }
        else if(checkKeyValidation(toKeyWriteField.getText()) == false) {
            Stage stage = (Stage) primaryText.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Your kay in invalid");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        }
        else {

            FirstCryptoAlgorytm firstCryptoAlgorytm = new FirstCryptoAlgorytm();

            try {
                outputField.setText(firstCryptoAlgorytm.encrytpionText(toWriteField.getText(), toKeyWriteField.getText() , state));
            }catch (Exception e){
                e.printStackTrace();
            }

            toWriteField.clear();
            toKeyWriteField.clear();

            Stage stage = (Stage) primaryText.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Succes");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.showAndWait();
        }
    }

    public boolean checkKeyValidation(String text) {
        if(state == STATE.FIRSTALGORITM){
            RailFence alg = new RailFence();
            return alg.checkKey(text);
        }else if(state == STATE.SECONDALGORITM){
            PrzestawienieMacierzowe1 alg2 =new PrzestawienieMacierzowe1();
            return  alg2.checkKey(text);
        } else {
            PrzestawienieMacierzowe2 alg3 = new PrzestawienieMacierzowe2();
            return alg3.checkKey(text);
        }
    }
}