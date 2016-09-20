package string;

/**
 Given two strings S and T, determine if they are both one edit distance apart.
 */

// TODO: simplify
public class OneEditDistance
{
    public boolean isOneEditDistance( String s, String t )
    {
    	if ( s == null 
    			|| t == null )
    	{
    		throw new IllegalArgumentException("");
    	}
    	if ( s.length( ) < t.length( ) )
    	{
    		return isOneEditDistance( s, t );
    	}
    	
    	if ( s.length( ) - t.length( ) > 1 )
    	{
    		return false;
    	}
    	else if ( s.length( ) == t.length( ) )
    	{
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
    		for ( int i = 0; i < s.length( ); i++ )
    		{
    			// if delete ith ch from s
    			for ( int m = 0, n = 0; m < s.length( ) && n < t.length( ); )
    			{
    				if ( m == i )
    				{
    					m++;
    					continue;
    				}
    				else
    				{
    					if ( s.charAt( m ) != t.charAt( n ) )
    					{
    						return false;
    					}
    					m++;
    					n++;
    				}
    			}
    			
    			return true;
    		}
        	return false;		
    	}    	    	
    }
}
