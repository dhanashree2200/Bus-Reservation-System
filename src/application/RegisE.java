package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class RegisE {
	
    @FXML
    private AnchorPane mainPane;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField id;

    @FXML
    private JFXPasswordField pass;

    @FXML
    private JFXPasswordField cpass;

    @FXML
    private JFXTextField mob;
    

    @FXML
    private Label white;
    
    @FXML
    void white(MouseEvent event) {
    	if(id.getText().contains(" ")) {
    		white.setText("White space not allowed");
    	}
    }


    @FXML
    void click(ActionEvent event) {
    	System.out.println("You clicked "+event);
    	String n=name.getText();
        String i=id.getText();
        String p=pass.getText();
        String p2=cpass.getText();
        String m=mob.getText();
        System.out.println(p);
        System.out.println(p2);
        if(!p.equals(p2)) {
        	Alert a=new Alert(AlertType.WARNING);
        	a.setTitle("Error");
        	a.setContentText("Password does not match");
        	a.showAndWait();
        }
        if(id.getText().contains(" ")) {
        	Alert a=new Alert(AlertType.ERROR);
        	a.setTitle("ERROR");
        	a.setContentText("White space not allowed");
        	a.showAndWait();
        }
        else {
    	System.out.println("hi");
    	Alert a=new Alert(AlertType.CONFIRMATION);
    	a.setTitle("SUCCESS");
    	a.setContentText("Registration Successful");
    	a.showAndWait();
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("h2");
             try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bus","root","root")) {
                 System.out.println("h3");
                 Statement st=con.createStatement();
                 System.out.println("h4");
                 System.out.println(n);
                 LocalDate d=java.time.LocalDate.now();
                 System.out.println("date = "+d);
                 String q="insert into regis(name,id,pass,mob,date1) values('"+n+"','"+i+"','"+p+"','"+m+"','"+d+"')";
                 
                 int s=st.executeUpdate(q);
                 System.out.println("Inserted");
             }
        }
        catch(ClassNotFoundException | SQLException e){
            
    }
        
        }
}
    @FXML
    void reset(ActionEvent event) {
    	name.setText("");
    	id.setText("");
    	pass.setText("");
    	cpass.setText("");
    	mob.setText("");
    }
}