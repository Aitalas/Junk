package junk.main.gui.layers;

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
 * 		[][02.21.2014]		
 */

public class JunkStackPane {

	public static final String DEFAULT_IMAGE0 = "/junk/images/hatsuneMiku.jpg";
	public static final String DEFAULT_IMAGE1 = "/junk/images/MoonlightRise.jpg";
	public static final String DEFAULT_IMAGE2 = "/junk/images/SoundAndFury_Yuumei.jpg";
	
	private final int STACK_INDEX_OFFSET = 1;	
	private final int BOTTOM_OF_STACK = 0;
	private int topImage = 0;
	
	private FadeTransition fadeOut = new FadeTransition();
	private PauseTransition pause = new PauseTransition();
	private SequentialTransition st = new SequentialTransition(pause, fadeOut, pause);
	
	private StackPane imageViewer = new StackPane();
		
	public JunkStackPane() {		
		imageViewer.setStyle("-fx-effect: innershadow(gaussian, black, 20, 0, 0, 0);");
	}	
	
	public StackPane getStackPane() {
		return imageViewer;
	}
	
	public void initDefaultImages() {
		addAllImages(DEFAULT_IMAGE0, DEFAULT_IMAGE1, DEFAULT_IMAGE2);
	}
	
	public void addImage(String imagePath) {//add one image to the stackpane
		try {
			JunkImage image = new JunkImage(imagePath);
			imageViewer.getChildren().add(image.getImageView());
			updateTopImageIndex();
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
				imageViewer.getChildren().add(image.getImageView());//add to the stackpane from bottom up
				updateTopImageIndex();//update index of top image
			} catch (NullPointerException e) {
				System.out.println("Image \'" + imagePaths[i] + "\' cannot be found. Please try again.");
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				System.out.println("\'" + imagePaths[i] + "\' is an invalid path. Please try again.");
				e.printStackTrace();
			}
		}
	}	
	
	public void removeAllImages() {
		imageViewer.getChildren().remove(BOTTOM_OF_STACK, topImage);
	}
	
	private void updateTopImageIndex() {
		topImage = imageViewer.getChildren().size() - STACK_INDEX_OFFSET;
	}
	
	private void initFade() {
		fadeOut.setCycleCount(1);//do animation only once per image 'fadeOut'
		fadeOut.setDuration(Duration.seconds(3));//take 3 seconds to finish fading
		fadeOut.setAutoReverse(false);//do not reverse animation
		fadeOut.setFromValue(1.0);//start image at full opacity
		fadeOut.setToValue(0.0);//end image with no opacity		
		fadeOut.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				fadeOut.stop();
			}
			
		});
	}
	
	
	private void initPause() {
		pause.setCycleCount(1);//pause once
		pause.setDuration(Duration.seconds(5));//pause on image for 3 seconds
		pause.setAutoReverse(false);//do not reverse... w/e that means
		pause.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				pause.stop();
			}
			
		});	
	}
	
	private void initSequential() {
		st.setNode(imageViewer.getChildren().get(topImage));//apply transitions to top image
		st.setCycleCount(1);//play once before repeating
		st.setAutoReverse(false);//do not reverse sequence animation
		st.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				st.stop();//reset the transition					
				ImageView currentImage = (ImageView) imageViewer.getChildren().get(topImage);//save current top image
				currentImage.setOpacity(1.0);//reset its opacity				
				imageViewer.getChildren().remove(topImage);//remove top image 
				imageViewer.getChildren().add(BOTTOM_OF_STACK, currentImage);//move it down to bottom of stackpane
				st.setNode(imageViewer.getChildren().get(topImage));//set transition to new top image		
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
	
	public void stopPlayImages() {
		st.stop();
	}
	
}
