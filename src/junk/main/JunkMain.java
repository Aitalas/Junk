package junk.main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class JunkMain extends Application {

	private final String VIDEO_SOURCE = "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";
	private final String MUSIC_SOURCE = "C:/Users/Aphrodite/Music/Instrumental/Heaven.mp3";
	private final String IMAGE_SOURCE = "http://24.media.tumblr.com/544fdd25bfdbfa12f113afa977e92e4e/tumblr_n1are65lBG1qgb4moo1_500.jpg";
	private final String MY_IMAGE = "/junk/main/hatsuneMiku.jpg";
	private final String IMAGE_FXML = "junk.fxml";
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {			

		/*Media video = new Media(VIDEO_SOURCE);
		MediaPlayer player = new MediaPlayer(video);
		player.setAutoPlay(true);
		
		MediaView mediaPlayer = new MediaView(player);*/
		
		
		JunkStackPane myImageViewer = new JunkStackPane();
		myImageViewer.playImages();
		//myImageViewer.getChildren().add(mediaPlayer);//add media on top of it
		
		
		
		Group nodeWrap = new Group();
		nodeWrap.getChildren().add(myImageViewer);
		Scene scene = new Scene(nodeWrap, 590, 390);		
		
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.setResizable(false);
		primaryStage.setTitle("Junk Image Viewer");
		primaryStage.show();		
	}

}
