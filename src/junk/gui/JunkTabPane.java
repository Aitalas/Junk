package junk.gui;

import java.io.IOException;
import java.util.LinkedList;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

/*
 * 
 */
public class JunkTabPane implements JunkInjector {

	private static final String TABPANE_FXML = "/junk/fxml/junk_tab_pane.fxml";
	
	private FXMLLoader myLoader;
	private Node tabPane;
	private TranslateTransition slider = new TranslateTransition();
	private final int SLIDE_UP = -250;
	private final int SLIDE_DOWN = 0;
	
	private LinkedList<MediaPlayer> playlist;
	
	public JunkTabPane() {
		try {
			myLoader = new FXMLLoader(getClass().getResource(TABPANE_FXML));//get tab pane screen
            tabPane = (Parent) myLoader.load();//load screen into node                            
		} catch (IOException e) {
			System.out.println("Unable to load tab pane fxml.");
			e.printStackTrace();
		}
		
		initSlider();		
	}
	
	public void initSlider() {
		slider.setNode(tabPane);
		slider.setCycleCount(1);
		slider.setAutoReverse(false);		
		slider.setDuration(Duration.millis(500));
	}
	
	public void slidePaneUp() {
		slider.setFromY(SLIDE_DOWN);
		slider.setToY(SLIDE_UP);
		slider.play();
	}
	
	public void slidePaneDown() {
		slider.setFromY(SLIDE_UP);
		slider.setToY(SLIDE_DOWN);
		slider.play();
	}
	
	public Node getTabPane() {
		return tabPane;
	}
	
	public FXMLLoader getFXMLLoader() {
		return myLoader;		
	}

	@Override
	public void registerPrimaryStage(Stage primaryStage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerMediaPlayer(MediaPlayer mediaPlayer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerMediaPlaylist(LinkedList<MediaPlayer> playlist) {
		this.playlist = playlist;
	}

	@Override
	public void registerGroup(Group group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerTabPane(JunkTabPane junkTabPane) {
		// TODO Auto-generated method stub
		
	}		
}
