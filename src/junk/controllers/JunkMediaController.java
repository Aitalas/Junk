package junk.controllers;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import junk.gui.JunkInjector;
import junk.gui.JunkTabPane;

public class JunkMediaController implements Initializable, JunkInjector {

	public HBox draggableNode;
	
	public Button exitButton;
	public Button playButton;
	public Button stopButton;	
	public Button gearButton;
	
	private Stage primaryStage;
	private MediaPlayer mediaPlayer;
	private LinkedList<MediaPlayer> playlist;
	private JunkTabPane tabPane;
	
	private double initialX = 0;
	private double initialY = 0;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		makeDraggable(draggableNode);
		
		exitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Exit button clicked.");
				primaryStage.close();
			}
			
		});
		
		playButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Button clicked.");
				mediaPlayer = playlist.getFirst();				
				mediaPlayer.play();
			}
			
		});
		
		stopButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Button clicked.");
				mediaPlayer = playlist.getFirst();
				mediaPlayer.stop();
			}
			
		});
		
		gearButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Button clicked.");
				tabPane.slidePaneUp();
			}
			
		});
	}

	@Override
	public void registerPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@Override
	public void registerMediaPlayer(MediaPlayer mediaPlayer) {
		this.mediaPlayer = mediaPlayer;
	}

	
	
	
	
	public void makeDraggable(Node node) {
		//make application draggable by the menubar
		node.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				System.out.println("HBox clicked.");
				initialX = event.getSceneX();//get x-coordinate of mouse click
				initialY = event.getSceneY();//get y-coordinate of mouse click
			}
			
		});
		
		node.setOnMouseDragged(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				primaryStage.setX(event.getScreenX() - initialX);//move stage over by the difference
				primaryStage.setY(event.getScreenY() - initialY);
			}
			
		});
	}

	@Override
	public void registerGroup(Group group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerMediaPlaylist(LinkedList<MediaPlayer> playlist) {
		this.playlist = playlist;
	}

	@Override
	public void registerTabPane(JunkTabPane tabPane) {
		this.tabPane = tabPane;
	}
	
}
