public class Position {
	private int row;
	private int column;
	
	public Position(int row, int column) {
		this.setRow(row);
		this.setColumn(column);
	}
	
	/*public void set(int row, int column) {
		this.setRow(row);
		this.setColumn(column);
	}*/
	
	private void setRow(int value) {
		if (value >= 1 && value <= 9) this.row = value;
	}
	
	private void setColumn(int value) {
		if (value >= 1 && value <= 9) this.column = value;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getColumn() {
		return this.column;
	}
	
}