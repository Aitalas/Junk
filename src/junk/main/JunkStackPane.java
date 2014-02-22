package junk.main;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/* [NOTES]	
 * 		[ADDED][02.21.2014]	I would like to come up with a method that can add 
 * 							all the images to the stackpane in a loop...
 * 
 */

public class JunkStackPane extends StackPane {

	public static final String DEFAULT_IMAGE0 = "/junk/main/hatsuneMiku.jpg";
	public static final String DEFAULT_IMAGE1 = "/junk/main/MoonlightRise.jpg";
	public static final String DEFAULT_IMAGE2 = "/junk/main/SoundAndFury_Yuumei.jpg";
	
	private final int TOP_IMAGE = 2;
	private final int BOTTOM_OF_STACK = 0;
	
	private FadeTransition fadeOut = new FadeTransition();
	private PauseTransition pause = new PauseTransition();
	private SequentialTransition st = new SequentialTransition(pause, fadeOut, pause);
		
	public JunkStackPane() {
		super();
		initDefaultImages();
	}
	
	public void initDefaultImages() {
		JunkImage img0 = new JunkImage(DEFAULT_IMAGE0);
		JunkImage img1 = new JunkImage(DEFAULT_IMAGE1);
		JunkImage img2 = new JunkImage(DEFAULT_IMAGE2);
	
		getChildren().add(img0.getImageView());//add img0 to bottom
		getChildren().add(img1.getImageView());
		getChildren().add(img2.getImageView());//img2 is top of stackpane					
	}
	
	public void addImage(String imagePath) {//add one image to the stackpane
		try {
			JunkImage image = new JunkImage(imagePath);
			getChildren().add(image.getImageView());
		} catch (NullPointerException e) {
			System.out.println("\'" + imagePath + "\' cannot be found. Please try again.");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println("\'" + imagePath + "\' is an invalid image path. Please try again.");
			e.printStackTrace();
		}
	}
	
	public void addAllImages(String... imagePaths) {			
		JunkImage image;
		for (int i = 0; i < imagePaths.length; i++) {//for every path supplied
			try {
				image = new JunkImage(imagePaths[i]);//create an image out of it
				getChildren().add(image.getImageView());//add to the stackpane from bottom up
			} catch (NullPointerException e) {
				System.out.println("Image \'" + imagePaths[i] + "\' cannot be found. Please try again.");
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				System.out.println("\'" + imagePaths[i] + "\' is an invalid path. Please try again.");
				e.printStackTrace();
			}
		}
	}
	
	public void initFade() {
		fadeOut.setCycleCount(1);//do animation only once per image 'fadeOut'
		fadeOut.setDuration(Duration.seconds(3));//take 3 seconds to finish fading
		fadeOut.setAutoReverse(false);//do not reverse animation
		fadeOut.setFromValue(1.0);//start image at full opacity
		fadeOut.setToValue(0.0);//end image with no opacity		
		fadeOut.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				fadeOut.stop();
				System.out.println("Fade out stopped.");
			}
			
		});
	}
	
	
	public void initPause() {
		pause.setCycleCount(1);//pause once
		pause.setDuration(Duration.seconds(3));//pause on image for 3 seconds
		pause.setAutoReverse(false);//do not reverse... w/e that means
		pause.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				pause.stop();
				System.out.println("Pause stopped.");
			}
			
		});	
	}
	
	public void initSequential() {
		st.setNode(getChildren().get(TOP_IMAGE));//apply transitions to top image
		st.setCycleCount(1);//play once before repeating
		st.setAutoReverse(false);//do not reverse sequence animation
		st.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Sequence restarting.");//inform user
				st.stop();//reset the transition					
				ImageView currentImage = (ImageView) getChildren().get(TOP_IMAGE);//save current top image
				currentImage.setOpacity(1.0);//reset its opacity				
				getChildren().remove(TOP_IMAGE);//remove top image 
				getChildren().add(BOTTOM_OF_STACK, currentImage);//move it down to bottom of stackpane
				st.setNode(getChildren().get(TOP_IMAGE));//set transition to new top image		
				st.play();//play again
			}
			
		});
	}
	
	
	public void playImages() {
		initFade();//initialize fade properties
		initPause();//initialize pause properties
		initSequential();//initialize sequential properties
		st.play();//begin 'slideshow' of images
	}
	
}
