package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class checka implements Initializable {
	
    @FXML
    private BorderPane mainPane;
	
    @FXML
    private TableView<CA> chk;

    @FXML
    private TableColumn<CA, Integer> sno;

    @FXML
    private TableColumn<CA, String> no;

    @FXML
    private TableColumn<CA, String> at;

    @FXML
    private TableColumn<CA, String> dt;

    @FXML
    private TableColumn<CA, String> amt;
    
    @FXML
    private JFXButton back;
    
    @FXML
    private Label not;
    
    public static String a1,d1,att,n1;
    
    @FXML
    private TableColumn<CA, JFXButton> book;
    ObservableList<CA> olist1=FXCollections.observableArrayList();
    
    JFXButton book1=new JFXButton("BOOK TICKET");
    

    @FXML
    void back(ActionEvent event) {
    	System.out.println("You clicked me");   	
    	FxmlLoader obj=new FxmlLoader();
    	System.out.println("You clicked me");
    	Pane view = obj.getPage("BT");
    	System.out.println("You clicked me");
    	mainPane.setCenter(view);
    	System.out.println("You clicked me");
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		book1.setBorder(new Border(new BorderStroke(Color.BLACK , BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
		String d="Select * from addBus";
		
		  try{
              
              Class.forName("com.mysql.jdbc.Driver");
               try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bus","root","root")) {
                   Statement st=con.createStatement();
                   ResultSet rs=st.executeQuery(d);
                   System.out.println("1");
                   Integer c=1;
                   System.out.println("2");
                   bookticket bt=new bookticket();
                   System.out.println("3");
////                   bt.val();
                   while(rs.next()){
                	   System.out.println("dddddddd99999999");
                	   if(rs.getString("fr").equals(bt.ff1) && rs.getString("t").equals(bt.tt1)) {
                		   
                		   System.out.println("ff1 d = "+bt.ff1+" fr = "+rs.getString("fr"));
                           System.out.println("tt1 d = "+bt.tt1+"  = "+rs.getString("t"));
                   	olist1.add(new CA(c,rs.getString("no"),rs.getString("at"),rs.getString("dt"),rs.getString("amount"),book1));
                   	a1=rs.getString("at");
                   	d1=rs.getString("dt");
                   	att=rs.getString("amount");
                   	n1=rs.getString("no");
                   	c++;
                   	
                	   }
                   	}
                   }
               
   }
		  catch(Exception e) {
	         	
	         }
	                     
	                         
	 		System.out.println("os = "+olist1);
	 		
	 		sno.setCellValueFactory(new PropertyValueFactory<CA, Integer>("sn"));
	 		no.setCellValueFactory(new PropertyValueFactory<CA, String>("n1"));
	 		at.setCellValueFactory(new PropertyValueFactory<CA, String>("a1"));
	 		dt.setCellValueFactory(new PropertyValueFactory<CA, String>("d1"));
	 		amt.setCellValueFactory(new PropertyValueFactory<CA, String>("a2"));
	 		book.setCellValueFactory(new PropertyValueFactory<CA, JFXButton>("bk"));
	 		System.out.println("bye2");
	 		chk.setItems(olist1);
	 		System.out.println("bye3");
	 		if(olist1.isEmpty()) {
	 			not.setText("No bus available");
	 			not.setTextFill(Color.web("#ff0000", 0.8));
	 		}
	 		book1.setOnAction(new EventHandler<ActionEvent>() {
	 	        @Override
	 	        public void handle(ActionEvent event) {
	 	       	FxmlLoader obj=new FxmlLoader();
	 	       	System.out.println("You clicked me");
	 	       	Pane view = obj.getPage("L");
	 	       	System.out.println("You clicked me");
	 	       	mainPane.setCenter(view);
	 	       	System.out.println("You clicked me");

	 	        }
	 	    });
	 	
	}
	

}
