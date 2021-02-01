package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class login {
	

    @FXML
    private BorderPane mainPane;

    @FXML
    private JFXTextField id;

    @FXML
    private JFXPasswordField pass;
    
    public static Stage stage1=new Stage();

    @FXML
    void reg(ActionEvent event) {
    	try {
    		FXMLLoader root = new FXMLLoader(getClass().getResource("/application/Regis.fxml"));
			Parent r=(Parent)root.load();
			Stage stage=new Stage();		
			stage.setTitle("REGISTRATION FORM");
			stage.setScene(new Scene(r));
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }


    @FXML
    void submit(ActionEvent event) {
        String q="Select * from regis";
        System.out.println("hi");
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("h2");
             try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bus","root","root")) {
                 System.out.println("h3");
                 Statement st=con.createStatement();
                 System.out.println("h4");
                 ResultSet c=st.executeQuery(q);
                 String id1=id.getText();
                 String p1=pass.getText();
                 System.out.println(id1);
                 System.out.println(p1);
                 int flag=1;
                 String i2,p2;
                 while(c.next()){
                	 i2=c.getString("id");
                	 p2= c.getString("pass");
                     System.out.println("ssi       "+c.getString("id"));
                    if(i2.equals(id1)) {
                    	if(p2.equals(p1)) {
                             flag=2;
                         }  
                    }
                 }
                    if(flag==2) {
                    	Alert a=new Alert(AlertType.CONFIRMATION);
                    	a.setTitle("Success");
                    	a.setContentText("Login Sucessful");
                    	a.showAndWait();
                    	try {
                    		FXMLLoader root = new FXMLLoader(getClass().getResource("/application/SeatsLayout.fxml"));
                			Parent r=(Parent)root.load();
                		    	
                			stage1.setTitle("ADMIN LOGIN FORM");
                			stage1.setScene(new Scene(r));
                			stage1.show();
                		} catch(Exception e) {
                			e.printStackTrace();
                		}
                    }
                    else {
                    	Alert a=new Alert(AlertType.ERROR);
                    	a.setTitle("ERROR");
                    	a.setContentText("Credential does not match ");
                    	a.showAndWait();
                    }
                 
             }
        }
                 catch(ClassNotFoundException | SQLException ae){
                     
                 }  
           
        
    }
}
