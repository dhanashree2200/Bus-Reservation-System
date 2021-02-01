package admin;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

public class busdetails implements Initializable{
	
	ObservableList<String> list=FXCollections.observableArrayList("Pune","Mumbai","Nashik","Aurangabad");
	
    @FXML
    private JFXComboBox<String> f1;

    @FXML
    private JFXComboBox<String> t1;

    @FXML
    private TableView<detailTable> details;

    @FXML
    private TableColumn<detailTable, Integer> sr;

    @FXML
    private TableColumn<detailTable, String> no;

    @FXML
    private TableColumn<detailTable, String> fr;

    @FXML
    private TableColumn<detailTable, String> t2;
    
    @FXML
    private TableColumn<detailTable, String> at;

    @FXML
    private TableColumn<detailTable, String> dt;


    @FXML
    private JFXButton check;
    
    @FXML
    private Label empty;
    
    @FXML
    private JFXButton all;

    @FXML
    void allBusses(ActionEvent event) {
    	details.getItems().clear();
    	String d="Select * from addBus";
        Integer c=1;
        
				        
         try{
                    
                    Class.forName("com.mysql.jdbc.Driver");
                     try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bus","root","root")) {
                         Statement st=con.createStatement();
                         ResultSet rs=st.executeQuery(d);

                         
                         
                         System.out.println("f1 = "+f1);
                         while(rs.next()){
                        	 
                         	olist1.add(new detailTable(c,rs.getString("no"),rs.getString("fr"),rs.getString("t"),rs.getString("at"),rs.getString("dt")));
                         	c++;}
                         }
                     
                     
         }
         catch(Exception e) {
         	
         }
                     
                         
 		System.out.println("os = "+olist1);
 		
 		sr.setCellValueFactory(new PropertyValueFactory<detailTable, Integer>("source"));
 		no.setCellValueFactory(new PropertyValueFactory<detailTable, String>("busno"));
 		fr.setCellValueFactory(new PropertyValueFactory<detailTable, String>("from"));
 		t2.setCellValueFactory(new PropertyValueFactory<detailTable, String>("to1"));
 		at.setCellValueFactory(new PropertyValueFactory<detailTable, String>("ariT"));
 		dt.setCellValueFactory(new PropertyValueFactory<detailTable, String>("depT"));
 		System.out.println("bye2");
 		details.setItems(olist1);
 		System.out.println("bye3");
 		if(olist1.isEmpty()) {
 			empty.setText("No bus available");
 			empty.setTextFill(Color.web("#ff0000", 0.8));
 		}
    	 
    }
    ObservableList<detailTable> olist1=FXCollections.observableArrayList();
    
    
    
    
    @FXML
    void check(ActionEvent event) {
    	details.getItems().clear();
    	empty.setText("");
    	String ff=f1.getValue();
    	String tt=t1.getValue();
    	System.out.println("ff = "+ff);
    	System.out.println("tt = "+tt);
    	
    	System.out.println("bye");
 		String d="Select * from addBus";
         Integer c=1;
         
         try{
                    
                    Class.forName("com.mysql.jdbc.Driver");
                     try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bus","root","root")) {
                         Statement st=con.createStatement();
                         ResultSet rs=st.executeQuery(d);
                         
                         
                         
                         while(rs.next()){
                        	 if(rs.getString("fr").equals(ff) && rs.getString("t").equals(tt)) {
                         	olist.add(new detailTable(c,rs.getString("no"),rs.getString("fr"),rs.getString("t"),rs.getString("at"),rs.getString("dt")));
                         	c++;}
                         }
                     }
         }
         catch(Exception e) {
         	
         }
                     
                         
 		System.out.println("os = "+olist);
 		
 		sr.setCellValueFactory(new PropertyValueFactory<detailTable, Integer>("source"));
 		no.setCellValueFactory(new PropertyValueFactory<detailTable, String>("busno"));
 		fr.setCellValueFactory(new PropertyValueFactory<detailTable, String>("from"));
 		t2.setCellValueFactory(new PropertyValueFactory<detailTable, String>("to1"));
 		at.setCellValueFactory(new PropertyValueFactory<detailTable, String>("ariT"));
 		dt.setCellValueFactory(new PropertyValueFactory<detailTable, String>("depT"));
 		System.out.println("bye2");
 		details.setItems(olist);
 		System.out.println("bye3");
 		if(olist.isEmpty()) {
 			empty.setText("No bus available");
 			empty.setTextFill(Color.web("#ff0000", 0.8));
 		}
    	 
    }
    ObservableList<detailTable> olist=FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		f1.setItems(list);
		t1.setItems(list);

	}
}
