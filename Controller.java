package com.internshala.newjavafxapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
	public Label welcomeLabel;
	@FXML
	public ChoiceBox<String>  choiceBox;
	@FXML
	public TextField userInputField;
	@FXML
	public Button convertButton;
	private static final String C_To_F_Text ="Celsius to Fahrenheit";
	private static final String F_To_C_Text ="Fahrenheit to Celsius";
	private boolean isC_To_F = true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		choiceBox.getItems().add(C_To_F_Text);
		choiceBox.getItems().add(F_To_C_Text);
		choiceBox.setValue(C_To_F_Text);
		choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
             if(newValue.equals(C_To_F_Text)){
             	isC_To_F= true;
             } else{
             	isC_To_F =false;
             }
		});
		convertButton.setOnAction(event-> {
                      convert();
		});

	}

	private void convert() {
	String input = userInputField.getText();
	float enterTemperature=0.0f;
	try {
		 enterTemperature = Float.parseFloat(input);
	}catch(Exception exception){
		warnUser();
		return;
	}
	float newTemperature=0.0f;
	if(isC_To_F){
		newTemperature = (enterTemperature * 9 /5) + 32;
	} else{
		newTemperature= (enterTemperature-32) *5 /9;
	}
	  display(newTemperature);

	}

	private void warnUser() {
		Alert alertDialog = new Alert(Alert.AlertType.ERROR);
		alertDialog.setTitle("Error Occured");
		alertDialog.setHeaderText("Invalid Temperature Entered");
		alertDialog.setContentText("Please enter a valid temperature");
		alertDialog.show();
	}

	private void display(float newTemperature) {
		String unit = isC_To_F? "F":"C";

		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("Result");
		alertDialog.setContentText("New Temperature is: "+ newTemperature + unit);
		alertDialog.show();
	}
	public void reset(){
		userInputField.clear();
		choiceBox.setValue(C_To_F_Text);

	}

}
