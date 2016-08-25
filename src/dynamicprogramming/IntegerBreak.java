package dynamicprogramming;

/**
Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

Note: You may assume that n is not less than 2 and not larger than 58.
 */

public class IntegerBreak
{
    public int integerBreak( int n )
    {
    	if ( n <= 1 )
    	{
    		throw new IllegalArgumentException("");
    	}
    		
    	// max product of breaking integer i
        int[] maxProd = new int[n+1];
        maxProd[1] = 1;
        for ( int i = 2; i <= n; i++ )
        {
        	for ( int j = 1; j < i; j++ )
        	{
        		maxProd[i] += maxProd[i-j] * j;
        	}
        }
        return maxProd[n];
    }
}
