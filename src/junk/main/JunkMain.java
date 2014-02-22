package junk.main;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*	[NOTES]
 * 		[][02.21.2014]	JunkStackPane is working as intended as an image viewer.
 * 						Testing music playback.
 * 
 */

public class JunkMain extends Application {

	public static final String VIDEO_SOURCE = 
			"http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";
	
	public static final String IMAGE_SOURCE = 
			new File("C:/Users/Aphrodite/Downloads/hgjart.jpg").toURI().toString();
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {				
		JunkStackPane myImageViewer = new JunkStackPane();		
		myImageViewer.initDefaultImages();
		myImageViewer.playImages();
		
		JunkMediaPlayer song = new JunkMediaPlayer();
						
		Group nodeWrap = new Group();
		nodeWrap.getChildren().add(myImageViewer.getStackPane());
		nodeWrap.getChildren().add(song.getPlayerButtons());
		
		//dimensions are to offset white space created when setResizable is false
		Scene scene = new Scene(nodeWrap, 590, 390);
		
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.setResizable(false);
		primaryStage.setTitle("Junk Image Viewer");
		primaryStage.show();		
	}



}
