package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class seatlayout implements Initializable{
	
	public static Stage stage3=new Stage();

    @FXML
    private JFXButton submit;
    

    @FXML
    private JFXButton book;
    
    @FXML
    private Label stt;
    
	int f=0;
	static String ap="";
	
    @FXML
    void book(ActionEvent event) {
    	login lo=new login();
    	lo.stage1.hide();
    	try {
    		FXMLLoader root = new FXMLLoader(getClass().getResource("/application/checkout.fxml"));
			Parent r=(Parent)root.load(); 	
			stage3.setTitle("Checkout");
			stage3.setScene(new Scene(r));
			stage3.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void click(MouseEvent event) {
    	
    	Object b=event.getSource();
    	Object c=(Button)b;
    	f=1;
    	String gg=c.toString();
    	String[] l=gg.split("'");
    	
    	String q1="select * from confirm;";
    	int flag=0;
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("h2");
             try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bus","root","root")) {
                 Statement st=con.createStatement();
                 ResultSet rs=st.executeQuery(q1);
                 String[] s2;
                
                 while(rs.next()){
                	 
                	 String s1=rs.getString("seats");
                	 s2=s1.split(",");
                	 for(int i=0;i<s2.length;i++) {
                		 String o;
                		 LocalDate t=bookticket.dt;
                		 o=t.toString();
                		
                		 if(s2[i].equals(l[1])) {
                			 if(rs.getString("dat").equals(o)){
                			flag=1;
                			break;
                		 }
                		 }
                	
                	 }
                 }
                	 System.out.println("flag = "+flag);
                	 if(flag==1) {
                		 System.out.println("hiii");
                		 Alert a=new Alert(AlertType.WARNING);
         	        	a.setTitle("Error");
         	        	a.setContentText("Seat already booked, select another seat");
         	        	a.showAndWait();
         	        	((Node) c).setStyle("-fx-background-color:  #f34e2d;");
                	 }
                	 else{
                		 ((Node) c).setStyle("-fx-background-color: #56ae33;");
            		    	ap=ap+l[1]+",";
                	 }
                 
             }
        }
        catch(Exception e) {
        	
        }
        
    	System.out.println(c);
    	
    	
    	
    }
    


    
    @FXML
    void enter(MouseEvent event) {
    	f=0;
    	Object b=event.getSource();
    	Object c=(Button)b;
    	((Node) c).setStyle("-fx-background-color:  #56ae33;");
    }

    @FXML
    void exit(MouseEvent event) {
    	if(f==0) {
    	Object b=event.getSource();
    	Object c=(Button)b;
    	((Node) c).setStyle("-fx-background-color:  #f34e2d;");
    	f=0;
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String q1="select * from confirm;";
		// TODO Auto-generated method stub
		try{
		            
		            Class.forName("com.mysql.jdbc.Driver");
		            System.out.println("h2");
		             try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bus","root","root")) {
		                 Statement st=con.createStatement();
		                 ResultSet rs=st.executeQuery(q1);
		                 String s2="";
		                 String s3="";
		                 String o1;
                		 LocalDate t1=bookticket.dt;
                		 o1=t1.toString();
		                 while(rs.next()){
		                	 if(rs.getString("dat").equals(o1)) {
		                	 s3=rs.getString("seats");
		                	 s2=s2+s3;
		                	 }
		                 }
		                 String sub=s2.substring(0, s2.length()-1);
		                
                		 
		                 stt.setText(sub);
                		 
		             }
		        }
		        catch(Exception e) {
		        	
		        }
		
	}



}