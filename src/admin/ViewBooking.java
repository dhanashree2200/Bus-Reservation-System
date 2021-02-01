package admin;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

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

public class ViewBooking implements Initializable{
	ObservableList<String> list=FXCollections.observableArrayList("Pune","Mumbai","Nashik","Aurangabad");
	ObservableList<VIEW> olist=FXCollections.observableArrayList();
	
    @FXML
    private TableView<VIEW> view;
	
    @FXML
    private JFXComboBox<String> from;

    @FXML
    private JFXComboBox<String> to;

    @FXML
    private TableColumn<VIEW,Integer> s1;

    @FXML
    private TableColumn<VIEW, String> b1;

    @FXML
    private TableColumn<VIEW, String> u1;

    @FXML
    private TableColumn<VIEW, String> d1;

    @FXML
    private TableColumn<VIEW, String> bn1;

    @FXML
    private TableColumn<VIEW, String> se1;
    
    @FXML
    private Label empty;

    @FXML
    void submit(ActionEvent event) {
    	view.getItems().clear();
    	empty.setText("");
    	String d="Select * from confirm";
        String ff=from.getValue();
        String tt=to.getValue();
        Integer c=1;
        
        try{
                   
                   Class.forName("com.mysql.jdbc.Driver");
                    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bus","root","root")) {
                        Statement st=con.createStatement();
                        ResultSet rs=st.executeQuery(d);
                        
                        
                        
                        while(rs.next()){
                       	 if(rs.getString("f1").equals(ff) && rs.getString("t1").equals(tt)) {
                       		 String f=rs.getString("first");
                       		 String l=rs.getString("last");
                       		 String fl=f+" "+l;
                       		String s=rs.getString("seats");
                       		String st1=s.substring(0, s.length()-1);
                        	olist.add(new VIEW(c,rs.getString("noo"),fl,rs.getString("dat"),rs.getString("bno"),st1));
                        	c++;}
                        }
                    }
        }
        catch(Exception e) {
        	
        }
                    
                        
		System.out.println("os = "+olist);
		
		s1.setCellValueFactory(new PropertyValueFactory<VIEW, Integer>("s1"));
		b1.setCellValueFactory(new PropertyValueFactory<VIEW, String>("b2"));
		u1.setCellValueFactory(new PropertyValueFactory<VIEW, String>("u2"));
		d1.setCellValueFactory(new PropertyValueFactory<VIEW, String>("d2"));
		bn1.setCellValueFactory(new PropertyValueFactory<VIEW, String>("bn2"));
		se1.setCellValueFactory(new PropertyValueFactory<VIEW, String>("s2"));
		System.out.println("bye2");
		view.setItems(olist);
		System.out.println("bye3");
		if(olist.isEmpty()) {
			empty.setText("No bus available");
			empty.setTextFill(Color.web("#ff0000", 0.8));
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		from.setItems(list);
		to.setItems(list);
		
	}

}