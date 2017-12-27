import processing.core.PApplet;

public class Creature {
	int row;
	int col;
	Square[][] currentSquare;

	public Creature(int row, int col) {
		this.row = row;
		this.col = col;

		currentSquare = new Square[row][col];

	} // end constructor

	public void moveLeft() {
		if (!currentSquare[row][col - 1].isBlocked()) {
			col = col - 1;
		} // end if
	} // end moveLeft

	public void moveRight() {
		if (!currentSquare[row][col + 1].isBlocked()) {
			col = col + 1;
		} // end if
	} // end moveRight

	public void moveUp() {
		if (!currentSquare[row - 1][col].isBlocked()) {
			row = row - 1;
		} // end if
	} // end moveUp

	public void moveDown() {
		if (!currentSquare[row + 1][col].isBlocked()) {
			row = row + 1;
		} // end if
	} // end moveDown

	void display(PApplet proc) {
		proc.fill(255, 0, 0);
		proc.ellipse(row, col, 20, 20);

	} // end display

} // end class
