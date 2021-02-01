package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

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

public class ViewTicket implements Initializable{
	

    @FXML
    private TableView<VT> view;

    @FXML
    private TableColumn<VT,String> from;

    @FXML
    private TableColumn<VT,String> to;

    @FXML
    private TableColumn<VT,String> arit;

    @FXML
    private TableColumn<VT,String> dept;

    @FXML
    private TableColumn<VT,String> sno;

    @FXML
    private JFXTextField bno;
    
    @FXML
    private Label empty;
    
    ObservableList<VT> olist1=FXCollections.observableArrayList();


    @FXML
    void submit(ActionEvent event) {
    	view.getItems().clear();
    	String d="Select * from confirm";
        String no=bno.getText(); 
         try{
                    
                    Class.forName("com.mysql.jdbc.Driver");
                     try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bus","root","root")) {
                         Statement st=con.createStatement();
                         ResultSet rs=st.executeQuery(d);
                         
                         
                         String se="",s1="";
                         while(rs.next()){
                        	 if(rs.getString("noo").equals(no)) {
                        		 se=rs.getString("seats");
                        		 s1=se.substring(0, se.length()-1);
                         	olist1.add(new VT(rs.getString("f1"),rs.getString("t1"),rs.getString("at"),rs.getString("dt"),s1));
                         	}
                         }
                         }
                     
         }
         catch(Exception e) {
         	
         }
                     
                         
 		System.out.println("os = "+olist1);
 		
 		from.setCellValueFactory(new PropertyValueFactory<VT, String>("f1"));
 		to.setCellValueFactory(new PropertyValueFactory<VT, String>("t1"));
 		arit.setCellValueFactory(new PropertyValueFactory<VT, String>("a1"));
 		dept.setCellValueFactory(new PropertyValueFactory<VT, String>("d1"));
 		sno.setCellValueFactory(new PropertyValueFactory<VT, String>("s1"));
 		view.setItems(olist1);
 		if(olist1.isEmpty()) {
 			empty.setText("No Bookings Done");
 			empty.setTextFill(Color.web("#ff0000", 0.8));
 		}
    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
