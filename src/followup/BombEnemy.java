package followup;

/**
Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
Note that you can only put the bomb at an empty cell.

Example:
For the given grid

0 E 0 0
E 0 W E
0 E 0 0

return 3. (Placing a bomb at (1,1) kills 3 enemies) 
 */

public class BombEnemy
{	
    public int maxKilledEnemies( char[][] grid )
    {
    	if ( grid == null || grid.length == 0 || grid[0].length == 0 )
    	{
    		return 0;
    	}
    	
    	int height = grid.length;
    	int width = grid[0].length;
    	int[][] numKilled = new int[height][width];
    	for ( int i = 0; i < height; i++ )
    	{
    		for ( int j = 0; j < width; j++ )
    		{
    			if ( grid[i][j] == 'E' )
    			{
    				aggreReacheableEnemies( numKilled, grid, i, j );
    			}
    		}
    	}
    	
    	int maxEnemies = 0;
    	for ( int i = 0; i < height; i++ )
    	{
    		for ( int j = 0; j < width; j++ )
    		{
    			if ( grid[i][j] == '0' && numKilled[i][j] > maxEnemies )
    			{
    				maxEnemies = Math.max( maxEnemies, numKilled[i][j] );
    			}
    		}
    	}
    	return maxEnemies;
    }
    
    private void aggreReacheableEnemies( int[][] numKilled, char[][] grid, int startX, int startY )
    {
    	int[][] directions = new int[][]{ {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
    	int height = grid.length;
    	int width = grid[0].length;
    	for ( int[] direction : directions )
    	{
    		int nextX = startX + direction[0];
    		int nextY = startY + direction[1];
    		int numEnemy = 1;
    		while ( nextX < height 
    				&& nextX >= 0 
    				&& nextY < width
    				&& nextY >= 0 )
    		{
    			if ( grid[nextX][nextY] == 'W' )
    			{
    				break;
    			}
    			else if ( grid[nextX][nextY] == 'E' )
    			{
    				numEnemy++;
    			}
    			else
    			{
    				numKilled[nextX][nextY] += numEnemy;
    			}
    			nextX += direction[0];
    			nextY += direction[1];
    		}
    	}
    }
}
