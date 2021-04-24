public class Position {
	private int row;
	private int column;
	
	public void set(int row, int column) {
		this.setRow(row);
		this.setColumn(column);
	}
	
	public void setRow(int value) {
		if (value >= 1 && value <= 9) this.row = value;
	}
	
	public void setColumn(int value) {
		if (value >= 1 && value <= 9) this.column = value;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getColumn() {
		return this.column;
	}
	
}