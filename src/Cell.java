import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cell extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label;
	private int value;
	
	public Cell(int value) {
		
		this.label = new JLabel();
		this.setLayout(new GridBagLayout());
		this.add(label, new GridBagConstraints()); // Centers Label. It just works
	}
	
	public void setValue(int value) {
		this.value = value;
		if (value > 0 && value < 10) this.label.setText(Integer.toString(this.getValue()));
	}
	
	public int getValue() {
		return this.value;
	}
	
	public boolean isEmpty() {
		return this.getValue() == 0;
	}
	
	public String toString() {
		return Integer.toString(getValue());
	}
}

