package junk.main;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.AudioSpectrumListener;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class JunkMain extends Application {

	public static final String VIDEO_SOURCE = "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";
	public static final String MUSIC_SOURCE = new File("C:/Users/Aphrodite/Music/Instrumental/Heaven.mp3").toURI().toString();

	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {			

		Media thing = new Media(MUSIC_SOURCE);
		MediaPlayer player = new MediaPlayer(thing);
		player.setAutoPlay(true);
				
		MediaView mediaPlayer = new MediaView(player);
				
		JunkStackPane myImageViewer = new JunkStackPane();
		myImageViewer.playImages();
		myImageViewer.getChildren().add(mediaPlayer);//add media on top of it
					
		Group nodeWrap = new Group();
		nodeWrap.getChildren().add(myImageViewer);
		Scene scene = new Scene(nodeWrap, 590, 390);//dimensions are to offset white space created 
													//when setResizable is false
		
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.setResizable(false);
		primaryStage.setTitle("Junk Image Viewer");
		primaryStage.show();		
	}



}
