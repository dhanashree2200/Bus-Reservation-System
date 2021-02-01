package application;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main1 {

    @FXML
    private JFXButton admin;

    @FXML
    private JFXButton user;
    public static Stage stage1=new Stage();	

    @FXML
    void admin(ActionEvent event) {
    	try {
    		FXMLLoader root = new FXMLLoader(getClass().getResource("/admin/ALogin.fxml"));
			Parent r=(Parent)root.load();
				
			stage1.setTitle("ADMIN LOGIN FORM");
			stage1.setScene(new Scene(r));
			stage1.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void user(ActionEvent event) {
    	try {
    		FXMLLoader root = new FXMLLoader(getClass().getResource("/application/UP11.fxml"));
			Parent r=(Parent)root.load();
			Stage stage=new Stage();		
			stage.setTitle("BUS RESERVATION FORM");
			stage.setScene(new Scene(r));
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

}
