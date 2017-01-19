package facebook.easy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 * */

public class ExcelSheetColumnTitle 
{
    public String convertToTitle( int n )
    {
    	if ( n <= 0 )
    	{
    		throw new IllegalArgumentException( "" );
    	}
    	
    	StringBuilder result = new StringBuilder();
    	while ( n != 0 )
    	{
    		char currChar =  ( char ) ( n % 26 - 1 + 'A' );
    		n = n / 26;
    		result.append( currChar );
    	}
    	
    	return result.reverse().toString();
    }
    
    @Test
    public void test()
    {
    	assertEquals( "A", convertToTitle( 1 ) );
    	assertEquals( "AA", convertToTitle( 27 ) );
    	assertEquals( "AB", convertToTitle( 28 ) );

    }
}
