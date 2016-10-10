package depthFirstSearch;

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
    			if ( grid[i][j] == '1' )
    			{
    				numIsland++;
    				visitIsland( grid, isVisited, i, j );
    			}
    		}
    	}
    	
    	return numIsland;
    }
    
    private void visitIsland( char[][] grid, boolean[][] isVisited, int xStart, int yStart )
    {
    	if ( xStart < 0 
    			|| xStart >= grid.length
    			|| yStart < 0
    			|| yStart >= grid[0].length
    			|| isVisited[xStart][yStart] )
    	{
    		return;
    	}

    	isVisited[xStart][yStart] = true;
    	for ( int[] direction : directions )
    	{
    		visitIsland( grid, isVisited, xStart + direction[0], yStart + direction[1] );
    	}
    }
}
