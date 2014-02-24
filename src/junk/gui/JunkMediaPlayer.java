package junk.gui;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class JunkMediaPlayer {
	private static final String BUTTONS_FXML = "/junk/fxml/junk_buttons.fxml";
	
	private static final String MUSIC_SOURCE = 
			new File("C:/Users/Aphrodite/Music/Instrumental/Heaven.mp3").toURI().toString();
	
	//private static final String ONLINE_MUSIC_SOURCE = "http://a.tumblr.com/tumblr_mu8122iLdz1s6dzm0o1.mp3";
	
	
	private Media media;
	private MediaPlayer mediaPlayer;
	private MediaView mediaView;	
	private Node playerButtons;	
	private FXMLLoader myLoader;
	
	private LinkedList<MediaPlayer> playList = new LinkedList<MediaPlayer>();
	
	public JunkMediaPlayer() {		
		try {
			myLoader = new FXMLLoader(getClass().getResource(BUTTONS_FXML));//get button screen	
            playerButtons = (Parent) myLoader.load();//load screen into node                            
		} catch (IOException e) {
			System.out.println("Unable to load button fxml.");
			e.printStackTrace();
		}
	}
	
	public void initDefaultSong() {
		media = new Media(MUSIC_SOURCE);
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(false);		
		mediaPlayer.setCycleCount(1);		
		mediaView = new MediaView(mediaPlayer);//not sure if I still need MediaView...						
	}
	
	public void addSong(String songPath) {		
		try {
			media = new Media(new File(songPath).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			mediaPlayer.setAutoPlay(false);
			mediaPlayer.setCycleCount(1);
			playList.add(mediaPlayer);
		} catch (NullPointerException e) {
			System.out.println("\'" + songPath + "\' is a null path. Please try again.");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println("\'" + songPath + "\' is an invalid path. Please try again.");
			e.printStackTrace();
		}
	}
	
	public void setSong(String songPath) {
		try {
			media = new Media(new File(songPath).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			mediaPlayer.setAutoPlay(false);
			mediaPlayer.setCycleCount(1);
			playList.clear();
			playList.add(mediaPlayer);
		} catch (NullPointerException e) {
			System.out.println("\'" + songPath + "\' is a null path. Please try again.");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println("\'" + songPath + "\' is an invalid path. Please try again.");
			e.printStackTrace();
		}
	}
	
	public LinkedList<MediaPlayer> getPlayList() {
		return playList;
	}
		
	public FXMLLoader getFXMLLoader() {
		return myLoader;
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
