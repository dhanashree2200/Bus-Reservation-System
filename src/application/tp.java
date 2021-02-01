package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class tp {


    @FXML
    void col(MouseEvent event) {
    	Object b=event.getSource();
    	Object c=(Button)b;
    	((Node) c).setStyle("-fx-background-color: #ff0000;");
    }

    @FXML
    void tp(ActionEvent event) {
    	Object b=event.getSource();
    	Object c=(Button)b;
    	((Node) c).setStyle("-fx-background-color: #ffffff;");

    }

}


