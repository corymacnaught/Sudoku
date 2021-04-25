import javax.swing.JPanel;

public class Cell extends JPanel{
	
	private Position position;
	
	public Cell(int row, int column) {
		this.position = new Position(row, column);
	}
	
	public Position getPosition() {
		return position;
	}
}
