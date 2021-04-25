import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cell extends JPanel{
	
	private Position position;
	private JLabel label;
	
	public Cell(int row, int column) {
		this.position = new Position(row, column);
		
		this.label = new JLabel();
		this.setLayout(new GridBagLayout());
		this.add(label, new GridBagConstraints()); // Centers Label. It just works
	}
	
	public void setValue(int value) {
		if (value > 0 && value < 10) this.label.setText(Integer.toString(value));
	}
	
	public Position getPosition() {
		return position;
	}
}
