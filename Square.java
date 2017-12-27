import processing.core.PApplet;

public class Square {

	float xPos;
	float yPos;
	float size;
	boolean blocked;
	boolean reached = false;
	int row;
	int col;

	public Square(float xPos, float yPos, float size, boolean blocked, int row, int col) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.size = size;
		this.blocked = blocked;
		this.row = row;
		this.col = col;
	} // end constructor

	public void display(PApplet proc) {
		if (blocked) {
			proc.fill(0, 0, 255);
		} else {
			proc.fill(255, 255, 255);
		} // end if
		proc.rect(xPos, yPos, size, size);
	} // end display

	public boolean isBlocked() {
		return blocked;
	} // end isBlocked

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	} // end setBlocked

	public boolean isReached() {
		return reached;
	} // end isReached

	public void setReached(boolean reached) {
		this.reached = reached;
	} // end setReached

	public int getRow() {
		return row;
	} // end getRow

	public int getCol() {
		return col;
	} // end getCol

} // end class Square
