package dfs;

/**
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

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
	private final static int MARKED_LAND = 2;
	private final static int LAND = 1;
	
    public int numIslands(char[][] grid) 
    {
    	if ( grid.length == 0
    			|| grid[0].length == 0 )
    	{
    		return 0;
    	}
    	
    	int heighth = grid.length;
    	int width = grid[0].length;
    	int islandCount = 0;
    	for ( int i = 0; i < heighth; i++ )
    	{
    		for ( int j = 0; j < width; j++ )
    		{
    			if ( grid[i][j] == LAND )
    			{
    				islandCount++;
    				markEntireIsland( grid, i, j );
    			}
    		}
    	}
    	
    	for ( int i = 0; i < heighth; i++ )
    	{
    		for ( int j = 0; j < width; j++ )
    		{
    			if ( grid[i][j] == MARKED_LAND )
    			{
    				grid[i][j] = LAND;
    			}
    		}
    	}
    	
    	return islandCount;
    }
    
    private void markEntireIsland( char[][] grid, int xStart, int yStart )
    {
    	int heighth = grid.length;
    	int width = grid[0].length;
    	if ( xStart < 0 
    			|| xStart >= heighth
    			|| yStart < 0
    			|| yStart >= width
    			|| grid[xStart][yStart] != LAND )
    	{
    		return;
    	}
    	
    	grid[xStart][yStart] = MARKED_LAND;
    	markEntireIsland( grid, xStart + 1, yStart );
    	markEntireIsland( grid, xStart - 1, yStart );
    	markEntireIsland( grid, xStart, yStart + 1 );
    	markEntireIsland( grid, xStart, yStart - 1 );
    }

}
