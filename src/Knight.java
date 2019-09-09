import java.util.*;

/*
 * Creates the knight object used to move around the board in Heuristic and Non Heuristic
 * 
 * @author Marlon Cabrera
 * @version September 9, 2019
 * Programming Project 1
 * Fall 2019
 */

public class Knight {
	
	Random r = new Random();
	
	private int x;
	private int y;
	
	/*
	 * empty argument constructor
	 */
	public Knight() {
		randomK();
	}
	
	/*
	 * constructor that accepts x and y coordinates
	 * @param x
	 * @param y
	 */
	public Knight(int X, int Y) {
		
		x = X;
		y = Y;
		
	}//end Knight
	
	/*
	 * changes the x and y of the knight to random variables between 0 and 7
	 */
	public void randomK() {
		
		y = r.nextInt(8);
		x = r.nextInt(8);
	
	}//end randomK

	/*
	 * getter for x
	 * @return x
	 */
	public int getX() {
		return x;
	}//end getX

	/*
	 * setter for x
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}//end setX

	/*
	 * getter for y
	 * @return y
	 */
	public int getY() {
		return y;
	}//end getY

	/*
	 * setter for y
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}//end setY

	@Override
	public String toString() {
		return "Knight [r=" + r + ", x=" + x + ", y=" + y + "]";
	}//end toString
	
}//end Class
