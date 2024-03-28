package labs.lab9;

//import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MusicLibrary {

	public static void main(String[] args) throws InterruptedException {
		// Create a new frame for Music Library
		MusicLibraryFrame frame = new MusicLibraryFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
