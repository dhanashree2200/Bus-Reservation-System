package admin;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class Dashboard implements Initializable{

    @FXML
    private Label users;

    @FXML
    private Label booking;

    @FXML
    private Label date;

    @FXML
    private Label busses;

    @FXML
    private Label routes;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String d="Select * from addBus";
		String q="Select * from regis";
		String q1="Select * from confirm";
        int c=0,u=0,s=0;
        try{
                   
                   Class.forName("com.mysql.jdbc.Driver");
                    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bus","root","root")) {
                        Statement st=con.createStatement();
                        ResultSet rs=st.executeQuery(d);
                        
                        while(rs.next()){
                        	c++;
                        }
                        ResultSet rs1=st.executeQuery(q);
                        while(rs1.next()) {
                        	u++;
                        }
                        ResultSet rs2=st.executeQuery(q1);
                        while(rs2.next()) {
                        	s++;
                        }
                        System.out.println(c);
                        System.out.println(u);
                        System.out.println(s);
                        users.setText(Integer.toString(u));
                        booking.setText(Integer.toString(s));
                        LocalDate d1=java.time.LocalDate.now();
                        String da=d1.toString();
                        date.setText(da);
                        busses.setText(Integer.toString(c));
                        routes.setText(Integer.toString(c));
                        }
                    
        }
        catch(Exception e) {
        	
        }
        
        
	}
    
    
}