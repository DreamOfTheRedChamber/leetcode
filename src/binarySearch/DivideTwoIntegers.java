package binarySearch;

/**
 * 
 */

public class DivideTwoIntegers
{
	
    public int divide( int dividend, int divisor )
    {
    	if ( divisor == 0 )
    	{
    		throw new ArithmeticException("");
    	}
    	
    	// handle edge cases before converting both to positive
    	if ( divisor == Integer.MIN_VALUE )
    	{
    		if ( dividend == Integer.MIN_VALUE )
    		{
    			return 1;
    		}
    		else
    		{
    			return 0;
    		}
    	}
    	
    	int boundaryAddition = 0;    	    	
    	if ( dividend == Integer.MIN_VALUE )
    	{
    		dividend += Math.abs( divisor );
    		boundaryAddition += 1;
    	}
    	
    	// convert to positive
    	boolean isNeg = ( dividend > 0 ) ^ ( divisor > 0 );
    	dividend = Math.abs( dividend );
    	divisor = Math.abs( divisor );
    	
    	// calc bitwise width of quotient
    	int quotientBitWidth = 0;
    	int shiftedDivisor = divisor;
    	while ( shiftedDivisor < dividend )
    	{
    		quotientBitWidth += 1;
    		shiftedDivisor = ( shiftedDivisor << 1 );	
    	}
    	
    	int quotient = 0;
    	while ( quotientBitWidth > 0 )
    	{
    		if ( dividend - ( divisor << quotientBitWidth )  > 0 )
    		{
        		quotient += ( 1 << quotientBitWidth );
        		dividend -= ( divisor << quotientBitWidth );
    		}
    		quotientBitWidth--;
    	}
    	
    	int result = quotient + boundaryAddition;
    	return isNeg ? -1 * result : result;
    }
}
