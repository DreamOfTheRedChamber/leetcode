package string;

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
    	if ( s == null 
    			|| t == null )
    	{
    		throw new IllegalArgumentException("");
    	}
    	if ( s.length( ) < t.length( ) )
    	{
    		return isOneEditDistance( t, s );
    	}
    	
    	if ( s.length( ) - t.length( ) > 1 )
    	{
    		return false;
    	}
    	else if ( s.length( ) == t.length( ) )
    	{
    		// is one replace
    		int numDiffCh = 0;
    		for ( int i = 0; i < s.length(); i++ )
    		{
    			if ( s.charAt( i ) != t.charAt( i ) )
    			{
    				numDiffCh++;
    			}
    			if ( numDiffCh > 1 )
    			{
    				return false;
    			}
    		}
    		return true;
    	} 
    	else
    	{
    		// is one insert
    		boolean hasAlreadyInserted = false;
			for ( int m = 0, n = 0; m < s.length() && n < t.length();) 
			{
				if ( s.charAt( m ) != t.charAt( n ) )
				{
					if ( hasAlreadyInserted )
					{
						return false;
					}
					m++;
					hasAlreadyInserted = true;
				}
				else
				{
					m++;
					n++;
				}
			}    			
    		return true;    		
    	}    	    	
    }
}
