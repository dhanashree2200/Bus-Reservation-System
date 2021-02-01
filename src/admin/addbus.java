package admin;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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


public class addbus implements Initializable
{
	
	ObservableList<String> list=FXCollections.observableArrayList("Pune","Mumbai","Nashik","Aurangabad");
	ObservableList<String> list1=FXCollections.observableArrayList("AC","Non-AC");
	ObservableList<String> list2=FXCollections.observableArrayList("Sleeper","Non-Sleeper");
	
    @FXML
    private JFXComboBox<String> from;

    @FXML
    private JFXComboBox<String> to;

    @FXML
    private JFXComboBox<String> type;

    @FXML
    private JFXComboBox<String> type2;
    

    @FXML
    private JFXTimePicker dtime;

    @FXML
    private JFXTimePicker atime;


    @FXML
    private JFXDatePicker ofrom;

    @FXML
    private JFXDatePicker oto;

    @FXML
    private JFXTextField no;
    
    @FXML
    private JFXTextField amt;

    @FXML
    private JFXButton submit;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		from.setItems(list);
		to.setItems(list);
		type.setItems(list1);
		type2.setItems(list2);
	}

    @FXML
    void submit1(ActionEvent event) {
    	String f=from.getValue();
    	System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiii "+f);
    	String t=to.getValue();
    	String t1=type.getValue();
    	String t2=type2.getValue();
    	LocalTime dt=dtime.getValue();
    	LocalTime at=atime.getValue();
    	LocalDate  of=ofrom.getValue();
    	LocalDate  ot=oto.getValue();
    	String  bn=no.getText();
    	String a1=amt.getText();

    	
    	
    	String q="insert into addBus(no,fr,t,ty,ty2,dt,at,of,ot,amount) values('"+bn+"','"+f+"','"+t+"','"+t1+"','"+t2+"','"+dt+"','"+at+"','"+of+"','"+ot+"','"+a1+"');";
    	System.out.println("hi");
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

}
