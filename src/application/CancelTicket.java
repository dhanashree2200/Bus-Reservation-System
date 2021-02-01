package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;

import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

public class CancelTicket {

    @FXML
    private JFXTextField no;

    @FXML
    private Label empty;
    
    @FXML
    void submit(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
		 alert.setTitle("Confirmation Dialog");
		 alert.setHeaderText("Do you want to cancel ticket??");
		 Optional<ButtonType> result = alert.showAndWait();
		 if (result.get() == ButtonType.OK){
			 String d="Select * from confirm";
			 String n11=no.getText();
			 String q1="delete from confirm where noo = "+n11+";";
		        String no1=no.getText(); 
		        int f=0;
		         try{
		                    
		                    Class.forName("com.mysql.jdbc.Driver");
		                     try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bus","root","root")) {
		                         Statement st=con.createStatement();
		                         ResultSet rs=st.executeQuery(d);
		                         
		                         
		                         while(rs.next()){
		                        	 System.out.println("ggg noo = "+rs.getString("noo")+"\n n1 = "+n11);
		                        	 if(rs.getString("noo").equals(n11)) {
		                        		 System.out.println("noo = "+rs.getString("noo")+"\n n1 = "+n11);
		                        		 f=1;
		                         	}
		                         }
		                         if(f==1) {
		                        	 System.out.println("d");
		                        	 int c=st.executeUpdate(q1);
		                        	 System.out.println("d");
		                         }
		                         if(f==0) {
		    	                	 Alert a=new Alert(AlertType.ERROR);
		     	                 	a.setTitle("ERROR");
		     	                 	a.setContentText("Booking number not found");
		     	                 	a.showAndWait();
		    	                 }
		                         }
		                     
		         }
		         catch(Exception e) {
		         	
		         }
		 } else {
		     // ... user chose CANCEL or closed the dialog
		 }
    	
    }

}