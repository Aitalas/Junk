package junk.main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import junk.gui.JunkInjector;
import junk.gui.JunkMediaPlayer;
import junk.gui.JunkStackPane;
import junk.gui.JunkTabPane;

/*	[NOTES]
 * 		[][02.21.2014]	JunkStackPane is working as intended as an image viewer.
 * 						Testing music playback.
 * 		[02.22.2014]	Hella reorganized everything ahehe.
 * 
 */

public class JunkMain extends Application {

	public static final String VIDEO_SOURCE = 
			"http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {				
		JunkStackPane myImageViewer = new JunkStackPane();		
		myImageViewer.initDefaultImages();
		myImageViewer.playImages();
		
		
		JunkMediaPlayer myMediaPlayer = new JunkMediaPlayer();
		myMediaPlayer.initDefaultSong();
		
		JunkTabPane myControls = new JunkTabPane();
		
		Group root = new Group();
		root.getChildren().add(myImageViewer.getStackPane());
		root.getChildren().add(myMediaPlayer.getPlayerButtons());		
		
		
		VBox vbox = new VBox();
		vbox.getChildren().add(root);
		vbox.getChildren().add(myControls.getTabPane());
		
		
		Scene scene = new Scene(vbox, 600, 400);
		scene.setFill(Color.TRANSPARENT);
		
		
		JunkInjector ji = myMediaPlayer.getFXMLLoader().getController();//inject into media controller
		ji.registerPrimaryStage(primaryStage);
		ji.registerMediaPlaylist(myMediaPlayer.getPlaylist());
		ji.registerTabPane(myControls);
		
		ji = myControls.getFXMLLoader().getController();//inject into tab pane controller
		ji.registerTabPane(myControls);
		ji.registerMediaPlaylist(myMediaPlayer.getPlaylist());
		
		ji = (JunkInjector) myControls;
		ji.registerMediaPlaylist(myMediaPlayer.getPlaylist());
		
		primaryStage.initStyle(StageStyle.TRANSPARENT);		
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		//primaryStage.setResizable(false);
		primaryStage.setTitle("Junk Image Viewer");
		primaryStage.centerOnScreen();
		primaryStage.show();		
	}



}
