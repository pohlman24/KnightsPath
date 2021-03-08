import java.util.*;
import java.util.Scanner;
import java.util.Stack;


public class Project2Main {
	static Pos[][] board = new Pos[8][8];
	static LLQueue q = new LLQueue();
	
	public static void main(String[] args) throws QueueFullException, QueueEmptyException {
		Scanner input = new Scanner(System.in);
		
		populateBoard();
		
		System.out.println("Enter starting row");
		int rowStart = input.nextInt();
		System.out.println("Enter starting column");
		int colStart = input.nextInt();
		System.out.println("Enter ending row");
		int rowEnd = input.nextInt();
		System.out.println("Enter ending column");
		int colEnd = input.nextInt();
		
		Pos start = new Pos(rowEnd,colEnd,0);
		Pos end = new Pos(rowStart,colStart, Integer.MAX_VALUE);
		
		board[0][1] = new Pos(start.x, start.y,0);
		
		q.enqueue(start);
		
		while(!q.isEmpty()){
			Pos pos = q.dequeue();
			
			if(end.equals(pos)) {
				Iterable<Pos> path = getPath(start,end);
				System.out.println("Found Path:");
				System.out.println(pos.x + ", " + pos.y);
				
				for(Pos position: path) {
					System.out.println(position.x + ", " + position.y);
				}
				return;
			}
			else {
				bfs(pos, ++pos.depth);
			}
		}
		System.out.println("Position not reachable");
	}
	
	private static void bfs(Pos current, int depth) throws QueueFullException {
		// Start from -2 to +2 range and start marking each location on the board
		for (int i = -2; i <= 2; i++) {
			for (int j = -2; j <= 2; j++) {
			  
				Pos next = new Pos(current.x + i, current.y + j, depth);
				  
				if(inRange(next.x, next.y)) {
					//Skip if next location is same as the location you came from in previous run
					if(current.equals(next)) continue;
			
					if (isValid(current, next)) {
					  
						Pos position = board[next.x][next.y] ;
						/*
						* Get the current position object at this location on board.
						* If this location was reachable with a costlier depth, this iteration has given a shorter way to reach
						*/
						if (position.depth > depth) {
							board[current.x + i][current.y + j] = new Pos(current.x, current.y, depth);
							q.enqueue(next);
						}
					}
				}
			}	
		}

	}

	private static boolean inRange(int x, int y) {
		return 0 <= x && x < 8 && 0 <= y && y < 8;
	}
		
	/*Check if this is a valid jump or position for Knight based on its current location */
	public static boolean isValid(Pos current, Pos next) {
		// Use pags theorem to ensure that a move makes a right-angled triangle with sides of 1 and 2. 1-squared + 2-squared is 5.
		int deltaR = next.x - current.x;
		int deltaC = next.y - current.y;
		return 5 == deltaR * deltaR + deltaC * deltaC;
	}

	/*Populate initial board values*/
	private static void populateBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = new Pos(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
			}
		}
	}
		  
	/*Get the Path and return iterable object */
	private static Iterable getPath(Pos start, Pos end) {	  
		Stack<Pos> path = new Stack<Pos>();
			  
		Pos current = board[end.x][end.y];
		while(!current.equals(start)) {
			path.add(current);
			current = board[current.x][current.y];
		}
		path.add(new Pos(start.x, start.y, 0));
		return path;
	}
}
