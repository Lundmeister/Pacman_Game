import processing.core.PApplet;

public class Main extends PApplet {

	Maze theMaze;
	Creature theCreature;
	
	public void setup() {
		size(1000, 800);
		theMaze = new Maze(20, 20, 0.4);
		theCreature = new Creature(500-(theMaze.getNumCols()/2*theMaze.getWidthOfSquare())
									+ theMaze.getWidthOfSquare()/2
									, 400-(theMaze.getNumRows()/2*theMaze.getHeightOfSquare())
									+ theMaze.getHeightOfSquare()/2);
	} // end setup

	public void draw() {
		background(0, 0, 0);
		theMaze.display(this);
		theMaze.markReachable();
		
		
	} // end background

	

} // end class
