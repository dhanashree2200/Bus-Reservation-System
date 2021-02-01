package admin;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class updatebus implements Initializable{
	
	ObservableList<String> list1=FXCollections.observableArrayList("AC","Non-AC");
	ObservableList<String> list2=FXCollections.observableArrayList("Sleeper","Non-Sleeper");


    @FXML
    private JFXTextField no;

    @FXML
    private JFXTextField amt;

    @FXML
    private JFXTimePicker at;

    @FXML
    private JFXTimePicker dt;

    @FXML
    private JFXComboBox<String> bt;

    @FXML
    private JFXComboBox<String> bt2;

    @FXML
    private JFXButton update;

    @FXML
    private JFXDatePicker pf;

    @FXML
    private JFXDatePicker pt;
    
    int f=0;


    @FXML
    void check(MouseEvent event) {
    	
    	String n1=no.getText();
    	String q1="select no from addBus";
    	try{
    				f=0;
    	            
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
    	                 
    	                 System.out.println("Inserted");
    	             }
    	        }
    	        catch(ClassNotFoundException | SQLException e){
    	            
    	        } 
    }

 
    @FXML
    void update(ActionEvent event) {	
    	
    	String bt1=bt.getValue();
    	String bt3=bt2.getValue();
    	String atm=amt.getText();
    	LocalTime at1=at.getValue();
    	LocalTime dt1=dt.getValue();
    	LocalDate pf1=pf.getValue();
    	LocalDate pt1=pt.getValue();
    	String gg=no.getText();
    	
    	String q="UPDATE addBus SET ty = '"+bt1+"', ty2 = '"+bt3+"', dt = '"+dt1+"', at = '"+at1+"', of = '"+pf1+"', ot = '"+pt1+"', amount = '"+atm+"' WHERE no = '"+gg+"';";

try{
            
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("h2");
             try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bus","root","root")) {
                 System.out.println("h3");
                 Statement st=con.createStatement();
                 System.out.println("h4");
                 
                
                 
                 int c=st.executeUpdate(q);
                 
                
                 
                 System.out.println("Inserted");
             }
        }
        catch(ClassNotFoundException | SQLException e){
            
        } 
    	

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		bt.setItems(list1);
		bt2.setItems(list2);

		
	}

}