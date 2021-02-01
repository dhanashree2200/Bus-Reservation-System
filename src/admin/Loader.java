package admin;


import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class Loader {
	private Pane view;
	public Pane getPage(String fileName) {
		try {
			URL fileURL = Main.class.getResource("/admin/"+fileName+".fxml");
			if(fileURL==null) {
				throw new java.io.FileNotFoundException("FXML file not found");
			}
			new FXMLLoader();
			view = FXMLLoader.load(fileURL);
			
		}
		catch(Exception ex) {
			System.out.println("No page "+fileName+" please check fxml loader");
			System.out.println(ex);
		}
	return view;
	}
	

}
