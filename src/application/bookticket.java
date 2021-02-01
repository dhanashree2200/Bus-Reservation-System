package application;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class bookticket implements Initializable{
	
	ObservableList<String> list=FXCollections.observableArrayList("Pune","Mumbai","Nashik","Aurangabad");
	
    @FXML
    private BorderPane mainPane;

    @FXML
    private JFXDatePicker dept;

    @FXML
    public JFXComboBox<String> from;

    @FXML
    public JFXComboBox<String> to;

    @FXML
    private JFXButton check;
    
	public static String ff1, tt1,ud;
	public static LocalDate dt;
    
    @FXML
    void check(ActionEvent event) {
    	dt=dept.getValue();
    	ud=dt.toString();
    	ff1=from.getValue();
   	 	tt1=to.getValue();
   	 	System.out.println("ff1 = "+ff1);
   	 	System.out.println("tt1 = "+tt1);
    	System.out.println("You clicked me");   	
    	FxmlLoader obj=new FxmlLoader();
    	System.out.println("You clicked me");
    	Pane view = obj.getPage("CheckA");
    	System.out.println("You clicked me");
    	mainPane.setCenter(view);
    	System.out.println("You clicked me");
    	

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		from.setItems(list);
		to.setItems(list);
		
		
		
	}

}
//class D extends bookticket{
//	void dd() {
//	bookticket btt=new bookticket();
//	btt.tp();
//	String gg=btt.ff1;
//	String gg1=btt.tt1;
//	System.out.println(ff1+tt1);
//	
//	btt.val();
//	}
//	public static void main(String ar[]){
//		D d=new D();
//		d.dd();
//	}
//	
//}
