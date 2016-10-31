package facebook.hard;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 * */

public class RegularExpressionMatching 
{
    public boolean isMatch( String s, String p )
    {
        if ( s == null )
        {
        	return p == null;        	
        }
        if ( p == null )
        {
        	return false;
        }
        
        return isMatch( s, p, s.length() - 1, p.length() - 1 );
    }
    
    private boolean isMatch( String s, String p, int sIndex, int pIndex )
    {
    	if ( pIndex == -1 )
    	{
    		return sIndex == -1;
    	}
    	
    	if ( p.charAt( pIndex ) == '*' )
    	{
    		return isMatch( s, p, sIndex, pIndex - 2 )
    				|| ( ( p.charAt( pIndex - 1 ) == s.charAt( sIndex ) || p.charAt( pIndex - 1 ) == '.') && isMatch( s, p, sIndex-1, pIndex ) ) ;
    	}
    	else
    	{
    		return sIndex >= 0 
    				&& ( p.charAt( pIndex ) == s.charAt( sIndex ) || p.charAt( pIndex ) == '.' )
    				&& isMatch( s, p, sIndex - 1, pIndex - 1 );
    	}
    }

    @Test
    public void testLetters()
    {
    	assertTrue( isMatch( "aa", "aa" ) );
    	assertTrue( !isMatch( "ab", "aa" ) );
    	assertTrue( !isMatch( "caa", "aa" ) );
    	assertTrue( !isMatch( "aa", "caa" ) );
    }
    
    @Test
    public void testDot()
    {
    	assertTrue( isMatch( "aa", "a." ) );
    	assertTrue( isMatch( "ab", "a." ) );
    	assertTrue( !isMatch( "caa", "a." ) );
    	assertTrue( !isMatch( "aa", "c.a" ) );
    }
    
    @Test
    public void testStar()
    {
    	assertTrue( isMatch( "", "a*" ) );
    	assertTrue( isMatch( "a", "a*" ) );
    	assertTrue( isMatch( "aa", "a*" ) );
    	assertTrue( isMatch( "aaa", "a*" ) );
    	assertTrue( !isMatch( "baa", "a*" ) );
    	assertTrue( !isMatch( "aab", "a*" ) );    	
    }
    
    @Test
    public void testDotStar()
    {
    	assertTrue( isMatch( "", ".*" ) );
    	assertTrue( isMatch( "a", ".*" ) );
    	assertTrue( isMatch( "aa", ".*" ) );
    	assertTrue( isMatch( "aaa", ".*" ) );
    	assertTrue( isMatch( "baa", ".*" ) );
    	assertTrue( isMatch( "aab", ".*" ) );    	    	
    }
}