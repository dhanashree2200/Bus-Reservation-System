package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

public class VUser {
	
	ObservableList<VU> olist=FXCollections.observableArrayList();
	ObservableList<VU> olist1=FXCollections.observableArrayList();
	
    @FXML
    private JFXTextField user1;
	
    @FXML
    private TableView<VU> user;

    @FXML
    private TableColumn<VU, Integer> s1;

    @FXML
    private TableColumn<VU, String> n1;

    @FXML
    private TableColumn<VU, String> u1;

    @FXML
    private TableColumn<VU, String> c1;

    @FXML
    private TableColumn<VU, String> r1;

    @FXML
    private Label empty;

    @FXML
    void all(ActionEvent event) {
    	user.getItems().clear();
    	String d="Select * from regis";
        Integer c=1;
				        
         try{
        	 System.out.println("pppp");
                    Class.forName("com.mysql.jdbc.Driver");
                    System.out.println("pppp");
                     try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bus","root","root")) {
                         Statement st=con.createStatement();
                         ResultSet rs=st.executeQuery(d);

                         
                         System.out.println("pppp");
                         while(rs.next()){ 
                        	 System.out.println("pppp");
                         	olist1.add(new VU(c,rs.getString("name"),rs.getString("id"),rs.getString("mob"),rs.getString("date1")));
                         	c++;
                         	}
                         }
         }
         catch(Exception e) {
         	
        }                 
 		s1.setCellValueFactory(new PropertyValueFactory<VU, Integer>("s2"));
 		n1.setCellValueFactory(new PropertyValueFactory<VU, String>("n2"));
 		u1.setCellValueFactory(new PropertyValueFactory<VU, String>("u2"));
 		c1.setCellValueFactory(new PropertyValueFactory<VU, String>("c2"));
 		r1.setCellValueFactory(new PropertyValueFactory<VU, String>("r2"));
 		System.out.println("bye2");
 		user.setItems(olist1);
 		System.out.println("bye3");
 		if(olist1.isEmpty()) {
 			empty.setText("No users available");
 			empty.setTextFill(Color.web("#ff0000", 0.8));
 		}
    }

    @FXML
    void submit(ActionEvent event) {
    	user.getItems().clear();
    	empty.setText("");
    	String use=user1.getText();
    	
    	System.out.println("bye");
 		String d="Select * from regis";
         Integer c=1;
         
         try{
                    
                    Class.forName("com.mysql.jdbc.Driver");
                     try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bus","root","root")) {
                         Statement st=con.createStatement();
                         ResultSet rs=st.executeQuery(d);
                         
                         
                         
                         while(rs.next()){
                        	 if(rs.getString("name").equals(use)) {
                        		 olist.add(new VU(c,rs.getString("name"),rs.getString("id"),rs.getString("mob"),rs.getString("date1")));
                         	c++;}
                         }
                     }
         }
         catch(Exception e) {
         	
         }
                     
                         
 		System.out.println("os = "+olist);
 		
 		s1.setCellValueFactory(new PropertyValueFactory<VU, Integer>("s2"));
 		n1.setCellValueFactory(new PropertyValueFactory<VU, String>("n2"));
 		u1.setCellValueFactory(new PropertyValueFactory<VU, String>("u2"));
 		c1.setCellValueFactory(new PropertyValueFactory<VU, String>("c2"));
 		r1.setCellValueFactory(new PropertyValueFactory<VU, String>("r2"));
 		System.out.println("bye2");
 		user.setItems(olist);
 		System.out.println("bye3");
 		if(olist.isEmpty()) {
 			empty.setText("No such user available");
 			empty.setTextFill(Color.web("#ff0000", 0.8));
 		}
    }


}
