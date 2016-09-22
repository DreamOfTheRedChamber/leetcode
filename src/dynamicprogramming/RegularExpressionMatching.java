package dynamicprogramming;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 *
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
 */

// TO_IMME
public class RegularExpressionMatching
{
	@Test
	public void test()
	{
		// test *
		assertTrue( isMatch( "ab", "c*a*b" ) );
		assertTrue( isMatch( "cab", "c*a*b" ) );
		assertTrue( isMatch( "ccaab", "c*a*b" ) );
		assertTrue( isMatch( "", ".*" ) );
		assertTrue( isMatch( "ab", ".*" ) );
		
		assertFalse( isMatch( "aaba", "ab*a*c*a" ) );
		assertTrue( isMatch( "aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s" ) );
	}
	
    public boolean isMatch( String s, String p )
    {
    	if ( s == null 
    			|| p == null )
    	{
    		throw new IllegalArgumentException("");
    	}
    	
    	int height = s.length() + 1;
    	int width = p.length() + 1;
    	boolean[][] isSubstringMatch = new boolean[height][width];
    	
    	// init dp table
    	isSubstringMatch[0][0] = true;
    	for ( int j = 2; j < width; j += 2 )
    	{
    		if ( p.charAt( j - 1 ) == '*' )
    		{
    			isSubstringMatch[0][j] = true;
    		}
    		else
    		{
    			break;
    		}
    	}
    	
    	// fill in dp table
    	for ( int i = 1; i < height; i++ )
    	{
    		for ( int j = 1; j < width; j++ )
    		{
    			if ( p.charAt( j - 1 ) == '.' )
    			{
    				isSubstringMatch[i][j] = isSubstringMatch[i-1][j-1];
    			}
    			else if ( p.charAt( j - 1 ) == '*' && p.charAt( j - 2 ) != '.' )
    			{
    				// 0 match for *
    				if ( isSubstringMatch[i][j-2] )
    				{
    					isSubstringMatch[i][j] = true;
    					continue;
    				}
    				
    				// 1 match for *
    				if ( isSubstringMatch[i][j-1] )
    				{
    					isSubstringMatch[i][j] = true;
    					continue;
    				}
// equivalent with the following, but more concise
//    				if ( i < 2 && isSubstringMatch[i-1][j-2] )
//    				{
//    					isSubstringMatch[i][j] = true;
//    				}
//    				if ( i >= 2 && isSubstringMatch[i-1][j-2] && s.charAt( i - 1 ) == p.charAt( j - 2 ) )
//        			{
//    					isSubstringMatch[i][j] = true;
//    					continue;
//    				}
    					
    				// multi match for *
    				for ( int k = 1; i - 1 - k >= 0; k++ )
    				{
    					if ( isSubstringMatch[i-1-k][j-2] 
    							&& s.charAt( i - 1 - k ) == s.charAt( i - k )
    							&& s.charAt( i - 1 - k ) == p.charAt( j - 2 ) )
    					{
    						isSubstringMatch[i][j] = true;
    						continue;
    					}
    				}
    			}
    			else if ( p.charAt( j - 1 ) == '*' && p.charAt( j - 2 ) == '.' )
    			{
    				for ( int k = i; k >= 1; k-- )
    				{
    					if ( isSubstringMatch[k][j-1] )
    					{
    						isSubstringMatch[i][j] = true;
    					}
    				}
    			}
    			else
    			{
    				isSubstringMatch[i][j] = s.charAt( i - 1 ) == p.charAt( j - 1 )
    										&& isSubstringMatch[i-1][j-1];
    			}
    		}
    	}
    	
    	return isSubstringMatch[height-1][width-1];
    }
}