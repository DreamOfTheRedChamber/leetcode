package dynamicprogramming;

/**
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 */

public class MinPathSum
{
    public int minPathSum(int[][] grid) 
    {
        if ( grid.length == 0 
        		|| grid[0].length == 0 )
        {
        	throw new IllegalArgumentException("");
        }
        
        int heighth = grid.length;
        int width = grid[0].length;        
        int[] minSum = new int[width];
        
        // init minSum
        minSum[0] = grid[0][0];
        for ( int j = 1; j < width; j++ )
        {
        	minSum[j] = minSum[j-1] + grid[0][j];
        }
        
        // fill in minSum
        for ( int i = 1; i < heighth; i++ )
        {
        	for ( int j = 1; j < width; j++ )
        	{
        		minSum[j] = Math.min( minSum[j-1], minSum[j] ) + grid[i][j];
        	}
        }
        
        return minSum[width-1];
    }
}
