package dynamicprogramming;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
 */
public class UniquePathII
{
    public int uniquePathsWithObstacles( int[][] obstacleGrid )
    {
    	if ( obstacleGrid.length == 0 
    			|| obstacleGrid[0].length == 0 )
    	{
    		throw new IllegalArgumentException("");
    	}
    	    	
    	int height = obstacleGrid.length;
    	int width = obstacleGrid[0].length;
    	int[][] numUniquePaths = new int[height][width];
    	// init dp table
    	for ( int j = 0; j < width; j++ )
    	{
    		if ( obstacleGrid[0][j] == 1 )
    		{
    			break;
    		}
    		else
    		{
    			numUniquePaths[0][j] = 1;
    		}
    	}
    	for ( int i = 0; i < height; i++ )
    	{
    		if ( obstacleGrid[i][0] == 1 )
    		{
    			break;
    		}
    		else
    		{
    			numUniquePaths[i][0] = 1;
    		}
    	}
    	
    	// fill dp table
    	for ( int i = 1; i < height; i++ )
    	{
    		for ( int j = 1; j < width; j++ )
    		{
    			if ( obstacleGrid[i][j] == 1 )
    			{
    				continue;
    			}
    			else
    			{
    				numUniquePaths[i][j] = numUniquePaths[i-1][j] + numUniquePaths[i][j-1];
    			}
    		}
    	}
    	
    	return numUniquePaths[height-1][width-1];
    }
    
    @Test
    public void test()
    {
    	int[][] singleElemGrid = new int[0][0];
    	singleElemGrid[0][0] = 0;
    	assertEquals( 1, uniquePathsWithObstacles( singleElemGrid ) );
    	
    }
}