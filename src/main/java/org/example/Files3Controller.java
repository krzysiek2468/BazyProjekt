package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class Files3Controller {

    @FXML
    public void switchLesson1(ActionEvent actionEvent) throws IOException {
        App.setRoot("Files");

    }
    @FXML
    public void switchLesson2(ActionEvent actionEvent) throws IOException {
        App.setRoot("Files2");
    }
    @FXML
    public void switchLesson3(ActionEvent actionEvent){

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

    public void switchToAlg2File(ActionEvent actionEvent) {
    }

    public void switchToAlg2Text(ActionEvent actionEvent) throws IOException {
        App.setRoot("Text3b");
    }

    public void switchToAlg1Text(ActionEvent actionEvent) throws IOException {
        App.setRoot("Text3");
    }

    public void getPath1Encryption(ActionEvent actionEvent) {
    }

    public void getPath2Encryption(ActionEvent actionEvent) {
    }

    public void submitEncryption(ActionEvent actionEvent) {
    }

    public void getPath1Decryption(ActionEvent actionEvent) {
    }

    public void getPath2Decryption(ActionEvent actionEvent) {
    }

    public void submitDecryption(ActionEvent actionEvent) {
    }
}
