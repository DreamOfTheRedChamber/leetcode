package bfs;

/**
 * 
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
