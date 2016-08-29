package binarySearch;

/**
Implement int sqrt(int x).

Compute and return the square root of x.
 */

public class Sqrt
{
    public int mySqrt( int input )
    {
    	if ( input < 0 )
    	{
    		throw new IllegalArgumentException("");
    	}
    	if ( input <= 1 )
    	{
    		return input;
    	}
    	
    	int start = 1;
    	int end = input / 2;
    	while ( start + 1 < end )
    	{
    		int mid = ( end - start ) / 2 + start;
    		if ( input / mid < mid ) // !!! when equals, find the result mid
    		{
    			end = mid;
    		}
    		else
    		{
    			start = mid;
    		} 			
    	}
    	
    	if ( input / end >= end )
    	{
    		return end;
    	}
    	else
    	{
    		return start;
    	}
    }
}