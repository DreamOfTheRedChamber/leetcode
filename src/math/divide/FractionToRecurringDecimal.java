package math.divide;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
 */

public class FractionToRecurringDecimal
{
    public String fractionToDecimal( int numerator, int denominator )
    {
    	if ( denominator == 0 )
    	{
    		throw new ArithmeticException("");
    	}
    	if ( numerator == 0 )
    	{
    		return "0";
    	}
    	
    	StringBuilder result = new StringBuilder();
    	boolean isNeg = ( numerator > 0 ) ^ ( denominator > 0 );
    	if ( isNeg )
    	{
    		result.append( "-" );
    	}
    	
    	// how to handle integer boundary case ( convert to long )
    	long absNumerator = Math.abs( (long) numerator );
    	long absDenominator = Math.abs( (long) denominator );
    	
    	Map<Long, Integer> residueToPos = new HashMap<>();
    	
    	// before dot
    	long quotient = absNumerator / absDenominator;
    	long residue = absNumerator % absDenominator;
		result.append( String.valueOf( quotient ) );
    	if ( residue == 0 )
    	{
    		return result.toString();
    	}

    	result.append(".");
		int lengthBeforeDot = result.length();

		// after dot
		int posAfterDot = 1; // start from 1
		while ( residue != 0 
				&& !residueToPos.containsKey( residue ) ) 
		{
			residueToPos.put( residue, posAfterDot );
			posAfterDot++;
			quotient = ( residue * 10 ) / absDenominator;
			residue = ( residue * 10 ) % absDenominator;
			result.append( String.valueOf( quotient ) );
		}

		// add parentheses
		if ( residue != 0 
				&& residueToPos.containsKey( residue ) ) 
		{
			result.append( ")" );
			result.insert( lengthBeforeDot - 1 + residueToPos.get( residue ), "(");
		}

    	return result.toString( );
    }
    
    @Test
    public void test()
    {
    	System.out.println( fractionToDecimal( 1, 5 ) );
    	System.out.println( fractionToDecimal( 2, 1 ) );
    	System.out.println( fractionToDecimal( 2, 3 ) );
    	System.out.println( fractionToDecimal( -50, 8 ) );
    }
}
