package junk.main;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class JunkStackPane extends StackPane {

	private static final String DEFAULT_IMAGE1 = "/junk/main/hatsuneMiku.jpg";
	private static final String DEFAULT_IMAGE2 = "/junk/main/MoonlightRise.jpg";
	private static final String DEFAULT_IMAGE3 = "/junk/main/the_sound_and_fury_by_yuumei-d6ys5aw.jpg";
	
	//private HashMap<Integer, ImageView> imageBucket = new HashMap<Integer, ImageView>(); 
	
	private JunkImage[] images;//array of images
	
	private FadeTransition fadeOut = new FadeTransition();
	private FadeTransition fadeIn = new FadeTransition();
	
	public JunkStackPane() {
		initDefaultImages();
	}
	
	public void initDefaultImages() {
		JunkImage img0 = new JunkImage(DEFAULT_IMAGE1);
		JunkImage img1 = new JunkImage(DEFAULT_IMAGE2);
		JunkImage img2 = new JunkImage(DEFAULT_IMAGE3);
	
		getChildren().add(0, img0.getImageView());
		getChildren().add(1, img1.getImageView());
		getChildren().add(2, img2.getImageView());
	}
	
	public void initFade() {
		fadeOut.setCycleCount(1);//do animation only once per image 'fadeOut'
		fadeOut.setDuration(Duration.seconds(3));//take 3 seconds to finish fading
		//fadeOut.setDelay(Duration.seconds(3));//wait 3 seconds before starting animation
		fadeOut.setAutoReverse(false);//do not reverse animation
		fadeOut.setFromValue(1.0);//start image at full opacity
		fadeOut.setToValue(0.0);//end image with no opacity		
		
		fadeIn.setCycleCount(1);//do animation only once per image 'fadeIn'
		fadeIn.setDuration(Duration.seconds(3));//take 3 seconds to finish fading
		fadeIn.setDelay(Duration.seconds(3));//wait 3 seconds before starting animation
		fadeIn.setAutoReverse(false);//do not reverse animation
		fadeIn.setFromValue(0.0);//start image at no opacity
		fadeIn.setToValue(1.0);//end image with full opacity
	}
	
	public void playImages() {
		int numOfImages = getChildren().size() - 1;		
		initFade();//initialize fadeOut and fadeIn properties
		
		fadeOut.setNode(getChildren().get(2));//fade top image
		fadeOut.play();		
		fadeOut.setNode(getChildren().get(1));//fade image underneath
		fadeOut.play();				
		
		/*
		for(int i = numOfImages; i >= 0; i--) {
			fadeOut.setNode(getChildren().get(i));//set current image to fade
			fadeOut.play();//fade away the image
			//fade.stop();//stop for next image
		}*/
	}
	
}
