package facebook.medium;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
 
 */

public class NumberOfIslands
{	
	private int[][] directions = new int[][]{ {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
	
    public int numIslands(char[][] grid) 
    {
    	if ( grid.length == 0
    			|| grid[0].length == 0 )
    	{
    		return 0;
    	}
    	
    	int height = grid.length;
    	int width = grid[0].length;
    	int numIsland = 0;
    	boolean[][] isVisited = new boolean[height][width];
    	for ( int i = 0; i < height; i++ )
    	{
    		for ( int j = 0; j < width; j++ )
    		{
    			if ( grid[i][j] == '1' && !isVisited[i][j] )
    			{
    				numIsland++;
    				visitIsland( grid, isVisited, i, j );
    			}
    		}
    	}
    	
    	return numIsland;
    }
    
    private class Pair
    {
    	public final int x;
    	public final int y;
    	public Pair( int x, int y )
    	{
    		this.x = x;
    		this.y = y;
    	}
    }
    
    private void visitIsland( char[][] grid, boolean[][] isVisited, int xStart, int yStart )
    {
    	Queue<Pair> bfsQueue = new LinkedList<>();
    	bfsQueue.offer( new Pair( xStart, yStart ) );
    	isVisited[xStart][yStart] = true;
    	
    	int height = grid.length;
    	int width = grid[0].length;
    	while ( !bfsQueue.isEmpty() )
    	{
    		Pair qHead = bfsQueue.poll();
    		for ( int[] direction : directions )
    		{
    			int neighborX = qHead.x + direction[0];
    			int neighborY = qHead.y + direction[1];
    			if ( neighborX >= 0 
    					&& neighborX < height 
    					&& neighborY >= 0 
    					&& neighborY < width 
    					&& !isVisited[neighborX][neighborY] 
    					&& grid[neighborX][neighborY] == '1'		)
    			{
    				isVisited[neighborX][neighborY] = true;
    				bfsQueue.offer( new Pair( neighborX, neighborY ) );
    			}
    		}
    	}
    }
}
