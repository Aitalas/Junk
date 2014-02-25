package junk.controllers;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import junk.gui.JunkInjector;
import junk.gui.JunkTabPane;

public class JunkTabPaneController implements Initializable, JunkInjector {

	public Button closeButton;
	public TextArea textArea;
	
	private JunkTabPane tabPane;	
	private LinkedList<MediaPlayer> playlist;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initMusicListView();
		
		closeButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Button clicked.");
				tabPane.slidePaneDown();
			}
			
		});
	}

	
	
	public void initMusicListView() {
		for (int i = 0; i < 10; i++) {
			textArea.appendText("Hello World.");
			textArea.appendText("\n");
		}
	}
	
	
	
	@Override
	public void registerPrimaryStage(Stage primaryStage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerMediaPlayer(MediaPlayer mediaPlayer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerMediaPlaylist(LinkedList<MediaPlayer> playlist) {
		this.playlist = playlist;
	}

	@Override
	public void registerGroup(Group group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerTabPane(JunkTabPane junkTabPane) {
		this.tabPane = junkTabPane;
	}

}
