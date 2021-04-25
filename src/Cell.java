import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Cell extends JPanel{
	
	private Position position;
	
	public Cell(int row, int column) {
		this.position = new Position(row, column);
		
		this.setBorder(BorderFactory.createLineBorder(Color.black, 2));
	}
	
	public Position getPosition() {
		return position;
	}
}
