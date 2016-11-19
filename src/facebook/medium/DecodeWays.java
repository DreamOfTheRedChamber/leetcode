package facebook.medium;

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

public class DecodeWays
{
    public int numDecodings( String s )
    {
    	if ( s == null || s.length() == 0 || s.charAt( 0 ) == '0' )
    	{
    		return 0;
    	}
    	if ( s.length() == 0 )
    	{
    		return 1;
    	}
    	
    	int[] numWays = new int[3];
    	numWays[0] = 1;
    	numWays[1] = s.charAt( 0 ) == '0' ? 0 : 1;
    	for ( int i = 2; i <= s.length(); i++ )
    	{
    		numWays[i % 3] = 0;
    		int oneDigitNum = s.charAt( i - 1 ) - '0';
    		if ( oneDigitNum > 0 )
    		{
    			numWays[i % 3] += numWays[(i - 1) % 3];
    		}
    		
    		int twoDigitNum = s.charAt( i - 2 ) - '0';
    		if ( twoDigitNum > 0 )
    		{
    			int value = twoDigitNum * 10 + oneDigitNum;
    			if ( value >= 1 && value <= 26 )
    			{
    				numWays[i % 3] += numWays[(i - 2) % 3];
    			}
    		}
    	}
    	return numWays[s.length() % 3];
    }

    @Test
    public void test()
    {
    	assertEquals( 2, numDecodings( "12" ) );
    	assertEquals( 2, numDecodings( "26" ) );
    	assertEquals( 0, numDecodings( "0" ) );
    	assertEquals( 1, numDecodings( "10" ) );
    	assertEquals( 0, numDecodings( "100" ) );
    }
}