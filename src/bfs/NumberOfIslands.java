package bfs;

/**
 * 
 */

public class NumberOfIslands
{

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
    			if ( grid[i][j] == '1' )
    			{
    				islandCount++;
    				markIsland( grid, i, j );
    			}
    		}
    	}
    	
    	for ( int i = 0; i < heighth; i++ )
    	{
    		for ( int j = 0; j < width; j++ )
    		{
    			if ( grid[i][j] == '2' )
    			{
    				grid[i][j] = '1';
    			}
    		}
    	}
    	
    	return islandCount;
    }
    
    private void markIsland( char[][] grid, int xStart, int yStart )
    {
    	int heighth = grid.length;
    	int width = grid[0].length;
    	if ( xStart < 0 
    			|| xStart >= heighth
    			|| yStart < 0
    			|| yStart >= width
    			|| grid[xStart][yStart] != '1' )
    	{
    		return;
    	}
    	
    	markIsland( grid, xStart + 1, yStart );
    	markIsland( grid, xStart - 1, yStart );
    	markIsland( grid, xStart, yStart + 1 );
    	markIsland( grid, xStart, yStart - 1 );
    }

}
