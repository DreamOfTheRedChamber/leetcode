package dp.girdBased;

/**
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
 */
public class UniquePath
{
 public int uniquePaths( int m, int n )
 {
 	int[] numUniquePaths = new int[n];
 	
 	// init numUniquePaths
 	for ( int j = 0; j < n; j++ )
 	{
 		numUniquePaths[j] = 1;
 	}
 	
 	// fill in numUniquePaths
 	for ( int i = 1; i < m; i++ )
 	{
 		for ( int j = 1; j < n; j++ )
 		{
 			numUniquePaths[j] = numUniquePaths[j-1] + numUniquePaths[j];
 		}
 	}
 	
 	return numUniquePaths[n-1];
 }
}