package junk.gui;

import java.util.LinkedList;

import javafx.scene.Group;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public interface JunkInjector {
	void registerPrimaryStage(Stage primaryStage);
	void registerMediaPlayer(MediaPlayer mediaPlayer);
	void registerMediaPlaylist(LinkedList<MediaPlayer> playlist);
	void registerGroup(Group group);
	void registerTabPane(JunkTabPane junkTabPane);
}
