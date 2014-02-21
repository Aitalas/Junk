package junk.main;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/* [NOTES]	
 * 		[02.21.2014]	I would like to come up with a method that can add all the images to the stackpane in a loop...
 * 
 */

public class JunkStackPane extends StackPane {

	private static final String DEFAULT_IMAGE0 = "/junk/main/hatsuneMiku.jpg";
	private static final String DEFAULT_IMAGE1 = "/junk/main/MoonlightRise.jpg";
	private static final String DEFAULT_IMAGE2 = "/junk/main/the_sound_and_fury_by_yuumei-d6ys5aw.jpg";
	
	private ImageView[] images;//array of images
	
	private FadeTransition fadeOut = new FadeTransition();
	private PauseTransition pause = new PauseTransition();
	private SequentialTransition st = new SequentialTransition(pause, fadeOut, pause);
	private final int TOP_IMAGE = 2;
	private final int BOTTOM_OF_STACK = 0;
	
	public JunkStackPane() {
		initDefaultImages();
	}
	
	public void initDefaultImages() {
		JunkImage img0 = new JunkImage(DEFAULT_IMAGE0);
		JunkImage img1 = new JunkImage(DEFAULT_IMAGE1);
		JunkImage img2 = new JunkImage(DEFAULT_IMAGE2);
	
		images = new ImageView[3];
		images[0] = img0.getImageView();
		images[1] = img1.getImageView();
		images[2] = img2.getImageView();
		
		for (int i = 0; i < images.length; i++) {
			getChildren().add(images[i]);//add bottom to top, so image 2 is on top
		}				
	}
	
	public void initTransitions() {
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
		
		st.setNode(getChildren().get(TOP_IMAGE));//apply transitions to top image
		st.setCycleCount(1);//play once before repeating
		st.setAutoReverse(false);//do not reverse sequence animation
		st.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Sequence restarting.");//inform user
				st.stop();//reset the transition					
				ImageView currentImage = (ImageView) getChildren().get(TOP_IMAGE);//save current image
				currentImage.setOpacity(1.0);//reset its opacity				
				getChildren().remove(TOP_IMAGE);//remove top image 
				getChildren().add(BOTTOM_OF_STACK, currentImage);//move it down to bottom of stackpane
				st.setNode(getChildren().get(TOP_IMAGE));//set transition to new top image		
				st.play();//play again
			}
			
		});
	}
	
	public void playImages() {
		initTransitions();//initialize all transition properties
		st.play();//begin 'slideshow' of images
	}
	
}
