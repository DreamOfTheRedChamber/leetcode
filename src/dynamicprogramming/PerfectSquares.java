package dynamicprogramming;

/**
 * 
 */

public class PerfectSquares
{
    public int numSquares( int n )
    {
    	if ( n == 1 )
    	{
    		return 1;
    	}
    	
        int[] minNumSquare = new int[n+1];
        
        for ( int i = 2; i <= n; i++ )
        {
        	for ( int j = 1; j * j <= i; j++ )
        	{
        		if ( j * j == i )
        		{
        			minNumSquare[i] = 1;
        			break;
        		}
        		else
        		{
        			minNumSquare[i] = Math.min( minNumSquare[i], 1 + minNumSquare[i-j*j] );
        		}
        	}
        }
        return minNumSquare[n];
    }
}
