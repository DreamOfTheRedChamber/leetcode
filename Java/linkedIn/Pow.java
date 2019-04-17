package linkedIn;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Implement pow(x, n).
 * 
 * (输入和输出都是float)
 */

public class Pow
{
    public double myPow( double x, int n )
    {
    	// exception case
    	if ( x == 0 
    			&& n < 0 )
    	{
    		throw new ArithmeticException("");
    	}
    	
    	// need to convert x and n to positive for processing    	

    	// processing n
    	// n == Integer.MIN_VALUE case
    	if ( n == Integer.MIN_VALUE )
    	{
    		return myPow( x, n + 1) / x;
    	}
    	// n < 0 && n != Integer.MIN_VALUE
    	if ( n < 0 )
    	{
        	n = Math.abs( n );
    		return 1 / myPow( x, n );
    	}
    	
    	// processing x
    	boolean isNeg = ( x < 0 ) && ( Math.abs( n ) % 2 != 0 );
    	x = Math.abs( x );
    	    	
    	return ( isNeg ? -1 : 1 ) * myPowRecurse( x, n );
    }
    
    private double myPowRecurse( double x, int n )
    {
    	// assert n >= 0
    	if ( n == 0 )
    	{
    		return 1;
    	}    	
    	if ( n == 1 )
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
    
    @Test
    public void test()
    {    	
    	assertEquals( 1.0, myPow( 0.44528, 0 ), 1e-5 );
    	assertEquals( -2529.955038927, myPow( -13.62608, 3 ), 1e-5 );
    }
}
