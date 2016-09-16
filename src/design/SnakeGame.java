package design;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.
The snake is initially positioned at the top left corner (0,0) with length = 1 unit.
You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.
Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.
When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.

Given width = 3, height = 2, and food = [[1,2],[0,1]].

Snake snake = new Snake(width, height, food);

Initially the snake appears at position (0,0) and the food at (1,2).

|S| | |
| | |F|

snake.move("R"); -> Returns 0

| |S| |
| | |F|

snake.move("D"); -> Returns 0

| | | |
| |S|F|

snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )

| |F| |
| |S|S|

snake.move("U"); -> Returns 1

| |F|S|
| | |S|

snake.move("L"); -> Returns 2 (Snake eats the second food)

| |S|S|
| | |S|

snake.move("U"); -> Returns -1 (Game over because snake collides with border)
*/

// assumption:
// 1. food grid is always enough
// 2. direction always valid
public class SnakeGame
{
	// snake
	private Queue<Integer> snakeBody;
	private int snakeHeadX;
	private int snakeHeadY;
	
	// food
	private int[][] foodGrid;
	private int nextFood;
	
	// board
	private int boardHeight;
	private int boardWidth;
	
	// avoids eating itself
	private Set<Integer> snakeBodyMarker;
	
	private int score;

	/**
	 * Initialize your data structure here.
	 * 
	 * @param width
	 *            - screen width
	 * @param height
	 *            - screen height
	 * @param food
	 *            - A list of food positions E.g food = [[1,1], [1,0]] means the
	 *            first food is positioned at [1,1], the second is at [1,0].
	 */
	public SnakeGame( int width, int height, int[][] food )
	{
		boardHeight = height;
		boardWidth = width;
		
		foodGrid = food;
		nextFood = 0;
		
		snakeHeadX = 0;
		snakeHeadY = 0;
		
		snakeBody = new LinkedList<>();
		snakeBody.add( getCoorHash( snakeHeadX, snakeHeadY ) );
		snakeBodyMarker = new HashSet<>();
		snakeBodyMarker.add( getCoorHash( snakeHeadX, snakeHeadY ) );
		
		score = 0;
	}

	private int getCoorHash( int x, int y )
	{
		return x * boardWidth + y;
	}
	
	/**
	 * Moves the snake.
	 * 
	 * @param direction
	 *            - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
	 * @return The game's score after the move. Return -1 if game over. Game
	 *         over when snake crosses the screen boundary or bites its body.
	 */
	public int move( String direction )
	{
		// find the next head position
		int nextSnakeHeadX = snakeHeadX;
		int nextSnakeHeadY = snakeHeadY;
		if ( direction.equals( "U" ) )
		{
			nextSnakeHeadX--;
		}
		else if ( direction.equals( "D" ) )
		{
			nextSnakeHeadX++;
		}
		else if ( direction.equals( "L" ) )
		{
			nextSnakeHeadY--;
		}
		else
		{
			nextSnakeHeadY++;
		}
		
		
		// edge cases
		// if cross boundary
		if( ( nextSnakeHeadX < 0 || nextSnakeHeadX >= boardHeight )
				|| ( nextSnakeHeadY < 0 || nextSnakeHeadY >= boardWidth ) )
		{
			return -1;
		}

		// if eat itself
		// always won't eat its tail
		Integer tailHash = snakeBody.peek( );
		Integer nextSnakeHeadHash = getCoorHash( nextSnakeHeadX, nextSnakeHeadY );
		if ( snakeBodyMarker.contains( nextSnakeHeadHash )
			&& nextSnakeHeadHash != tailHash ) 
		{
			return -1;
		}

		
		// move toward next position
		// has food
		if ( nextFood < foodGrid.length 
				&& foodGrid[nextFood][0] == nextSnakeHeadX 
				&& foodGrid[nextFood][1] == nextSnakeHeadY )
		{
			score++;
			nextFood++;			
		}
		else
		{
			snakeBody.remove();
			snakeBodyMarker.remove( tailHash );
		}
		
		// Add head
		snakeBody.add( nextSnakeHeadHash );
		snakeBodyMarker.add( nextSnakeHeadHash );		
		snakeHeadX = nextSnakeHeadX;
		snakeHeadY = nextSnakeHeadY;
		
		return score;
	}

	public static void main(String[] args)
	{
		/*
["SnakeGame","move","move","move","move","move","move","move","move","move","move","move","move","move","move","move"]
[[3,3,[[2,0],[0,0],[0,2],[0,1],[2,2],[0,1]]],["D"],["D"],["R"],["U"],["U"],["L"],["D"],["R"],["R"],["U"],["L"],["L"],["D"],["R"],["U"]]
		 * */
		int[][] food = new int[][]{ {2,0}, {0,0}, {0,2}, {0,1}, {2,2}, {0,1} };
		SnakeGame snakeGame = new SnakeGame( 3, 3, food );

		// first food
		assertEquals( 0, snakeGame.move( "D" ) );
		assertEquals( 1, snakeGame.move( "D" ) );
		
		// second food
		assertEquals( 1, snakeGame.move( "R" ) );
		assertEquals( 1, snakeGame.move( "U" ) );
		assertEquals( 1, snakeGame.move( "U" ) );
		assertEquals( 2, snakeGame.move( "L" ) );
		
		// third food
		assertEquals( 2, snakeGame.move( "D" ) );
		assertEquals( 2, snakeGame.move( "R" ) );
		assertEquals( 2, snakeGame.move( "R" ) );
		assertEquals( 3, snakeGame.move( "U" ) );		

		// fourth food
		assertEquals( 4, snakeGame.move( "L" ) );
		assertEquals( 4, snakeGame.move( "L" ) );
		assertEquals( 4, snakeGame.move( "D" ) );
		assertEquals( 4, snakeGame.move( "R" ) );
		
		// eat itself
		assertEquals( -1, snakeGame.move( "U" ) );
				
		// edge case: when to remove snake tail
		/*
["SnakeGame","move","move","move","move","move","move","move","move","move","move","move","move"]
[[3,3,[[2,0],[0,0],[0,2],[2,2]]],["D"],["D"],["R"],["U"],["U"],  ["L"],["D"],["R"],["R"],["U"],  ["L"],["D"]]
		 */
		food = new int[][]{ {2,0}, {0,0}, {0,2}, {2,2} };
		snakeGame = new SnakeGame( 3, 3, food );
		
		// first food
		assertEquals( 0, snakeGame.move( "D" ) );
		assertEquals( 1, snakeGame.move( "D" ) );
		
		// second food
		assertEquals( 1, snakeGame.move( "R" ) );
		assertEquals( 1, snakeGame.move( "U" ) );
		assertEquals( 1, snakeGame.move( "U" ) );
		assertEquals( 2, snakeGame.move( "L" ) );
		
		// third food
		assertEquals( 2, snakeGame.move( "D" ) );
		assertEquals( 2, snakeGame.move( "R" ) );
		assertEquals( 2, snakeGame.move( "R" ) );
		assertEquals( 3, snakeGame.move( "U" ) );
		
		assertEquals( 3, snakeGame.move( "L" ) );
		assertEquals( 3, snakeGame.move( "D" ) );
	
		// remove tail before adding head
	/*
["SnakeGame","move","move","move","move","move","move","move","move","move","move","move","move","move","move","move","move","move","move","move"]
[[3,3,[[0,1],[0,2],[1,2],[2,2],[2,1],[2,0],[1,0]]],["R"],["R"],["D"],["D"],["L"],["L"],["U"],["U"],["R"],["R"],["D"],["D"],["L"],["L"],["U"],["R"],["U"],["L"],["D"]]
	 */
		food = new int[][]{ {0, 1}, {0, 2}, {1, 2}, {2, 2}, {2, 1}, {2, 0}, {1, 0} };
		snakeGame = new SnakeGame( 3, 3, food );

		assertEquals( 1, snakeGame.move( "R" ) );
		assertEquals( 2, snakeGame.move( "R" ) );
		assertEquals( 3, snakeGame.move( "D" ) );
		assertEquals( 4, snakeGame.move( "D" ) );
		assertEquals( 5, snakeGame.move( "L" ) );
		assertEquals( 6, snakeGame.move( "L" ) );
		assertEquals( 7, snakeGame.move( "U" ) );
		
		assertEquals( 7, snakeGame.move( "U" ) );		
		assertEquals( 7, snakeGame.move( "R" ) );		
		assertEquals( 7, snakeGame.move( "R" ) );		
		assertEquals( 7, snakeGame.move( "D" ) );
		assertEquals( 7, snakeGame.move( "D" ) );		
		assertEquals( 7, snakeGame.move( "L" ) );
		assertEquals( 7, snakeGame.move( "L" ) );
		assertEquals( 7, snakeGame.move( "U" ) );
		assertEquals( 7, snakeGame.move( "R" ) );
		assertEquals( 7, snakeGame.move( "U" ) );
		assertEquals( 7, snakeGame.move( "L" ) );
		
		assertEquals( -1, snakeGame.move( "D" ) );
	}
}
/**
 * Your SnakeGame object will be instantiated and called as such: SnakeGame obj
 * = new SnakeGame(width, height, food); int param_1 = obj.move(direction);
 */