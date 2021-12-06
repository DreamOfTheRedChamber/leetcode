package dp.girdBased;

/**
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 */

public class MinimumPathSum
{
 public int minPathSum( int[][] grid )
 {
 	if ( grid.length == 0 
 			|| grid[0].length == 0 )
 	{
 		throw new IllegalArgumentException();
 	}
 	
 	int height = grid.length;
 	int width = grid[0].length;
 
 	// init dp table
 	int[][] minPathSumGrid = new int[height][width];
 	minPathSumGrid[0][0] = grid[0][0];
 	for ( int i = 1; i < height; i++ )
 	{
 		minPathSumGrid[i][0] = minPathSumGrid[i-1][0] + grid[i][0];
 	}
 	for ( int j = 1; j < width; j++ )
 	{
 		minPathSumGrid[0][j] = minPathSumGrid[0][j-1] + grid[0][j];
 	}
 	
 	// fill dp table
 	for ( int i = 1; i < height; i++ )
 	{
 		for ( int j = 1; j < width; j++ )
 		{
 			minPathSumGrid[i][j] = Math.min( minPathSumGrid[i-1][j], minPathSumGrid[i][j-1] ) + grid[i][j];
 		}
 	}
 	
 	return minPathSumGrid[height-1][width-1];
 }
}
