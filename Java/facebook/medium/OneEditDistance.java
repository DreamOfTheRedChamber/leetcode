package facebook.medium;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 Given two strings S and T, determine if they are both one edit distance apart.
 */

public class OneEditDistance
{
	@Test
	public void test()
	{
		assertTrue( isOneEditDistance( "ab", "abc" ) );		
	}
	
	public boolean isOneEditDistance( String s, String t ) 
	{
		if ( s == null || t == null )
		{
			throw new IllegalArgumentException();
		}
		if ( s.length() < t.length() )
		{
			return isOneEditDistance( t, s );
		}
		
	    for ( int i = 0; i < t.length(); i++ ) 
	    { 
	    	if ( s.charAt( i ) != t.charAt( i ) ) 
	    	{
	    		if ( s.length() == t.length() ) // s has the same length as t, so the only possibility is replacing one char in s and t
	    		{
	    			return s.substring( i + 1 ).equals( t.substring( i + 1 ) );
	    		}
				else // s is longer than t, so the only possibility is deleting one char from s
				{
					return t.substring( i ).equals( s.substring( i + 1 ) );
				}
	    	}
	    }       
	    //All previous chars are the same, the only possibility is deleting the end char in the longer one of s and t 
	    return Math.abs( s.length() - t.length() ) == 1;        
	}
}
