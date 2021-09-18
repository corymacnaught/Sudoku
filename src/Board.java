import java.util.Arrays;

public abstract class Board {
	protected Cell[][] board;
	
	// Solve the current board
	public void solve() {
		solve(0, 0);
	}
	
	protected abstract boolean solve(int row, int column);
	
	public abstract boolean isValid();
	
	public String toString() {
		String s = "";
		for (Cell[] array : board) s += Arrays.toString(array) + "\n";
		return s;
	}
}
