package junk.main;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class JunkMediaPlayer {
	private static final String BUTTONS_FXML = "junk_buttons.fxml";
	private static final String MUSIC_SOURCE = 
			new File("C:/Users/Aphrodite/Music/Instrumental/Heaven.mp3").toURI().toString();
	
	Media media;
	MediaPlayer mediaPlayer;
	MediaView mediaView;
	
	Node playerButtons;
	
	public JunkMediaPlayer() {
		media = new Media(MUSIC_SOURCE);
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(false);		
		mediaPlayer.setCycleCount(1);		
		mediaView = new MediaView(mediaPlayer);//not sure if I still need MediaView...
				
		try {
			FXMLLoader myLoader = new FXMLLoader(getClass().getResource(BUTTONS_FXML));//get button screen	
            playerButtons = (Parent) myLoader.load();//load screen into node                            
		} catch (IOException e) {
			System.out.println("Unable to load button fxml.");
			e.printStackTrace();
		}
		
	}
		
	public Node getPlayerButtons() {
		return playerButtons;
	}
	
	public Media getMedia() {
		return media;
	}
	
	public MediaPlayer getMediaPlayer() {
		return mediaPlayer;
	}
	
	public MediaView getMediaView() {
		return mediaView;
	}
	
	
	
	
}
