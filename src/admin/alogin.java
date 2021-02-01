package admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class alogin {

    @FXML
    private AnchorPane ap;

    @FXML
    private JFXTextField uname;

    @FXML
    private JFXButton submit;

    @FXML
    private JFXPasswordField pass;


    @FXML
    void submit(ActionEvent event) {
    	String u=uname.getText();
    	System.out.println("hii");
    	String p=pass.getText();
    	System.out.println("hii");
    	System.out.println(u+"  "+p);
    	if(u.equals("a") && p.equals("a")) {
    		System.out.println("hii");
    		
        	try {
        		FXMLLoader root = new FXMLLoader(getClass().getResource("/admin/Main1.fxml"));
    			Parent r=(Parent)root.load();
    			Stage stage=new Stage();		
    			stage.setTitle("ADMIN FORM");
    			stage.setScene(new Scene(r));
    			stage.show();
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
        	application.main1.stage1.hide();
    	}
    	else {
    		Alert a=new Alert(AlertType.ERROR);
        	a.setTitle("ERROR");
        	a.setContentText("Credential does not match ");
        	a.showAndWait();
    	}
    }

}
