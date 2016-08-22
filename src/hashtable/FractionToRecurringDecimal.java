package hashtable;

import java.util.HashMap;
import java.util.Map;

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
    	
    	boolean isNeg = ( numerator > 0 ) ^ ( denominator > 0 );
    	Map<Integer, Integer> residueToPos = new HashMap<>();
    	StringBuilder result = new StringBuilder();
    	if ( isNeg )
    	{
    		result.append( "-" );
    	}
    	
    	// before dot
    	int quotient = numerator / denominator;
    	int residue = numerator % denominator;
    	result.append( String.valueOf( quotient ) );
    	if ( residue != 0 )
    	{
	    	result.append( "." );
	    	int lengthBeforeDot = result.length( );
	    	
	    	// after dot
	    	int posAfterDot = 1; // start from 1
	     	while ( residue != 0 
	    			&& !residueToPos.containsKey( residue ) )
	     	{
	     		residueToPos.put( residue, posAfterDot );
	     		posAfterDot++;
	     		residue = ( residue * 10 ) % numerator;
	     		quotient = ( residue * 10 ) / numerator;
	     		result.append( String.valueOf( quotient ) );
	     	}
	    	
	     	// add parentheses
	     	if ( residue != 0 
	     			&& residueToPos.containsKey( residue ) )
	     	{
	     		result.append( ")" );
	     		result.insert( lengthBeforeDot - 1 + residueToPos.get( residue ), "(" );
	     	}
    	}
    	return result.toString( );
    }
}
