package dp.rectangle;

/**
 * 
 */

public class PerfectSquares
{
 public int numSquares(int n) 
 {
 	int[] minNum = new int[n+1];
 	minNum[1] = 1;
 	for ( int i = 1; i <= n; i++ )
 	{
 		minNum[i] = Integer.MAX_VALUE;
 		// recurse by subtracting all smaller squares smaller than i
 		for ( int j = 1; j <= i; j++ )
 		{
 			int square = j * j;
 			if ( square == n )
 			{
 				return 1;
 			}
 			else if ( square <= i )
 			{
 				minNum[i] = Math.min( minNum[i], 1 + minNum[i - square] );
 			}
 			else
 			{
 				break;
 			}
 		}
 	}
 	return minNum[n];
 }
}
