package junk.main.gui.layers;

import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public interface JunkInjector {
	void injectPrimaryStage(Stage primaryStage);
	void injectMediaPlayer(MediaPlayer mediaPlayer);
}
