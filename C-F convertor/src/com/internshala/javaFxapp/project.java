package com.internshala.javaFxapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class project implements Initializable {
    public Button button;
    public Label label;
    public TextField text;
    public ChoiceBox choicebox;
    public String C_to_F="Celcius to Farenhite";
    public String F_to_C="Farenhite to Celcius";
    public boolean isC_to_F=true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choicebox.getItems().add(C_to_F);
        choicebox.getItems().add(F_to_C);
        choicebox.setValue(C_to_F);
        choicebox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<?extends String> observable, String oldValue, String newValue) {
            if(newValue.equals(C_to_F))
            {
                isC_to_F=true;
                System.out.println("celcius value");
            }
            else
            {
                isC_to_F=false;
                System.out.println("Farenhite value");
            }
            }

        });

        button.setOnAction(event -> {
            convert();
        });

    }


    private void convert() {
        String texting = text.getText();
        float givenvalue=0.0f;
        try{
             givenvalue=Float.parseFloat(texting);
        }
        catch (Exception exception)
        {
            warnuser();
            return;
        }
        float nval=0.0f;
        if(isC_to_F)
        {
        nval=(givenvalue*9/5)+32;
        }
        else
        {
            nval=(givenvalue-32)*5/9;
        }
        show(nval);
    }

    private void warnuser() {
        Alert alertdialogue=new Alert(Alert.AlertType.ERROR);
        alertdialogue.setTitle("Error occured");
        alertdialogue.setHeaderText("invalid temparature entered");
        alertdialogue.setContentText("Please enter a valid temparature");
        alertdialogue.show();
    }

    private void show(float nval) {
        Alert alertdialogue=new Alert(Alert.AlertType.INFORMATION);
        alertdialogue.setTitle("result");
        alertdialogue.setHeaderText("the value will be");
        alertdialogue.setContentText(String.valueOf(nval));
        alertdialogue.show();
    }
}
