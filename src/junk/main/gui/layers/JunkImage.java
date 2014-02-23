package junk.main.gui.layers;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class JunkImage {

	Image image;
	ImageView imgView;
	
	public JunkImage() {
		createImage(JunkStackPane.DEFAULT_IMAGE0);
	}
	
	public JunkImage(String path) {
		createImage(path);
	}
	
	public void createImage(String path) {
		image = new Image(path);
		imgView = new ImageView(image);
		imgView.setPreserveRatio(false);
		imgView.setSmooth(true);
		imgView.setFitWidth(600);
		imgView.setFitHeight(400);
	}
	
	public ImageView getImageView() {
		return imgView;
	}
	
}
