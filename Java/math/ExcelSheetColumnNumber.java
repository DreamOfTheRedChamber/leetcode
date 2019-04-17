package math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 

 */

public class ExcelSheetColumnNumber
{
    public int titleToNumber( String s ) 
    {
    	if ( s == null || s.length() == 0 )
    	{
    		return 0;
    	}
    	
    	int result = 0;
    	for ( int i = 0; i < s.length(); i++ )
    	{
    		result = ( s.charAt( i ) - 'A' + 1 ) + result * 26;
    	}
    	
    	return result;
    }
    
    @Test
    public void test()
    {
    	assertEquals( 28, titleToNumber( "AB" ) );
    }
}
