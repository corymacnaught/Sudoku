
public abstract class SudokuSolver {

	protected Board board;
	
	// Solve the current board
	public Board solve() {
		this.solve(0, 0);
		return this.board;
	}
		
	protected abstract boolean solve(int row, int column);
	
}
