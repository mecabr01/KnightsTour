import java.util.*;

/*
 * Non Heuristic Knights Tour
 * 
 * @author Marlon Cabrera
 * @version September 9, 2019
 * Programming Project 1
 * Fall 2019
 */

public class NoHeuristic{
	
	private int moves = 0;
	private int board[][] = new int [8][8];
	
	Knight Knight = new Knight();
	Random r = new Random();
	
	boolean cantUse[] = new boolean[8];
	boolean stop = false;
	
	private int row;
	private int col;
	
	
	ArrayList <String> results = new ArrayList <String>();
	
	/*
	 * determines if a move can be used
	 * @param f
	 */
	public void cantUse(int f) {
		cantUse[f] = true;
	}//end cantUse
	
	/*
	 * checks to see if cantUse is true
	 * @return stop
	 */
	public boolean checkCantUse() {
		
		boolean stop = false;
		for(int i = 0; i < 8; i++) {
			if(cantUse[i] == true) {
				
			}//end if
		else {
			stop = true;
			
		}//end else
	}//end for
		return stop;
	}//end checkCantUse
	
	/*
	 * resets which moves can't be used / reset cantUse
	 * 
	 */
	public void resetCantUse() {
		for(int i = 0; i < 8; i++) {
			cantUse[i] = false;
		}//end for
	}//end resetCantUse
	
	/*
	 * returns all possible directions a knight can move as a nested if statement
	 * 
	 */
	public void direction(int d) {
		row = 0;
		col = 0;
		
		if (d == 0) {
			row+=1;
			col+=2;
			cantUse(d);
		}//end if
		if (d == 1) {
			row+=2;
			col+=1;
			cantUse(d);
		}//end if
		if (d == 2) {
			row+=1;
			col-=2;
			cantUse(d);
		}//end if
		if (d == 3) {
			row+=2;
			col-=1;
			cantUse(d);
		}//end if
		if (d == 4) {
			row-=1;
			col-=2;
			cantUse(d);
		}//end if
		if (d == 5) {
			row-=2;
			col-=1;
			cantUse(d);
		}//end if
		if (d == 6) {
			row-=1;
			col+=2;
			cantUse(d);
		}//end if
		if (d == 7) {
			row-=2;
			col+=1;
			cantUse(d);
		}//end if
	}//end direction
	
	/*
	 * method that moves the knight around the board while also bounds checking 
	 * to make sure that the knight doesn't leave the chess board area
	 * 
	 */
	public void move() {
		int R = r.nextInt(8);
		
		direction(R);
		
		if((Knight.getX() + row) >= 0 && (Knight.getX() + row) <= 7 && 
			(Knight.getY() + col) >= 0 && (Knight.getY() + col) <= 7) {
			if (board[Knight.getX() + row][Knight.getY() + col] == 0) {
				
				moves++;
				Knight.setX(Knight.getX()+row);
				Knight.setY(Knight.getY()+col);
			
				resetCantUse();
			}//end if
		}else if(checkCantUse() == true) {
			
			results.add(", " + moves);
			results.add(", [" + Knight.getX() + ","+Knight.getY() + "]");
			END();
			moves = 64;
			stop = true;

		}else {
			move();
		}//end else
		
	}//end move
	
	/*
	 * method that resets board
	 */
	public void reset() {
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				board [x] [y] = 0;
			}//end for
		}//end for
		resetCantUse();
	}//end reset
	
	/*
	 * runs a new tour by reseting the board, moving the knight to a random location,
	 * setting the moves to zero, and then running move() up to a possible total of 64 times and
	 * then checking if it is a complete tour using FULL()
	 * 
	 */
	public void NEW() {
		stop = false;
		reset();
		
		Knight.randomK();
		
		results.add("["+Knight.getX()+","+Knight.getY()+"]");
		moves = 0;
		
		while(moves != 64) {
			move();	
		}//end while
		if(stop == false) {
		
		FULL();
		
		}//end if
		
	}//end NEW
	
	/*
	 * prints results if not a complete tour
	 * 
	 */
	public void END() {
		
		for(String list : results) {
			System.out.print(list);
		}//end for
		
		System.out.println();
		results = new ArrayList <String>();
		
	}//end END
	
	/*
	 * prints results for complete tour
	 * 
	 */
	public void FULL() {
		
		results.add(", " + moves);
    	results.add(", ["+Knight.getX()+","+Knight.getY()+"]*");
    	
    	for(String list : results) {
    		System.out.print(list);
    	}//end for
    	
    	System.out.println();
		results = new ArrayList <String>();
		
	}//end FULL
	
	/*
	 * uses NEW to run NoHeuristic
	 */
	public static void main(String[] args) {
		
		NoHeuristic tour = new NoHeuristic();
		for (int i = 0; i <= 1000; i++) {
			tour.NEW();
		}//end for
		
		
	}//end main
	
	
}//end Class