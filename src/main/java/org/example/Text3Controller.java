package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.algoritms.*;


import java.io.IOException;

public class Text3Controller {



    @FXML
    public TextArea algoritmOutput;

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
    @FXML
    public void switchLesson5(ActionEvent actionEvent) {

    }
    @FXML
    public void switchLesson6(ActionEvent actionEvent) {

    }
    @FXML
    public void switchLesson7(ActionEvent actionEvent) {

    }
    

    public void switchToAlg1Text(ActionEvent actionEvent) {
    }

    public void switchToAlg2File(ActionEvent actionEvent) throws IOException {
        App.setRoot("Files3");
    }

    public void switchToAlg2Text(ActionEvent actionEvent) throws IOException {
        App.setRoot("Text3b");
    }

    public void submit(ActionEvent actionEvent) {

      //  algoritmOutput.setText(algoritmOutput.getText() +"\n" + Math.random());
    }
}
