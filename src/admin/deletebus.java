package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class deletebus {

    @FXML
    private JFXButton del;
    
    @FXML
    private JFXTextField no;

    @FXML
    void submit(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
		 alert.setTitle("Confirmation");
		 alert.setHeaderText("Do you want to delete bus???");

		 Optional<ButtonType> result = alert.showAndWait();
		 if (result.get() == ButtonType.OK){
    	String n1=no.getText();
    	String q="delete from addBus where no = "+n1+";";
    	String q1="Select no from addBus";
    	int f=0;
		try{
               
               Class.forName("com.mysql.jdbc.Driver");
               System.out.println("h2");
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bus","root","root")) {
                    System.out.println("h3");
                    Statement st=con.createStatement();
                    System.out.println("h4");
                    ResultSet res=st.executeQuery(q1);
                    while(res.next()) {
	                	 if(res.getString("no").equals(n1)) {
	                		 f=1;
	                	 }
	                 }
	                 if(f==0) {
	                	 Alert a=new Alert(AlertType.ERROR);
 	                 	a.setTitle("ERROR");
 	                 	a.setContentText("Bus number not found");
 	                 	a.showAndWait();
	                 }
	                 if(f==1) {
	                	 
	                	 int c=st.executeUpdate(q);
	                 
	                 }
                    System.out.println("Deleted");
                }
		}
		catch(Exception e) {
			
		}
		 }
    }

}