package dynamicprogramming;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 */
// TO_TEST
public class DecodeWays
{
    public int numDecodings( String s )
    {
        if ( s == null )
        {
        	throw new IllegalArgumentException("");
        }
        if ( s.length() == 0 )
        {
        	return 0;
        }
        
        int[] numEndingAtPos = new int[s.length()];
        // init dp table
        numEndingAtPos[0] = s.charAt( 0 ) == '0' ? 0 : 1;
        // fill in dp table
        for ( int i = 1; i < s.length(); i++ )
        {
        	if ( s.charAt( i ) == '0' )
        	{
        		numEndingAtPos[i] = isValidChar( s, i-1, i ) ? numEndingAtPos[i-1] : 0; // assume always valid
        	}
        	else
        	{
        		if ( i == 2 )
        		{
                	numEndingAtPos[i] = numEndingAtPos[i-1] + ( isValidChar( s, i-1, i ) ? 1 : 0 );         			
        		}
        		else
        		{
                	numEndingAtPos[i] = numEndingAtPos[i-1] + ( isValidChar( s, i-1, i ) ? numEndingAtPos[i-2] : 0 );
        		}
        	}
        }
        return numEndingAtPos[s.length()-1];
    }
    
    private boolean isValidChar( String s, int start, int end )
    {
    	int convertedInt = Integer.parseInt( s.substring( start, end + 1 ) );
    	if ( convertedInt >= 10		
    			&& convertedInt <= 26 )		// '06' not valid
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }

    @Test
    public void test()
    {
    	assertEquals( 2, numDecodings( "12" ) );
    	assertEquals( 2, numDecodings( "26" ) );
    	assertEquals( 0, numDecodings( "0" ) );
    	assertEquals( 1, numDecodings( "10" ) );
    	assertEquals( 1, numDecodings( "100" ) );
    }
}