package application;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class UP1 {
	
    

	@FXML
    private BorderPane mainPane;

    @FXML
    private JFXButton book;

    @FXML
    private JFXButton view;

    @FXML
    private JFXButton cancel;

    @FXML
    private JFXButton about;

    @FXML
    private JFXButton contact;


    @FXML
    void bookTicket(ActionEvent event) {
    	System.out.println("You clicked me");   	
    	FxmlLoader obj=new FxmlLoader();
    	System.out.println("You clicked me");
    	Pane view = obj.getPage("BT");
    	System.out.println("You clicked me");
    	mainPane.setCenter(view);
    	System.out.println("You clicked me");
    }

    @FXML
    void cancelTicket(ActionEvent event) {
    	System.out.println("You clicked me");   	
    	FxmlLoader obj=new FxmlLoader();
    	System.out.println("You clicked me");
    	Pane view = obj.getPage("CancelTicket");
    	System.out.println("You clicked me");
    	mainPane.setCenter(view);
    	System.out.println("You clicked me");
    }

    @FXML
    void about(ActionEvent event) {
    	System.out.println("You clicked me");   	
    	FxmlLoader obj=new FxmlLoader();
    	System.out.println("You clicked me");
    	Pane view = obj.getPage("aboutus");
    	System.out.println("You clicked me");
    	mainPane.setCenter(view);
    	System.out.println("You clicked me");
    }


    @FXML
    void contact(ActionEvent event) {
    	System.out.println("You clicked me");   	
    	FxmlLoader obj=new FxmlLoader();
    	System.out.println("You clicked me");
    	Pane view = obj.getPage("contact_us");
    	System.out.println("You clicked me");
    	mainPane.setCenter(view);
    	System.out.println("You clicked me");
    }

    @FXML
    void viewTicket(ActionEvent event) {
    	System.out.println("You clicked me");   	
    	FxmlLoader obj=new FxmlLoader();
    	System.out.println("You clicked me");
    	Pane view = obj.getPage("ViewTicket");
    	System.out.println("You clicked me");
    	mainPane.setCenter(view);
    	System.out.println("You clicked me");
    }

}
