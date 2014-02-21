package junk.main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class JunkController implements Initializable {

	public Button viewNewImage;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		viewNewImage.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Button clicked.");
			}
			
		});
	}

}
