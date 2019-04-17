package facebook.medium;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 */

public class DivideTwoIntegers
{
	
    public int divide( int dividend, int divisor )
    {
    	// handle exception case
    	if ( divisor == 0 )
    	{
    		throw new ArithmeticException("");
    	}
    	
    	// need to convert to positive for processing
    	// handle divisor == Integer.MIN_VALUE case
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
    	
    	// handle dividend == Integer.MIN_VALUUE
    	int boundaryAddition = 0;
    	if ( dividend == Integer.MIN_VALUE )
    	{
    		if ( divisor == -1 )
    		{
    			return Integer.MAX_VALUE;
    		}
    		else
    		{
        		dividend += Math.abs( divisor );    			
        		boundaryAddition += 1;
    		}
    	}    	
    	
    	// convert to positive
    	boolean isNeg = ( dividend > 0 ) ^ ( divisor > 0 );
    	dividend = Math.abs( dividend );
    	divisor = Math.abs( divisor );
    	
    	// calc bitwise width of quotient
    	int quotientBitWidth = 0;
    	int shiftedDivisor = divisor;
    	while ( shiftedDivisor < dividend 
    			&& shiftedDivisor > 0 )
    	{
    		quotientBitWidth += 1;
    		shiftedDivisor = ( shiftedDivisor << 1 );	
    	}
    	
    	int quotient = 0;
    	while ( quotientBitWidth >= 0 ) // !!! attention to the equals condition
    	{
    		if ( dividend >= ( divisor << quotientBitWidth ) )
    		{
    			// key algorithm
        		quotient += ( 1 << quotientBitWidth );
        		dividend -= ( divisor << quotientBitWidth );
    		}
    		quotientBitWidth--;
    	}
    	
    	// aggregate final result
    	int result = quotient + boundaryAddition;
    	return isNeg ? -1 * result : result;
    }
    
    @Test
    public void test()
    {
    	assertEquals( 1, divide( 1, 1 ) );
    	assertEquals( Integer.MAX_VALUE, divide( Integer.MIN_VALUE, -1 ) );
    	assertEquals( Integer.MAX_VALUE, divide( Integer.MAX_VALUE, 1 ) );
    }
}
