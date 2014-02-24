package junk.gui;

import javafx.scene.Group;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public interface JunkInjector {
	void injectPrimaryStage(Stage primaryStage);
	void injectMediaPlayer(MediaPlayer mediaPlayer);
	void injectGroup(Group group);
}
