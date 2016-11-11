package facebook.medium;

/**
 * Question 1: Given an array, please get the length of the longest arithmetic sequence. The element order in the arithmetic sequence should be same as the element order in the array. 
 * For example, in the array {1, 6, 3, 5, 9, 7}, the longest arithmetic sequence is 1, 3, 5, and 7, whose elements have same order as they are in the array, and the length is 4.
 * 
 * Question 2: Given an array, please get the length of the longest arithmetic sequence. The element order in the arithmetic sequence is not necessarily same as the element order in the array. 
 * For example, in the array {1, 6, 3, 5, 9, 7}, the longest arithmetic sequence is 1, 3, 5, 7, and 9, and the length is 5.
 */

public class LongestArithmeticProgression
{
	public int lengthOfLongestAP( int[] set, int n )
	{
		if ( n <= 2 )
		{
			return n;
		}
		
		int[][] longestAP = new int[n][n];
		int longest = 2;
		for ( int i = 0; i < n; i++ )
		{
			longestAP[i][n-1] = 2;
		}
		
		for ( int j = n-2; j >= 1; j-- )
		{
			int i = j-1, k = j+1;
			while ( i >= 0 && k <= n-1 )
			{
				if ( set[i] + set[k] < 2 * set[j] )
				{
					k++;
				}
				else if ( set[i] + set[k] > 2 * set[j] )
				{
					longestAP[i][j] = 2;
					i--;
				}
				else
				{
					longestAP[i][j] = longestAP[j][k] + 1;					
					longest = Math.max( longest, longestAP[i][j] );
					
					i--;
					k++;
				}
			}
			
			while ( i >= 0 )
			{
				longestAP[i][j] = 2;
				i--;
			}
		}
		return longest;
	}
}