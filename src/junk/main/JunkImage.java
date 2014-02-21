package junk.main;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class JunkImage {

	Image image;
	ImageView imgView;
	
	public JunkImage() {
		
	}
	
	public JunkImage(String path) {
		image = new Image(path);
		imgView = new ImageView(image);
		imgView.setSmooth(true);
		imgView.setFitWidth(600);
		imgView.setFitHeight(400);
	}
	
	public ImageView getImageView() {
		return imgView;
	}
	
}
