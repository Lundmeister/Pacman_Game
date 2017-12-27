import java.util.ArrayList;

import processing.core.PApplet;

public class Maze {

	Square[][] grid;
	int widthOfSquare = 30;
	int heightOfSquare = 30;
	int numRows;
	int numCols;

	public Maze(int numRows, int numCols, double chanceOfBlocked) {
		this.numRows = numRows;
		this.numCols = numCols;

		do {
			grid = new Square[numRows][numCols];

			for (int row = 0; row < numRows; row++) {
				for (int col = 0; col < numCols; col++) {
					double x = Math.random();
					grid[row][col] = new Square(col * widthOfSquare + 500 - (numCols / 2 * widthOfSquare),
							row * widthOfSquare + 400 - (numRows / 2 * widthOfSquare), widthOfSquare,
							x < chanceOfBlocked, row, col);

				} // end for
			} // end for

			grid[0][0].setBlocked(false);
			grid[numRows - 1][numCols - 1].setBlocked(false);
			markReachable();
		} while (!grid[numRows - 1][numCols - 1].isReached());

		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				if (!grid[row][col].isReached()) {
					grid[row][col].setBlocked(true);
				} // end if
			} // end for
		} // end for

	} // end constructor

	public void display(PApplet proc) {
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				grid[row][col].display(proc);
			} // end for
		} // end for
	} // end display

	void markReachable() {
		ArrayList<Square> openList = new ArrayList<Square>();
		grid[0][0].setReached(true);
		openList.add(grid[0][0]);

		while (openList.size() > 0) {
			Square currentSquare = openList.remove(0);
			int row = currentSquare.getRow();
			int col = currentSquare.getCol();

			checkAndAdd(openList, row + 1, col, currentSquare);
			checkAndAdd(openList, row - 1, col, currentSquare);
			checkAndAdd(openList, row, col + 1, currentSquare);
			checkAndAdd(openList, row, col - 1, currentSquare);

		} // end while

	} // end markReachable

	void checkAndAdd(ArrayList<Square> openList, int row, int col, Square currentSquare) {

		if (row >= 0 && col >= 0 && row < numRows && col < numCols && !this.grid[row][col].isBlocked()
				&& !this.grid[row][col].isReached()) {
			this.grid[row][col].setReached(true);
			openList.add(this.grid[row][col]);

		} // end if

	} // end checkAndAdd

	void KeyPressed(PApplet proc) {
		if (proc.key == proc.CODED) {
			if (proc.keyCode == proc.LEFT) {
				theCreature.moveLeft();
			} // end if
			if (proc.keyCode == proc.RIGHT) {
				theCreature.moveRight();
			} // end if
			if (proc.keyCode == proc.UP) {
				theCreature.moveUp();
			} // end if
			if (proc.keyCode == proc.DOWN) {
				theCreature.moveDown();
			} // end if

		} // end if

	} // end KeyPressed
	
	public int getWidthOfSquare() {
		return widthOfSquare;
	} // end getter

	public int getHeightOfSquare() {
		return heightOfSquare;
	} // end getter
	
	public int getNumRows() {
		return numRows;
	} // end getter

	public int getNumCols() {
		return numCols;
	} // end getter

} // end class Maze
