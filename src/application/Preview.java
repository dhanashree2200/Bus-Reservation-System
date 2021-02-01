package application;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;

import javax.mail.Session;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Preview implements Initializable{
	
    @FXML
    private AnchorPane ap;

    @FXML
    private Label date;

    @FXML
    private Label from1;

    @FXML
    private Label at;

    @FXML
    private Label to1;

    @FXML
    private Label dt;

    @FXML
    private Label from;

    @FXML
    private Label to;

    @FXML
    private Label seats;

    @FXML
    private Label tot1;

    @FXML
    private Label tot;

    @FXML
    private Label price;

    @FXML
    private Label totp;

    @FXML
    private Label t1;

    @FXML
    private Label f1;

    @FXML
    private Label l1;

    @FXML
    private Label p1;

    @FXML
    private Label e1;

    @FXML
    private Label b1;

    @FXML
    private JFXButton confirm;
    
    String nn="";


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String dtt=bookticket.ud;
		date.setText(dtt);
		from.setText(bookticket.ff1);
		from1.setText(bookticket.ff1);
		to.setText(bookticket.tt1);
		to1.setText(bookticket.tt1);
		at.setText(checka.a1);
		dt.setText(checka.d1);
		String st=seatlayout.ap;
		nn=st.substring(0, st.length()-1);
		seats.setText(nn);
		String[] cnt=st.split(",");
		int c=0;
		for(int i=0;i<=cnt.length-1;i++) {
			System.out.println(cnt[i]);
			c++;
		}
		String ts=Integer.toString(c);
		System.out.println(ts);
		tot.setText(ts);
		tot1.setText(ts);
		price.setText("₹"+checka.att);
		int ammt=Integer.parseInt(checka.att);
		int total=ammt*c;
		totp.setText("₹"+Integer.toString(total));
		t1.setText(Checkout.tit);
		f1.setText(Checkout.fir);
		l1.setText(Checkout.last);
		p1.setText(Checkout.phone);
		e1.setText(Checkout.el);
		b1.setText(Checkout.rand);
	}
	
    @FXML
    void confirm(ActionEvent event) {
try{
            
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("h2");
             try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bus","root","root")) {
            	 String s1=seatlayout.ap;
                 System.out.println("h3");
                 Statement st=con.createStatement();
                 System.out.println("h4");
                 LocalDate d=java.time.LocalDate.now();
                 System.out.println("date = "+d);
                 
                 String q="insert into confirm(title,first,last,mob,eid,noo,seats,f1,t1,at,dt,dat,bno) values('"+Checkout.tit+"','"+Checkout.fir+"','"+Checkout.last+"','"+Checkout.phone+"','"+Checkout.el+"','"+Checkout.rand+"','"+s1+"','"+bookticket.ff1+"','"+bookticket.tt1+"','"+checka.a1+"','"+checka.d1+"','"+bookticket.dt+"','"+checka.n1+"')";   
                 int s=st.executeUpdate(q);
                 System.out.println("Inserted");
                 Alert a=new Alert(AlertType.CONFIRMATION);
             	a.setTitle("SUCCESS");
             	a.setContentText("Tickets booked successfully.......");
             	a.showAndWait();
             	System.out.println(Checkout.rand);
             	String fi=Checkout.rand;
             	File file = new File(fi+".pdf");
                
                if(file.delete()) 
                { 
                    System.out.println("File deleted successfully"); 
                } 
                else
                { 
                    System.out.println("Failed to delete the file"); 
                }
    			Checkout.stage22.hide();
    			seatlayout.stage3.hide();
             }
        }
        catch(ClassNotFoundException | SQLException e){
            
    }
		
		
		}

	
    @FXML
    void download(MouseEvent event) {
    
		System.out.println("hi");
		Document document=new Document();
		try {
			System.out.println("hi");
			Random ran=new Random();
	    	int num=ran.nextInt(900)+100;
			PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream(Checkout.rand+".pdf"));
			document.open();
			System.out.println(Checkout.fir);
			String f1=Checkout.fir;
			document.add(new Paragraph("BOOKING NUMBER = "+Checkout.rand+"\nSeat Number = "+nn+"\nFirst Name = "+f1+"\nLast Name = "+Checkout.last+"\nPhone number = "+Checkout.phone+"\nJourney Date = "+bookticket.ud+"\nFrom = "+bookticket.ff1+"\nTo = "+bookticket.tt1+"\nArrival Time = "+checka.a1+"\nDeparture Time = "+checka.d1));
			System.out.println("hii");
			document.close();
			writer.close();
			Desktop.getDesktop().open(new java.io.File(Checkout.rand+".pdf"));
			System.out.println("hii");
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
    }

}
