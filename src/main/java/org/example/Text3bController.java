package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class Text3bController {

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

    public void switchToAlg1Text(ActionEvent actionEvent) throws IOException {
        App.setRoot("Text3");
    }

    public void switchToAlg2File(ActionEvent actionEvent) throws IOException {
        App.setRoot("Files3");
    }

    public void switchToAlg2Text(ActionEvent actionEvent) {
    }


    public void submit(ActionEvent actionEvent) {
    }

    public void submit1(ActionEvent actionEvent) {
    }
}
