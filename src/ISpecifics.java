import java.awt.Dimension;
import java.awt.Toolkit;

public interface ISpecifics {
	
	// Window Information
	final static int CORRECTION_WIDTH = 16;
	final static int CORRECTION_HEIGHT = 60;
	final static int FRAME_WIDTH = 1000;
	final static int FRAME_HEIGHT = 600;
	final static int BOARD_WIDTH = 1000; // These dimensions do not need to be here
	final static int BOARD_HEIGHT = 600;
	
	final static Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
}
