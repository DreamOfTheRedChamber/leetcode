package binarySearch;

import org.junit.Test;

/**
 * Implement pow(x, n).
 */

public class Pow
{
    public double myPow( double x, int n )
    {
    	if ( x == 0 
    			&& n < 0 )
    	{
    		throw new ArithmeticException("");
    	}
    	
    	if ( n == Integer.MIN_VALUE )
    	{
    		return myPow( x, n + 1) / x;
    	}
    	
    	// convert x and n to positive
    	boolean isNeg = ( x < 0 ) && ( Math.abs( n ) % 2 == 0 );
    	x = Math.abs( x );
    	n = Math.abs( n );
    	if ( n < 0 )
    	{
    		// TODO: overflow exception
    		return isNeg ? -1 / myPow( x, n ) : 1 / myPow( x, n );
    	}
    	
    	return isNeg ? -1 * myPowRecurse( x, n ) : myPowRecurse( x, n );
    }
    
    private double myPowRecurse( double x, int n )
    {
    	// assert n >= 0
    	if ( n <= 1 )
    	{
    		return x;
    	}

		double halfMyPow = myPowRecurse( x, n / 2 );
    	if ( n % 2 == 1 )
    	{
    		return halfMyPow * halfMyPow * x;
    	}
    	else
    	{
    		return halfMyPow * halfMyPow;
    	}
    }
}
