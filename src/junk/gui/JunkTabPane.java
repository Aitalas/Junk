package junk.gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

/*
 * 
 */
public class JunkTabPane {

	private static final String TABPANE_FXML = "/junk/fxml/junk_tab_pane.fxml";
	
	FXMLLoader myLoader;
	Node tabPane;
	
	public JunkTabPane() {
		try {
			myLoader = new FXMLLoader(getClass().getResource(TABPANE_FXML));//get tab pane screen
            tabPane = (Parent) myLoader.load();//load screen into node                            
		} catch (IOException e) {
			System.out.println("Unable to load tab pane fxml.");
			e.printStackTrace();
		}
	}
	
	public Node getTabPane() {
		return tabPane;
	}
	
	public FXMLLoader getFXMLLoader() {
		return myLoader;		
	}		
}
