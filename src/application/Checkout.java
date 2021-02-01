package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Random;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Checkout implements Initializable{
	
	ObservableList<String> list=FXCollections.observableArrayList("Mr.","Mrs.","Ms.");

    @FXML
    private Label date;

    @FXML
    private Label from;

    @FXML
    private Label at;

    @FXML
    private Label to;

    @FXML
    private Label dt;
    
    @FXML
    private Label seats;

    @FXML
    private Label tot;

    @FXML
    private Label price;

    @FXML
    private Label totp;
    
    @FXML
    private Label from1;
    
    @FXML
    private Label to1;
    

    @FXML
    private Label tot1;
    
    @FXML
    private JFXComboBox<String> title;

    @FXML
    private JFXTextField fn;

    @FXML
    private JFXTextField ln;

    @FXML
    private JFXTextField pn;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXButton back;

    @FXML
    private JFXButton submit;
    
    public static Stage stage22,stage1;
    
    public static String tit,fir,last,phone,el,rand; 

    @FXML
    void back(ActionEvent event) {
    	try {
    		FXMLLoader root = new FXMLLoader(getClass().getResource("/application/SeatsLayout.fxml"));
			Parent r=(Parent)root.load();
		    stage1=new Stage();
			stage1.setTitle("Seat Layout");
			stage1.setScene(new Scene(r));
			stage1.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void submit(ActionEvent event) {
    	
    	 tit=title.getValue();
    	 fir=fn.getText();
    	 last=ln.getText();
    	 phone=pn.getText();
    	 el=email.getText();
    	 if(phone.length()!=0) {
    		 
    		 Alert a=new Alert(AlertType.ERROR);
          	a.setTitle("ERROR");
          	a.setContentText("Enter valid contact number");
          	a.showAndWait();
    	 }
    	 if(!el.contains("@")) {
    		 if(!el.contains(".")) {
    			 Alert a=new Alert(AlertType.ERROR);
              	a.setTitle("ERROR");
              	a.setContentText("Enter valid email-id");
              	a.showAndWait();
    		 }
    	 }
    	 else {
    	Random ran=new Random();
    	int num=ran.nextInt(90000)+10000;
    	System.out.println("RANDOM + "+num);
    	rand=Integer.toString(num);
    	

		try {
			FXMLLoader root = new FXMLLoader(getClass().getResource("/application/preview.fxml"));
			Parent r=(Parent)root.load();
			stage22=new Stage();		
			stage22.setTitle("PREVIEW");
			stage22.setScene(new Scene(r));
			stage22.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		}

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		title.setItems(list);
		System.out.println("1");
		String dtt=bookticket.ud;
		date.setText(dtt);
		from.setText(bookticket.ff1);
		from1.setText(bookticket.ff1);
		to.setText(bookticket.tt1);
		to1.setText(bookticket.tt1);
		at.setText(checka.a1);
		dt.setText(checka.d1);
		System.out.println("2");
		String st=seatlayout.ap;
		System.out.println("2");
		String nn=st.substring(0, st.length()-1);
		System.out.println("2");
		seats.setText(nn);
		System.out.println("1");
		String[] cnt=st.split(",");
		System.out.println("1");
		int c=0;
		System.out.println("1L");
		for(int i=0;i<=cnt.length-1;i++) {
			System.out.println(cnt[i]);
			c++;
		}
		String c1=Integer.toString(c);
		tot.setText(c1);
		tot1.setText(c1);
		price.setText("₹"+checka.att);
		int ammt=Integer.parseInt(checka.att);
		int total=ammt*c;
		totp.setText("₹"+Integer.toString(total));
	}

}