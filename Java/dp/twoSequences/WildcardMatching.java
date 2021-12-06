package dp.twoSequences;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 *
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
 */
public class WildcardMatching
{
	@Test
	public void test()
	{
		// test * 
		assertTrue( isMatch( "ab", "ab*" ) );
		assertTrue( isMatch( "ab", "a*" ) );
		assertTrue( isMatch( "ab", "*" ) );
		assertFalse( isMatch( "ab", "b*" ) );
		
		// test ?
		assertTrue( isMatch( "ab", "?b" ) );
		assertTrue( isMatch( "aka", "???") );
		
		// test ? * 
		assertTrue( isMatch( "ab", "?*" ) );
		
		assertTrue( isMatch( "ho", "**ho" ) );
	}
	
 public boolean isMatch( String s, String p )
 {
 	if ( s == null 
 			|| p == null )
 	{
 		throw new IllegalArgumentException("");
 	}
 	if ( s.length() == 0 )
 	{
 		return p.length() == 0 || p.equals( "*" );
 	}
 	if ( p.length() == 0 )
 	{
 		return s.length() == 0;
 	}
 	
 	int height = s.length() + 1;
 	int width = p.length() + 1;
 	boolean[][] isSubstringMatch = new boolean[height][width];
 	isSubstringMatch[0][0] = true;
 	
 	// init dp table
 	for ( int j = 1; j < width; j++ )
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
 			if ( p.charAt( j - 1 ) == '?' )
 			{
 				isSubstringMatch[i][j] = isSubstringMatch[i-1][j-1];
 			}
 			else if ( p.charAt( j - 1 ) == '*' )
 			{
 				for ( int k = 0; k <= i; k++ )
 				{
 					if ( isSubstringMatch[k][j-1] )
 					{
 						isSubstringMatch[i][j] = true;
 						break;
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
