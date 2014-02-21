package junk.main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class JunkMain extends Application {

	//private final String VIDEO_SOURCE = "C:/Users/Aphrodite/Desktop/Google Drive/Video/itachi_incubus_color1.avi";
	private final String MUSIC_SOURCE = "C:/Users/Aphrodite/Music/Instrumental/Heaven.mp3";
	private final String IMAGE_SOURCE = "http://24.media.tumblr.com/544fdd25bfdbfa12f113afa977e92e4e/tumblr_n1are65lBG1qgb4moo1_500.jpg";
	private final String MY_IMAGE = "/junk/main/hatsuneMiku.jpg";
	private final String IMAGE_FXML = "junk.fxml";
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {			

		JunkStackPane myImageViewer = new JunkStackPane();
		//myImageViewer.playImages();
		
		Group nodeWrap = new Group();
		nodeWrap.getChildren().add(myImageViewer);
		Scene scene = new Scene(nodeWrap);		
		
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		//primaryStage.setResizable(false);
		primaryStage.setTitle("Junk Image Viewer");
		primaryStage.show();		
	}

}
