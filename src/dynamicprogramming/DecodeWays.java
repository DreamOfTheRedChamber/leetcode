package dynamicprogramming;

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
//TO_TEST
public class DecodeWays
{
    public int numDecodings( String s )
    {
        if ( s == null )
        {
        	throw new IllegalArgumentException("");
        }
        
        // TODO: check condition in dp
        if ( s.length() <= 1 )
        {
        	return s.length();
        }
                
        int[] numEndingAtPos = new int[s.length()];
        // init dp table
        numEndingAtPos[0] = 1;
        numEndingAtPos[1] = 1 + ( isValidChar( s, 0, 1 ) ? 1 : 0 );
        // fill in dp table
        for ( int i = 2; i < s.length(); i++ )
        {
        	numEndingAtPos[i] = numEndingAtPos[i-1] + ( isValidChar( s, i-1, i ) ? numEndingAtPos[i-2] : 0 );
        }
        return numEndingAtPos[s.length()-1];
    }
    
    private boolean isValidChar( String s, int start, int end )
    {
    	int convertedInt = Integer.parseInt( s.substring(start, end + 1) );
    	if ( convertedInt >= 0
    			&& convertedInt <= 25 )
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
}
