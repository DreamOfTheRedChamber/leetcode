package binarySearch;

/**
Implement int sqrt(int x).

Compute and return the square root of x.
 */

public class Sqrt
{
    public int mySqrt( int x )
    {
    	if ( x < 0 )
    	{
    		throw new IllegalArgumentException("");
    	}
    	if ( x <= 1 )
    	{
    		return 1;
    	}
    	
    	int start = 1;
    	int end = x / 2;
    	while ( start + 1 < end )
    	{
    		int mid = ( end - start ) / 2 + start;
    		// TODO: techniques to avoid overflow
    		// TODO: lowerbound or upperbound
    		if ( x / mid < mid )
    		{
    			end = mid - 1;
    		}
    		else
    		{
    			start = mid;
    		} 			
    	}
    	
    	if ( x / end > end )
    	{
    		return end;
    	}
    	else
    	{
    		return start;
    	}
    }
}