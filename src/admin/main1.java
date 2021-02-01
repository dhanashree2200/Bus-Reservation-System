package admin;

import com.jfoenix.controls.JFXButton;

import application.FxmlLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class main1 {
	
    @FXML
    private BorderPane mainPane;

    @FXML
    private JFXButton dash;

    @FXML
    private JFXButton details;

    @FXML
    private JFXButton add;

    @FXML
    private JFXButton view;

    @FXML
    private JFXButton viewU;
    

    @FXML
    private JFXButton upd;

    @FXML
    private JFXButton del;

    @FXML
    void addBus(ActionEvent event) {
    	System.out.println("You clicked me");   	
    	Loader obj=new Loader();
    	System.out.println("You clicked me");
    	Pane view = obj.getPage("AddBus");
    	System.out.println("You clicked me");
    	mainPane.setCenter(view);
    	System.out.println("You clicked me\n");
    	
    }

    @FXML
    void busDetails(ActionEvent event) {
    	System.out.println("You clicked me");   	
    	Loader obj=new Loader();
    	System.out.println("You clicked me");
    	Pane view = obj.getPage("busDetails");
    	System.out.println("You clicked me");
    	mainPane.setCenter(view);
    	System.out.println("You clicked me\n");
    }

    @FXML
    void dashboard(ActionEvent event) {
    	System.out.println("You clicked me");   	
    	Loader obj=new Loader();
    	System.out.println("You clicked me");
    	Pane view = obj.getPage("Dashboard");
    	System.out.println("You clicked me");
    	mainPane.setCenter(view);
    	System.out.println("You clicked me\n");
    }

    @FXML
    void viewBooking(ActionEvent event) {
    	System.out.println("You clicked me");   	
    	Loader obj=new Loader();
    	System.out.println("You clicked me");
    	Pane view = obj.getPage("ViewBooking");
    	System.out.println("You clicked me");
    	mainPane.setCenter(view);
    	System.out.println("You clicked me\n");
    }

    @FXML
    void viewUsers(ActionEvent event) {
    	System.out.println("You clicked me");   	
    	Loader obj=new Loader();
    	System.out.println("You clicked me");
    	Pane view = obj.getPage("VUser");
    	System.out.println("You clicked me");
    	mainPane.setCenter(view);
    	System.out.println("You clicked me\n");
    }
    
    @FXML
    void delete(ActionEvent event) {
    	System.out.println("You clicked me");   	
    	Loader obj=new Loader();
    	System.out.println("You clicked me");
    	Pane view = obj.getPage("DeleteBus");
    	System.out.println("You clicked me");
    	mainPane.setCenter(view);
    	System.out.println("You clicked me\n");
    }

    @FXML
    void update(ActionEvent event) {
    	System.out.println("You clicked me");   	
    	Loader obj=new Loader();
    	System.out.println("You clicked me");
    	Pane view = obj.getPage("UpdateBus");
    	System.out.println("You clicked me");
    	mainPane.setCenter(view);
    	System.out.println("You clicked me\n");

    }
}
