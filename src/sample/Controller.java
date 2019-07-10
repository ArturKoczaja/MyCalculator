package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class Controller {

    @FXML
    private TextField input;

    @FXML
    void point(ActionEvent event) {
        String text = input.getText();
        input.setText(text + ".");
    }

    @FXML
    void add(ActionEvent event) {
        String text = input.getText();
        input.setText(text + "+");
    }

    @FXML
    void divide(ActionEvent event) {
        String text = input.getText();
        input.setText(text + "/");
    }

    @FXML
    void multiply(ActionEvent event) {
        String text = input.getText();
        input.setText(text + "*");
    }

    @FXML
    void remove(ActionEvent event) {
        input.setText("");
    }

    @FXML
    void result(ActionEvent event) {
        String text = input.getText().replace(",", ".");


        try{
            Double result = Calculator.count(text);
            input.setText(String.format("%.3f", result));
        }catch (Exception e){
            String result = "Something went wrong :(";
            input.setText(result);
        }
    }

    @FXML
    void subtract(ActionEvent event) {
        String text = input.getText();
        input.setText(text + "-");
    }

    @FXML
    void eight(ActionEvent event) {
        String text = input.getText();
        input.setText(text + "8");

    }

    @FXML
    void five(ActionEvent event) {
        String text = input.getText();
        input.setText(text + "5");
    }

    @FXML
    void four(ActionEvent event) {
        String text = input.getText();
        input.setText(text + "4");
    }

    @FXML
    void nine(ActionEvent event) {
        String text = input.getText();
        input.setText(text + "9");
    }

    @FXML
    void one(ActionEvent event) {
        String text = input.getText();
        input.setText(text + "1");
    }

    @FXML
    void seven(ActionEvent event) {
        String text = input.getText();
        input.setText(text + "7");
    }

    @FXML
    void six(ActionEvent event) {
        String text = input.getText();
        input.setText(text + "6");
    }

    @FXML
    void three(ActionEvent event) {
        String text = input.getText();
        input.setText(text + "3");
    }

    @FXML
    void two(ActionEvent event) {
        String text = input.getText();
        input.setText(text + "2");
    }

    @FXML
    void zero(ActionEvent event) {
        String text = input.getText();
        input.setText(text + "0");
    }

}