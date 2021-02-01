package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Check implements Initializable{
	
	ObservableList<String> list=FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10");
	
    @FXML
    private AnchorPane ap;

    @FXML
    private JFXComboBox<String> no;
    JFXButton b1;

    @FXML
    void submit(ActionEvent event) {
    	b1=new JFXButton("Hi");
    	ap.getChildren().add(b1);
    	b1.setLayoutX(100);
    	b1.setLayoutY(100);
    	

       
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		no.setItems(list);
	}


}
